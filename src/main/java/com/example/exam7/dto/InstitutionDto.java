package com.example.exam7.dto;

import com.example.exam7.entity.Institution;
import lombok.*;

import java.time.format.DateTimeFormatter;

@Data
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class InstitutionDto {
    private static final InstitutionDto NO_INSTITUTION = builder().name("--bad reference--").build();
    public static InstitutionDto from(Institution institution) {
        if (institution == null) {
            return NO_INSTITUTION;
        }

        return builder()
                .id(institution.getId())
                .name(institution.getName())
                .description(institution.getDescription())
                .build();
    }

    private Long id;
    private String name;
    private String description;
}
