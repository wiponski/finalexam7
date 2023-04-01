package com.example.exam7.dao;

import com.example.exam7.dto.DishDto;
import com.example.exam7.entity.Client;
import com.example.exam7.unit.GenerateData;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.sql.PreparedStatement;
import java.util.List;
import java.util.Random;

@Component
public class DishDao extends BaseDao {


    public DishDao(JdbcTemplate jdbcTemplate) {
        super(jdbcTemplate);
    }

    public void addDish(DishDto dish){
        String sql ="INSERT INTO dishes (name,  type,price, institution_id ) "
                + "VALUES ( ?, ?, ?, ?)";
        jdbcTemplate.update(conn -> {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, dish.getName());
            ps.setString(2,dish.getType());
            ps.setLong(3,dish.getPrice());
            ps.setInt(4, Math.toIntExact(dish.getInstitution_id()));
            return ps;
        });
    }
}
