package com.gopal.postoperationusingspringapi;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface ApiInterface {

    @FormUrlEncoded
    @POST("/login/registerAdmin")
    Call<User> getUserInformation(@Field("adminName") String adminName,@Field("email") String email,@Field("mobile") String mobile,@Field("password") String password);
}
