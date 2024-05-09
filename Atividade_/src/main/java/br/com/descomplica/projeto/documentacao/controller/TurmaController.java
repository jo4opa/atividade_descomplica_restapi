package br.com.descomplica.projeto.documentacao.controller;

import br.com.descomplica.projeto.documentacao.entity.Turma;
import br.com.descomplica.projeto.documentacao.service.TurmaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/turmas")
public class TurmaController {

    @Autowired
    private TurmaService turmaService;

    @PostMapping
    public ResponseEntity<Turma> createTurma(@RequestBody Turma turma) {
        try {
            Turma savedTurma = turmaService.saveTurma(turma);
            return new ResponseEntity<>(savedTurma, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping
    public ResponseEntity<List<Turma>> getAllTurmas() {
        try {
            List<Turma> turmas = turmaService.getAllTurmas();
            return new ResponseEntity<>(turmas, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Turma> getTurmaById(@PathVariable Integer id) {
        try {
            Optional<Turma> turma = turmaService.getTurmaById(id);
            return turma.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                    .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTurma(@PathVariable Integer id) {
        try {
            turmaService.deleteTurmaById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
