package com.example.exam7.entity;

import lombok.*;

import java.time.LocalDateTime;
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Order {
    private Long id;
    private Client client;
    private Dish orderedDish;
    private LocalDateTime order_date;

}
