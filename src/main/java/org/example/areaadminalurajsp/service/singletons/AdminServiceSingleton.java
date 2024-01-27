package org.example.areaadminalurajsp.service.singletons;

import com.google.gson.Gson;
import org.apache.http.impl.client.HttpClients;
import org.example.areaadminalurajsp.connections.ConnectionInitializer;
import org.example.areaadminalurajsp.connections.api.admin.AdminConnection;
import org.example.areaadminalurajsp.service.admin.AdminService;

public class AdminServiceSingleton {
    private static AdminService adminService;

    private AdminServiceSingleton() {
        Gson gson = new Gson();
        ConnectionInitializer initializer = new ConnectionInitializer(HttpClients.createDefault(), gson);
        AdminConnection adminConnection = new AdminConnection(initializer);
        adminService = new AdminService(adminConnection);
    }

    public static AdminService getInstance() {
        if (adminService == null) {
            new AdminServiceSingleton();
        }
        return adminService;
    }
}
