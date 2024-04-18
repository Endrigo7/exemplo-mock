package br.com.scout.exemplomock.repositories;


import br.com.scout.exemplomock.models.Usuario;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UsuarioRepositoy {

    private static final List<Usuario> listaDeUsuario = new ArrayList<>();

    public UsuarioRepositoy() {
        Usuario usuario1 = new Usuario("123", "Joao");
        Usuario usuario2 = new Usuario("234", "Maria");
        Usuario usuario3 = new Usuario("345", "Josefina");
        Usuario usuario4 = new Usuario("678", "Ana");

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
                    .orElseThrow(() -> new RuntimeException("Usuario não encontrado"));
    }
}
