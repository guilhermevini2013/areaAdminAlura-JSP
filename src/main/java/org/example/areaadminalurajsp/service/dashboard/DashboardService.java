package org.example.areaadminalurajsp.service.dashboard;

import org.example.areaadminalurajsp.connections.api.dashboard.DashboardConnection;
import org.example.areaadminalurajsp.dtos.read.DashBoardReadDTO;

import java.io.IOException;

public class DashboardService {
    private DashboardConnection dashboardConnection;

    public DashboardService(DashboardConnection dashboardConnection) {
        this.dashboardConnection = dashboardConnection;
    }
    public DashBoardReadDTO getDashBoard(String token) throws IOException {
        DashBoardReadDTO dashboard = dashboardConnection.getDashboard(token);
        return dashboard;

    }
}
