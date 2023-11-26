package com.example.eatathome.web;

import com.example.eatathome.model.dto.RestaurantDTO;
import com.example.eatathome.service.Inter.RestaurantService;
import com.example.eatathome.utils.City;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/restaurants")
public class RestaurantController {

    private final RestaurantService restaurantService;

    public RestaurantController(RestaurantService restaurantService) {
        this.restaurantService = restaurantService;
    }

    @GetMapping("city/{city}")
    public ResponseEntity<List<RestaurantDTO>> getRestaurantByCity(@PathVariable("city") City city) {
        List<RestaurantDTO> allRestaurants = restaurantService.getRestaurantByCity(city);

        if (allRestaurants.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(allRestaurants);
    }
    @GetMapping("/{id}")
    public ResponseEntity<RestaurantDTO> getRestaurantById(@PathVariable("id") String id){
        Optional<RestaurantDTO> currentRestaurant = restaurantService.getRestaurantById(id);
        if(currentRestaurant.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(currentRestaurant.get());
    }

    @PutMapping("/create")
    public ResponseEntity<RestaurantDTO> create(@RequestBody RestaurantDTO restaurantDTO, UriComponentsBuilder uriComponentsBuilder){
      String restaurantId = restaurantService.createRestaurant(restaurantDTO);
        URI location = uriComponentsBuilder.path("/restaurants/{id}").buildAndExpand(restaurantId).toUri();
      return ResponseEntity.created(location).build();
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<RestaurantDTO> deleteRestaurant(@PathVariable("id") String id){
    restaurantService.deleteRestaurant(id);
    return ResponseEntity.noContent().build();
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<RestaurantDTO> updateRestaurant(@PathVariable("id") String id){
        restaurantService.updateRestaurant(id);
        return ResponseEntity.noContent().build();
    }



}
