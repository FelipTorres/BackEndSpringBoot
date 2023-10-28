package com.saude.FelipeTorres.Model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Paciente {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String nome;

    private String cpf;

    @OneToMany(mappedBy = "paciente")
    private List<Consulta> consulta;

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
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

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setConsulta(List<Consulta> consulta) {
        this.consulta = consulta;
    }
}
