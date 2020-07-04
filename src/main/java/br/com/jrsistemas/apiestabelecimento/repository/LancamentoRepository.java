package br.com.jrsistemas.apiestabelecimento.repository;

import br.com.jrsistemas.apiestabelecimento.models.Lancamento;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;

public interface LancamentoRepository extends JpaRepository<Lancamento, Long> {
    Page<Lancamento> findByDataVencimentoGreaterThanEqualAndDataVencimentoLessThanEqual(LocalDate dataInicial, LocalDate dataFinal, Pageable pageable);
}
