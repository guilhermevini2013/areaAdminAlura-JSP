package org.example.areaadminalurajsp.servlets;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public interface IController {
    String execute(HttpServletRequest request, HttpServletResponse response) throws IOException;
}
