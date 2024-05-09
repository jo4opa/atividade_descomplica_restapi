package br.com.descomplica.projeto.documentacao.service;

import java.util.List;
import java.util.Optional;

import br.com.descomplica.projeto.documentacao.entity.Turma;
import br.com.descomplica.projeto.documentacao.repository.TurmaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TurmaService {

    @Autowired
    private TurmaRepository turmaRepository;

    public Turma saveTurma(Turma turma) {
        return turmaRepository.save(turma);
    }

    public List<Turma> getAllTurmas() {
        return turmaRepository.findAll();
    }

    public Optional<Turma> getTurmaById(Integer id) {
        return turmaRepository.findById(id);
    }

    public void deleteTurmaById(Integer id) {
        turmaRepository.deleteById(id);
    }
}
