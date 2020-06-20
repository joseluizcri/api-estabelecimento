package br.com.jrsistemas.apiestabelecimento.service;

import br.com.jrsistemas.apiestabelecimento.model.Receita;
import br.com.jrsistemas.apiestabelecimento.repository.ReceitaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReceitaService {

    @Autowired
    private ReceitaRepository receitaRepository;

    public List<Receita> findAll() {
        return receitaRepository.findAll();
    }

    public Receita save(Receita receita) {
        return receitaRepository.save(receita);
    }
}
