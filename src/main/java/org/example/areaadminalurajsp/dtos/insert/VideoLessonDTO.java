package org.example.areaadminalurajsp.dtos.insert;

public class VideoLessonDTO {
    private String nameLesson;
    private String archive;
    private Integer duration = 40;

    public VideoLessonDTO( String nameLesson, String archive) {
        this.nameLesson = nameLesson;
        this.archive = archive;
    }
    public VideoLessonDTO( ) {
    }

    public void setNameLesson(String nameLesson) {
        this.nameLesson = nameLesson;
    }

    public void setArchive(String archive) {
        this.archive = archive;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public String getNameLesson() {
        return nameLesson;
    }

    public String getArchive() {
        return archive;
    }

    public Integer getDuration() {
        return duration;
    }
}
