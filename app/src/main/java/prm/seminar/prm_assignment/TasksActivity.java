package prm.seminar.prm_assignment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.List;

import prm.seminar.prm_assignment.apiclient.ApiClient;
import prm.seminar.prm_assignment.task.TaskApiInterface;
import prm.seminar.prm_assignment.task.TaskDTO;
import prm.seminar.prm_assignment.user.UserDTO;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TasksActivity extends AppCompatActivity {

    TextView txtTaskName, txtTaskID, txtFullName,
            numberOfOpenTask, numberOfInprogressTask,
            numberOfDoneTask, numberOfOverdueTask, numberOfPendingTask;

    LinearLayout openTasksContainer, inProgressTasksContainer,
            doneTasksContainer, overdueTasksContainer, pendingTasksContainer;

    TaskApiInterface taskApiInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tasks);

        txtFullName = findViewById(R.id.txtFullName);

        openTasksContainer = findViewById(R.id.openTasksContainer);
        inProgressTasksContainer = findViewById(R.id.inProgressTasksContainer);
        doneTasksContainer = findViewById(R.id.doneTasksContainer);
        overdueTasksContainer = findViewById(R.id.overdueTasksContainer);
        pendingTasksContainer = findViewById(R.id.pendingTasksContainer);

        numberOfOpenTask = findViewById(R.id.numberOfOpenTask);
        numberOfInprogressTask = findViewById(R.id.numberOfInprogressTask);
        numberOfDoneTask = findViewById(R.id.numberOfDoneTask);
        numberOfOverdueTask = findViewById(R.id.numberOfOverdueTask);
        numberOfPendingTask = findViewById(R.id.numberOfPendingTask);

        Intent intent = getIntent();
        UserDTO user = (UserDTO) intent.getSerializableExtra("USER_INFO");
        initTask(user);
    }

    private void initTask(UserDTO user) {
        txtFullName.setText(user.getFullName());

        taskApiInterface = ApiClient.getRetrofitClient().create(TaskApiInterface.class); // Retrofit auto implements code body to TaskApiInterface.
        Call<List<TaskDTO>> callOpenTasks = taskApiInterface.getTasks(user.getUserName(), "Open");
        Call<List<TaskDTO>> callInProgessTasks = taskApiInterface.getTasks(user.getUserName(), "Inprogress");
        Call<List<TaskDTO>> callDoneTasks = taskApiInterface.getTasks(user.getUserName(), "Done");
        Call<List<TaskDTO>> callDueTasks = taskApiInterface.getTasks(user.getUserName(), "Overdue");
        Call<List<TaskDTO>> callPendingTasks = taskApiInterface.getTasks(user.getUserName(), "Pending");

        callOpenTasks.enqueue(new Callback<List<TaskDTO>>() {
            @Override
            public void onResponse(Call<List<TaskDTO>> call, Response<List<TaskDTO>> response) {
                if (response.isSuccessful()) {
                    renderTasks(response.body(), "Open");
                }
            }

            @Override
            public void onFailure(Call<List<TaskDTO>> call, Throwable t) {
                Toast.makeText(TasksActivity.this, "There is a problem with the server", Toast.LENGTH_SHORT).show();
            }
        });
        callInProgessTasks.enqueue(new Callback<List<TaskDTO>>() {
            @Override
            public void onResponse(Call<List<TaskDTO>> call, Response<List<TaskDTO>> response) {
                if (response.isSuccessful()) {
                    renderTasks(response.body(), "Inprogress");
                }
            }

            @Override
            public void onFailure(Call<List<TaskDTO>> call, Throwable t) {
                Toast.makeText(TasksActivity.this, "There is a problem with the server", Toast.LENGTH_SHORT).show();
            }
        });
        callDoneTasks.enqueue(new Callback<List<TaskDTO>>() {
            @Override
            public void onResponse(Call<List<TaskDTO>> call, Response<List<TaskDTO>> response) {
                if (response.isSuccessful()) {
                    renderTasks(response.body(), "Done");
                }
            }

            @Override
            public void onFailure(Call<List<TaskDTO>> call, Throwable t) {
                Toast.makeText(TasksActivity.this, "There is a problem with the server", Toast.LENGTH_SHORT).show();
            }
        });
        callDueTasks.enqueue(new Callback<List<TaskDTO>>() {
            @Override
            public void onResponse(Call<List<TaskDTO>> call, Response<List<TaskDTO>> response) {
                if (response.isSuccessful()) {
                    renderTasks(response.body(), "Overdue");
                }
            }

            @Override
            public void onFailure(Call<List<TaskDTO>> call, Throwable t) {
                Toast.makeText(TasksActivity.this, "There is a problem with the server", Toast.LENGTH_SHORT).show();
            }
        });
        callPendingTasks.enqueue(new Callback<List<TaskDTO>>() {
            @Override
            public void onResponse(Call<List<TaskDTO>> call, Response<List<TaskDTO>> response) {
                if (response.isSuccessful()) {
                    renderTasks(response.body(), "Pending");
                }
            }

            @Override
            public void onFailure(Call<List<TaskDTO>> call, Throwable t) {
                Toast.makeText(TasksActivity.this, "There is a problem with the server", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void renderTasks(List<TaskDTO> tasks, String taskStatus) {
        for (final TaskDTO task: tasks) {
            // Task container generator
            LinearLayout taskContainer = new LinearLayout(TasksActivity.this);
            LinearLayout.LayoutParams taskContainerLayoutParam = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
            );
            taskContainerLayoutParam.setMargins(0, 32, 0,0);
            taskContainer.setLayoutParams(taskContainerLayoutParam);
            taskContainer.setOrientation(LinearLayout.VERTICAL);
            taskContainer.setPadding(32,32,32,32);

            // taskID text generator
            TextView txtTaskID = createTextView(new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
            ), "#" + task.getTaskID(), 14, Typeface.DEFAULT, "");

            // taskName text generator
            TextView txtTaskName = createTextView(new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
            ), task.getTaskName(), 20, Typeface.DEFAULT_BOLD, "");

            // assignedTo text generator
            TextView txtAssignedTo = createTextView(new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
            ), "Assigned to " + task.getAssigneeID(), 12, Typeface.DEFAULT_BOLD, "#848484");

            // taskDesc text generator
            TextView txtTaskDesc = createTextView(new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
            ), task.getTaskDesc(), 16, Typeface.DEFAULT, "");

            // createBy text generator
            TextView txtCreateBy = createTextView(new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
            ), "Created by " + task.getCreateBy(), 12, Typeface.DEFAULT_BOLD, "#5A5A5B");

            // createdDate text generator
            TextView txtCreatedDate = createTextView(new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
            ), "Date created: " + task.getCreateDate(), 12, Typeface.DEFAULT_BOLD, "#5A5A5B");

            // Add childs to views
            taskContainer.addView(txtTaskID);
            taskContainer.addView(txtTaskName);
            taskContainer.addView(txtAssignedTo);
            taskContainer.addView(txtTaskDesc);
            taskContainer.addView(txtCreateBy);
            taskContainer.addView(txtCreatedDate);
            // Set onClickListener
            taskContainer.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(TasksActivity.this, TaskDetailActivity.class);
                    intent.putExtra("TASK_INFO", task);
                    startActivity(intent);
                }
            });

            String numberOfTasks = "(" + tasks.size() + ")";
            switch (taskStatus) {
                case "Open": {
                    taskContainer.setBackgroundColor(Color.parseColor("#DCD3FE"));
                    openTasksContainer.addView(taskContainer);
                    numberOfOpenTask.setText(numberOfTasks);
                } break;

                case "Inprogress": {
                    taskContainer.setBackgroundColor(Color.parseColor("#B5DBF8"));
                    inProgressTasksContainer.addView(taskContainer);
                    numberOfInprogressTask.setText(numberOfTasks);
                } break;

                case "Done": {
                    taskContainer.setBackgroundColor(Color.parseColor("#B5F8C3"));
                    doneTasksContainer.addView(taskContainer);
                    numberOfDoneTask.setText(numberOfTasks);
                } break;

                case "Overdue": {
                    taskContainer.setBackgroundColor(Color.parseColor("#F8AEB5"));
                    overdueTasksContainer.addView(taskContainer);
                    numberOfOverdueTask.setText(numberOfTasks);
                } break;

                case "Pending": {
                    taskContainer.setBackgroundColor(Color.parseColor("#F8F8B5"));
                    pendingTasksContainer.addView(taskContainer);
                    numberOfPendingTask.setText(numberOfTasks);
                } break;
            }
        }
    }

    private TextView createTextView(LinearLayout.LayoutParams layoutParams, String label, int fonSize, Typeface textStyle, String colorHex) {
        TextView textView = new TextView(this);
        textView.setLayoutParams(layoutParams);
        textView.setText(label);
        textView.setTextSize(fonSize);
        textView.setTypeface(textStyle);
        if (colorHex.isEmpty()) {
            textView.setTextColor(Color.parseColor("#222831"));
        } else {
            textView.setTextColor(Color.parseColor(colorHex));
        }

        return textView;
    }

    private LinearLayout createLinearLayout() {
        LinearLayout container = new LinearLayout(TasksActivity.this);
        container.setLayoutParams(new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        ));
        container.setOrientation(LinearLayout.HORIZONTAL);

        return container;
    }

    public void clickToLogout(View view) {
        SharedPreferences sharedPreferences = getSharedPreferences("USER_SESSION", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear();
        editor.commit();

        startActivity(new Intent(TasksActivity.this, LoginActivity.class));
        finish();
    }
}
