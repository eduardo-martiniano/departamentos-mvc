package com.departamentos.controllers;

import com.departamentos.domain.etities.Funcionario;
import com.departamentos.dtos.MensagemDto;
import com.departamentos.enums.Uf;
import com.departamentos.services.CargoService;
import com.departamentos.services.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/funcionarios")
public class FuncionarioController {

    @Autowired
    private FuncionarioService funcionarioService;

    @Autowired
    private CargoService cargoService;

    @GetMapping("/listar")
    public ModelAndView listar() {
        ModelAndView mv = new ModelAndView("/funcionario/lista");
        mv.addObject("funcionarios", funcionarioService.lista());
        mv.addObject("cargos", cargoService.lista());
        mv.addObject("ufs", Uf.values());
        return mv;
    }

    @GetMapping("/cadastrar")
    public ModelAndView cadastrar() {
        ModelAndView mv = new ModelAndView("/funcionario/cadastro");
        mv.addObject("funcionario", new Funcionario());
        mv.addObject("cargos", cargoService.lista());
        mv.addObject("ufs", Uf.values());
        return mv;
    }

    @PostMapping("/cadastrar")
    public ModelAndView cadastrar(Funcionario funcionario) {
        funcionarioService.salvar(funcionario);
        ModelAndView mv = new ModelAndView("/funcionario/cadastro");
        mv.addObject("funcionario", new Funcionario());
        mv.addObject("cargos", cargoService.lista());
        mv.addObject("ufs", Uf.values());
        mv.addObject("mensagem", new MensagemDto(true, "Cadastrado com sucesso!"));
        return mv;
    }

    @RequestMapping(value = "/excluir/{id}", method = RequestMethod.DELETE)
    public void excluir(@PathVariable("id") Long id) {
        funcionarioService.excluir(id);
    }
}
