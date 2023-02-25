package com.restaurant.avaliacaofinch.dtos;

import java.math.BigDecimal;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class MenuItemDto {

    private Long id;
    private String name;
    private List<IngredientDTO> ingredients;
    private BigDecimal price;

}
