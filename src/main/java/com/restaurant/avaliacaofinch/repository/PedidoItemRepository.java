package com.restaurant.avaliacaofinch.repository;

import com.restaurant.avaliacaofinch.entity.PedidoItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidoItemRepository extends JpaRepository<PedidoItem, Long> {

}