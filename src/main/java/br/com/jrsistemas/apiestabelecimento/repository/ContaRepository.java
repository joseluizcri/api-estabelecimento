package br.com.jrsistemas.apiestabelecimento.repository;

import br.com.jrsistemas.apiestabelecimento.model.Conta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContaRepository extends JpaRepository<Conta, Long> {

}
