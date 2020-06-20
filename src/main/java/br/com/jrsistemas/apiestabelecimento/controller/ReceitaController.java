package br.com.jrsistemas.apiestabelecimento.controller;

import br.com.jrsistemas.apiestabelecimento.model.Receita;
import br.com.jrsistemas.apiestabelecimento.service.ReceitaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/receitas")
public class ReceitaController {

    @Autowired
    private ReceitaService receitaService;

    @GetMapping
    public ResponseEntity<List<Receita>> listarReceitas() {
        return ResponseEntity.ok(receitaService.findAll());
    }

    @PostMapping
    public ResponseEntity<Receita> inserirReceita(@RequestBody Receita receita) {
        return ResponseEntity.ok(receitaService.save(receita));
    }

}
