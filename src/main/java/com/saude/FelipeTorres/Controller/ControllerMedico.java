package com.saude.FelipeTorres.Controller;

import com.saude.FelipeTorres.Model.Medico;
import com.saude.FelipeTorres.Service.ServiceEspecialidade;
import com.saude.FelipeTorres.Service.ServiceMedico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/medicos")
public class ControllerMedico {

    @Autowired
    private ServiceMedico serviceMedico;

    @Autowired
    private ServiceEspecialidade serviceEspecialidade;

    @GetMapping(value = "")
    public String listAll(Model model)
    {
        model.addAttribute("medicos", serviceMedico.listAll());

        return "medicos/medico";
    }

    @GetMapping(value = "/novo-medico")
    public String novoMedico(Model model)
    {
        model.addAttribute("especialidades", serviceEspecialidade.listAll());

        model.addAttribute("medico", new Medico());

        return "medicos/novo-medico";
    }

    @PostMapping(value = "/salvarMedico")
    public String salvarMedico(@ModelAttribute Medico medico)
    {
        serviceMedico.salvarMedico(medico);

        return "redirect:/medicos";
    }

    @GetMapping(value = "/excluir/{id}")
    public String excluirMedico(@PathVariable("id") int id)
    {
        Optional<Medico> medico = serviceMedico.getMedico(id);

        serviceMedico.excluirMedico(medico.get());

        return "redirect:/medicos";
    }

    @GetMapping(value = "/editar/{id}")
    public String editarMedico(@PathVariable("id") int id, Model model)
    {
        model.addAttribute("especialidades", serviceEspecialidade.listAll());

        Optional<Medico> medico = serviceMedico.getMedico(id);

        model.addAttribute("medico", medico.get());

        return "medicos/novo-medico";
    }
}
