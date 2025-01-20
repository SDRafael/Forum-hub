package br.com.alura.hub.api.hub.domain.topico;

import jakarta.validation.constraints.NotNull;

public record DadosAtualizarTopico(
        @NotNull
        Long id,


        String titulo,


        String mensagem,

        String status) {
}
