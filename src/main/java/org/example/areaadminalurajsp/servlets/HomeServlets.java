package org.example.areaadminalurajsp.servlets;

import com.google.gson.Gson;
import org.apache.http.impl.client.HttpClients;
import org.example.areaadminalurajsp.connections.ConnectionInitializer;
import org.example.areaadminalurajsp.connections.api.dashboard.DashboardConnection;
import org.example.areaadminalurajsp.dtos.read.DashBoardReadDTO;
import org.example.areaadminalurajsp.service.dashboard.DashboardService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/dashboard")
public class HomeServlets extends HttpServlet {
    private DashboardService dashboardService;

    @Override
    public void init() throws ServletException {
        Gson gson = new Gson();
        ConnectionInitializer initializer = new ConnectionInitializer(HttpClients.createDefault(), gson);
        DashboardConnection dashboardConnection = new DashboardConnection(initializer);
        dashboardService = new DashboardService(dashboardConnection);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DashBoardReadDTO dashBoard = dashboardService.getDashBoard("eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJhdXRoLWFwaSIsInN1YiI6ImFkbWluQGFkbWluIiwiZXhwIjoxNzA1NzEwNTM3fQ.54FLxPpD1Nr5W_QWfmd7FDcZHEML5S-TyhyAh15EW20");
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/homeAdmin.jsp");
        req.setAttribute("dashBoard", dashBoard);
        requestDispatcher.forward(req, resp);
    }
}
