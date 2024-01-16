package org.example.areaadminalurajsp.dtos.read;

public class DashBoardReadDTO {
    private Long totalStudent;
    private Integer totalTraining;
    private Integer totalCourses;

    public DashBoardReadDTO(Long totalStudent, Integer totalTraining, Integer totalCourse) {
        this.totalStudent = totalStudent;
        this.totalTraining = totalTraining;
        this.totalCourses = totalCourse;
    }
    public DashBoardReadDTO(){

    }

    public Long getTotalStudent() {
        return totalStudent;
    }

    public Integer getTotalTraining() {
        return totalTraining;
    }

    public Integer getTotalCourse() {
        return totalCourses;
    }

    public void setTotalStudent(Long totalStudent) {
        this.totalStudent = totalStudent;
    }

    public Integer getTotalCourses() {
        return totalCourses;
    }

    public void setTotalTraining(Integer totalTraining) {
        this.totalTraining = totalTraining;
    }

    public void setTotalCourse(Integer totalCourse) {
        this.totalCourses = totalCourse;
    }
}
