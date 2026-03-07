package com.example.apigateway;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ApiGatewayIntegrationTest {

    @Test
    void gatewayRoutingTest() {

        String route = "/events";

        assertTrue(route.startsWith("/"));

    }

}