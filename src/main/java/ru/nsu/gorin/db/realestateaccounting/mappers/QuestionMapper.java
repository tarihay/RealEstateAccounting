package ru.nsu.gorin.db.realestateaccounting.mappers;

import org.springframework.stereotype.Component;
import ru.nsu.gorin.db.realestateaccounting.model.dto.QuestionDTO;
import ru.nsu.gorin.db.realestateaccounting.model.entities.objectRelated.Question;

@Component
public class QuestionMapper {

    public QuestionDTO map(Question question) {
        QuestionDTO dto = new QuestionDTO();
        dto.setQuestion(question.getQuestion());
        dto.setId(question.getId());
        return dto;
    }

    public Question map(QuestionDTO dto) {
        Question question = new Question();
        question.setQuestion(dto.getQuestion());
        question.setId(dto.getId());
        return question;
    }
}
