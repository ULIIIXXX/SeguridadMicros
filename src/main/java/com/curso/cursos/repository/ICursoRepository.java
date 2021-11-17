package com.curso.cursos.repository;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import com.curso.cursos.model.Curso;

public interface ICursoRepository extends CrudRepository<Curso, Long>{
  
  List<Curso> findByNombre(String nombre);
  
  List<Curso> findByTurno(String turno);

}
