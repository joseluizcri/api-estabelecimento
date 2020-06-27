package br.com.jrsistemas.apiestabelecimento.builder;

import br.com.jrsistemas.apiestabelecimento.model.Conta;

public class ContaBuilder {
    public static class Builder {

        private Conta entity;

        public Builder(Conta entity) {
            super();
            this.entity = entity;
        }

        public static Builder create() {
            return new Builder(new Conta());
        }

        public static Builder from(Conta conta) {
            return new Builder(conta);
        }

        public Builder id(Long id) {
            entity.setId(id);
            return this;
        }

        public Builder descricao(String descricao) {
            entity.setDescricao(descricao);
            return this;
        }

        public Conta build() {
            return entity;
        }
    }
}
