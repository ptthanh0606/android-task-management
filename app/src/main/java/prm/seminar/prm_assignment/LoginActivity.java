package prm.seminar.prm_assignment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import prm.seminar.prm_assignment.apiclient.ApiClient;
import prm.seminar.prm_assignment.task.TaskApiInterface;
import prm.seminar.prm_assignment.task.TaskDTO;
import prm.seminar.prm_assignment.user.UserApiInteface;
import prm.seminar.prm_assignment.user.UserDTO;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {

    private TextView txtUsername, txtPassword;
    private UserApiInteface userApiInteface;
    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtPassword = findViewById(R.id.txtPassword);
        txtUsername = findViewById(R.id.txtUsername);
    }

    public void clickToLogin(View view) {
        if (txtUsername.getText().toString().isEmpty() || txtPassword.getText().toString().isEmpty()) {
            Toast.makeText(this, "Username or password must not be empty", Toast.LENGTH_SHORT).show();
            return;
        }
        login(txtUsername.getText().toString(), txtPassword.getText().toString());
    }

    private void login(final String username, final String password)  {
        userApiInteface = ApiClient.getRetrofitClient().create(UserApiInteface.class);
        Call<UserDTO> callUserApi = userApiInteface.checkLogin(username, password);
//        Call<UserDTO> callUserApi = userApiInteface.checkLogin("ThanhPT18", "123");

        callUserApi.enqueue(new Callback<UserDTO>() {
            @Override
            public void onResponse(Call<UserDTO> call, Response<UserDTO> response) {
                if (response.isSuccessful()) {
                    if (response.code() == 500) {
                        Toast.makeText(LoginActivity.this, "Login failed!", Toast.LENGTH_SHORT).show();
                    } else {
                        sharedPreferences = getSharedPreferences("USER_SESSION", MODE_PRIVATE);
                        SharedPreferences.Editor editor = sharedPreferences.edit();

                        editor.putString("LOGGED_USERNAME_SESSION", username);
                        editor.putString("LOGGED_PASSWORD_SESSION", password);
                        editor.commit();

                        Intent intent = new Intent(LoginActivity.this, TasksActivity.class);
                        intent.putExtra("USER_INFO", response.body());
                        startActivity(intent);
                        finish();
                    }
                } else {
                    Toast.makeText(LoginActivity.this, "Login failed!", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<UserDTO> call, Throwable t) {
                Toast.makeText(LoginActivity.this, t.toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
