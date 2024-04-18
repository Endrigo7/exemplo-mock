package br.com.scout.exemplomock.repositories;

import br.com.scout.exemplomock.models.Usuario;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class UsuarioRepositoyTest {

    private UsuarioRepositoy usuarioRepositoy;

    @BeforeEach
    public void setup(){
        usuarioRepositoy = new UsuarioRepositoy();
    }


    /*
    GIVEN - DADO      um CPF que existe lista (123)
    WHEN  - QUANDO    consultar o usuario
    THEN - ENTAO      deve retornar o usuario
     */

    @Test
    public void deveRetornarUsuarioQuandoCpfExistirNaLista(){
        Usuario esperado = new Usuario("123", "Joao");
        Usuario obtido = usuarioRepositoy.getUsuario("123");

        Assertions.assertEquals(esperado, obtido);
    }


}
