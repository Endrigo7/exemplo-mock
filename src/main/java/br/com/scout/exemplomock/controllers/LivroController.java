package br.com.scout.exemplomock.controllers;

import br.com.scout.exemplomock.models.Livro;
import br.com.scout.exemplomock.repositories.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/livro")
public class LivroController {

    @Autowired
    private LivroRepository livroRepository;


    /*
     * Crie um teste para esse classe
     */

    @GetMapping("/{ISDN}")
    public String buscarLivro(@PathVariable("ISDN") String ISDN){
        Livro livro = livroRepository.buscarLivro(ISDN);

        return livro.toString();
    }


}
