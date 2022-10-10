package com.example.testserverretrofit.api;

import com.example.testserverretrofit.spi.GithubUser;

import java.util.List;
import java.util.stream.Collectors;

public class GithubUserMapper {

    public static List<GithubUserDto> toDto(List<GithubUser> users) {
        return users
                .stream()
                .map(GithubUserMapper::toDto)
                .collect(Collectors.toList());
    }
    public static GithubUserDto toDto(GithubUser user) {
        GithubUserDto userDto = new GithubUserDto();
        userDto.setId(user.getId());
        userDto.setLogin(user.getLogin());
        return userDto;
    }
}
