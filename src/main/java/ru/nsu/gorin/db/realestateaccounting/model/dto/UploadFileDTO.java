package ru.nsu.gorin.db.realestateaccounting.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UploadFileDTO {
    private String id;
    private String filename;
}
