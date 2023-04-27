package ru.nsu.gorin.db.realestateaccounting.service;

import lombok.AllArgsConstructor;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@EnableScheduling
@AllArgsConstructor
public class SolutionSchedulingService {

    private final SolutionService solutionService;

    @Scheduled(cron = "0 0 0 * * ?")
    public void overdueSolutions() {
        solutionService.overdueSolutions();
    }
}
