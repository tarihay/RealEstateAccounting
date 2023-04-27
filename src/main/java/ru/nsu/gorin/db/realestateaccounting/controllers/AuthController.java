package ru.nsu.gorin.db.realestateaccounting.controllers;

import jakarta.annotation.security.PermitAll;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.nsu.gorin.db.realestateaccounting.model.dto.AuthRequestDTO;
import ru.nsu.gorin.db.realestateaccounting.model.dto.AuthenticationResponseDTO;
import ru.nsu.gorin.db.realestateaccounting.model.dto.RegisterRequestDTO;
import ru.nsu.gorin.db.realestateaccounting.service.AuthenticationService;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthenticationService authService;

    @PostMapping("/register")
    @PermitAll
    public ResponseEntity<AuthenticationResponseDTO> register(
            @RequestBody RegisterRequestDTO registerDTO
    ) {
        return ResponseEntity.ok().body(authService.register(registerDTO));
    }

    @PostMapping("/authenticate")
    @PermitAll
    public ResponseEntity<AuthenticationResponseDTO> register(
            @RequestBody AuthRequestDTO authRequestDTO
    ) {
        return ResponseEntity.ok().body(authService.authenticate(authRequestDTO));
    }
}
