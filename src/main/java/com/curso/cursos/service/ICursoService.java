package com.curso.cursos.service;

import java.util.List;
import com.curso.cursos.model.Curso;

public interface ICursoService {
  
  List<Curso> findAll();
  
  Curso findById(Long id);
  
  boolean addCurso(Curso curso);
  
  void updateCurso(String name ,Curso curso);
  
  void deleteCurso(String nombre);
  

}
