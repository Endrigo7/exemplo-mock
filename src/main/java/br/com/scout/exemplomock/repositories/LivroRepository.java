package br.com.scout.exemplomock.repositories;

import br.com.scout.exemplomock.models.Livro;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class LivroRepository {

    private static final List<Livro> LISTA_DE_LIVROS = new ArrayList<>();

    public LivroRepository(){
        LISTA_DE_LIVROS.addAll(
                Arrays.asList(
                        new Livro("ASD131ASDAB", "Programacao em JAva", Arrays.asList("End", "Dede")),
                        new Livro("ADGAS123131", "Diga nao a Python", Arrays.asList("Maria Joaquina de Amaral Pereira Goes")),
                        new Livro("HDGDGD7877AFAS", "Usando liguagem funcional em JAVA", Arrays.asList("End"))
                )
        );
    }

    /*
     * Tarefinha de casa 1
     * criar 2 cenarios de teste para esse metodo
     */
    public Livro buscarLivro(String ISDN){
        return LISTA_DE_LIVROS
                .stream()
                .filter(livro -> livro.getISDN().equalsIgnoreCase(ISDN))
                .findFirst()
                .get();
    }
}
