package org.example.areaadminalurajsp.service.singletons;

import com.google.gson.Gson;
import org.apache.http.impl.client.HttpClients;
import org.example.areaadminalurajsp.connections.ConnectionInitializer;
import org.example.areaadminalurajsp.connections.api.admin.AdminConnection;
import org.example.areaadminalurajsp.connections.api.course.CourseConnection;
import org.example.areaadminalurajsp.service.admin.AdminService;
import org.example.areaadminalurajsp.service.course.CourseService;

public class CourseServiceSingleton {
    private static CourseService courseService;

    private CourseServiceSingleton() {
        Gson gson = new Gson();
        ConnectionInitializer initializer = new ConnectionInitializer(HttpClients.createDefault(), gson);
        CourseConnection adminConnection = new CourseConnection(initializer);
        courseService = new CourseService(adminConnection);
    }
    public static CourseService getInstance(){
        if (courseService == null){
            new CourseServiceSingleton();
        }
        return courseService;
    }
}
