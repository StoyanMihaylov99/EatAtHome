package com.example.eatathome.service.Impl;

import com.example.eatathome.model.dto.MenuDTO;
import com.example.eatathome.model.dto.OrderDTO;
import com.example.eatathome.model.entity.Menu;
import com.example.eatathome.model.entity.Order;
import com.example.eatathome.repository.MenuRepository;
import com.example.eatathome.service.Inter.MenuService;
import jakarta.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class MenuServiceImpl implements MenuService {

    private final MenuRepository menuRepository;
    private final ModelMapper modelMapper;

    public MenuServiceImpl(MenuRepository menuRepository, ModelMapper modelMapper) {
        this.menuRepository = menuRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public Optional<MenuDTO> getById(String id) {
        return this.menuRepository.findById(id).map(this::asDTO);
    }

    private MenuDTO asDTO(Menu menu) {
        return modelMapper.map(menu, MenuDTO.class);
    }

    @Override
    public void deleteById(String id) {
        this.menuRepository.deleteById(id);
    }

    @Override
    public String createMenu(MenuDTO menuDTO) {
        Menu newMenu = new Menu().setId(UUID.randomUUID().toString()).setName(menuDTO.getName()).setDescription(menuDTO.getDescription()).setPrice(menuDTO.getPrice());
        return this.menuRepository.save(newMenu).getId();
    }

    @Override
    public Optional<MenuDTO> updateMenu(MenuDTO menuDTO) {
        if(!this.menuRepository.existsById(menuDTO.getId())) {
            throw new EntityNotFoundException("Entity with ID " + menuDTO.getId() + " not found");
        }

        this.menuRepository.save(modelMapper.map(menuDTO,Menu.class));
        return this.menuRepository.findById(menuDTO.getId()).map(this::asDTO);
    }


}
