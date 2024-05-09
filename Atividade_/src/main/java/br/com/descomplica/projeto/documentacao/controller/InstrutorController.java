package br.com.descomplica.projeto.documentacao.controller;

import br.com.descomplica.projeto.documentacao.entity.Instrutor;
import br.com.descomplica.projeto.documentacao.service.InstrutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/instrutores")
public class InstrutorController {

    @Autowired
    private InstrutorService instrutorService;
    @PostMapping
    public ResponseEntity<Instrutor> createInstrutor(@RequestBody Instrutor instrutor) {
        try {
            Instrutor savedInstrutor = instrutorService.saveInstrutor(instrutor);
            return new ResponseEntity<>(savedInstrutor, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping
    public ResponseEntity<List<Instrutor>> getAllInstrutores() {
        try {
            List<Instrutor> instrutores= instrutorService.getAllInstructors();
            return new ResponseEntity<>(instrutores, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Instrutor> getInstrutorById(@PathVariable Integer id) {
        try {
            Optional<Instrutor> instrutor = instrutorService.getInstrutorById(id);
            return instrutor.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                    .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteInstrutor(@PathVariable Integer id) {
        try {
            instrutorService.deleteInstrutorById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

