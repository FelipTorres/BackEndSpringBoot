package com.saude.FelipeTorres.Controller;

import com.saude.FelipeTorres.Model.Paciente;
import com.saude.FelipeTorres.Service.ServicePaciente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/pacientes")
public class ControllerPaciente {

    @Autowired
    private ServicePaciente servicePaciente;

    @GetMapping(value = "")
    public String listAll(Model model)
    {
        model.addAttribute("pacientes", servicePaciente.listAll());

        return "pacientes/paciente";
    }

    @GetMapping(value = "/novo-paciente")
    public String novoPaciente(Model model)
    {
        model.addAttribute("paciente", new Paciente());

        return "pacientes/novo-paciente";
    }

    @PostMapping(value = "/salvarPaciente")
    public String salvarPaciente(@ModelAttribute Paciente paciente)
    {
        servicePaciente.salvarPaciente(paciente);

        return "redirect:/pacientes";
    }

    @GetMapping(value = "/excluir/{id}")
    public String excluirPaciente(@PathVariable("id") int id)
    {
        Optional<Paciente> paciente = servicePaciente.getPaciente(id);

        servicePaciente.excluirPaciente(paciente.get());

        return "redirect:/pacientes";
    }

    @GetMapping(value = "/editar/{id}")
    public String editarPaciente(@PathVariable("id") int id, Model model)
    {
        Optional<Paciente> paciente = servicePaciente.getPaciente(id);

        model.addAttribute("paciente", paciente.get());

        return "pacientes/novo-paciente";
    }
}
