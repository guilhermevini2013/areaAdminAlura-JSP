package org.example.areaadminalurajsp.controllers;

import org.example.areaadminalurajsp.service.util.ControllerUtil;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(value = "/course")
public class CourseController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        ControllerUtil.prepare(req, resp, "org.example.areaadminalurajsp.servlets.get.");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        ControllerUtil.prepare(req, resp, "org.example.areaadminalurajsp.servlets.post.");
    }
}
