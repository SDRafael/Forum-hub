package br.com.alura.hub.api.hub.controller;

import br.com.alura.hub.api.hub.domain.topico.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Optional;

@RestController
@RequestMapping("/topico")
public class TopicoController {

    @Autowired
    private TopicoRepository repositorio;

    @PostMapping
    public ResponseEntity cadastraTopico(@RequestBody @Valid DadosTopico dadosTopico, UriComponentsBuilder uribuilder) {

//        abaixo garanto unicidade de topicos e salvo no bd
        if (repositorio.existsByTituloOrMensagem(dadosTopico.titulo(), dadosTopico.mensagem())) {
            throw new IllegalArgumentException("Tópico já cadastrado");
        }
        Topico topico = new Topico(dadosTopico);

        repositorio.save(topico);

        var uri = uribuilder.path("/topico/{id}").buildAndExpand(topico.getId()).toUri();
        return ResponseEntity.created(uri).body(new DadosListagemTopico(topico));
    }

    @GetMapping
    public ResponseEntity<Page<DadosListagemTopico>> listarTopicos(@PageableDefault(size = 10, sort = {"dataCriacao"}, direction = Sort.Direction.ASC) Pageable paginacao) {

        var listando = repositorio.findByStatus("ativo", paginacao).map(DadosListagemTopico::new);

        return ResponseEntity.ok(listando);
    }

    @PutMapping
    @Transactional
    public ResponseEntity atualizarTopicos(@RequestBody @Valid DadosAtualizarTopico dadosAtualizarTopico) {

        var topico = repositorio.getReferenceById(dadosAtualizarTopico.id());
        topico.atualizarInformacoes(dadosAtualizarTopico);

        return ResponseEntity.ok(new DadosListagemTopico(topico));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<DadosListagemTopico>> detalharTopico(@PathVariable Long id) {
        var topico = repositorio.getReferenceById(id);

        System.out.println(topico);

        var topicoConfirm = repositorio.findByIdAndAtivo(id, true).map(DadosListagemTopico::new);

        return ResponseEntity.ok(topicoConfirm);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity deletarTopico(@PathVariable Long id) {

        var topico = repositorio.getReferenceById(id);
        topico.excluir();
        return ResponseEntity.noContent().build();
    }
}
