package org.example.areaadminalurajsp.servlets.post;

import org.example.areaadminalurajsp.dtos.insert.CertificateDTO;
import org.example.areaadminalurajsp.dtos.insert.CourseDTO;
import org.example.areaadminalurajsp.dtos.insert.VideoLessonDTO;
import org.example.areaadminalurajsp.service.course.CourseService;
import org.example.areaadminalurajsp.service.singletons.CourseServiceSingleton;
import org.example.areaadminalurajsp.servlets.IController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class CourseForm implements IController {
    private CourseService courseService = CourseServiceSingleton.getInstance();
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String token = (String) request.getSession().getAttribute("token");
        String nameCourse = request.getParameter("nameCourse");
        String descriptionCourse = request.getParameter("descriptionCourse");
        String inf = courseService.addCourse(new CourseDTO(nameCourse, descriptionCourse, createVideoLesson(null), createCertificate(null)), token);
        request.setAttribute("messageInf",inf);
        return "redirect:courses?action=Courses";
    }
    private CertificateDTO createCertificate(String nameCertificate){
        return null;
    }
    private List<VideoLessonDTO> createVideoLesson(String[] videoLessons){
        return null;
    }
}
