package ru.nsu.gorin.db.realestateaccounting.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import ru.nsu.gorin.db.realestateaccounting.model.dto.dashboardRelated.DashboardDTO;
import ru.nsu.gorin.db.realestateaccounting.service.DashboardService;

@RestController
@RequestMapping("/api/v1/dashboard")
@RequiredArgsConstructor
public class DashboardController {

    private final DashboardService dashboardService;

    //TODO сделать так, чтобы по jwt понимать кто запрос отправляет, а не по userID
    @GetMapping("/{userId}")
    @PreAuthorize("hasAnyRole('INSPECTOR', 'EXECUTOR')")
    public ResponseEntity<DashboardDTO> getDashboardByUser(@PathVariable Integer userId) {
        return null;
    }
}
