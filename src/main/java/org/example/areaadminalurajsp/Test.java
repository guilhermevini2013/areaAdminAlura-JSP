package org.example.areaadminalurajsp;

import org.example.areaadminalurajsp.connections.api.course.CourseConnection;

import java.io.IOException;

public class Test {
    public static void main(String[] args) throws IOException {
        CourseConnection connection = new CourseConnection();
        String token  = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJhdXRoLWFwaSIsInN1YiI6ImFkbWluQGFkbWluIiwiZXhwIjoxNzA1MDczODA0fQ.NA2bYsZ1IbxtXmv7rjiyYMaAvRPgOjFcQ5cKoPHUETA";
        System.out.println(connection.getCourseByID(1l,token));
    }
}
