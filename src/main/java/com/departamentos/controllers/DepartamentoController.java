package com.departamentos.controllers;

import com.departamentos.domain.etities.Departamento;
import com.departamentos.dtos.MensagemDto;
import com.departamentos.services.DepartamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/departamentos")
public class DepartamentoController {

    @Autowired
    private DepartamentoService departamentoService;

    @GetMapping("/cadastrar")
    public ModelAndView cadastrar() {
        ModelAndView mv = new ModelAndView("/departamento/cadastro");
        mv.addObject("departamento", new Departamento());
        return mv;
    }

    @PostMapping("/cadastrar")
    public ModelAndView cadastrar(Departamento departamento) {
        ModelAndView mv = new ModelAndView("/departamento/cadastro");
        mv.addObject("departamento", departamentoService.salvar(departamento));
        mv.addObject("mensagem", new MensagemDto(true, "Cadastrado com sucesso!"));
        return mv;
    }

    @GetMapping("/listar")
    public ModelAndView listar() {
        ModelAndView mv = new ModelAndView("/templates/departamento/lista");
        return mv;
    }
}
