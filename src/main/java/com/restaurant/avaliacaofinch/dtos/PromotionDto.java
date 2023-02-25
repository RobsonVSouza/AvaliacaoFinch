package com.restaurant.avaliacaofinch.dtos;

import com.restaurant.avaliacaofinch.entity.PromotionType;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PromotionDto {

    private Long id;
    private String name;
    private PromotionType type;
    private List<IngredientDTO> requiredIngredients;

}
