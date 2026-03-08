package com.padaria.pablo.Controller;

import com.padaria.pablo.Business.UsuarioService;
import com.padaria.pablo.Infrastucture.Entitys.Usuario;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
@RequiredArgsConstructor

public class UsuarioController {

    private final UsuarioService service;

    @PostMapping
    public ResponseEntity<Void>salvarUsuario(@RequestBody Usuario usuario){
        service.salvarUsuario(usuario);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping
    public ResponseEntity<List<Usuario>> listarUsuario(){
        return ResponseEntity.ok(service.listarTodos());
    }

    @GetMapping("/{cpf}")
    public ResponseEntity<Usuario> buscarUsuarioPorCpf(@PathVariable String cpf){
        return ResponseEntity.ok(service.buscarUsuarioPorCpf(cpf));
    }

    @PutMapping("/{cpf}")
    public ResponseEntity<Void> atualizarUsuarioPorCpf(@PathVariable String cpf, @RequestBody Usuario usuario){
        service.atualizarUsuarioPorCpf(cpf, usuario);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{cpf}")
    public ResponseEntity<Void> deletarUsuarioPorCpf(@PathVariable String cpf){
        service.deletarUsuario(cpf);
        return ResponseEntity.ok().build();
    }
}
