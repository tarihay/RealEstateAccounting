package ru.nsu.gorin.db.realestateaccounting.model.dto.dashboardRelated;

import lombok.Data;

import java.util.HashMap;

@Data
public class GroupCountDTO {
    private HashMap<String, Long> nameAndCount;
}
