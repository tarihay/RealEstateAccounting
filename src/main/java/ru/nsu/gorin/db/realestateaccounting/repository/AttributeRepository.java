package ru.nsu.gorin.db.realestateaccounting.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.nsu.gorin.db.realestateaccounting.model.entities.attribute.Attribute;

import java.util.Optional;

@Repository
public interface AttributeRepository extends JpaRepository<Attribute, String> {

    Optional<Attribute> findByName(String name);

    Attribute save(Attribute attribute);
}
