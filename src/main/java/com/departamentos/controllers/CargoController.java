package com.departamentos.controllers;

import com.departamentos.domain.etities.Cargo;
import com.departamentos.domain.etities.Departamento;
import com.departamentos.dtos.MensagemDto;
import com.departamentos.services.CargoService;
import com.departamentos.services.DepartamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RestController
@RequestMapping("/cargos")
public class CargoController {

    @Autowired
    private DepartamentoService departamentoService;

    @Autowired
    private CargoService cargoService;

    @GetMapping("/cadastrar")
    public ModelAndView cadastrar() {
        ModelAndView mv = new ModelAndView("/cargo/cadastro");
        mv.addObject("departamentos", departamentoService.lista());
        mv.addObject("cargo", new Cargo());
        return mv;
    }

    @PostMapping("/cadastrar")
    public ModelAndView cadastrar(Cargo cargo) {
        cargoService.salvar(cargo);
        ModelAndView mv = new ModelAndView("/cargo/cadastro");
        mv.addObject("departamentos", departamentoService.lista());
        mv.addObject("cargo", new Cargo());
        mv.addObject("mensagem", new MensagemDto(true, "Cargo cadastrado com sucesso!"));
        return mv;
    }

    @GetMapping("/listar")
    public ModelAndView listar() {
        ModelAndView mv = new ModelAndView("/cargo/lista");
        mv.addObject("departamentos", departamentoService.lista());
        mv.addObject("cargos", cargoService.lista());
        return mv;
    }

    @RequestMapping(value = "/excluir/{id}", method = RequestMethod.DELETE)
    public void excluir(@PathVariable("id") Long id) {
        cargoService.excluir(id);
    }

    @RequestMapping(value = "/editar", method = RequestMethod.POST)
    public ModelAndView editar(Cargo cargo){
        cargoService.editar(cargo);
        ModelAndView mv = new ModelAndView("/cargo/lista");
        mv.addObject("departamentos", departamentoService.lista());
        mv.addObject("cargos", cargoService.lista());
        return mv;
    }
}
