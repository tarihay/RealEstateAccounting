package ru.nsu.gorin.db.realestateaccounting.model.dto;

import lombok.Data;
import ru.nsu.gorin.db.realestateaccounting.model.entities.userRelated.TypeOfWork;

@Data
public class GroupDTO {
    private String name;
    private TypeOfWork typeOfWork;
}
