package com.example.exam7.service;

import lombok.Getter;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Service
public class DataBaseConnectivity {
    @Getter
    private Connection conn;

    public DataBaseConnectivity(){
        try {
            init();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
    private Connection getNewConnection() throws SQLException {
        String url = "jdbc:postgresql://localhost:5432/postgres?user=postgres&password=5432";
        return DriverManager.getConnection(url);
    }

    private void init() throws SQLException{
        conn=getNewConnection();
    }
    private void close() throws SQLException{
        conn.close();
    }

    public String openConnection(){
        try {
            init();
            return "Connection to the DB was successful";
        }catch (SQLException e){
            return e.getMessage();
        }
    }
}
