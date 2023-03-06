package com.restaurant.avaliacaofinch.repository;

import com.restaurant.avaliacaofinch.entity.Lanche;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface LancheRepository extends JpaRepository <Lanche, Long> {


}
