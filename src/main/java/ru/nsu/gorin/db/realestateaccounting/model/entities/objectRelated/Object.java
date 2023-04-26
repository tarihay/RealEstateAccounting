package ru.nsu.gorin.db.realestateaccounting.model.entities.objectRelated;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.nsu.gorin.db.realestateaccounting.model.entities.event.Event;
import ru.nsu.gorin.db.realestateaccounting.model.entities.solutionRelated.Solution;

import java.util.List;

@Data
@Entity
@Table(name = "Object")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Object {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @NotNull
    private String county;

    @NotNull
    private String district;

    @NotNull
    private String address;

    @NotNull
    private String type;

    @Enumerated(EnumType.STRING)
    private ObjectStatus status;

    @NotNull
    private Double area;

    @NotNull
    private String owner;

    @NotNull
    private String actualUser;

    @OneToMany(mappedBy = "object")
    private List<Attachment> attachments;

    @OneToMany(mappedBy = "object")
    private List<Solution> solutions;

    @OneToMany(mappedBy = "object")
    private List<Question> questions;

    @ManyToMany(mappedBy = "objects")
    private List<Event> events;


}
