package com.example.exam7.dao;

import com.example.exam7.dto.ClientDto;
import com.example.exam7.entity.Client;
import com.example.exam7.unit.GenerateData;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.sql.PreparedStatement;
import java.util.List;
import java.util.Random;

@Component
public class ClientDao extends BaseDao {

    public ClientDao(JdbcTemplate jdbcTemplate) {
        super(jdbcTemplate);
    }

    public List<Client> getAllClients(){
        String query = "select * from clients;";
        return jdbcTemplate.query(query, new BeanPropertyRowMapper<>(Client.class));
    }

    public void addClient(Client client){
        Random rnd = new Random();
        String sql ="INSERT INTO clients (name, email, password) "
                + "VALUES ( ?, ?, ?)";
        jdbcTemplate.update(conn -> {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, client.getName());
            ps.setString(2, client.getEmail());
            ps.setString(3, client.getPassword());
            return ps;
        });
    }
}
