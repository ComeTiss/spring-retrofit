package com.example.testserverretrofit.api;

import com.example.testserverretrofit.spi.GithubClient;
import com.example.testserverretrofit.spi.GithubUser;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
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
    void should_get_users() throws IOException {
        // GIVEN
        GithubUser user = new GithubUser(LOGIN_ID, ID, "node_id_1");
        Call<List<GithubUser>> call = mock(Call.class);
        when(call.execute()).thenReturn(Response.success(List.of(user)));
        when(githubClient.getUsers()).thenReturn(call);

        // WHEN
        List<GithubUserDto> users = githubDataService.getUsers();

        // THEN
        assertThat(users).isNotEmpty();
        assertThat(users.get(0).getId()).isEqualTo(ID);
        assertThat(users.get(0).getLogin()).isEqualTo(LOGIN_ID);
    }
}
