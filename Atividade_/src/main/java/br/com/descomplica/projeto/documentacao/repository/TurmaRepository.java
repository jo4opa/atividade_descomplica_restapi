package br.com.descomplica.projeto.documentacao.repository;

import br.com.descomplica.projeto.documentacao.entity.Turma;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TurmaRepository extends JpaRepository<Turma, Integer> {
}