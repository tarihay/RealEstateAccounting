package ru.nsu.gorin.db.realestateaccounting.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.nsu.gorin.db.realestateaccounting.mappers.EventMapper;
import ru.nsu.gorin.db.realestateaccounting.model.dto.EventDTO;
import ru.nsu.gorin.db.realestateaccounting.model.entities.event.Event;
import ru.nsu.gorin.db.realestateaccounting.model.entities.event.EventStatus;
import ru.nsu.gorin.db.realestateaccounting.repository.EventRepository;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EventService {

    private final EventMapper eventMapper;
    private final EventRepository eventRepository;

    @Transactional
    public Integer create(EventDTO dto) {
        Event event = eventMapper.map(dto);
        return eventRepository.save(event).getId();
    }

    public List<EventDTO> getByStatus(EventStatus status) {
        return eventRepository.findByStatus(status).stream().map(eventMapper::map).toList();
    }

    public void overdueEvents() {
        List<Event> events = eventRepository.findAllByEndBeforeAndAndStatusIsNot(LocalDateTime.now(), EventStatus.PAST);
        for (Event event : events) {
            event.setStatus(EventStatus.PAST);
            eventRepository.save(event);
        }
    }
}
