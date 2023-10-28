package com.saude.FelipeTorres.Controller;

import com.saude.FelipeTorres.Model.Especialidade;
import com.saude.FelipeTorres.Service.ServiceEspecialidade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/especialidades")
public class ControllerEspecialidade {

    @Autowired
    private ServiceEspecialidade serviceEspecialidade;

    @GetMapping(value = "")
    public String listAll(Model model)
    {
        model.addAttribute("especialidades", serviceEspecialidade.listAll());

        return "especialidades/especialidade";
    }

    @GetMapping(value = "/nova-especialidade")
    public String novoEspecialidade(Model model)
    {
        model.addAttribute("especialidade", new Especialidade());

        return "especialidades/nova-especialidade";
    }

    @PostMapping(value = "/salvarEspecialidade")
    public String salvarEspecialidade(@ModelAttribute Especialidade especialidade)
    {
        serviceEspecialidade.salvarEspecialidade(especialidade);

        return "redirect:/especialidades";
    }

        @GetMapping(value = "/excluir/{id}")
    public String excluirEspecialidade(@PathVariable("id") int id)
    {
        Optional<Especialidade> especialidade = serviceEspecialidade.getEspecialidade(id);

        serviceEspecialidade.excluirEspecialidade(especialidade.get());

        return "redirect:/especialidades";
    }

    @GetMapping(value = "/editar/{id}")
    public String editarEspecialidade(@PathVariable("id") int id, Model model)
    {
        Optional<Especialidade> especialidade = serviceEspecialidade.getEspecialidade(id);

        model.addAttribute("especialidade", especialidade.get());

        return "especialidades/nova-especialidade";
    }
}
