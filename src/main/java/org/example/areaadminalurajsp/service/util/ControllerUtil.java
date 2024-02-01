package org.example.areaadminalurajsp.service.util;

import org.example.areaadminalurajsp.servlets.IController;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class ControllerUtil {

    private static void send(String result, HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (result != null) {
            String[] typeAction = result.split(":");
            if (typeAction[0].equals("forward")) {
                RequestDispatcher dispatcher = req.getRequestDispatcher("WEB-INF/view/" + typeAction[1]);
                dispatcher.forward(req, resp);
            } else if (typeAction[0].equals("redirect")) {
                resp.sendRedirect(typeAction[1]);
            }
        }
    }

    public static void prepare(HttpServletRequest req, HttpServletResponse resp,String className) {
        String action = req.getParameter("action");
        Class classAction = null;
        try {
            classAction = Class.forName(className + action);
            IController controller = (IController) classAction.newInstance();
            String result = controller.execute(req, resp);
            ControllerUtil.send(result, req, resp);
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | ServletException |
                 IOException e) {
            throw new RuntimeException(e);
        }
    }
}
