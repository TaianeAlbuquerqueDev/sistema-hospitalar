package br.com.senai.sistema_hospitalar.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.senai.sistema_hospitalar.entity.Especialidade;
import br.com.senai.sistema_hospitalar.exception.Response;
import br.com.senai.sistema_hospitalar.repository.EspecialidadeRepository;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/especialidades")
public class EspecialidadeController {
    @Autowired
    private EspecialidadeRepository repository;

    @PostMapping
    public Response cadastrarEspecialidade(@Valid @RequestBody Especialidade especialidade) {
        repository.save(especialidade);
        return new Response(201, "Especialidade cadastrada com sucesso!");
    }

    @GetMapping
    public List<Especialidade> getAllEspecialidades() {
        return repository.findAll();
    }

    @PutMapping("/{id}")
    public Response atualizarEspecialidade(@PathVariable Long id, @RequestBody Especialidade novo) {
        if (!repository.existsById(id)) {
            return new Response(404, "Especialidade não encontrada!");
        }

        Especialidade especialidade = repository.findById(id).get();

        if (novo.getNome() != null) {
            especialidade.setNome(novo.getNome());
        }

        if (novo.getDescricao() != null) {
            especialidade.setDescricao(novo.getDescricao());
        }

        repository.save(especialidade);

        return new Response(200, "Especialidade atualizada com sucesso!");
    }

    @DeleteMapping("/{id}")
    public Response deletarEspecialidade(@PathVariable Long id) {
        if (!repository.existsById(id)) {
            return new Response(404, "Especialidade não encontrada!");
        }
        repository.deleteById(id);
        return new Response(204, "Especialidade deletada com sucesso!");
    }
}
