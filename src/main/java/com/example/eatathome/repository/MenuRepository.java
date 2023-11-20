package com.example.eatathome.repository;

import com.example.eatathome.model.entity.Menu;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MenuRepository extends JpaRepository<String, Menu> {
}
