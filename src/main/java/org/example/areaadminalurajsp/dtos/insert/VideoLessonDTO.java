package org.example.areaadminalurajsp.dtos.insert;

public class VideoLessonDTO {
    private String nameLesson;
    private String archive;
    private Integer duration;

    public VideoLessonDTO( String nameLesson, String archive, Integer duration) {
        this.nameLesson = nameLesson;
        this.archive = archive;
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
