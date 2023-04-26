package ru.nsu.gorin.db.realestateaccounting.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.nsu.gorin.db.realestateaccounting.model.entities.attribute.Attribute;
import ru.nsu.gorin.db.realestateaccounting.model.entities.objectRelated.ObjectAttribute;

import java.util.List;
import java.util.Optional;

@Repository
public interface ObjectAttributeRepository extends JpaRepository<ObjectAttribute, ObjectAttribute.ObjectId> {

    List<ObjectAttribute> findByObject(Object object);

    Optional<ObjectAttribute> findByObjectAndAttribute(Object object, Attribute attribute);

}
