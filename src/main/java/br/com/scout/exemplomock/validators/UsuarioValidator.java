package br.com.scout.exemplomock.validators;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

@Component
public class UsuarioValidator {

    private boolean cpfEBranco(String cpf){
        System.out.println("Entrou no metodo cpf é branco?");

        if (StringUtils.isBlank(cpf)) {
            return true;
        }

        return false;
    }

    public boolean validaCpf(String cpf){
        System.out.println("Iniciou a validação do CPF");

        if(cpfEBranco(cpf)) {
            throw new RuntimeException("CPF deve ser preenchido!!!!!!!!!!!!");
        }

        if(!StringUtils.isNumeric(cpf)) {
            throw new RuntimeException("CPF deve ser um numero");
        }

        if (cpf.length() != 11) {
            throw new RuntimeException("CPF deve possuir 11 caracates");
        }

        return true;
    }
}
