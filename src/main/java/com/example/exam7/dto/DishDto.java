package com.example.exam7.dto;

import com.example.exam7.entity.Client;
import com.example.exam7.entity.Dish;
import com.example.exam7.entity.Institution;
import lombok.*;

@Data
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DishDto {
    private static final DishDto NO_DISH = builder().name("--bad reference--").build();

    public static DishDto from(Dish dish) {
        if (dish == null) {
            return NO_DISH;
        }

        return builder()
                .id(dish.getId())
                .name(dish.getName())
                .type(dish.getType())
                .price(dish.getPrice())
                .institution_id(dish.getInstitution_id())
                .build();
    }
    private Long id;
    private String name;
    private String type;
    private Integer price;
    private Long institution_id;
  // private Institution institution;
}
