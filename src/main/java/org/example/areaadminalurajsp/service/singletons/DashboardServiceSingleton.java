package org.example.areaadminalurajsp.service.singletons;

import com.google.gson.Gson;
import org.apache.http.impl.client.HttpClients;
import org.example.areaadminalurajsp.connections.ConnectionInitializer;
import org.example.areaadminalurajsp.connections.api.dashboard.DashboardConnection;
import org.example.areaadminalurajsp.service.dashboard.DashboardService;

public class DashboardServiceSingleton {
    private static DashboardService dashboardService;

    private DashboardServiceSingleton() {
        Gson gson = new Gson();
        ConnectionInitializer initializer = new ConnectionInitializer(HttpClients.createDefault(), gson);
        DashboardConnection dashboardConnection = new DashboardConnection(initializer);
        dashboardService = new DashboardService(dashboardConnection);
    }

    public static DashboardService getInstance() {
        if (dashboardService == null) {
            new DashboardServiceSingleton();
        }
        return dashboardService;
    }
}
