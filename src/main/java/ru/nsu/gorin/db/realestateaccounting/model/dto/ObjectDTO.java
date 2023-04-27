package ru.nsu.gorin.db.realestateaccounting.model.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import ru.nsu.gorin.db.realestateaccounting.model.entities.objectRelated.ObjectStatus;

import java.util.List;

@Data
@NoArgsConstructor
public class ObjectDTO {

    private Integer id;
    private String county;
    private String district;
    private String address;
    private String type;
    private ObjectStatus status;
    private Double area;
    private String actualUser;
    private String owner;
    private List<CustomFieldDTO> customFields;

    public ObjectDTO(List<CustomFieldDTO> customFields) {
        this.customFields = customFields;
    }
}
