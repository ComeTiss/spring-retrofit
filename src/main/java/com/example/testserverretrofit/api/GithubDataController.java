package com.example.testserverretrofit.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/data")
public class GithubDataController {

    @Autowired
    private GithubDataService githubDataService;

    @GetMapping("/users")
    List<GithubUserDto> getUsers() {
        return githubDataService.getUsers();
    }
}
