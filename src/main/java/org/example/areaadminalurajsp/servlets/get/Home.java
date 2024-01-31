package org.example.areaadminalurajsp.servlets.get;

import org.example.areaadminalurajsp.dtos.read.DashBoardReadDTO;
import org.example.areaadminalurajsp.service.dashboard.DashboardService;
import org.example.areaadminalurajsp.service.singletons.DashboardServiceSingleton;
import org.example.areaadminalurajsp.servlets.IController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Home implements IController {
    private DashboardService dashboardService = DashboardServiceSingleton.getInstance();

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        DashBoardReadDTO dashBoard = dashboardService.getDashBoard("eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJhdXRoLWFwaSIsInN1YiI6ImFkbWluQGFkbWluIiwiZXhwIjoxNzA2NTMwMzg2fQ.JeyLGqRaioa6V9jjlKCHFlxPE2Y8m6VZu9RhpAt3Ytc");
        request.setAttribute("dashBoard", dashBoard);
        return "forward:homeAdmin.jsp";
    }
}
