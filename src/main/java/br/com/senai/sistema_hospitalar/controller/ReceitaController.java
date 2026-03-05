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

import br.com.senai.sistema_hospitalar.entity.Receita;
import br.com.senai.sistema_hospitalar.exception.Response;
import br.com.senai.sistema_hospitalar.repository.ReceitaRepository;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/receitas")
public class ReceitaController {
    @Autowired
    private ReceitaRepository repository;

    @PostMapping
    public Response cadastrarReceita(@Valid @RequestBody Receita receita) {
        repository.save(receita);
        return new Response(201, "Receita cadastrada com sucesso!");
    }

    @GetMapping
    public List<Receita> getAllReceitas() {
        return repository.findAll();
    }

    @PutMapping("/{id}")
    public Response atualizarReceita(@PathVariable Long id, @RequestBody Receita novo) {
        if (!repository.existsById(id)) {
            return new Response(404, "Receita não encontrada!");
        }

        Receita receita = repository.findById(id).get();

        if (novo.getDataEmissao() != null) {
            receita.setDataEmissao(novo.getDataEmissao());
        }

        if (novo.getDescricaoMedicamento() != null) {
            receita.setDescricaoMedicamento(novo.getDescricaoMedicamento());
        }

        repository.save(receita);

        return new Response(200, "Receita atualizada com sucesso!");
    }

    @DeleteMapping("/{id}")
    public Response deletarReceita(@PathVariable Long id) {
        if (!repository.existsById(id)) {
            return new Response(404, "Receita não encontrada!");
        }
        repository.deleteById(id);
        return new Response(204, "Receita deletada com sucesso!");
    }
}
