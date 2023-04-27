package ru.nsu.gorin.db.realestateaccounting.mappers;

import org.springframework.stereotype.Component;
import ru.nsu.gorin.db.realestateaccounting.model.dto.GroupDTO;
import ru.nsu.gorin.db.realestateaccounting.model.entities.userRelated.ExecutionGroup;

@Component
public class GroupMapper {
    public GroupDTO map(ExecutionGroup executionGroup) {
        GroupDTO groupDTO = new GroupDTO();

        groupDTO.setName(executionGroup.getGroupName());
        groupDTO.setTypeOfWork(executionGroup.getTypeOfWork());

        return groupDTO;
    }
}
