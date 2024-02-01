package org.example.areaadminalurajsp.servlets.post;

import org.example.areaadminalurajsp.servlets.IController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LogoutForm implements IController {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.getSession().invalidate();
        return "redirect:login?action=Login";
    }
}
