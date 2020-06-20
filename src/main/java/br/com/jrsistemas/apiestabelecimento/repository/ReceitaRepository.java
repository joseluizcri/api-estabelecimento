package br.com.jrsistemas.apiestabelecimento.repository;

import br.com.jrsistemas.apiestabelecimento.model.Receita;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReceitaRepository extends JpaRepository<Receita, Long> {

}
