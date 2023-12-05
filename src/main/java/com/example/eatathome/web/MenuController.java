package com.example.eatathome.web;

import com.example.eatathome.model.dto.MenuDTO;
import com.example.eatathome.service.Impl.MenuServiceImpl;
import com.example.eatathome.service.Inter.MenuService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping("/menus")
public class MenuController{

    private final MenuServiceImpl menuService;

    public MenuController(MenuServiceImpl menuService) {
        this.menuService = menuService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<MenuDTO> getById(@PathVariable("id") String id) {
        Optional<MenuDTO> menuById = this.menuService.getById(id);

        if(menuById.isEmpty()) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(menuById.get());
    }

    @PutMapping("/create")
    public ResponseEntity<MenuDTO> createMenu(@RequestBody MenuDTO menuDTO, UriComponentsBuilder uriComponentsBuilder) {
        String menuId = this.menuService.createMenu(menuDTO);
        URI location = uriComponentsBuilder.path("/menus/{id}").buildAndExpand(menuId).toUri();
        return ResponseEntity.created(location).build();
    }

    @GetMapping("/update/{id}")
    public ResponseEntity<MenuDTO> updateMenu(@PathVariable("id") String id,@RequestBody MenuDTO menuForUpdate){
        menuForUpdate.setId(id);
        Optional<MenuDTO> updatedMenu = this.menuService.updateMenu(menuForUpdate);
        return ResponseEntity.ok(updatedMenu.get());
    }

    @DeleteMapping
    public ResponseEntity<MenuDTO> deleteMenu(String id){
        this.menuService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
