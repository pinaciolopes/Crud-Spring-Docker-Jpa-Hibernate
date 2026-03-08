package com.padaria.pablo.Business;

import com.padaria.pablo.Exception.ResourceNotFoundException;
import com.padaria.pablo.Infrastucture.Entitys.Padaria;
import com.padaria.pablo.Infrastucture.Repository.PadariaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PadariaService {

    @Autowired
    private PadariaRepository repository;

    public void salvarPadaria(Padaria padaria) {
        repository.saveAndFlush(padaria);
    }

    public Padaria buscarPadariaPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public void deletarporId(Long id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException(id);
        }
        repository.deleteById(id);
    }
    public Padaria atualizarPadaria(Long id, Padaria padaria) {
        Padaria existente = buscarPadariaPorId(id);
        existente.setNome(padaria.getNome());
        existente.setPreco(padaria.getPreco());
        return repository.saveAndFlush(existente);
    }

    public List<Padaria> listarPadaria() {
        return repository.findAll();
    }
}
