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

import br.com.senai.sistema_hospitalar.entity.Paciente;
import br.com.senai.sistema_hospitalar.exception.Response;
import br.com.senai.sistema_hospitalar.repository.PacienteRepository;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {
    @Autowired
    private PacienteRepository repository;

    @PostMapping
    public Response cadastrarPaciente(@Valid @RequestBody Paciente paciente) {

        boolean cpfJaExiste = repository.existsByCpf(paciente.getCpf());

        if (cpfJaExiste) {
            return new Response(409, "Já existe um paciente cadastrado com este Cpf!");
        }

        repository.save(paciente);
        return new Response(201, "Paciente cadastrado(a) com sucesso!");
    }

    @GetMapping
    public List<Paciente> getAllPacientes() {
        return repository.findAll();
    }

    @PutMapping("/{id}")
    public Response atualizarPaciente(@PathVariable Long id, @RequestBody Paciente novo) {
        if (!repository.existsById(id)) {
            return new Response(404, "Paciente não encontrado(a)!");
        }

        Paciente paciente = repository.findById(id).get();

        if (novo.getNome() != null) {
            paciente.setNome(novo.getNome());
        }
        if (novo.getCpf() != null) {
            paciente.setCpf(novo.getNome());
        }
        if (novo.getDataNascimento() != null) {
            paciente.setDataNascimento(novo.getDataNascimento());
        }

        repository.save(paciente);

        return new Response(200, "Paciente atualizado(a) com sucesso!");
    }

    @DeleteMapping("/{id}")
    public Response deletarPaciente(@PathVariable Long id) {
        if (!repository.existsById(id)) {
            return new Response(404, "Paciente não encontrado(a)!");
        }
        repository.deleteById(id);
        return new Response(204, "Paciente deletado(a) com sucesso!");
    }
}
