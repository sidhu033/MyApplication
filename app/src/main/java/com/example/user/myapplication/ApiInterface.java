package com.example.user.myapplication;

import com.example.user.myapplication.pojo.LoginEntity;
import com.example.user.myapplication.pojo.SaveEntity;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface ApiInterface {

    @FormUrlEncoded
    @POST("simplelogin.php")
    Call<LoginEntity> savePost(@Field("username") String username, @Field("password") String password);

    @FormUrlEncoded
    @POST("treatment_log.php")
    Call<SaveEntity> saveReadings(@Field("username") String username, @Field("starttime") String starttime, @Field("r_sys") String r_sys,
                                  @Field("r_dia") String r_dia, @Field("r_pulse") String r_pulse, @Field("l_sys") String l_sys,
                                  @Field("l_dia") String l_dia, @Field("l_pulse") String l_pulse);

}
