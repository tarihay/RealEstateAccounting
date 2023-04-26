package ru.nsu.gorin.db.realestateaccounting.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RegisterRequestDTO {
    private String firstname;
    private String lastname;
    private String patronymic;
    private String email;
    private String phone;
    private String password;
}
