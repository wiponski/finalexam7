package com.example.exam7.controller;

import com.example.exam7.dto.DishDto;
import com.example.exam7.dto.OrderDto;
import com.example.exam7.entity.Client;
import com.example.exam7.entity.Dish;
import com.example.exam7.entity.Institution;
import com.example.exam7.entity.Order;
import com.example.exam7.service.CreateService;
import com.example.exam7.service.DataBaseConnectivity;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("/")
@RequiredArgsConstructor
public class MainController {
    private final DataBaseConnectivity dbService;
    private final CreateService service;


    @GetMapping("/clients")
    public ResponseEntity<List<Client>> clients(){
        return new ResponseEntity<>(service.getClients(), HttpStatus.OK);
    }

    @PostMapping("/addclient")
    public ResponseEntity<String> newClient(@RequestBody Client client){
        try {
            service.insertClient(client);
            return new ResponseEntity<>("All is ok",HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>("!!! ",HttpStatus.CONFLICT);
        }

    }


    @PostMapping("/addinsitute")
    public ResponseEntity<String> newInstitution(@RequestBody Institution institution){
        try {
            service.insertInstitutions(institution);
            return new ResponseEntity<>("All is ok",HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>("!!! ",HttpStatus.CONFLICT);
        }

    }

    @PostMapping("/addDish")
    public ResponseEntity<String> newDish(@RequestBody DishDto dish){
        try {
            service.insertDish(dish);
            return new ResponseEntity<>("All is ok",HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>("!!! ",HttpStatus.CONFLICT);
        }

    }

    @GetMapping("/institutions")
    public ResponseEntity<List<Institution>> institutions(){
        return new ResponseEntity<>(service.getInstitutions(), HttpStatus.OK);
    }

    @GetMapping("/dishes")
    public ResponseEntity<List<Institution>> dishes(){
        return new ResponseEntity<>(service.getInstitutions(), HttpStatus.OK);
    }

    @PostMapping("/addorder")
    public ResponseEntity<String> newOrder(@RequestBody OrderDto order){
        try {
            service.insertOrder(order);
            return new ResponseEntity<>("All is ok",HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>("!!! ",HttpStatus.CONFLICT);
        }

    }


    @GetMapping("/orders")
    public ResponseEntity<List<Order>> orders(){
        return new ResponseEntity<>(service.getOrders(), HttpStatus.OK);
    }
}
