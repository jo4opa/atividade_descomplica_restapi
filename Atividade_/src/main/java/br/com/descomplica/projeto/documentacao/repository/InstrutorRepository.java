package br.com.descomplica.projeto.documentacao.repository;

import br.com.descomplica.projeto.documentacao.entity.Instrutor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InstrutorRepository extends JpaRepository<Instrutor, Integer> {
}
