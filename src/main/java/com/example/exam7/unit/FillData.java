package com.example.exam7.unit;

import com.example.exam7.service.CreateService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class FillData {

    private final CreateService createService;

    @Bean
    public void create(){
        System.out.println("create");
        createService.shouldCreateTable();
        createService.insertClient();
        createService.insertInstitutions();
        createService.insertDish();
    }
}
