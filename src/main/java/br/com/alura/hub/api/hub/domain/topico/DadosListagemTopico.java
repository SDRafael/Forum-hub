package br.com.alura.hub.api.hub.domain.topico;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.time.LocalDateTime;

public record DadosListagemTopico(Long id,
                                  String titulo,
                                  String mensagem,
                                  String status,
                                  String autor,
                                  Curso curso,
                                  LocalDateTime dataCriacao,
                                  @JsonIgnore boolean ativo) {

    public DadosListagemTopico(Topico topico) {
        this(topico.getId(), topico.getTitulo(), topico.getMensagem(), topico.getStatus(), topico.getAutor(), topico.getCurso(), topico.getDataCriacao(), topico.getAtivo());
    }
}
