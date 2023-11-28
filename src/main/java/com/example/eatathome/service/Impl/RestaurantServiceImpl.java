package com.example.eatathome.service.Impl;
import com.example.eatathome.model.dto.RestaurantDTO;
import com.example.eatathome.model.entity.Restaurant;
import com.example.eatathome.repository.RestaurantRepository;
import com.example.eatathome.service.Inter.RestaurantService;
import com.example.eatathome.utils.City;
import jakarta.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
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
        return modelMapper.map(restaurant, RestaurantDTO.class);
    }


    @Override
    public List<RestaurantDTO> getRestaurantByCity(City city) {
        return this.restaurantRepository.findRestaurantsByCity(city).stream().map(this::asDTO).collect(Collectors.toList());
    }

    @Override
    public Optional<RestaurantDTO> getRestaurantById(String id) {
        return this.restaurantRepository.findRestaurantsById(id).map(this::asDTO);
    }

    @Override
    public String createRestaurant(RestaurantDTO restaurantDTO) {
        Restaurant newRestaurant = new Restaurant().setName(restaurantDTO.getName()).setCity(restaurantDTO.getCity())
                .setDescription(restaurantDTO.getDescription()).setId(UUID.randomUUID().toString());
        return restaurantRepository.save(newRestaurant).getId();
    }

    @Override
    public void deleteRestaurant(String id) {
        restaurantRepository.deleteById(id);
    }

    @Override
    public Optional<RestaurantDTO> updateRestaurant(RestaurantDTO restaurantDTO) {
        if(!this.restaurantRepository.existsById(restaurantDTO.getId())){
            throw new EntityNotFoundException("Entity with ID " + restaurantDTO.getId() + " not found");
        }

        this.restaurantRepository.save(modelMapper.map(restaurantDTO,Restaurant.class));
        return this.restaurantRepository.findRestaurantsById(restaurantDTO.getId()).map(this::asDTO);
    }
}
