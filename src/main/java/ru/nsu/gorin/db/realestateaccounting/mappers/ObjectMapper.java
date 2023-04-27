package ru.nsu.gorin.db.realestateaccounting.mappers;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.nsu.gorin.db.realestateaccounting.model.dto.CustomFieldDTO;
import ru.nsu.gorin.db.realestateaccounting.model.dto.FilterDTO;
import ru.nsu.gorin.db.realestateaccounting.model.dto.ObjectDTO;
import ru.nsu.gorin.db.realestateaccounting.model.entities.objectRelated.Object;


import java.util.List;


@Component
@RequiredArgsConstructor
public class ObjectMapper {

    public ObjectDTO map(Object object) {
        if (object == null) {
            return new ObjectDTO();
        }
        ObjectDTO dto = new ObjectDTO();
        dto.setId(object.getId());
        dto.setType(object.getType());
        dto.setActualUser(object.getActualUser());
        dto.setAddress(object.getAddress());

        dto.setCounty(object.getCounty());
        dto.setArea(object.getArea());
        dto.setDistrict(object.getDistrict());
        dto.setOwner(object.getOwner());
        dto.setStatus(object.getStatus());
        return dto;
    }

    public ObjectDTO map(Object object, List<CustomFieldDTO> customFields) {
        ObjectDTO dto = map(object);
        dto.setCustomFields(customFields);
        return dto;
    }


    public Object map(ObjectDTO dto) {
        Object object = new Object();
        object.setId(dto.getId());
        object.setCounty(dto.getCounty());
        object.setActualUser(dto.getActualUser());
        object.setAddress(dto.getAddress());
        object.setDistrict(dto.getDistrict());
        object.setOwner(dto.getOwner());
        object.setType(dto.getType());
        object.setStatus(dto.getStatus());
        object.setArea(dto.getArea());
        return object;
    }

    public Object map(FilterDTO dto) {
        Object object = new Object();
        object.setCounty(dto.getCounty());
        object.setActualUser(dto.getActualUser());
        object.setAddress(dto.getAddress());
        object.setDistrict(dto.getDistrict());
        object.setOwner(dto.getOwner());
        object.setType(dto.getType());
        object.setStatus(dto.getStatus());
        return object;
    }
}
