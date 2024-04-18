package br.com.scout.exemplomock.controllers;

import br.com.scout.exemplomock.models.Usuario;
import br.com.scout.exemplomock.repositories.UsuarioRepositoy;
import br.com.scout.exemplomock.validators.UsuarioValidator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import static org.mockito.Mockito.times;

@ExtendWith(MockitoExtension.class)
public class UsuarioControllerTest {

    private UsuarioController usuarioController;

    @Mock
    private UsuarioValidator usuarioValidator;

    @Mock
    private UsuarioRepositoy usuarioRepositoy;

    @BeforeEach
    public void setup(){
        usuarioController = new UsuarioController();
        usuarioController.setUsuarioRepositoy(usuarioRepositoy);
        usuarioController.setUsuarioValidator(usuarioValidator);
    }


    /*
    GIVEN - DADO      um cpf que existe na lista
    WHEN  - QUANDO    consultar o cpf 123
    THEN - ENTAO      deve retornar o usuario
     */

    @Test
    public void deveRetornarUsuarioQuandoCpfExistirNaLista(){
        Usuario usuario = new Usuario("123", "Maria Joaquina");

        ResponseEntity<Usuario> esperado = ResponseEntity.ok(usuario);

        Mockito.when(usuarioValidator.validaCpf("123")).thenReturn(false);

        Mockito.when(usuarioRepositoy.getUsuario("123"))
                .thenReturn(new Usuario("123", "Maria Joaquina"));

        ResponseEntity<Usuario> obtido = usuarioController.getUsuario("123");

        Mockito.verify(usuarioValidator, Mockito.times(2)).validaCpf("123");
        Mockito.verify(usuarioRepositoy, Mockito.times(1)).getUsuario("123");

        Assertions.assertEquals(esperado, obtido);
    }

    @Test
    public void bla(){
        Usuario usuario = new Usuario("123", "Maria Joaquina");

        ResponseEntity<Usuario> esperado = ResponseEntity.ok(usuario);

        Mockito.when(usuarioValidator.validaCpf("123")).thenReturn(true);

        Mockito.when(usuarioRepositoy.getUsuario("123"))
                .thenReturn(new Usuario("123", "Maria Joaquina"));

        ResponseEntity<Usuario> obtido = usuarioController.getUsuario("123");

        Assertions.assertEquals(esperado, obtido);
    }

}
