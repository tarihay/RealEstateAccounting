package ru.nsu.gorin.db.realestateaccounting.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.nsu.gorin.db.realestateaccounting.model.entities.objectRelated.Question;

import java.util.List;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Integer> {

    List<Question> findAllByObject(Object object);
}
