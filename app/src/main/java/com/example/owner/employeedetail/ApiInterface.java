package com.example.owner.employeedetail;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by owner on 10/6/2021.
 */

public interface ApiInterface {

    @FormUrlEncoded
    @POST("insert.php")
    Call<Modal> addData(@Field("first_name") String first_name,

                        @Field("last_name") String last_name,

                        @Field("designation") String designation,

                        @Field("email") String email,

                        @Field("date_of_birth") String date_of_birth,

                        @Field("address") String address,

                        @Field("department") String department);
}
