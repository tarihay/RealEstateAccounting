package ru.nsu.gorin.db.realestateaccounting.model.dto.dashboardRelated;

import lombok.Data;
import ru.nsu.gorin.db.realestateaccounting.model.entities.event.EventStatus;

import java.util.EnumMap;

@Data
public class EventStatusCountDTO {

    private EnumMap<EventStatus, Long> eventStatusAndCount;
}
