package br.com.jrsistemas.apiestabelecimento.controller;

import br.com.jrsistemas.apiestabelecimento.enums.TipoLancamento;
import br.com.jrsistemas.apiestabelecimento.model.Lancamento;
import br.com.jrsistemas.apiestabelecimento.service.LancamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

import static org.springframework.format.annotation.DateTimeFormat.*;
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
    public ResponseEntity<List<Lancamento>> listarTodos(@RequestParam @DateTimeFormat(iso = DATE) LocalDate dataInicial,
                                                               @RequestParam @DateTimeFormat(iso = DATE) LocalDate dataFinal) {
        return ResponseEntity.ok(lancamentoService.findByPeriodo(dataInicial, dataFinal));
    }

    @PostMapping("receita")
    public ResponseEntity<List<Lancamento>> inserirReceita(@RequestBody Lancamento lancamento) {
        lancamento.setTipoLancamento(TipoLancamento.RECEITA);
        return ResponseEntity.ok(lancamentoService.save(lancamento));
    }

    @PostMapping("despesa")
    public ResponseEntity<List<Lancamento>> inserirDespesa(@RequestBody Lancamento lancamento) {
        lancamento.setTipoLancamento(TipoLancamento.DESPESA);
        return ResponseEntity.ok(lancamentoService.save(lancamento));
    }

}
