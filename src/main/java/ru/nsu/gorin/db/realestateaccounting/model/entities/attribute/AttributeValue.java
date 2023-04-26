package ru.nsu.gorin.db.realestateaccounting.model.entities.attribute;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "Attribute_Value")
@NoArgsConstructor
public class AttributeValue {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;


    @ManyToOne
    @JoinColumn(name = "attribute", nullable = false)
    private Attribute attribute;

    @Column(name = "value", nullable = false)
    private String value;

    public AttributeValue(Attribute attribute, String value) {
        this.attribute = attribute;
        this.value = value;
    }
}
