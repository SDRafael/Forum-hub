package br.com.alura.hub.api.hub.domain.usuario;

import jakarta.validation.constraints.NotBlank;

public record DadosCadastroUsuario(
        @NotBlank
        String password,

        @NotBlank
        String login) {
}
