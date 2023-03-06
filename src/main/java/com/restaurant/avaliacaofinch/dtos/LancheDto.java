package com.restaurant.avaliacaofinch.dtos;

import java.math.BigDecimal;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class LancheDto {

    private Long id;
    private String nome;
    private List<IngredienteDto> ingredientes;
    private BigDecimal valor;
}
