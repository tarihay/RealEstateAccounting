package ru.nsu.gorin.db.realestateaccounting.model.entities.objectRelated;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "Attachment")
public class Attachment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "document_id")
    private String documentID;

    @Column(name = "file_name")
    private String fileName;

    @ManyToOne
    @JoinColumn(name = "object_id", nullable = false)
    private Object object;
}
