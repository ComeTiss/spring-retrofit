package com.example.testserverretrofit.spi;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GithubUser {
    private String login;
    private int id;
    private String node_id;
}
