import com.dio.desafio.dominio.*;

import java.time.LocalDate;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Conteudo curso = new Curso.CursoBuilder()
                .titulo("Java for beguines")
                .descricao("This is a course of java")
                .cargaHoraria(15)
                .build();
        Conteudo curso2 = new Curso.CursoBuilder()
                .titulo("Java with Spring boot")
                .descricao("This is a course of java for web")
                .cargaHoraria(7)
                .build();

        Conteudo mentoria = new Mentoria.MentoriaBuilder()
                .titulo("Woman in tech, what are the challenges?")
                .descricao("We will discuss what barriers women face in the job market, especially in technology.")
                .data(LocalDate.now())
                .build();

        Bootcamp bootcamp = new Bootcamp.BootcampBuild()
                .nome("Bootcamp java ")
                .descricao("This is a java bootcamp")
                .conteudos(Set.of(curso, curso2, mentoria))
                .build();

        Dev lucas = new Dev.DevBuilder()
                .nome("Lucas")
                .build();

        lucas.increverBootcamp(bootcamp);
        System.out.println("Conteúdos Inscritos Camila:" + lucas.getConteudosInscritos());
        lucas.progredir();
        lucas.progredir();
        System.out.println("-");
        System.out.println("Conteúdos Inscritos Camila:" + lucas.getConteudosInscritos());
        System.out.println("Conteúdos Concluídos Camila:" + lucas.getConteudosConcluidos());
        System.out.println("XP:" + lucas.calcularXpTotal());

    }
}
