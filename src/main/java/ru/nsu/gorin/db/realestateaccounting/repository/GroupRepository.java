package ru.nsu.gorin.db.realestateaccounting.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.nsu.gorin.db.realestateaccounting.model.entities.userRelated.ExecutionGroup;

import java.util.Optional;

@Repository
public interface GroupRepository extends JpaRepository<ExecutionGroup, Integer> {
    Optional<ExecutionGroup> findByGroupName(String name);
}
