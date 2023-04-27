package ru.nsu.gorin.db.realestateaccounting.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.nsu.gorin.db.realestateaccounting.model.entities.solutionRelated.Solution;
import ru.nsu.gorin.db.realestateaccounting.repository.SolutionRepository;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ReportService {

    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm");
    private final SolutionRepository solutionRepository;

    public File createReport() throws IOException {
        File report = File.createTempFile("report", ".csv");
        try (FileWriter fileWriter = new FileWriter(report)){
            fileWriter.write("Адрес объекта,Ответственный,Статус,Вопросы,Дедлайн\n");
            List<Solution> solutions = solutionRepository.findAll();
            for (Solution solution : solutions) {
                fileWriter.write(solution.getObject().getAddress() + ","
                        + solution.getExecutor() + ","
                        + solution.getSolutionStatus() + ","
                        + solution.getStatement() + ","
                        + solution.getEnd().format(formatter) + "\n");
            }
            fileWriter.flush();
        }
        return report;
    }
}
