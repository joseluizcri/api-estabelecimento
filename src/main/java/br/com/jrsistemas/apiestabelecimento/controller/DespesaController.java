package br.com.jrsistemas.apiestabelecimento.controller;

import br.com.jrsistemas.apiestabelecimento.model.Despesa;
import br.com.jrsistemas.apiestabelecimento.model.Receita;
import br.com.jrsistemas.apiestabelecimento.service.DespesaService;
import br.com.jrsistemas.apiestabelecimento.service.ReceitaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/despesas")
public class DespesaController {

    @Autowired
    private DespesaService despesaService;

    @GetMapping
    public ResponseEntity<List<Despesa>> listarDespesas() {
        return ResponseEntity.ok(despesaService.findAll());
    }

    @PostMapping
    public ResponseEntity<Despesa> inserirDespesa(@RequestBody Despesa despesa) {
        return ResponseEntity.ok(despesaService.save(despesa));
    }

}
