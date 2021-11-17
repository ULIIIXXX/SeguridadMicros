package com.curso.cursos.service.impl;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.curso.cursos.model.Curso;
import com.curso.cursos.repository.ICursoRepository;
import com.curso.cursos.service.ICursoService;

@Service
public class ICursoServiceImpl implements ICursoService{

  @Autowired
  ICursoRepository cursoRepository;
  
  @Override
  public List<Curso> findAll() {
    List<Curso> cursos = new ArrayList<>();
    cursoRepository.findAll().forEach(c -> cursos.add(c));
    return cursos;
  }

  @Override
  public Curso findById(Long id) {
    return cursoRepository.findById(id).orElse(null);
  }

  @Override
  public boolean addCurso(Curso curso) {
    List<Curso> cursos = cursoRepository.findByNombre(curso.getNombre());
    if(cursos.contains(cursos)) {
      return false;
    }else {
      cursoRepository.save(curso);
      return true;
    }
  }

  @Override
  public void updateCurso(String name ,Curso curso) {
    List<Curso> cursos = new ArrayList<>();
    cursoRepository.findAll().forEach(c -> cursos.add(c));
    for(Curso cc : cursos) {
      if(cc.getNombre().contains(name)) {
          cc.setNombre(curso.getNombre());
          cc.setTurno(curso.getTurno());
          cc.setDuracion(curso.getDuracion());
          cursoRepository.save(cc);
      }
    }
    
    
  }

  @Override
  public void deleteCurso(String nombre) {
    List<Curso> cursos = new ArrayList<>();
    cursoRepository.findAll().forEach(c -> cursos.add(c));
    for(Curso cu : cursos) {
      if(cu.getNombre().equalsIgnoreCase(nombre)) {
        cursoRepository.delete(findById(cu.getId()));
      }
    }
  }

}
