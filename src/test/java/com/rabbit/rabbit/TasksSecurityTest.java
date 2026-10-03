package com.rabbit.rabbit;

import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest (webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)

public class TasksSecurityTest {

    @Value ("${local.server.port}")
    private int port;

    @Test 
    void tasksRejectRequestWithoutToken()throws Exception{
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
        .uri(URI.create("http://localhost:" + port + "/tasks"))
        .GET()
        .build();

        HttpResponse<String> response =
        client.send(request, HttpResponse.BodyHandlers.ofString());
        
        int status = response.statusCode();
        assertTrue(status == 401 || status == 403);
    }
}
