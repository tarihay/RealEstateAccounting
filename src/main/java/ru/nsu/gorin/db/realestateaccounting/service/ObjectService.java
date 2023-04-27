package ru.nsu.gorin.db.realestateaccounting.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.nsu.gorin.db.realestateaccounting.mappers.ObjectMapper;
import ru.nsu.gorin.db.realestateaccounting.mappers.QuestionMapper;
import ru.nsu.gorin.db.realestateaccounting.model.dto.CustomFieldDTO;
import ru.nsu.gorin.db.realestateaccounting.model.dto.ObjectDTO;
import ru.nsu.gorin.db.realestateaccounting.model.dto.QuestionDTO;
import ru.nsu.gorin.db.realestateaccounting.model.entities.objectRelated.ObjectStatus;
import ru.nsu.gorin.db.realestateaccounting.model.entities.objectRelated.Question;
import ru.nsu.gorin.db.realestateaccounting.repository.ObjectRepository;
import ru.nsu.gorin.db.realestateaccounting.repository.QuestionRepository;
import ru.nsu.gorin.db.realestateaccounting.utils.exceptions.NoEntityFoundException;
import ru.nsu.gorin.db.realestateaccounting.model.entities.objectRelated.Object;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ObjectService {

    private final ObjectRepository objectRepository;
    private final QuestionRepository questionRepository;
    private final ObjectMapper objectMapper;

    private final QuestionMapper questionMapper;
    private final ObjectCustomFieldsService objectCustomFieldsService;


    @Transactional
    public Integer create(ObjectDTO dto) {
        return objectRepository.save(objectMapper.map(dto)).getId();

    }

    @Transactional
    public void update(Integer id, ObjectDTO dto) {
        Object oldObject = objectRepository.findById(id)
                .orElseThrow(() -> new NoEntityFoundException("Нет объекта с id " + id));

        Object updatedObject = objectMapper.map(dto);
        updatedObject.setId(oldObject.getId());

        objectRepository.save(updatedObject);
        objectCustomFieldsService.updateCustomFieldsValues(objectRepository.save(updatedObject), dto.getCustomFields());
    }

    public void delete(Integer id) {
        Object object = objectRepository.findById(id)
                .orElseThrow(() -> new NoEntityFoundException("Нет объекта с id " + id));
        objectRepository.delete(object);
    }

    public ObjectDTO getNewObject() {
        List<CustomFieldDTO> customFieldDTOS = objectCustomFieldsService.getAllFCustomFields();
        return new ObjectDTO(customFieldDTOS);
    }

    public ObjectDTO getObject(Integer id) {
        Object object = objectRepository.findById(id).orElseThrow(() -> new NoEntityFoundException("Нет объекта с id " + id));

        return objectMapper.map(object, objectCustomFieldsService.getByObject(object));
    }

    public List<ObjectDTO> getObjects(Integer amount, Integer skip) {
        return objectRepository.findAll().stream().skip(skip).limit(amount).map(objectMapper::map).collect(Collectors.toList());
    }

    public long getTotalCount() {
        return objectRepository.count();
    }

    public long getCountByStatus(ObjectStatus status) {
        return objectRepository.countByStatus(status);
    }

    public List<QuestionDTO> getQuestions(Integer objectId) {
        Object object = objectRepository.findById(objectId).orElseThrow(() -> new NoEntityFoundException("Нет объекта с id " + objectId));
        return questionRepository.findAllByObject(object).stream().map(questionMapper::map).toList();
    }

    @Transactional
    public void createQuestion(Integer objectId, QuestionDTO questionDTO) {
        Object object = objectRepository.findById(objectId).orElseThrow(() -> new NoEntityFoundException("Нет объекта с id " + objectId));
        Question question = questionMapper.map(questionDTO);
        question.setObject(object);
        questionRepository.save(question);
    }
}
