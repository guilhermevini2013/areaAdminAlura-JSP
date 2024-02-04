package org.example.areaadminalurajsp.filters;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(urlPatterns = {"/dashboard", "/student", "/course"})
public class ControllerFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        String token = (String) request.getSession().getAttribute("token");
        if (token == null) {
            response.sendRedirect("/admin/login?action=Login");
            return;
        }
        filterChain.doFilter(servletRequest,servletResponse);
    }
}
