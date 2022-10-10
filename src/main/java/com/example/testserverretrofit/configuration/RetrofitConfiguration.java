package com.example.testserverretrofit.configuration;

import com.example.testserverretrofit.spi.GithubClient;
import okhttp3.OkHttpClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import javax.inject.Named;

@Configuration
public class RetrofitConfiguration {

    @Value("${retrofit.base-url}")
    private String baseUrl;

    @Bean
    public OkHttpClient okHttpClient() {
        return new OkHttpClient.Builder().build();
    }

    @Bean
    public GithubClient githubClient(@Named("okHttpClient") OkHttpClient client) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client).build();

        return retrofit.create(GithubClient.class);
    }
}
