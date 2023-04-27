package ru.nsu.gorin.db.realestateaccounting.mappers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.nsu.gorin.db.realestateaccounting.model.dto.SolutionDTO;
import ru.nsu.gorin.db.realestateaccounting.model.entities.solutionRelated.Solution;

@Component
@RequiredArgsConstructor
public class SolutionMapper {
    private final GroupMapper groupMapper;

    public Solution map(SolutionDTO solutionDTO) {
        Solution solution = new Solution();

        solution.setStatement(solutionDTO.getStatement());
        solution.setStart(solutionDTO.getStart());
        solution.setEnd(solutionDTO.getEnd());
        solution.setSolutionStatus(solutionDTO.getSolutionStatus());

        return solution;
    }

    public Solution map(Solution oldSolution, SolutionDTO solutionDTO) {
        oldSolution.setStatement(solutionDTO.getStatement());
        oldSolution.setStart(solutionDTO.getStart());
        oldSolution.setEnd(solutionDTO.getEnd());
        oldSolution.setSolutionStatus(solutionDTO.getSolutionStatus());

        return oldSolution;
    }

    public SolutionDTO map(Solution solution) {
        SolutionDTO solutionDTO = new SolutionDTO();

        solutionDTO.setStatement(solution.getStatement());
        solutionDTO.setStart(solution.getStart());
        solutionDTO.setEnd(solution.getEnd());
        solutionDTO.setSolutionStatus(solution.getSolutionStatus());
        solutionDTO.setExecutor(groupMapper.map(solution.getExecutor()));

        return solutionDTO;
    }
}
