package ru.nsu.gorin.db.realestateaccounting.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.nsu.gorin.db.realestateaccounting.model.entities.objectRelated.ObjectStatus;
import ru.nsu.gorin.db.realestateaccounting.model.entities.objectRelated.Object;

@Repository
public interface ObjectRepository extends JpaRepository<Object, Integer> {

    Object save(Object object);

    long countByStatus(ObjectStatus status);

}
