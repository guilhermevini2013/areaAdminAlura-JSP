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
}
