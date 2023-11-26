package com.example.eatathome.repository;

import com.example.eatathome.model.entity.Restaurant;
import com.example.eatathome.utils.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;


@Repository
public interface RestaurantRepository extends JpaRepository<Restaurant,String> {



    List<Restaurant> findRestaurantsByCity (City city);

    Optional<Restaurant> findRestaurantsById(String id);


}
