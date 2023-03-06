package com.restaurant.avaliacaofinch.service;

import com.restaurant.avaliacaofinch.dtos.IngredienteDto;
import com.restaurant.avaliacaofinch.entity.Ingrediente;
import com.restaurant.avaliacaofinch.repository.IngredienteRepository;
import java.util.List;
import javax.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class IngredienteService {
    private final IngredienteRepository ingredienteRepository;

    public IngredienteService(IngredienteRepository ingredienteRepository) {
        this.ingredienteRepository = ingredienteRepository;
    }

    public List<IngredienteDto> findAll() {
        List<Ingrediente> ingredientes = ingredienteRepository.findAll();
        return ingredientes.stream().map(IngredienteDto::new).collect(Collectors.toList());
    }

    public IngredienteDto findById(Long id) {
        Ingrediente ingrediente = ingredienteRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Ingrediente não encontrado."));
        return new IngredienteDto(ingrediente);
    }

    public IngredienteDto save(IngredienteDto ingredienteDTO) {
        Ingrediente ingrediente = new Ingrediente();
        ingrediente.setNome(ingredienteDTO.getNome());
        ingrediente.setValor(ingredienteDTO.getValor());
        ingrediente = ingredienteRepository.save(ingrediente);
        return new IngredienteDto(ingrediente);
    }

    public IngredienteDto update(Long id, IngredienteDto ingredienteDTO) {
        Ingrediente ingrediente = ingredienteRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Ingrediente não encontrado."));
        ingrediente.setNome(ingredienteDTO.getNome());
        ingrediente.setValor(ingredienteDTO.getValor());
        ingrediente = ingredienteRepository.save(ingrediente);
        return new IngredienteDto(ingrediente);
    }

    public void delete(Long id) {
        Ingrediente ingrediente = ingredienteRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Ingrediente não encontrado."));
        ingredienteRepository.delete(ingrediente);
    }

}
