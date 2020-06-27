package br.com.jrsistemas.apiestabelecimento.repository;

import br.com.jrsistemas.apiestabelecimento.model.Lancamento;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface LancamentoRepository extends JpaRepository<Lancamento, Long> {
    List<Lancamento> findByDataVencimentoGreaterThanEqualAndDataVencimentoLessThanEqual(LocalDate dataInicial, LocalDate dataFinal);
}
