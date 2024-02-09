package org.example.areaadminalurajsp.connections.api.dashboard;

import com.google.gson.Gson;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.util.EntityUtils;
import org.example.areaadminalurajsp.connections.ConnectionInitializer;
import org.example.areaadminalurajsp.dtos.read.DashBoardReadDTO;

import java.io.IOException;
import java.net.URI;

public class DashboardConnection {
    private final ConnectionInitializer connection;

    public DashboardConnection(ConnectionInitializer connection) {
        this.connection = connection;
    }
    public DashBoardReadDTO getDashboard(String token) throws IOException {
        URI uri = URI.create("http://localhost:8080/admin/dashboard");
        CloseableHttpResponse response = connection.doGetRequest(uri, token);
        String json = EntityUtils.toString(response.getEntity());
        return connection.getGson().fromJson(json, DashBoardReadDTO.class);
    }
}
