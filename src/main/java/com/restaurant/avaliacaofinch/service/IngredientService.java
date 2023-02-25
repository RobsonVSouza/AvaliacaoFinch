package com.restaurant.avaliacaofinch.service;

import com.restaurant.avaliacaofinch.dtos.IngredientDTO;
import com.restaurant.avaliacaofinch.entity.Ingredient;
import com.restaurant.avaliacaofinch.repository.IngredientRepository;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IngredientService {

    @Autowired
    private IngredientRepository ingredientRepository;

    public IngredientDTO createIngredient(IngredientDTO ingredientDTO) {
        Ingredient ingredient = new Ingredient();
        ingredient.setName(ingredientDTO.getName());
        ingredient.setPrice(ingredientDTO.getPrice());

        Ingredient savedIngredient = ingredientRepository.save(ingredient);

        return new IngredientDTO(savedIngredient.getId(), savedIngredient.getName(), savedIngredient.getPrice());
    }

    public IngredientDTO getIngredientById(Long id) {
        Ingredient ingredient = ingredientRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Ingredient not found with id: " + id));

        return new IngredientDTO(ingredient.getId(), ingredient.getName(), ingredient.getPrice());
    }

    public List<IngredientDTO> getAllIngredients() {
        List<Ingredient> ingredients = ingredientRepository.findAll();

        return ingredients.stream()
                .map(ingredient -> new IngredientDTO(ingredient.getId(), ingredient.getName(), ingredient.getPrice()))
                .collect(Collectors.toList());
    }

    public void deleteIngredient(Long id) {
        if (ingredientRepository.existsById(id)) {
            ingredientRepository.deleteById(id);
        } else {
            throw new NoSuchElementException("Ingredient not found with id: " + id);
        }
    }

    public IngredientDTO updateIngredient(Long id, IngredientDTO ingredientDTO) {
        Ingredient ingredient = ingredientRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Ingredient not found with id: " + id));

        ingredient.setName(ingredientDTO.getName());
        ingredient.setPrice(ingredientDTO.getPrice());

        Ingredient updatedIngredient = ingredientRepository.save(ingredient);

        return new IngredientDTO(updatedIngredient.getId(), updatedIngredient.getName(), updatedIngredient.getPrice());
    }
}


