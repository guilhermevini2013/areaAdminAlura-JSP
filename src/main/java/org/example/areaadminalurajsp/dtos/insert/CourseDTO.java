package org.example.areaadminalurajsp.dtos.insert;

import java.util.List;

public class CourseDTO {
    private String nameContent;
    private String description;
    private List<VideoLessonDTO> videoLessonDTOList;
    private CertificateDTO certificateDTO;
    private Long idCategory;

    public CourseDTO(String nameContent, String description, List<VideoLessonDTO> videoLessonDTOList, CertificateDTO certificateDTO,Long idCategory) {
        this.nameContent = nameContent;
        this.description = description;
        this.videoLessonDTOList = videoLessonDTOList;
        this.certificateDTO = certificateDTO;
        this.idCategory = idCategory;
    }

    public String getNameContent() {
        return nameContent;
    }

    public String getDescription() {
        return description;
    }

    public List<VideoLessonDTO> getVideoLessonDTOList() {
        return videoLessonDTOList;
    }

    public CertificateDTO getCertificateDTO() {
        return certificateDTO;
    }

    public Long getIdCategory() {
        return idCategory;
    }
}
