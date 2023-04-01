package com.example.exam7.service;

import com.example.exam7.dao.*;
import com.example.exam7.entity.Dish;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import com.example.exam7.dto.DishDto;
import com.example.exam7.dto.OrderDto;
import com.example.exam7.entity.Client;
import java.io.IOException;
import com.example.exam7.service.InstitionDishesService;
@Service
public class InstitionDishesService {


        private final InstitutionDao institutionDao;

        public InstitionDishesService(InstitutionDao institutionDao) {
            this.institutionDao = institutionDao;
        }


//    public Resource getById(Long dishId) {
//        Dish dish = institutionDao.findById(dishId);
//
//        return Resource (findById.get());
//
//
//
//    }
    //}

}
