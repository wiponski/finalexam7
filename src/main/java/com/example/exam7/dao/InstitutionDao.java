package com.example.exam7.dao;

import com.example.exam7.entity.Client;
import com.example.exam7.entity.Dish;
import com.example.exam7.entity.Institution;
import com.example.exam7.unit.GenerateData;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.sql.PreparedStatement;
import java.util.List;
import java.util.Optional;
import java.util.Random;
@Component
public class InstitutionDao extends BaseDao  {
    public InstitutionDao(JdbcTemplate jdbcTemplate) {
        super(jdbcTemplate);
    }

    public void addInstitution(Institution institution){
        Random rnd = new Random();
        String sql ="INSERT INTO institutions (name, description) "
                + "VALUES ( ?, ?);";
        jdbcTemplate.update(conn -> {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, institution.getName());
            ps.setString(2,institution.getDescription());
            return ps;
        });
    }

    public Optional<Dish> findById(Long id) {
        String sql = "select * " +
                "from movie_image " +
                "where id = ?";
        return Optional.ofNullable(DataAccessUtils.singleResult(
                jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Dish.class), id)
        ));
    }
    public List<Institution> getAllInstitutions(){
        String query = "select * from institutions;";
        return jdbcTemplate.query(query, new BeanPropertyRowMapper<>(Institution.class));
    }


}
