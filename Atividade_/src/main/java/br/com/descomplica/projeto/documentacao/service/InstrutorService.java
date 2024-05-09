package br.com.descomplica.projeto.documentacao.service;

import java.util.List;
import java.util.Optional;

import br.com.descomplica.projeto.documentacao.entity.Instrutor;
import br.com.descomplica.projeto.documentacao.repository.InstrutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InstrutorService {

    @Autowired
    private InstrutorRepository instrutorRepository;

    public Instrutor saveInstrutor(Instrutor instrutor) {
        return instrutorRepository.save(instrutor);
    }

    public List<Instrutor> getAllInstrutores() {
        return instrutorRepository.findAll();
    }

    public Optional<Instrutor> getInstrutorById(Integer id) {
        return instrutorRepository.findById(id);
    }

    public void deleteInstrutorById(Integer id) {
        instrutorRepository.deleteById(id);
    }

    public List<Instrutor> getAllInstructors() {
        return getAllInstrutores();
    }
}

