package com.springedumanager.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springedumanager.model.Estudiante;
import com.springedumanager.service.EstudianteService;

@Controller
@RequestMapping("/estudiantes-web")
public class EstudianteWebController {

    private final EstudianteService estudianteService;

    public EstudianteWebController(EstudianteService estudianteService) {
        this.estudianteService = estudianteService;
    }

    @GetMapping
    public String mostrarEstudiantes(Model model) {

        model.addAttribute("estudiante", new Estudiante());
        model.addAttribute("estudiantes", estudianteService.listarEstudiantes());

        return "estudiantes";
    }

    @PostMapping("/guardar")
    public String guardarEstudiante(@ModelAttribute Estudiante estudiante) {

        estudianteService.guardarEstudiante(estudiante);

        return "redirect:/estudiantes-web";
    }
}