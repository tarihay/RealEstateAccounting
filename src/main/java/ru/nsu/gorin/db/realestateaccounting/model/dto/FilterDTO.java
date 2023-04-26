package ru.nsu.gorin.db.realestateaccounting.model.dto;

import lombok.Data;
import ru.nsu.gorin.db.realestateaccounting.model.entities.objectRelated.ObjectStatus;

@Data
public class FilterDTO {
    private String county;
    private String district;
    private String address;
    private String type;
    private ObjectStatus status;
    private Double areaValue;
    private String actualUser;
    private String owner;
}
