package ru.nsu.gorin.db.realestateaccounting.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.nsu.gorin.db.realestateaccounting.model.entities.event.Event;
import ru.nsu.gorin.db.realestateaccounting.model.entities.event.EventStatus;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface EventRepository extends JpaRepository<Event,Integer> {
    Event save(Event event);

    List<Event> findByStatus(EventStatus status);

    List<Event> findAllByEndBeforeAndAndStatusIsNot(LocalDateTime date, EventStatus status);
}
