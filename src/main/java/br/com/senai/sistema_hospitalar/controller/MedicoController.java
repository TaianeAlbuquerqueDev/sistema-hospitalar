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

import br.com.senai.sistema_hospitalar.entity.Medico;
import br.com.senai.sistema_hospitalar.exception.Response;
import br.com.senai.sistema_hospitalar.repository.MedicoRepository;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/medicos")
public class MedicoController {
    @Autowired
    private MedicoRepository repository;

    @PostMapping
    public Response cadastrarMedico(@Valid @RequestBody Medico medico) {

        boolean crmJaExiste = repository.existsByCrm(medico.getCrm());

        if (crmJaExiste) {
            return new Response(409, "Já existe um(a) medico(a) cadastrado com este CRM!");
        }

        repository.save(medico);
        return new Response(201, "Medico(a) cadastrado(a) com sucesso!");
    }

    @GetMapping
    public List<Medico> getAllMedicos() {
        return repository.findAll();
    }

    @PutMapping("/{id}")
    public Response atualizarMedico(@PathVariable Long id, @RequestBody Medico novo) {
        if (!repository.existsById(id)) {
            return new Response(404, "Medico(a) não encontrado(a)!");
        }

        Medico medico = repository.findById(id).get();

        if (novo.getNome() != null) {
            medico.setNome(novo.getNome());
        }
        if (novo.getCrm() != null) {
            medico.setCrm(novo.getCrm());
        }

        repository.save(medico);

        return new Response(200, "Medico(a) atualizado(a) com sucesso!");
    }

    @DeleteMapping("/{id}")
    public Response deletarMedico(@PathVariable Long id) {
        if (!repository.existsById(id)) {
            return new Response(404, "Medico(a) não encontrado(a)!");
        }
        repository.deleteById(id);
        return new Response(204, "Medico(a) deletado(a) com sucesso!");
    }
}
