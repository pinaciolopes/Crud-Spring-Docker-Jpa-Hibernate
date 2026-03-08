package com.padaria.pablo.Business;

import com.padaria.pablo.DTO.CompraRequestDTO;
import com.padaria.pablo.Infrastucture.Entitys.Compra;
import com.padaria.pablo.Infrastucture.Entitys.Padaria;
import com.padaria.pablo.Infrastucture.Entitys.Usuario;
import com.padaria.pablo.Infrastucture.Repository.CompraRepository;
import com.padaria.pablo.Infrastucture.Repository.PadariaRepository;
import com.padaria.pablo.Infrastucture.Repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CompraService {

    private final CompraRepository compraRepository;
    private final UsuarioRepository usuarioRepository;
    private final PadariaRepository padariaRepository;

    public Compra criarCompraComDto(CompraRequestDTO dto) {
        Usuario usuario = usuarioRepository.findById(dto.getUsuarioId())
                .orElseThrow(() -> new RuntimeException("usuario não encontrado"));
        List<Padaria> produtos = padariaRepository.findAllById(dto.getProdutosIds());

        Compra compra = Compra.builder().
                usuario(usuario).
                produtos(produtos).
                dataCompra(LocalDateTime.now()).
                valorTotal(calcularValorTotal(produtos))
                .build();
        return compraRepository.save(compra);
    }

    private BigDecimal calcularValorTotal(List<Padaria> produtos) {
        return produtos.stream().map(p -> p.getPreco() != null ? p.getPreco() : BigDecimal.ZERO).reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}
