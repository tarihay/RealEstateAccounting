package ru.nsu.gorin.db.realestateaccounting.model.entities.attribute;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "Attribute")
@NoArgsConstructor
@AllArgsConstructor
public class Attribute {
    @Id
    @Column(name = "name", nullable = false)
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(name = "type", nullable = false)
    private Type type;
}
