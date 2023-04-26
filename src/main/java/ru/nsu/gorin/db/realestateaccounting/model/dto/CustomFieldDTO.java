package ru.nsu.gorin.db.realestateaccounting.model.dto;

import lombok.Data;
import ru.nsu.gorin.db.realestateaccounting.model.entities.attribute.Type;

import java.util.List;

@Data
public class CustomFieldDTO {
    private String name;
    private String value;
    private Type type;
    private List<String> possibleValues;
}
