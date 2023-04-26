package ru.nsu.gorin.db.realestateaccounting.model.dto.dashboardRelated;

import lombok.Data;

@Data
public class DashboardDTO {

    private Long objectsCount;
    private Long groupCount;
    private EventStatusCountDTO eventStatusAndCount;
    private ObjectStatusCountDTO objectStatusAndCount;
    private SolutionStatusCountDTO solutionStatusAndCount;
    private GroupCountDTO groupAndCount;

}
