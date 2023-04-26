package ru.nsu.gorin.db.realestateaccounting.model.entities.objectRelated;

import jakarta.persistence.*;
import lombok.Data;


@Data
@Entity
@Table(name = "Question")
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String question;

    @ManyToOne
    @JoinColumn(name = "object_id", nullable = false)
    private Object object;

}
