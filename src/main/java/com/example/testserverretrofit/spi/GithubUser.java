package com.example.testserverretrofit.spi;

import lombok.Data;

@Data
public class GithubUser {
    private String login;
    private int id;
    private String node_id;
}
