package com.example.testserverretrofit.api;

import com.example.testserverretrofit.spi.GithubClient;
import com.example.testserverretrofit.spi.GithubUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import retrofit2.Call;
import retrofit2.Response;

import java.util.ArrayList;
import java.util.List;

@Component
public class GithubDataService {

    private final Logger logger = LoggerFactory.getLogger(GithubDataService.class);

    @Autowired
    private GithubClient githubClient;

    public List<GithubUserDto> getUsers() {
        List<GithubUserDto> users = new ArrayList<>();
        Call<List<GithubUser>> usersCall = githubClient.getUsers();
        try {
            Response<List<GithubUser>> response = usersCall.execute();

            if (response.body() != null) {
                users = GithubUserMapper.toDto(response.body());
            }
        } catch (Exception e) {
            logger.error("GithubDataService/getUsers=An error occurred while fetching users");
        }

        return users;
    }
}
