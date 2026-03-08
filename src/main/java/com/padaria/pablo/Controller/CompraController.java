package com.padaria.pablo.Controller;

import com.padaria.pablo.Business.CompraService;
import com.padaria.pablo.DTO.CompraRequestDTO;
import com.padaria.pablo.Infrastucture.Entitys.Compra;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/compra")
@RequiredArgsConstructor
public class CompraController {
    private final CompraService compraService;

    @PostMapping
    public ResponseEntity<Compra> salvarCompra(@RequestBody CompraRequestDTO dto) {
        Compra novaCompra = compraService.criarCompraComDto(dto);
        return ResponseEntity.ok().body(novaCompra);
    }
}
