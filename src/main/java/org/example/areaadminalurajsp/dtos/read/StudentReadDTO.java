package org.example.areaadminalurajsp.dtos.read;

public class StudentReadDTO {
    private Long id;
    private String name;
    private String typeSignature;

    public StudentReadDTO(Long id, String name, String typeSignature) {
        this.id = id;
        this.name = name;
        this.typeSignature = typeSignature;
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
}
