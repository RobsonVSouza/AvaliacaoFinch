package com.restaurant.avaliacaofinch.controller;

import com.restaurant.avaliacaofinch.dtos.IngredienteDto;
import com.restaurant.avaliacaofinch.service.IngredienteService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ingredientes")
public class IngredienteController {

    @Autowired
    private IngredienteService ingredienteService;

    @GetMapping
    public List<IngredienteDto> findAll() {
        return ingredienteService.findAll();
    }

    @PostMapping
    public IngredienteDto save(@RequestBody IngredienteDto ingredienteDTO) {
        return ingredienteService.save(ingredienteDTO);
    }

    @GetMapping("/{id}")
    public IngredienteDto findById(@PathVariable Long id) {
        return ingredienteService.findById(id);
    }

    @PutMapping("/{id}")
    public IngredienteDto atualizarIngrediente(@PathVariable Long id, @RequestBody IngredienteDto ingredienteDTO) {
        return ingredienteService.update(id, ingredienteDTO);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        ingredienteService.delete(id);
    }
}
