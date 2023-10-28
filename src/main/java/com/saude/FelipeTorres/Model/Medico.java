package com.saude.FelipeTorres.Model;

import net.bytebuddy.implementation.bind.annotation.IgnoreForBinding;

import javax.persistence.*;
import java.util.List;

@Entity
public class Medico {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String nome;

    private int crm;

    @ManyToOne
    @JoinColumn(name="especialidade_id", nullable = false)
    private Especialidade especialidade;

    @OneToMany(mappedBy = "medico")
    private List<Consulta> consulta;

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public int getCrm() {
        return crm;
    }

    public Especialidade getEspecialidade() {
        return especialidade;
    }

    public List<Consulta> getConsulta() {
        return consulta;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCrm(int crm) {
        this.crm = crm;
    }

    public void setEspecialidade(Especialidade especialidade) {
        this.especialidade = especialidade;
    }

    public void setConsulta(List<Consulta> consulta) {
        this.consulta = consulta;
    }
}
