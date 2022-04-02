package com.dio.desafio.dominio;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

public class Bootcamp {
    private String nome;
    private String descricao;
    private final LocalDate dataInicial = LocalDate.now();
    private final LocalDate dataFinal = dataInicial.plusDays(50);
    private Set<Dev> devsInscritos = new HashSet<>();
    private Set<Conteudo> conteudos = new LinkedHashSet<>();

    public Bootcamp(String nome, String descricao, Set<Dev> devsInscritos, Set<Conteudo> conteudos) {
        this.nome = nome;
        this.descricao = descricao;
        this.devsInscritos = devsInscritos;
        this.conteudos = conteudos;
    }

    public static class BootcampBuild {

        private String nome;
        private String descricao;
        private final LocalDate dataInicial = LocalDate.now();
        private final LocalDate dataFinal = dataInicial.plusDays(50);
        private Set<Dev> devsInscritos = new HashSet<>();
        private Set<Conteudo> conteudos = new LinkedHashSet<>();

        public BootcampBuild nome(String nome) {
            this.nome = nome;
            return this;
        }

        public BootcampBuild descricao(String descricao) {
            this.descricao = descricao;
            return this;
        }

        public BootcampBuild devsInscritos(Set<Dev> devsInscritos) {
            this.devsInscritos = devsInscritos;
            return this;
        }

        public BootcampBuild conteudos(Set<Conteudo> conteudos) {
            this.conteudos = conteudos;
            return this;
        }

        public Bootcamp build() {
            return new Bootcamp(nome, descricao, devsInscritos, conteudos);
        }
    }

    public Set<Dev> getDevsInscritos() {
        return devsInscritos;
    }

    public Set<Conteudo> getConteudos() {
        return conteudos;
    }

    @Override
    public String toString() {
        return "Bootcamp{" +
                "nome='" + nome + '\'' +
                ", descricao='" + descricao + '\'' +
                ", dataInicial=" + dataInicial +
                ", dataFinal=" + dataFinal +
                ", devsInscritos=" + devsInscritos +
                ", conteudos=" + conteudos +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bootcamp bootcamp = (Bootcamp) o;
        return Objects.equals(nome, bootcamp.nome) && Objects.equals(descricao, bootcamp.descricao) && Objects.equals(dataInicial, bootcamp.dataInicial) && Objects.equals(dataFinal, bootcamp.dataFinal) && Objects.equals(devsInscritos, bootcamp.devsInscritos) && Objects.equals(conteudos, bootcamp.conteudos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, descricao, dataInicial, dataFinal, devsInscritos, conteudos);
    }
}
