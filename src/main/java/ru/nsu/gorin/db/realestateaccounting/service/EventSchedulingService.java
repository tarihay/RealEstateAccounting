package ru.nsu.gorin.db.realestateaccounting.service;

import lombok.AllArgsConstructor;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@EnableScheduling
@AllArgsConstructor
public class EventSchedulingService {

    private final EventService eventService;

    @Scheduled(cron = "0 0 0 * * ?")
    public void overdueEvents() {
        eventService.overdueEvents();
    }
}
