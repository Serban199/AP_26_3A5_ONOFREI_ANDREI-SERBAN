package com.example.hm7;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class Client implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:8081/movies";

        try {
            String response = restTemplate.getForObject(url, String.class);
            System.out.println("client: " + response);
        } catch (Exception e) {
            System.out.println("server indisponibil");
        }
    }
}