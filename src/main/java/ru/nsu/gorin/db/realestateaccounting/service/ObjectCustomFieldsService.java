package ru.nsu.gorin.db.realestateaccounting.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.nsu.gorin.db.realestateaccounting.mappers.AttributeMapper;
import ru.nsu.gorin.db.realestateaccounting.model.dto.CustomFieldDTO;
import ru.nsu.gorin.db.realestateaccounting.model.entities.attribute.Attribute;
import ru.nsu.gorin.db.realestateaccounting.model.entities.attribute.AttributeValue;
import ru.nsu.gorin.db.realestateaccounting.model.entities.objectRelated.ObjectAttribute;
import ru.nsu.gorin.db.realestateaccounting.repository.AttributeRepository;
import ru.nsu.gorin.db.realestateaccounting.repository.AttributeValueRepository;
import ru.nsu.gorin.db.realestateaccounting.repository.ObjectAttributeRepository;
import ru.nsu.gorin.db.realestateaccounting.model.entities.objectRelated.Object;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ObjectCustomFieldsService {

    private final AttributeValueRepository attributeValueRepository;
    private final ObjectAttributeRepository objectAttributeRepository;
    private final AttributeRepository attributeRepository;
    private final AttributeMapper attributeMapper;

    public List<CustomFieldDTO> getAllFCustomFields() {
        List<ObjectAttribute> objectAttributes = objectAttributeRepository.findAll();

        return objectAttributes.stream()
                .map(objectAttribute -> attributeMapper.map(objectAttribute, new ArrayList<>())).toList();
    }

    public List<CustomFieldDTO> getByObject(Object object) {
        List<ObjectAttribute> objectAttributes = objectAttributeRepository.findByObject(object);
        return objectAttributes.stream().map(objectAttribute ->
        {
            List<String> values = attributeValueRepository.findByAttribute(objectAttribute.getAttribute()).stream()
                    .map(AttributeValue::getValue)
                    .toList();
            return attributeMapper.map(objectAttribute, values);
        }).toList();

    }

    @Transactional
    public void updateCustomFieldsValues(Object object, List<CustomFieldDTO> customFieldDTOS) {
        customFieldDTOS.forEach(customFieldDTO -> {
            Attribute attribute = attributeRepository.findByName(customFieldDTO.getName())
                    .orElse(attributeRepository.save(new Attribute(customFieldDTO.getName(), customFieldDTO.getType())));
            Optional<ObjectAttribute> maybeObjectAttribute = objectAttributeRepository.findByObjectAndAttribute(object, attribute);

            if (maybeObjectAttribute.isPresent()) {
                ObjectAttribute objectAttribute = maybeObjectAttribute.get();
                AttributeValue value = objectAttribute.getValue();
                if (!Objects.equals(value.getValue(), customFieldDTO.getValue())) {
                    AttributeValue newValue = attributeValueRepository.save(new AttributeValue(attribute, customFieldDTO.getValue()));
                    objectAttribute.setValue(newValue);

                }
            } else {
                ObjectAttribute objectAttribute =
                        new ObjectAttribute(object, attribute, attributeValueRepository.save(new AttributeValue(attribute, customFieldDTO.getValue())));
                objectAttributeRepository.save(objectAttribute);
            }

        });


    }

}
