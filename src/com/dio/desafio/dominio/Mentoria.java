package com.dio.desafio.dominio;

import java.time.LocalDate;

public class Mentoria extends Conteudo {
    private LocalDate data;

    private Mentoria(String titulo, String descricao, LocalDate data) {
        setTitulo(titulo);
        setDescricao(descricao);
        this.data = data;
    }

    public static class MentoriaBuilder {

        private String titulo;
        private String descricao;
        private LocalDate data;
        public MentoriaBuilder titulo(String titulo) {
            this.titulo = titulo;
            return this;
        }

        public MentoriaBuilder descricao(String descricao) {
            this.descricao = descricao;
            return this;
        }

        public MentoriaBuilder data(LocalDate data) {
            this.data = data;
            return this;
        }

        public Mentoria build() {
            return new Mentoria(titulo, descricao, data);
        }


    }
    @Override
    public String toString() {
        return " \nMentoria{" +
                " \n* titulo = '" + getTitulo() + '\'' +
                ", \n* descricao = '" + getDescricao() + '\'' +
                ", \n* data = " + data +
                " }";
    }

    @Override
    public double calcularXp() {
        return 0;
    }
}
