package com.springedumanager.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.springedumanager.model.Estudiante;
import com.springedumanager.repository.EstudianteRepository;

@Service
public class EstudianteService {

    private final EstudianteRepository estudianteRepository;

    public EstudianteService(EstudianteRepository estudianteRepository) {
        this.estudianteRepository = estudianteRepository;
    }

    public List<Estudiante> listarEstudiantes() {
        return estudianteRepository.findAll();
    }

    public Estudiante guardarEstudiante(Estudiante estudiante) {
        return estudianteRepository.save(estudiante);
    }

    public Estudiante buscarPorId(Long id) {
        return estudianteRepository.findById(id).orElse(null);
    }

    public Estudiante actualizarEstudiante(Long id, Estudiante estudiante) {

        Estudiante estudianteExistente = buscarPorId(id);

        if (estudianteExistente != null) {
            estudianteExistente.setNombre(estudiante.getNombre());
            estudianteExistente.setEmail(estudiante.getEmail());

            return estudianteRepository.save(estudianteExistente);
        }

        return null;
    }

    public void eliminarEstudiante(Long id) {
        estudianteRepository.deleteById(id);
    }
}