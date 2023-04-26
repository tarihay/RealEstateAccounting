package ru.nsu.gorin.db.realestateaccounting.model.entities.event;

import jakarta.persistence.*;
import lombok.Data;
import ru.nsu.gorin.db.realestateaccounting.model.entities.objectRelated.Object;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@Table(name = "Event")
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "start_execution", nullable = false)
    private LocalDateTime start;

    @Column(name = "end_exexcution", nullable = false)
    private LocalDateTime end;

    @Enumerated(EnumType.STRING)
    private EventStatus status;

    @ManyToMany
    @JoinTable(
            name = "Event_Object",
            joinColumns = @JoinColumn(name = "event_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "object_id", referencedColumnName = "id")
    )
    private List<Object> objects;

}
