package com.example.exam7.dto;

import com.example.exam7.entity.Client;
import com.example.exam7.entity.Dish;
import lombok.*;

import java.time.LocalDateTime;
@Data
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderDto {
    private Long id;
    private Client client;
    private Dish orderedDish;
    private LocalDateTime order_date;
    private Long client_id;
    private Long dish_id;
}
