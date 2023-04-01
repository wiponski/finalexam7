package com.example.exam7.dao;

import com.example.exam7.dto.OrderDto;
import com.example.exam7.entity.Client;
import com.example.exam7.entity.Dish;
import com.example.exam7.entity.Order;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class OrderRowMapper implements RowMapper<Order> {
    @Override
    public Order mapRow(ResultSet rs, int rowNum) throws SQLException {
        Client client = Client.builder()
                .id(rs.getLong("c_id"))
//                .name(rs.getString("c_name"))
//                .email(rs.getString("email"))
//                .password(rs.getString("password"))
                .build();
        Dish dish = Dish.builder()
                .id(rs.getLong("d_id"))
//                .name(rs.getString("c_name"))
//                .type(rs.getString("type"))
//                .price(rs.getInt("price"))
                .build();
        Order order = Order.builder()
                .id(rs.getLong("o_id"))
                .client(client)
                .orderedDish(dish)
                .order_date(rs.getTimestamp("order_date").toLocalDateTime())
                .build();

        return order;


    }
}
