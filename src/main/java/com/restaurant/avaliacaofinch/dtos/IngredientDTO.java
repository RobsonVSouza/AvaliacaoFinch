package com.restaurant.avaliacaofinch.dtos;

import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class IngredientDTO {

    private Long id;
    private String name;
    private BigDecimal price;

}
