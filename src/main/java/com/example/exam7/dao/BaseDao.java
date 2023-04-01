package com.example.exam7.dao;

import com.example.exam7.unit.GenerateData;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
@Component
@RequiredArgsConstructor
public abstract class BaseDao {
    protected final JdbcTemplate jdbcTemplate;

    public final void execute(String sql){
        jdbcTemplate.execute(sql);
    }
}
