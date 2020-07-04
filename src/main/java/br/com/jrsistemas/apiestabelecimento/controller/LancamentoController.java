package br.com.jrsistemas.apiestabelecimento.controller;

import br.com.jrsistemas.apiestabelecimento.dto.LancamentoDto;
import br.com.jrsistemas.apiestabelecimento.enums.TipoLancamento;
import br.com.jrsistemas.apiestabelecimento.service.LancamentoService;
import br.com.jrsistemas.apiestabelecimento.models.Lancamento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.format.annotation.DateTimeFormat.ISO.DATE;

@RestController
@RequestMapping(path = "/lancamentos")
public class LancamentoController {

    @Autowired
    private LancamentoService lancamentoService;

    @GetMapping
    public ResponseEntity<List<Lancamento>> listarTodos() {
        return ResponseEntity.ok(lancamentoService.findAll());
    }

    @GetMapping("periodo")
    public ResponseEntity<Page<LancamentoDto>> listarTodos(@RequestParam @DateTimeFormat(iso = DATE) LocalDate dataInicial,
                                                           @RequestParam @DateTimeFormat(iso = DATE) LocalDate dataFinal,
                                                           Pageable pageable) {
        Page<LancamentoDto> lancamentos = lancamentoService.findByPeriodo(dataInicial, dataFinal, pageable).map(LancamentoDto::toRepresentation);
        return ResponseEntity.ok(lancamentos);
    }

    @PostMapping("receita")
    public ResponseEntity<List<LancamentoDto>> inserirReceita(@RequestBody Lancamento lancamento) {
        lancamento.setTipoLancamento(TipoLancamento.RECEITA);
        List<LancamentoDto> result = lancamentoService.save(lancamento).stream().map(LancamentoDto::toRepresentation).collect(Collectors.toList());
        return ResponseEntity.ok(result);
    }

    @PostMapping("despesa")
    public ResponseEntity<List<LancamentoDto>> inserirDespesa(@RequestBody Lancamento lancamento) {
        lancamento.setTipoLancamento(TipoLancamento.DESPESA);
        List<LancamentoDto> result = lancamentoService.save(lancamento).stream().map(LancamentoDto::toRepresentation).collect(Collectors.toList());
        return ResponseEntity.ok(result);
    }

}
