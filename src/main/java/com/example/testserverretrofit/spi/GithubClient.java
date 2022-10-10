package com.example.testserverretrofit.spi;

import retrofit2.Call;
import retrofit2.http.GET;

import java.util.List;

public interface GithubClient {

    @GET("users")
    Call<List<GithubUser>> getUsers();
}
