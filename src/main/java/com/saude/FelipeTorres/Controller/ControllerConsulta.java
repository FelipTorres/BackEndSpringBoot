package com.saude.FelipeTorres.Controller;

import com.saude.FelipeTorres.Model.Consulta;
import com.saude.FelipeTorres.Service.ServiceConsulta;
import com.saude.FelipeTorres.Service.ServiceMedico;
import com.saude.FelipeTorres.Service.ServicePaciente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/consultas")
public class ControllerConsulta {

    @Autowired
    private ServiceConsulta serviceConsulta;

    @Autowired
    private ServiceMedico serviceMedico;

    @Autowired
    private ServicePaciente servicePaciente;

    @GetMapping(value = "")
    public String listAll(Model model)
    {
        model.addAttribute("consultas", serviceConsulta.listAll());

        return "consultas/consulta";
    }

    @GetMapping(value = "/nova-consulta")
    public String novoConsulta(Model model)
    {
        model.addAttribute("pacientes", servicePaciente.listAll());

        model.addAttribute("medicos", serviceMedico.listAll());

        model.addAttribute("consultas", new Consulta());

        return "consultas/nova-consulta";
    }

    @PostMapping(value = "/salvarConsulta")
    public String salvarConsulta(@ModelAttribute Consulta consulta)
    {
        serviceConsulta.salvarConsulta(consulta);

        return "redirect:/consulta";
    }

    @GetMapping(value = "/excluir/{id}")
    public String excluirConsulta(@PathVariable("id") int id)
    {
        Optional<Consulta> consulta = serviceConsulta.getConsulta(id);

        serviceConsulta.excluirConsulta(consulta.get());

        return "redirect:/consulta";
    }

    @GetMapping(value = "/editar/{id}")
    public String editarConsulta(@PathVariable("id") int id, Model model)
    {
        Optional<Consulta> consulta = serviceConsulta.getConsulta(id);

        model.addAttribute("consulta", consulta.get());

        return "consultas/nova-consulta";
    }
}
