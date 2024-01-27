package org.example.areaadminalurajsp.servlets.post;

import com.google.gson.Gson;
import org.apache.http.impl.client.HttpClients;
import org.example.areaadminalurajsp.connections.ConnectionInitializer;
import org.example.areaadminalurajsp.connections.api.admin.AdminConnection;
import org.example.areaadminalurajsp.service.admin.AdminService;
import org.example.areaadminalurajsp.servlets.IController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UnblockStudent implements IController {
    String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJhdXRoLWFwaSIsInN1YiI6ImFkbWluQGFkbWluIiwiZXhwIjoxNzA2NDMzNjIxfQ.WbjiLvLkdvU9xHc20-_DP4qooZOwOsJ-K-T-d83PizM";
    private AdminService adminService;

    {
        Gson gson = new Gson();
        ConnectionInitializer initializer = new ConnectionInitializer(HttpClients.createDefault(), gson);
        AdminConnection adminConnection = new AdminConnection(initializer);
        adminService = new AdminService(adminConnection);
    }
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String idStudent = request.getParameter("idStudent");
        adminService.unblockStudent(Long.valueOf(idStudent),token);
        return "redirect:student?action=Student";
    }
}
