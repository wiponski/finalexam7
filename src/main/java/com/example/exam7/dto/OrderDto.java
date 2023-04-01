package com.example.exam7.dto;

import com.example.exam7.entity.Client;
import com.example.exam7.entity.Dish;
import com.example.exam7.entity.Order;
import lombok.*;

import java.time.LocalDateTime;
@Data
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderDto {
//    private static final OrderDto NO_ORDER = builder().orderedDish("").build();
//
//    public static OrderDto from(Order order) {
//        if (order == null) {
//            return NO_ORDER;
//        }
//
//        return builder()
//                .id(order.getId())
//              //  .client_id(ClientDto.from(order.getClient())
//                .client(ClientDto.from(order.getClient())
//                .orderedDish(DishDto.from()))
//                .build();
//    }
    private Long id;
    private Client client;
    private Dish orderedDish;
    private LocalDateTime order_date;
    private Long client_id;
    private Long dish_id;
}
