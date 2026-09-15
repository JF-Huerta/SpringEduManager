package com.springedumanager.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.springedumanager.model.Curso;
import com.springedumanager.repository.CursoRepository;

@Service
public class CursoService {

    private final CursoRepository cursoRepository;

    public CursoService(CursoRepository cursoRepository) {
        this.cursoRepository = cursoRepository;
    }

    public List<Curso> listarCursos() {
        return cursoRepository.findAll();
    }

    public Curso guardarCurso(Curso curso) {
        return cursoRepository.save(curso);
    }

    public Curso buscarPorId(Long id) {
        return cursoRepository.findById(id).orElse(null);
    }

    public Curso actualizarCurso(Long id, Curso cursoActualizado) {
        Curso cursoExistente = cursoRepository.findById(id).orElse(null);

        if (cursoExistente != null) {
            cursoExistente.setNombre(cursoActualizado.getNombre());
            cursoExistente.setDescripcion(cursoActualizado.getDescripcion());

            return cursoRepository.save(cursoExistente);
        }

        return null;
    }

    public void eliminarCurso(Long id) {
        cursoRepository.deleteById(id);
    }
}