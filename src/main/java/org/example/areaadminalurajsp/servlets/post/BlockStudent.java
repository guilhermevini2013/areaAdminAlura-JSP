package org.example.areaadminalurajsp.servlets.post;

import com.google.gson.Gson;
import org.apache.http.impl.client.HttpClients;
import org.example.areaadminalurajsp.connections.ConnectionInitializer;
import org.example.areaadminalurajsp.connections.api.admin.AdminConnection;
import org.example.areaadminalurajsp.service.admin.AdminService;
import org.example.areaadminalurajsp.service.singletons.AdminServiceSingleton;
import org.example.areaadminalurajsp.service.util.ControllerUtil;
import org.example.areaadminalurajsp.servlets.IController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class BlockStudent implements IController {
    private AdminService adminService = AdminServiceSingleton.getInstance();

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String token = (String) request.getSession().getAttribute("token");
        String idStudent = request.getParameter("idStudent");
        String hours = request.getParameter("hours");
        adminService.blockStudent(Long.valueOf(idStudent), Integer.valueOf(hours), token);
        return "redirect:student?action=Student";
    }
}
