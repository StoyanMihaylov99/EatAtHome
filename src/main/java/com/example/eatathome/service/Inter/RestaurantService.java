package com.example.eatathome.service.Inter;

import com.example.eatathome.model.dto.RestaurantDTO;
import com.example.eatathome.utils.City;

import java.util.List;
import java.util.Optional;

public interface RestaurantService {


    List<RestaurantDTO> getRestaurantByCity(City city);
    Optional<RestaurantDTO> getRestaurantById(String id);
    String createRestaurant(RestaurantDTO restaurantDTO);
    void deleteRestaurant(String id);

    Optional<RestaurantDTO> updateRestaurant(RestaurantDTO restaurantDTO);

}
