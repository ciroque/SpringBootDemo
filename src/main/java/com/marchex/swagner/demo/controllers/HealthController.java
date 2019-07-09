package com.marchex.swagner.demo.controllers;

import com.marchex.swagner.demo.consul.ConsulClient;
import com.marchex.swagner.demo.pojo.ConsulConnectResponse;
import com.marchex.swagner.demo.pojo.HealthResponse;
import com.marchex.swagner.demo.pojo.Libraries;
import com.orbitz.consul.Consul;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthController {

    @Autowired
    private ConsulClient consulClient;

    @RequestMapping("/health")
    public HealthResponse health() {
        return new HealthResponse("Healthy");
    }

    @RequestMapping("/health/consul-connection")
    public ConsulConnectResponse testConsulConnection() {
        ConsulConnectResponse response;
        try {
            Consul client = consulClient.getClient();
            response = new ConsulConnectResponse(String.format("available: %s", client.statusClient().getLeader()));
        } catch(Exception ex) {
            response = new ConsulConnectResponse(String.format("not-available: %s", ex.getMessage()));
        }

        return response;
    }

    @RequestMapping("/health/ping")
    public String ping() {
        return "pong";
    }

    @RequestMapping("/health/libraries")
    public Libraries libraries() {
        return Libraries.GetLibraries();
    }
}
