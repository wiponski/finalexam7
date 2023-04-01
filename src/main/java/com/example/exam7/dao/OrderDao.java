package com.example.exam7.dao;

import com.example.exam7.dto.OrderDto;
import com.example.exam7.entity.Order;
import com.example.exam7.unit.GenerateData;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.sql.PreparedStatement;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;
@Component
public class OrderDao extends BaseDao{

    public OrderDao(JdbcTemplate jdbcTemplate) {
        super(jdbcTemplate);
    }
    public void addOrder(OrderDto order){

        Random rnd = new Random();
        String sql ="INSERT INTO orders (client_id, dish_id,order_date) "
                + "VALUES ( ?, ?, ? );";
        jdbcTemplate.update(conn -> {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setLong(1, order.getClient_id());
            ps.setLong(2, order.getDish_id());
            ps.setTimestamp(3, Timestamp.valueOf(LocalDateTime.now()));
            return ps;
        });
    }

    public List<Order> getOrders(){
        String query = "select o.id as o_id, c.id as c_id , d.id as d_id, o.order_date from orders as o inner join clients as c on c.id = o.client_id inner join dishes as d on d.id = o.dish_id";
        return jdbcTemplate.query(query, new OrderRowMapper());
    }
}
