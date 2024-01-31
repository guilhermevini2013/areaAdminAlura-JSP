package org.example.areaadminalurajsp.servlets.get;

import org.example.areaadminalurajsp.servlets.IController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Login implements IController {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        return "forward:login.jsp";
    }
}
