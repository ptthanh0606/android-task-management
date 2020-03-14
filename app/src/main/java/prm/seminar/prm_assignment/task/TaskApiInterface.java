package prm.seminar.prm_assignment.task;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface TaskApiInterface {

    @GET("api/tasks")
    Call<List<TaskDTO>> getTasks(
            @Query("userName") String userName,
            @Query("taskStatus") String taskStatus
    );
}
