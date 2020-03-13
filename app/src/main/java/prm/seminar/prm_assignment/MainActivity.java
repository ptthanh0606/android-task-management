package prm.seminar.prm_assignment;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import prm.seminar.prm_assignment.apiclient.ApiClient;
import prm.seminar.prm_assignment.task.TaskApiInterface;
import prm.seminar.prm_assignment.task.TaskDTO;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    TextView txtTaskName, txtTaskID, txtUsername;
    TaskApiInterface taskApiInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtUsername = findViewById(R.id.txtUsername);
        txtTaskID = findViewById(R.id.txtTaskID);
        txtTaskName = findViewById(R.id.txtTaskName);

        initTask();
    }

    private void initTask() {
        taskApiInterface = ApiClient.getRetrofitClient().create(TaskApiInterface.class); // Retrofit auto implements code body to TaskApiInterface.
        Call<List<TaskDTO>> callTasks = taskApiInterface.getTasks();
        callTasks.enqueue(new Callback<List<TaskDTO>>() {
            @Override
            public void onResponse(Call<List<TaskDTO>> call, Response<List<TaskDTO>> response) {
                if (response.isSuccessful()) {
                    List<TaskDTO> tasks = response.body();
                    for (TaskDTO task: tasks) {
                        String content = "";
                        content = task.getTaskName() + "\n";
                        txtTaskName.append(content);
                    }
                } else {
                    Toast.makeText(MainActivity.this, response.errorBody().toString(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<TaskDTO>> call, Throwable t) {
                Toast.makeText(MainActivity.this, t.toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
