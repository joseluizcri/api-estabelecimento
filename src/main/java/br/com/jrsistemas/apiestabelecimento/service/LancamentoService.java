package br.com.jrsistemas.apiestabelecimento.service;

import br.com.jrsistemas.apiestabelecimento.enums.TipoParcelamento;
import br.com.jrsistemas.apiestabelecimento.models.Lancamento;
import br.com.jrsistemas.apiestabelecimento.repository.LancamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class LancamentoService {

    @Autowired
    private LancamentoRepository lancamentoRepository;

    public List<Lancamento> findAll() {
        return lancamentoRepository.findAll();
    }

    public Page<Lancamento> findByPeriodo(LocalDate dataInicial, LocalDate dataFinal, Pageable pageable) {
        return lancamentoRepository.findByDataVencimentoGreaterThanEqualAndDataVencimentoLessThanEqual(dataInicial, dataFinal, pageable);
    }

    public List<Lancamento> save(Lancamento lancamento) {
        if (lancamento.getParcelas() != null && lancamento.getParcelas() > 1) {
            List<Lancamento> lancamentosPacelados = new ArrayList<>();
            lancamento.setParcela(1);
            for(int cont = 1; cont < lancamento.getParcelas();) {

                Lancamento lancamentoPacelado = Lancamento.copy(lancamento);

                if (lancamento.getTipoParcelamento().equals(TipoParcelamento.MENSAL)) {
                    lancamentoPacelado.setDataVencimento(lancamento.getDataVencimento().plusMonths(cont));
                }

                lancamentoPacelado.setPai(lancamento);
                lancamentoPacelado.setParcela(++cont);
                lancamentosPacelados.add(lancamentoPacelado);
            }
            return lancamentoRepository.saveAll(lancamentosPacelados);
        }
        lancamento.setParcelas(1);
        lancamento.setParcela(1);
        return Collections.singletonList(lancamentoRepository.save(lancamento));
    }
}
