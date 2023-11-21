package com.example.eatathome.service.Impl;

import com.example.eatathome.model.dto.RestaurantDTO;
import com.example.eatathome.model.entity.Restaurant;
import com.example.eatathome.repository.RestaurantRepository;
import com.example.eatathome.service.Inter.RestaurantService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RestaurantServiceImpl implements RestaurantService {

    private final RestaurantRepository restaurantRepository;
    private final ModelMapper modelMapper;

    public RestaurantServiceImpl(RestaurantRepository restaurantRepository, ModelMapper modelMapper) {
        this.restaurantRepository = restaurantRepository;
        this.modelMapper = modelMapper;
    }

    public List<RestaurantDTO> getAllRestaurant() {

        return this.restaurantRepository.findAll().stream().map(this::asDTO).collect(Collectors.toList());
    }

    private RestaurantDTO asDTO(Restaurant restaurant) {
        return modelMapper.map(restaurant,RestaurantDTO.class);
    }
}
