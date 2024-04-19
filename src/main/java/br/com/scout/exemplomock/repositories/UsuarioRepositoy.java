package br.com.scout.exemplomock.repositories;


import br.com.scout.exemplomock.models.Usuario;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UsuarioRepositoy {

    private static final List<Usuario> listaDeUsuario = new ArrayList<>();

    public UsuarioRepositoy() {
        Usuario usuario1 = new Usuario("12311111111", "Joao");
        Usuario usuario2 = new Usuario("23411111111", "Maria");
        Usuario usuario3 = new Usuario("34511111111", "Josefina");
        Usuario usuario4 = new Usuario("67811111111", "Ana");

        listaDeUsuario.add(usuario1);
        listaDeUsuario.add(usuario2);
        listaDeUsuario.add(usuario3);
        listaDeUsuario.add(usuario4);
    }

    public Usuario getUsuario(String cpf){
        System.out.println("Entrou no usuarioRepository");

        return listaDeUsuario
                    .stream()
                    .filter(user -> user.getCpf().equals(cpf))
                    .findFirst()
                    .orElseThrow(() -> new RuntimeException("Usuario com " + cpf + " não foi encontrado!"));
    }
}
