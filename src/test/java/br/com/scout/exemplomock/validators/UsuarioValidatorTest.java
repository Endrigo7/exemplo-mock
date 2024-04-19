package br.com.scout.exemplomock.validators;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class UsuarioValidatorTest {

    private UsuarioValidator usuarioValidator;

    @BeforeEach
    public void setup(){
        usuarioValidator = new UsuarioValidator();
    }


    @Test
    public void deveRetornarFalseQuandoCPFPreenchido(){
        Exception thrown = Assertions.assertThrows(RuntimeException.class, () -> {
            usuarioValidator.validaCpf("");
        });

        Assertions.assertEquals("CPF deve ser preenchido!!!!!!!!!!!!", thrown.getMessage());
    }

    @Test
    public void deveLancarExcecaoQuandoCpfNaoForNumerico(){
        Exception thrown = Assertions.assertThrows(RuntimeException.class, () -> {
            usuarioValidator.validaCpf("asfasfa");
        });

        Assertions.assertEquals("CPF deve ser um numero", thrown.getMessage());
    }

    @Test
    public void deveLancarExcecaoQuandoCpfNaoTiver11Caracaters(){
        Exception thrown = Assertions.assertThrows(RuntimeException.class, () -> {
            usuarioValidator.validaCpf("123");
        });

        Assertions.assertEquals("CPF deve possuir 11 caracates", thrown.getMessage());
    }

    @Test
    public void deveRetornarTrueQuandoCpfForValido(){
        boolean obtido = usuarioValidator.validaCpf("00000000000");
        Assertions.assertTrue(obtido);
    }
}
