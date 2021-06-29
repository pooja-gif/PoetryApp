package com.example.poetryapp;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {
    @GET("readpoetry.php")
    Call<GetPoetryResponse> readpoetry();


}
