package com.restaurant.avaliacaofinch.service;

import com.restaurant.avaliacaofinch.dtos.LancheDto;
import com.restaurant.avaliacaofinch.entity.Ingrediente;
import com.restaurant.avaliacaofinch.entity.Lanche;
import com.restaurant.avaliacaofinch.repository.IngredienteRepository;
import com.restaurant.avaliacaofinch.repository.LancheRepository;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LancheService {

    @Autowired
    private LancheRepository lancheRepository;

    @Autowired
    private IngredienteService ingredienteService;

    public LancheDto criarLanche(LancheDto lancheDTO) {
        // Cria um novo objeto Lanche a partir do DTO recebido
        Lanche lanche = new Lanche();
        lanche.setNome(lancheDTO.getNome());
        lanche.setIngredientes(ingredienteService.findById(LancheDto.findById(id));

        // Calcula o preço do lanche
        BigDecimal preco = calcularPrecoLanche(lanche);
        lanche.setId(preco);

        // Salva o lanche no banco de dados e converte o objeto salvo para um DTO
        Lanche lancheSalvo = lancheRepository.save(lanche);
        return converterParaDTO(lancheSalvo);
    }

    public LancheDto atualizarLanche(Long id, LancheDto lancheDTO) {
        // Busca o lanche pelo ID
        Optional<Lanche> lancheOpt = lancheRepository.findById(id);

        if (lancheOpt.isPresent()) {
            Lanche lanche = lancheOpt.get();
            lanche.setNome(lancheDTO.getNome());
            lanche.setIngredientes(ingredienteService.findById(lancheDTO.getId()));

            // Calcula o preço do lanche
            BigDecimal preco = calcularPrecoLanche(lanche);
            lanche.setId(id);

            // Salva o lanche no banco de dados e converte o objeto salvo para um DTO
            Lanche lancheSalvo = lancheRepository.save(lanche);
            return converterParaDto(lancheSalvo);
        } else {
            throw new RecursoNaoEncontradoException("Lanche não encontrado com o ID " + id);
        }
    }



    public List<LancheDto> buscarTodosLanches() {
        List<Lanche> lanches = lancheRepository.findAll();
        return converterParaListaDto(lanches);
    }

    public LancheDto buscarLanchePorId(Long id) {
        Optional<Lanche> lancheOpt = lancheRepository.findById(id);

        if (lancheOpt.isPresent()) {
            Lanche lanche = lancheOpt.get();
            return converterParaDto(lanche);
        } else {
            throw new RecursoNaoEncontradoException("Lanche não encontrado com o ID " + id);
        }
    }

    public void deletarLanchePorId(Long id) {
        lancheRepository.deleteById(id);
    }

    public BigDecimal calcularPrecoLanche(Lanche lanche) {
        BigDecimal precoTotal = BigDecimal.ZERO;
        List<Ingrediente> ingredientes = lanche.getIngredientes();
        Map<Long, Integer> qtdIngredientes = new HashMap<>();

        // Conta a quantidade de ingredientes para cada ID
        for (Ingrediente ingrediente : ingredientes) {
            Long id = ingrediente.getId();
            qtdIngredientes.put(id, qtdIngredientes.getOrDefault(id, 0) + 1);
        }

        // Calcula o preço de cada ingrediente e soma no total
        for (Map.Entry<Long, Integer> entry : qtdIngredientes.entrySet()) {
            Long id = entry.getKey();
            Integer qtd = entry.getValue();

            Optional<Ingrediente> ingredienteOpt = ingredienteService.findById(id);
