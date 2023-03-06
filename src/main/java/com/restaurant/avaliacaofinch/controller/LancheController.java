package com.restaurant.avaliacaofinch.controller;

import com.restaurant.avaliacaofinch.dtos.LancheDto;
import com.restaurant.avaliacaofinch.entity.Lanche;
import com.restaurant.avaliacaofinch.service.LancheService;
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
@RequestMapping("/lanches")
public class LancheController {

    @Autowired
    private LancheService lancheService;

    @GetMapping
    public List<LancheDto> listarLanches() {
        return lancheService.listarLanches();
    }

    @PostMapping
    public Lanche criarLanche(@RequestBody LancheDto lancheDTO) {
        return lancheService.criarLanche(lancheDTO);
    }

    @GetMapping("/{id}")
    public LancheDto buscarLanche(@PathVariable Long id) {
        return lancheService.buscarLanche(id);
    }

    @PutMapping("/{id}")
    public LancheDTO atualizarLanche(@PathVariable Long id, @RequestBody LancheDTO lancheDTO) {
        return lancheService.atualizarLanche(id, lancheDTO);
    }

    @DeleteMapping("/{id}")
    public void excluirLanche(@PathVariable Long id) {
        lancheService.excluirLanche(id);
    }
}
