package ru.nsu.gorin.db.realestateaccounting.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.nsu.gorin.db.realestateaccounting.model.dto.FilterDTO;
import ru.nsu.gorin.db.realestateaccounting.service.ObjectRegistryService;

@RestController
@RequestMapping("/api/v1/registry")
@RequiredArgsConstructor
public class ObjectRegistryController {

    private final ObjectRegistryService objectRegistryService;

    @GetMapping("/objects")
    @PreAuthorize("hasAnyRole('EXECUTOR', 'INSPECTOR')")
    public ResponseEntity<?> getObjectList(@RequestParam(defaultValue = "0") int pageNumber,
                                           @RequestParam(defaultValue = "10") int pageSize) {
        try {
            return ResponseEntity.ok().body(objectRegistryService.getObjectsRegistry(pageNumber, pageSize));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e);
        }
    }

    @PostMapping("/objects-by-filter")
    @PreAuthorize("hasAnyRole('EXECUTOR', 'INSPECTOR')")
    public ResponseEntity<?> getObjectListByFilter(@RequestParam(defaultValue = "0") int pageNumber,
                                                   @RequestParam(defaultValue = "10") int pageSize,
                                                   @RequestBody FilterDTO filterDTO) {
        try {
            return ResponseEntity.ok().body(objectRegistryService.getObjectsRegistryByFilter(pageNumber, pageSize, filterDTO));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e);
        }
    }
}
