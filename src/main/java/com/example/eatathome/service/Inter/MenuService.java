package com.example.eatathome.service.Inter;

import com.example.eatathome.model.dto.MenuDTO;

import java.util.Optional;

public interface MenuService {
    Optional<MenuDTO> getById(String id);
    void deleteById(String id);
    String createMenu(MenuDTO menuDTO);
    Optional<MenuDTO> updateMenu(MenuDTO menuDTO);
}
