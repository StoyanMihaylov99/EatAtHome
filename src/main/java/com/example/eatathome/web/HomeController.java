package com.example.eatathome.web;

import com.example.eatathome.model.dto.RestaurantDTO;
import com.example.eatathome.service.Impl.RestaurantServiceImpl;

import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/restaurants")
public class HomeController {
    private final RestaurantServiceImpl restaurantService;


    public HomeController(RestaurantServiceImpl restaurantService) {
        this.restaurantService = restaurantService;
    }

    @GetMapping
    public ResponseEntity<List<RestaurantDTO>> getAllRestaurant() {
        List<RestaurantDTO> allRestaurants = restaurantService.getAllRestaurant();

        return ResponseEntity.ok(allRestaurants);
    }
}
