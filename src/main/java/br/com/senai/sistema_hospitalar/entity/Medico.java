package br.com.senai.sistema_hospitalar.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
public class Medico {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank(message = "É necessário informar um nome!")
    @Size(min = 3, max = 80, message = "Mínimo de 3 e máximo de 80 caracteres para o nome!")
    private String nome;

    @NotBlank(message = "É necessário informar o CRM!")
    @Size(min = 12, max = 12, message = "Informe 12 caracteres para o CRM!")
    @Column(unique = true)
    private String crm;

    @OneToMany(mappedBy = "medico")
    @JsonIgnore
    private List<Consulta> consultas;

    @ManyToOne
    @JoinColumn(name = "fk_especialidade")
    private Especialidade especialidade;

    @OneToMany(mappedBy = "medico")
    @JsonIgnore
    private List<Receita> receitas;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCrm() {
        return crm;
    }

    public void setCrm(String crm) {
        this.crm = crm;
    }

    public List<Consulta> getConsultas() {
        return consultas;
    }

    public void setConsultas(List<Consulta> consultas) {
        this.consultas = consultas;
    }

    public Especialidade getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(Especialidade especialidade) {
        this.especialidade = especialidade;
    }

    public List<Receita> getReceitas() {
        return receitas;
    }

    public void setReceitas(List<Receita> receitas) {
        this.receitas = receitas;
    }

}
