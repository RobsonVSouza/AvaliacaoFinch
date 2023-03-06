package com.restaurant.avaliacaofinch.repository;

import com.restaurant.avaliacaofinch.entity.Ingrediente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IngredienteRepository extends JpaRepository <Ingrediente, Long> {

}
