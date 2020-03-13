package prm.seminar.prm_assignment.task;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface TaskApiInterface {
    @GET("api/tasks")
    Call<List<TaskDTO>> getTasks();
}
