package br.com.scout.exemplomock.controllers;

import br.com.scout.exemplomock.models.Usuario;
import br.com.scout.exemplomock.repositories.UsuarioRepositoy;
import br.com.scout.exemplomock.validators.UsuarioValidator;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Data
@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioValidator usuarioValidator;

    @Autowired
    private UsuarioRepositoy usuarioRepositoy;

    @GetMapping("/{cpf}")
    public ResponseEntity<Usuario> getUsuario(@PathVariable("cpf") String cpf){
        System.out.println("Inicio da funcao");

        if (!usuarioValidator.validaCpf(cpf)) {
            throw new RuntimeException("Erro ao validar CPF");
        }

        Usuario usuarioEncontrado = usuarioRepositoy.getUsuario(cpf);  //MOCK

        if (!usuarioValidator.validaCpf(cpf)) {
            throw new RuntimeException("Erro ao validar CPF");
        }

        return ResponseEntity.ok(usuarioEncontrado);
    }


    /*
    assinatura de um metodos em JAVA
    1. Medificadores de Acesso (Public, Private, Procteced)
    2. Modificadores de Escopo (static / final) Pode aparecer ou não
    3. Tipo de retorno  (void , String, int , double , Usuario, ResponseEntity<Usuario>)
    4. Nome do meu metodo
    5. Parametros (Quem podem vim ou não)
     */
}
