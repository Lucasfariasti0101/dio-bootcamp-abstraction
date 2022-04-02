import com.dio.desafio.dominio.Conteudo;
import com.dio.desafio.dominio.Curso;
import com.dio.desafio.dominio.Mentoria;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Conteudo curso = new Curso.CursoBuilder()
                .titulo("Java for beguines")
                .descricao("This is a course for beginners in programing computers with java language")
                .cargaHoraria(5)
                .build();
        Conteudo mentoria = new Mentoria.MentoriaBuilder()
                .titulo("Mentoria 1")
                .descricao("Descrição da mentoria")
                .data(LocalDate.now())
                .build();

        System.out.println(curso.toString());
        System.out.println(mentoria.toString());

    }
}
