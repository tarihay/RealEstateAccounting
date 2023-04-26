package ru.nsu.gorin.db.realestateaccounting.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.nsu.gorin.db.realestateaccounting.model.entities.attribute.Attribute;
import ru.nsu.gorin.db.realestateaccounting.model.entities.attribute.AttributeValue;

import java.util.List;
import java.util.Optional;

@Repository
public interface AttributeValueRepository extends JpaRepository<AttributeValue, Integer> {

    List<AttributeValue> findByAttribute(Attribute attribute);

    Optional<AttributeValue> findByAttributeAndValue(Attribute attribute, String value);

    AttributeValue save(AttributeValue attributeValue);
}

