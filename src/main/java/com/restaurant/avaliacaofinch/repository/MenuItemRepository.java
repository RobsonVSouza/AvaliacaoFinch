package com.restaurant.avaliacaofinch.repository;

import com.restaurant.avaliacaofinch.entity.MenuItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MenuItemRepository extends JpaRepository <MenuItem, Long> {

}
