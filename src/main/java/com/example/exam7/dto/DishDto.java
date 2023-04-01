package com.example.exam7.dto;

import lombok.*;

@Data
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DishDto {
    private Long id;
    private String name;
    private String type;
    private Integer price;
    private Long institution_id;
}
