package com.springedumanager.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springedumanager.model.Curso;
import com.springedumanager.service.CursoService;

@Controller
@RequestMapping("/cursos-web")
public class CursoWebController {

    private final CursoService cursoService;

    public CursoWebController(CursoService cursoService) {
        this.cursoService = cursoService;
    }

    @GetMapping
    public String mostrarCursos(Model model) {

        model.addAttribute("curso", new Curso());
        model.addAttribute("cursos", cursoService.listarCursos());

        return "cursos";
    }

    @PostMapping("/guardar")
    public String guardarCurso(@ModelAttribute Curso curso) {

        cursoService.guardarCurso(curso);

        return "redirect:/cursos-web";
    }
}