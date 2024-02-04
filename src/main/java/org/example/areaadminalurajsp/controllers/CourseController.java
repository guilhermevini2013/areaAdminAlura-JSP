package org.example.areaadminalurajsp.controllers;

import org.example.areaadminalurajsp.service.util.ControllerUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/course")
public class CourseController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ControllerUtil.prepare(req, resp, "org.example.areaadminalurajsp.servlets.get.");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ControllerUtil.prepare(req, resp, "org.example.areaadminalurajsp.servlets.post.");
    }
}
