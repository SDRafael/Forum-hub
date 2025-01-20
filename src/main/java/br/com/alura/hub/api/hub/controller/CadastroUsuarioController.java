package br.com.alura.hub.api.hub.controller;

import br.com.alura.hub.api.hub.domain.usuario.DadosCadastroUsuario;
import br.com.alura.hub.api.hub.domain.usuario.Usuario;
import br.com.alura.hub.api.hub.domain.usuario.UsuarioRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cadastro")
public class CadastroUsuarioController {
    @Autowired
    private UsuarioRepository repositorio;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping
    public ResponseEntity cadastrarUsuario(@RequestBody @Valid DadosCadastroUsuario dadosUsuario) {

//        abaixo garanto unicidade de topicos e salvo no bd
        if (repositorio.existsByLogin(dadosUsuario.login())) {
            throw new IllegalArgumentException("Usuário já existe");
        }
        Usuario usuario = new Usuario(dadosUsuario);


        usuario.setPassword(passwordEncoder.encode(dadosUsuario.password()));
        repositorio.save(usuario);


        return ResponseEntity.noContent().build();
    }
}
