package br.com.jrsistemas.apiestabelecimento.repository;

import br.com.jrsistemas.apiestabelecimento.models.Conta;
import br.com.jrsistemas.apiestabelecimento.models.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {

}
