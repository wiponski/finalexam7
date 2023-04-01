package com.example.exam7.dto;

import lombok.*;

@Data
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class InstitutionDto {
    private Long id;
    private String name;
    private String description;
}
