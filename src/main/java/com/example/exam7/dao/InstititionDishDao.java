package com.example.exam7.dao;
import com.example.exam7.dto.DishDto;
import com.example.exam7.entity.Client;
import com.example.exam7.entity.Dish;
import com.example.exam7.unit.GenerateData;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import java.sql.PreparedStatement;
import java.util.List;
import java.util.Optional;
import java.util.Random;
@Component
public class InstititionDishDao extends BaseDao {
    public InstititionDishDao(JdbcTemplate jdbcTemplate, NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        super(jdbcTemplate, namedParameterJdbcTemplate);
    }
    public Optional<Dish> findById(Long movieId) {
        String sql = "select * " +
                "from dishes " +
                "where institution_id = ?";
        return Optional.ofNullable(DataAccessUtils.singleResult(
                jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Dish.class), movieId)
        ));
    }


}
