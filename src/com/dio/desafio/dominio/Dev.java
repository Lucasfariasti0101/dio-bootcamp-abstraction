package com.dio.desafio.dominio;

import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

public class Dev {
    private String nome;
    private Set<Conteudo> conteudosInscritos = new LinkedHashSet<>();
    private Set<Conteudo> conteudosConcluidos = new LinkedHashSet<>();

    public Dev(String nome, Set<Conteudo> conteudosInscritos, Set<Conteudo> conteudosConcluidos) {
        this.nome = nome;
        this.conteudosInscritos = conteudosInscritos;
        this.conteudosConcluidos = conteudosConcluidos;
    }

    public void increverBootcamp(Bootcamp bootcamp) {
        this.conteudosInscritos.addAll(bootcamp.getConteudos());
        bootcamp.getDevsInscritos().add(this);
    }

    public void progredir() {
        Optional<Conteudo> conteudo = this.conteudosInscritos.stream().findFirst();
        if (conteudo.isPresent()) {
            this.conteudosConcluidos.add(conteudo.get());
            this.conteudosInscritos.remove(conteudo.get());
        } else {
            System.out.println("ATENÇÃO: Você deve estar inscrito em algúm conteúdo!");
        }

    }

    public double calcularXpTotal() {
        return this.conteudosConcluidos
                .stream()
                .mapToDouble(Conteudo::calcularXp)
                .sum();
    }

    public static class DevBuilder {

        private String nome;
        private Set<Conteudo> conteudosInscritos = new LinkedHashSet<>();
        private Set<Conteudo> conteudosConcluidos = new LinkedHashSet<>();

        public DevBuilder nome(String nome) {
            this.nome = nome;
            return this;
        }

        public DevBuilder conteudosInscritos(Set<Conteudo> conteudosInscritos) {
            this.conteudosInscritos = conteudosInscritos;
            return this;
        }

        public DevBuilder conteudosConcluidos(Set<Conteudo> conteudosConcluidos) {
            this.conteudosConcluidos = conteudosConcluidos;
            return this;
        }

        public Dev build() {
            return new Dev(nome, conteudosInscritos, conteudosConcluidos);
        }

    }

    public Set<Conteudo> getConteudosInscritos() {
        return conteudosInscritos;
    }

    public Set<Conteudo> getConteudosConcluidos() {
        return conteudosConcluidos;
    }

    @Override
    public String toString() {
        return "Dev{" +
                "nome = '" + nome + '\'' +
                ",\nconteudosInscritos = " + conteudosInscritos +
                ",\nconteudosConcluidos = " + conteudosConcluidos +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dev dev = (Dev) o;
        return Objects.equals(nome, dev.nome) && Objects.equals(conteudosInscritos, dev.conteudosInscritos) && Objects.equals(conteudosConcluidos, dev.conteudosConcluidos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, conteudosInscritos, conteudosConcluidos);
    }
}
