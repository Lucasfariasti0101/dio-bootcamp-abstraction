package com.dio.desafio.dominio;

public class Curso extends Conteudo {

    private int cargaHoraria;

    private Curso(String titulo, String discricao, int cargaHoraria) {
        setTitulo(titulo);
        setDescricao(discricao);
        this.cargaHoraria = cargaHoraria;
    }

    public static class CursoBuilder {
        private String titulo;
        private String descricao;
        private int cargaHoraria;

        public CursoBuilder titulo(String titulo) {
            this.titulo = titulo;
            return this;
        }

        public CursoBuilder descricao(String descricao) {
            this.descricao = descricao;
            return this;
        }

        public CursoBuilder cargaHoraria(int cargaHoraria) {
            this.cargaHoraria = cargaHoraria;
            return this;
        }

        public Curso build() {
            return new Curso(titulo, descricao, cargaHoraria);
        }

    }
    @Override
    public double calcularXp() {
        return XP_PADRAO * cargaHoraria;
    }

    @Override
    public String toString() {
        return "Curso{" +
                "titulo='" + getTitulo() + '\'' +
                ", descricao='" + getDescricao() + '\'' +
                ", cargaHoraria=" + cargaHoraria +
                '}';
    }

}
