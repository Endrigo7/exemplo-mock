package br.com.scout.exemplomock.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Livro {

    private String ISDN;
    private String nome;
    private List<String> autores;

}
