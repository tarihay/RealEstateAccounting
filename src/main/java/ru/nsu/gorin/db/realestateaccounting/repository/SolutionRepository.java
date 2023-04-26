package ru.nsu.gorin.db.realestateaccounting.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.nsu.gorin.db.realestateaccounting.model.entities.solutionRelated.Solution;
import ru.nsu.gorin.db.realestateaccounting.model.entities.solutionRelated.SolutionStatus;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface SolutionRepository extends JpaRepository<Solution, Integer> {

    List<Solution> findAllByEndBeforeAndSolutionStatusIsNot(LocalDateTime end, SolutionStatus solutionStatus);
}
