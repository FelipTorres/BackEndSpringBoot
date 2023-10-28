package com.saude.FelipeTorres.Model;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Consulta {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String convenio;

    private Date data;

    @ManyToOne
    @JoinColumn(name="medico_id", nullable = false)
    private Medico medico;

    @ManyToOne
    @JoinColumn(name = "paciente_id", nullable = false)
    private Paciente paciente;

    public int getId() {
        return id;
    }

    public Medico getMedico() {
        return medico;
    }

    public String getConvenio() {
        return convenio;
    }

    public Date getData() {
        return data;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public void setConvenio(String convenio) {
        this.convenio = convenio;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }
}
