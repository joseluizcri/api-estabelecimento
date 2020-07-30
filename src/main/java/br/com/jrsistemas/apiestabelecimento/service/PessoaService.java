package br.com.jrsistemas.apiestabelecimento.service;

import br.com.jrsistemas.apiestabelecimento.models.Pessoa;
import br.com.jrsistemas.apiestabelecimento.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;

    public Page<Pessoa> findAll(Pageable pageable) {
        return pessoaRepository.findAll(pageable);
    }

    public Pessoa findOne(Long id) {
        return pessoaRepository.findById(id).orElse(null);
    }
}
