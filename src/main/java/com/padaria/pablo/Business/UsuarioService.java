package com.padaria.pablo.Business;

import com.padaria.pablo.Infrastucture.Entitys.Usuario;
import com.padaria.pablo.Infrastucture.Repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    private final UsuarioRepository repository;

    public UsuarioService(UsuarioRepository repository) {
        this.repository = repository;
    }
    public void salvarUsuario(Usuario usuario) {
        repository.saveAndFlush(usuario);
    }

    public Usuario buscarUsuarioPorCpf(String cpf) {
        return repository.findByCpf(cpf).orElseThrow(() -> new RuntimeException("cpf não encontrado"));
    }

    public void deletarUsuario(String cpf) {
        repository.deleteByCpf(cpf);
    }

    public void atualizarUsuarioPorCpf(String cpf, Usuario usuario) {
        Usuario usuarioEntity = repository.findByCpf(cpf).orElseThrow(() -> new RuntimeException("cpf inexistente"));

        if (usuario.getNome() != null ){
            usuarioEntity.setNome(usuario.getNome());
        }

        if (usuario.getEmail() != null ) {
            usuarioEntity.setEmail(usuario.getEmail());
        }

        if (usuario.getCpf() != null ){
            usuarioEntity.setCpf(usuario.getCpf());
        }

        repository.saveAndFlush(usuarioEntity);

    }
    public List<Usuario> listarTodos() {
       return repository.findAll();
    }
}
