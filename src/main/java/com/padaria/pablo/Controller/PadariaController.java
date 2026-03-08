package com.padaria.pablo.Controller;

import com.padaria.pablo.Business.PadariaService;
import com.padaria.pablo.Infrastucture.Entitys.Padaria;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/padaria")
@RequiredArgsConstructor
public class PadariaController {

    private final PadariaService padariaService;

    @PostMapping
    public ResponseEntity<Void> salvarPadaria(@RequestBody Padaria padaria) {
        padariaService.salvarPadaria(padaria);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Padaria> buscarPadariaPorId(@PathVariable Long id) {
        return ResponseEntity.ok(padariaService.buscarPadariaPorId(id));
    }

    @GetMapping
    public ResponseEntity<List<Padaria>> listarPadaria() {
        return ResponseEntity.ok(padariaService.listarPadaria());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void>atualizarPadaria(@PathVariable Long id, @RequestBody Padaria padaria) {
        padariaService.atualizarPadaria(id, padaria);
        return ResponseEntity.ok().build();

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removerPadaria(@PathVariable Long id) {
        padariaService.deletarporId(id);
        return ResponseEntity.ok().build();
    }
}
