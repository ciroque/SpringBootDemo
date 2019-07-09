package com.marchex.swagner.demo.consul;

import com.orbitz.consul.CatalogClient;
import com.orbitz.consul.Consul;
import com.orbitz.consul.KeyValueClient;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "consul")
public class ConsulClient {
    private String url;

    public String getUrl() {
        return this.url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public CatalogClient getCatalogClient() {
        return this.getClient().catalogClient();
    }

    public Consul getClient() {
        return Consul.builder().withUrl(this.url).build();
    }

    public KeyValueClient getKeyValueClient() {
        return getClient().keyValueClient();
    }
}
