package ru.nsu.gorin.db.realestateaccounting.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ru.nsu.gorin.db.realestateaccounting.mappers.ObjectMapper;
import ru.nsu.gorin.db.realestateaccounting.model.dto.FilterDTO;
import ru.nsu.gorin.db.realestateaccounting.model.dto.ObjectDTO;
import ru.nsu.gorin.db.realestateaccounting.repository.ObjectRepository;
import ru.nsu.gorin.db.realestateaccounting.model.entities.objectRelated.Object;

@Service
@RequiredArgsConstructor
public class ObjectRegistryService {

    private final ObjectRepository objectRepository;

    private final ObjectMapper objectMapper;

    public Page<ObjectDTO> getObjectsRegistry(int pageNumber, int pageSize) {
        Pageable pageable = PageRequest.of(pageNumber, pageSize);
        return objectRepository.findAll(pageable).map(objectMapper::map);
    }

    public Page<ObjectDTO> getObjectsRegistryByFilter(int pageNumber, int pageSize, FilterDTO filterDTO) {
        ExampleMatcher matcher = ExampleMatcher.matching()
                .withIgnoreCase()
                .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);
        Example<Object> example = Example.of(objectMapper.map(filterDTO), matcher);
        Pageable pageable = PageRequest.of(pageNumber, pageSize);
        return objectRepository.findAll(example, pageable).map(objectMapper::map);
    }

}
