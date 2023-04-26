package ru.nsu.gorin.db.realestateaccounting.model.dto;

import lombok.Data;
import ru.nsu.gorin.db.realestateaccounting.model.entities.event.EventStatus;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class EventDTO {
    private Integer id;
    private LocalDateTime start;
    private LocalDateTime end;
    private EventStatus status;
    private List<ObjectDTO> objects;
}
