package com.platform.reservations;

import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

@Component
public class DefaultWebClient {


    WebClient client = WebClient.create("http://localhost:8080");
}
