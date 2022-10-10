package com.example.testserverretrofit.api;

import com.example.testserverretrofit.spi.GithubClient;
import com.example.testserverretrofit.spi.GithubUser;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class GithubDataServiceTest {

    @Mock
    private GithubClient githubClient;

    private GithubDataService githubDataService;

    private static final String LOGIN_ID = "mojombo";
    private static final int ID = 1;

    @BeforeEach
    void setup() {
        this.githubDataService = new GithubDataService(githubClient);
    }

    @Test
    void should_get_users_async() throws ExecutionException, InterruptedException {
        // GIVEN
        GithubUser user = new GithubUser(LOGIN_ID, ID, "node_id_1");
        when(githubClient.getUsers()).thenReturn(CompletableFuture.completedFuture(List.of(user)));

        // WHEN
        List<GithubUserDto> users = githubDataService.getUsers();

        // THEN
        assertThat(users).isNotEmpty();
        assertThat(users.get(0).getId()).isEqualTo(ID);
        assertThat(users.get(0).getLogin()).isEqualTo(LOGIN_ID);
    }
}
