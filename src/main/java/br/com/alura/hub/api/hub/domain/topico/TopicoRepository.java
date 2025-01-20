package br.com.alura.hub.api.hub.domain.topico;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface TopicoRepository extends JpaRepository<Topico, Long> {
    boolean existsByTituloOrMensagem(String titulo, String mensagem);



    Page<Topico> findByStatus(String status, Pageable pageable);

    Optional<Topico> findByIdAndAtivo(Long id, boolean ativo);
}
