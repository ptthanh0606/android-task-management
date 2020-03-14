package prm.seminar.prm_assignment.user;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface UserApiInteface {
    @FormUrlEncoded
    @POST("/api/login")
    Call<UserDTO> checkLogin(
            @Field("userName") String userName,
            @Field("password") String password
    );
}
