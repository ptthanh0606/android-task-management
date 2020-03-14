package prm.seminar.prm_assignment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Toast;

import prm.seminar.prm_assignment.apiclient.ApiClient;
import prm.seminar.prm_assignment.user.UserApiInteface;
import prm.seminar.prm_assignment.user.UserDTO;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SplashScreenActivity extends AppCompatActivity {

    private UserApiInteface userApiInteface;
    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_sreen);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
            sharedPreferences = getSharedPreferences("USER_SESSION", MODE_PRIVATE);
            String username = sharedPreferences.getString("LOGGED_USERNAME_SESSION", "");
            String password = sharedPreferences.getString("LOGGED_PASSWORD_SESSION", "");
            if (!username.isEmpty() || !password.isEmpty()) {
                login(username, password);
            } else {
                Intent intent = new Intent(SplashScreenActivity.this, LoginActivity.class);
                startActivity(intent);

                finish();
            }
            }
        }, 3000);
    }

    private void login(final String username, final String password)  {
        userApiInteface = ApiClient.getRetrofitClient().create(UserApiInteface.class);
        Call<UserDTO> callUserApi = userApiInteface.checkLogin(username, password);

        callUserApi.enqueue(new Callback<UserDTO>() {
            @Override
            public void onResponse(Call<UserDTO> call, Response<UserDTO> response) {
                if (response.isSuccessful()) {
                    if (response.code() == 500) {
                        Toast.makeText(SplashScreenActivity.this, "Login failed!", Toast.LENGTH_SHORT).show();
                    } else {
                        Intent intent = new Intent(SplashScreenActivity.this, TasksActivity.class);
                        intent.putExtra("USER_INFO", response.body());
                        startActivity(intent);

                        finish();
                    }
                } else {
                    Toast.makeText(SplashScreenActivity.this, "Login failed!", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<UserDTO> call, Throwable t) {
                Toast.makeText(SplashScreenActivity.this, t.toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
