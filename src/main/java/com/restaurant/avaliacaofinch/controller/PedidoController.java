package com.restaurant.avaliacaofinch.controller;

import com.restaurant.avaliacaofinch.service.PedidoService;
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
@RequestMapping("/pedidos")
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;

    @GetMapping
    public List<PedidoDTO> listarPedidos() {
        return pedidoService.listarPedidos();
    }

    @PostMapping
    public PedidoDTO criarPedido(@RequestBody PedidoDTO pedidoDTO) {
        return pedidoService.criarPedido(pedidoDTO);
    }

    @GetMapping("/{id}")
    public PedidoDTO buscarPedido(@PathVariable Long id) {
        return pedidoService.buscarPedido(id);
    }

    @PutMapping("/{id}")
    public PedidoDTO atualizarPedido(@PathVariable Long id, @RequestBody PedidoDTO pedidoDTO) {
        return pedidoService.atualizarPedido(id, pedidoDTO);
    }

    @DeleteMapping("/{id}")
    public void excluirPedido(@PathVariable Long id) {
        pedidoService.excluirPedido(id);
    }
}

