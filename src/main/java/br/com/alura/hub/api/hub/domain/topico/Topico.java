package br.com.alura.hub.api.hub.domain.topico;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Table(name = "topicos")
@Entity(name = "Topico")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Topico {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String titulo;
    private String mensagem;
    private String status = "ativo";
    private String autor;

    @Enumerated(EnumType.STRING)
    private Curso curso;

    @Column(updatable = false)
    private LocalDateTime dataCriacao;

    private boolean ativo;

    public Topico() {}
    public Topico(DadosTopico dadosTopico) {
        this.titulo = dadosTopico.titulo();
        this.mensagem = dadosTopico.mensagem();
        this.autor = dadosTopico.autor();
        this.curso = dadosTopico.curso();
        this.dataCriacao = LocalDateTime.now();
        this.ativo = true;
    }

    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getMensagem() {
        return mensagem;
    }

    public String getStatus() {
        return this.status;
    }

    public String getAutor() {
        return autor;
    }

    public Curso getCurso() {
        return curso;
    }

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

    public boolean getAtivo() {
        return ativo;
    }

    public void atualizarInformacoes(DadosAtualizarTopico dadosAtualizarTopico) {
        if (dadosAtualizarTopico.titulo() != null) {
            this.titulo = dadosAtualizarTopico.titulo();

        }
        if (dadosAtualizarTopico.mensagem() != null) {
            this.mensagem = dadosAtualizarTopico.mensagem();
        }
        if (dadosAtualizarTopico.status() != null) {
            this.status = dadosAtualizarTopico.status();
        }

    }

    public void excluir() {
        this.ativo = false;
        this.status = "encerrado";
    }
}
