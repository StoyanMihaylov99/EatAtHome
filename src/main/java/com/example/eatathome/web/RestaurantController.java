package com.example.eatathome.web;

import com.example.eatathome.model.dto.RestaurantDTO;
import com.example.eatathome.service.Inter.RestaurantService;
import com.example.eatathome.utils.City;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
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
        List<RestaurantDTO> allRestaurants = this.restaurantService.getRestaurantByCity(city);

        if (allRestaurants.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(allRestaurants);
    }
    @GetMapping("/{id}")
    public ResponseEntity<RestaurantDTO> getRestaurantById(@PathVariable("id") String id){
        Optional<RestaurantDTO> currentRestaurant = this.restaurantService.getRestaurantById(id);
        if(currentRestaurant.isEmpty()) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(currentRestaurant.get());
    }

    @PostMapping("/create")
    public ResponseEntity<RestaurantDTO> create(@RequestBody RestaurantDTO restaurantDTO, UriComponentsBuilder uriComponentsBuilder){
      String restaurantId = this.restaurantService.createRestaurant(restaurantDTO);
        URI location = uriComponentsBuilder.path("/restaurants/{id}").buildAndExpand(restaurantId).toUri();
      return ResponseEntity.created(location).build();
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<RestaurantDTO> deleteRestaurant(@PathVariable("id") String id){
    this.restaurantService.deleteRestaurant(id);
    return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<RestaurantDTO> updateRestaurant(@PathVariable("id") String id, @RequestBody RestaurantDTO updatedRestaurant){
        updatedRestaurant.setId(id);
        Optional<RestaurantDTO> updatedRestaurantDTO = this.restaurantService.updateRestaurant(updatedRestaurant);
        return ResponseEntity.ok(updatedRestaurantDTO.get());
    }
}
