package org.example.areaadminalurajsp.dtos.read;

public class StudentBlockedReadDTO {
    private Long id;
    private String name;
    private String typeSignature;
    private Integer timeBlocked;

    public StudentBlockedReadDTO(Long id, String name, String typeSignature, Integer timeBlocked) {
        this.id = id;
        this.name = name;
        this.typeSignature = typeSignature;
        this.timeBlocked = timeBlocked;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getTypeSignature() {
        return typeSignature;
    }

    public Integer getTimeBlocked() {
        return timeBlocked;
    }
}
