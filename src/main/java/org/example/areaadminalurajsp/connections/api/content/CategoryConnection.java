package org.example.areaadminalurajsp.connections.api.content;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.util.EntityUtils;
import org.example.areaadminalurajsp.connections.ConnectionInitializer;
import org.example.areaadminalurajsp.dtos.read.CategoryReadDTO;

import java.io.IOException;
import java.net.URI;

public class CategoryConnection {
    private final ConnectionInitializer connection;

    public CategoryConnection(ConnectionInitializer initializer) {
        this.connection = initializer;
    }
    public CategoryReadDTO[] getAllCategories(String token) throws IOException {
        URI uri = URI.create("http://localhost:8080/category");
        CloseableHttpResponse response = connection.doGetRequest(uri, token);
        String json = EntityUtils.toString(response.getEntity());
        return connection.getGson().fromJson(json, CategoryReadDTO[].class);
    }
}
