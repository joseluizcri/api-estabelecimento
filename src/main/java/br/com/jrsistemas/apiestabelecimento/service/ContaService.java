package br.com.jrsistemas.apiestabelecimento.service;

import br.com.jrsistemas.apiestabelecimento.model.Conta;
import br.com.jrsistemas.apiestabelecimento.model.Despesa;
import br.com.jrsistemas.apiestabelecimento.repository.ContaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContaService {

    @Autowired
    private ContaRepository contaRepository;

    public List<Conta> findAll() {
        return contaRepository.findAll();
    }

    public Conta createNewConta(Conta conta, Double saldoInicial) {
        conta.creditar(saldoInicial);
        return contaRepository.save(conta);
    }

    public Conta creditar(Long idConta, Double valor) {
        Conta conta = contaRepository.getOne(idConta);
        conta.creditar(valor);
        return contaRepository.save(conta);
    }

    public Conta debitar(Long idConta, Double valor) {
        Conta conta = contaRepository.getOne(idConta);
        conta.debitar(valor);
        return contaRepository.save(conta);
    }

    public Boolean transferir(Long idContaOrigem, Long idContaDestino, Double valor) {
        debitar(idContaOrigem, valor);
        creditar(idContaDestino, valor);
        return true;
    }
}
