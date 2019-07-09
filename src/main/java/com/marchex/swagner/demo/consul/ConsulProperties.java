package com.marchex.swagner.demo.consul;

import com.orbitz.consul.Consul;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "consul")
public class ConsulProperties {
    private String url;

    public String getUrl() {
        return this.url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Consul getClient() {
        return Consul.builder().withUrl(this.url).build();
    }
}
