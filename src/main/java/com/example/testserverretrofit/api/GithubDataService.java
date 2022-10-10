package com.example.testserverretrofit.api;

import com.example.testserverretrofit.spi.GithubClient;
import com.example.testserverretrofit.spi.GithubUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@Component
public class GithubDataService {

    private final Logger logger = LoggerFactory.getLogger(GithubDataService.class);

    private final GithubClient githubClient;

    public GithubDataService(GithubClient githubClient) {
        this.githubClient = githubClient;
    }

    public List<GithubUserDto> getUsers() {
        List<GithubUserDto> users = new ArrayList<>();
        CompletableFuture<List<GithubUser>> usersCall = githubClient.getUsers();

        try {
            while (!usersCall.isDone()) {
                Thread.sleep(300);
            }

            users = GithubUserMapper.toDto(usersCall.get());
        } catch (Exception e) {
            logger.error("GithubDataService/getUsers=An error occurred while fetching users: " + e.getMessage());
        }

        return users;
    }
}
