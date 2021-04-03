package com.departamentos.controllers;

import com.departamentos.domain.etities.Departamento;
import com.departamentos.dtos.MensagemDto;
import com.departamentos.services.DepartamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
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
        departamentoService.salvar(departamento);
        mv.addObject("departamento", new Departamento());
        mv.addObject("mensagem", new MensagemDto(true, "Cadastrado com sucesso!"));
        return mv;
    }

    @GetMapping("/listar")
    public ModelAndView listar() {
        ModelAndView mv = new ModelAndView("/departamento/lista");
        mv.addObject("departamentos", departamentoService.lista());
        return mv;
    }

    @RequestMapping(value = "/excluir/{id}", method = RequestMethod.DELETE)
    public void excluir(@PathVariable("id") Long id) {
        departamentoService.excluir(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ModelAndView editar(@PathVariable("id") Long id, Departamento departamento){
        departamentoService.editar(departamento);
        ModelAndView mv = new ModelAndView("/departamento/lista");
        mv.addObject("departamentos", departamentoService.lista());
        return mv;
    }
}
