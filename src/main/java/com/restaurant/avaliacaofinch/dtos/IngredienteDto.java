package com.restaurant.avaliacaofinch.dtos;

import com.restaurant.avaliacaofinch.entity.Ingrediente;
import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class IngredienteDto {

    private Long id;
    private String nome;
    private BigDecimal valor;


    public IngredienteDto(Ingrediente ingrediente) {

    }
}
