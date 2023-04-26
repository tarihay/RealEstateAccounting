package ru.nsu.gorin.db.realestateaccounting.model.dto.dashboardRelated;

import lombok.Data;
import ru.nsu.gorin.db.realestateaccounting.model.entities.objectRelated.ObjectStatus;

import java.util.EnumMap;

@Data
public class ObjectStatusCountDTO {

    private EnumMap<ObjectStatus, Long> objectStatusAndCount;
}
