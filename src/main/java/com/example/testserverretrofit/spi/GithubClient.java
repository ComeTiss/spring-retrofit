package com.example.testserverretrofit.spi;

import retrofit2.http.GET;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public interface GithubClient {

    @GET("users")
    CompletableFuture<List<GithubUser>> getUsers();
}
