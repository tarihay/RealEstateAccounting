package ru.nsu.gorin.db.realestateaccounting.model.dto.dashboardRelated;

import lombok.Data;
import ru.nsu.gorin.db.realestateaccounting.model.entities.solutionRelated.SolutionStatus;

import java.util.EnumMap;

@Data
public class SolutionStatusCountDTO {

    private EnumMap<SolutionStatus, Long> solutionStatusAndCount;
}
