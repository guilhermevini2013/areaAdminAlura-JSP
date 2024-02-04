package org.example.areaadminalurajsp.servlets.get;

import org.example.areaadminalurajsp.dtos.read.DashBoardReadDTO;
import org.example.areaadminalurajsp.service.dashboard.DashboardService;
import org.example.areaadminalurajsp.service.singletons.DashboardServiceSingleton;
import org.example.areaadminalurajsp.service.util.ControllerUtil;
import org.example.areaadminalurajsp.servlets.IController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class Home implements IController {
    private DashboardService dashboardService = DashboardServiceSingleton.getInstance();

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String token = (String) request.getSession().getAttribute("token");
        DashBoardReadDTO dashBoard = dashboardService.getDashBoard(token);
        request.setAttribute("dashBoard", dashBoard);
        return "forward:homeAdmin.jsp";
    }
}
