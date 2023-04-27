package ru.nsu.gorin.db.realestateaccounting.mappers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.nsu.gorin.db.realestateaccounting.model.dto.EventDTO;
import ru.nsu.gorin.db.realestateaccounting.model.entities.event.Event;

@Component
@RequiredArgsConstructor
public class EventMapper {
    private final ObjectMapper objectMapper;

    public Event map(EventDTO dto) {
        Event event = new Event();
        event.setStart(dto.getStart());
        event.setEnd(dto.getEnd());
        event.setStatus(dto.getStatus());
        event.setId(dto.getId());
        event.setObjects(dto.getObjects().stream().map(objectMapper::map).toList());
        return event;
    }

    public EventDTO map(Event event) {
        EventDTO dto = new EventDTO();
        dto.setEnd(event.getEnd());
        dto.setStart(event.getStart());
        dto.setStatus(event.getStatus());
        dto.setId(event.getId());
        dto.setObjects(event.getObjects().stream().map(objectMapper::map).toList());
        return dto;
    }
}
