package br.com.jrsistemas.apiestabelecimento.service;

import br.com.jrsistemas.apiestabelecimento.models.Conta;
import br.com.jrsistemas.apiestabelecimento.repository.ContaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ContaService {

    @Autowired
    private ContaRepository contaRepository;

    public Page<Conta> findAll(Pageable pageable) {
        return contaRepository.findAll(pageable);
    }

    public Conta findOne(Long id) {
        return contaRepository.findById(id).orElse(null);
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
