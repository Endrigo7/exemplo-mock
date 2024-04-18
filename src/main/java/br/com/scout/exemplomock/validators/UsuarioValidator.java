package br.com.scout.exemplomock.validators;

import br.com.scout.exemplomock.models.Usuario;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

@Component
public class UsuarioValidator {

    public boolean validaCpf(String cpf){

        System.out.println("Iniciou a validação do CPF");

        if(StringUtils.isBlank(cpf)) {
            throw new RuntimeException("CPF deve ser preenchido");
        }

        if(!StringUtils.isNumeric(cpf)) {
            throw new RuntimeException("CPF deve ser um numero");
        }

        return true;
    }

}
