package br.com.jrsistemas.apiestabelecimento.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Getter
@Setter
@Entity
public class Despesa extends Lancamento implements Serializable {

    @ManyToOne
    private Pessoa credor;

}