package org.example.areaadminalurajsp.servlets.post;

import org.example.areaadminalurajsp.dtos.read.LoginAdmin;
import org.example.areaadminalurajsp.service.admin.AdminService;
import org.example.areaadminalurajsp.service.singletons.AdminServiceSingleton;
import org.example.areaadminalurajsp.servlets.IController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LoginForm implements IController {
    private AdminService adminService = AdminServiceSingleton.getInstance();

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String token = adminService.loginAdmin(new LoginAdmin(email, password));
        if (token != null) {
            HttpSession session = request.getSession();
            session.setAttribute("token",token);
            return "redirect:dashboard?action=Home";
        }
        return null;
    }
}
