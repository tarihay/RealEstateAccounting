package ru.nsu.gorin.db.realestateaccounting.model.entities.objectRelated;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.nsu.gorin.db.realestateaccounting.model.entities.attribute.Attribute;
import ru.nsu.gorin.db.realestateaccounting.model.entities.attribute.AttributeValue;
import ru.nsu.gorin.db.realestateaccounting.model.entities.objectRelated.Object;

import java.io.Serializable;

@Data
@Entity
@Table(name = "Object_Attribute")
@IdClass(ObjectAttribute.ObjectId.class)
@AllArgsConstructor
@NoArgsConstructor
public class ObjectAttribute {
    @Id
    @ManyToOne
    @JoinColumn(name = "object_id", nullable = false)
    private Object object;

    @Id
    @ManyToOne
    @JoinColumn(name = "attribute", nullable = false)
    private Attribute attribute;

    @Id
    @ManyToOne
    @JoinColumn(name = "value_id", nullable = false)
    private AttributeValue value;


    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class ObjectId implements Serializable {
        private Integer object;
        private String attribute;
        private Integer value;
    }

}
