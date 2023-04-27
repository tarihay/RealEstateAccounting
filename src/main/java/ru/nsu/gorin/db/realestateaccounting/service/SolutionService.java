package ru.nsu.gorin.db.realestateaccounting.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.nsu.gorin.db.realestateaccounting.mappers.SolutionMapper;
import ru.nsu.gorin.db.realestateaccounting.model.dto.SolutionDTO;
import ru.nsu.gorin.db.realestateaccounting.model.entities.solutionRelated.Solution;
import ru.nsu.gorin.db.realestateaccounting.model.entities.solutionRelated.SolutionStatus;
import ru.nsu.gorin.db.realestateaccounting.model.entities.userRelated.ExecutionGroup;
import ru.nsu.gorin.db.realestateaccounting.repository.GroupRepository;
import ru.nsu.gorin.db.realestateaccounting.repository.SolutionRepository;
import ru.nsu.gorin.db.realestateaccounting.utils.exceptions.NoEntityFoundException;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SolutionService {
    private final SolutionRepository solutionRepository;
    private final SolutionMapper solutionMapper;
    private final GroupRepository groupRepository;


    public Integer createSolution(SolutionDTO solutionDTO) {
        Solution solution = solutionMapper.map(solutionDTO);

        Solution created = solutionRepository.save(solution);

        ExecutionGroup executionGroup = groupRepository.findByGroupName(solutionDTO.getExecutor().getName()).get();
        solution.setExecutor(executionGroup);

        return created.getId();
    }

    @Transactional
    public void updateSolution(Integer id, SolutionDTO solutionDTO) {
        Solution oldSolution = solutionRepository.findById(id)
                .orElseThrow(() -> new NoEntityFoundException("Нет решения с id " + id));

        ExecutionGroup executor = groupRepository.findByGroupName(solutionDTO.getExecutor().getName()).get();

        Solution solution = solutionMapper.map(oldSolution, solutionDTO);
        solution.setExecutor(executor);
        solutionRepository.save(solution);
    }

    public SolutionDTO getSolution(Integer id) {
        Optional<Solution> solution = solutionRepository.findById(id);

        return solutionMapper.map(solution.get());
    }

    public SolutionDTO getEmptySolution() {
        return new SolutionDTO();
    }

    public List<SolutionDTO> getSolutions(Integer amount, Integer skip) {
        return solutionRepository.findAll().stream().skip(skip).limit(amount).map(solutionMapper::map).collect(Collectors.toList());
    }

    public void overdueSolutions() {
        List<Solution> solutions = solutionRepository.findAllByEndBeforeAndSolutionStatusIsNot(LocalDateTime.now(), SolutionStatus.COMPLETED);
        for (Solution solution : solutions) {
            solution.setSolutionStatus(SolutionStatus.EXPIRED);
            solutionRepository.save(solution);
        }
    }
}
