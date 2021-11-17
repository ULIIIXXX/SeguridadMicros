package com.curso.cursos.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.curso.cursos.model.Curso;
import com.curso.cursos.service.ICursoService;

@RestController
public class CursosRestconteroller {
  
  @Autowired
  ICursoService cursoService;
  
  List<Curso> cursos = new ArrayList<>();
  
  @GetMapping(value = "/listar", produces = MediaType.APPLICATION_JSON_VALUE)
  private ResponseEntity<List<Curso>> listarCusros(){
    cursos = cursoService.findAll();
    return new ResponseEntity<>(cursos,HttpStatus.OK);
  }
  
  @GetMapping(value = "/listar/{nombre}", produces = MediaType.APPLICATION_JSON_VALUE)
  private ResponseEntity<Curso> listarCurso(@PathVariable String nombre){
    cursos = cursoService.findAll();
    Curso c = new Curso();
    for(Curso p : cursos) {
      if(p.getNombre().equalsIgnoreCase(nombre)){
        c = p;
      }
    }
    return new ResponseEntity<>(c,HttpStatus.OK);
  }
  
  @PostMapping(value = "/crear", produces =MediaType.APPLICATION_JSON_VALUE)
  private ResponseEntity<Curso> crearCurso(@RequestBody Curso curso){
    Curso c = new Curso();
    c.setNombre(curso.getNombre());
    c.setDuracion(curso.getDuracion());
    c.setTurno(curso.getTurno());
    cursoService.addCurso(c);
    return new ResponseEntity<>(c,HttpStatus.OK);
  }
  
  @PutMapping(value = "/update/{nombre}", produces = MediaType.APPLICATION_JSON_VALUE)
  private ResponseEntity<Curso> actualziarCurso(@PathVariable String nombre,
      @RequestBody Curso curso){
        cursoService.updateCurso(nombre,curso);     
    return new ResponseEntity<>(curso,HttpStatus.OK);
  }
  
  @DeleteMapping(value = "/eliminar/{nombre}")
  private ResponseEntity<String> eliminarCurso(@PathVariable("nombre") String nombre){
    //cursos.removeIf(c -> c.getNombre().equalsIgnoreCase(nombre));
    cursoService.deleteCurso(nombre);
    return new ResponseEntity<>("Eliminado",HttpStatus.OK);
  }

}
