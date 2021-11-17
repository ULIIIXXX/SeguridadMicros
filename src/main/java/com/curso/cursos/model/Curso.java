package com.curso.cursos.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@XmlRootElement //Para trnasformar clasea a XML
@Entity
@Table(name = "cursos")
public class Curso implements Serializable{

  
  /**
   * 
   */
  private static final long serialVersionUID = 1L;
  
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "id_curso")
  private Long id;
  
  @Column(name = "nombre")
  private String nombre;
  
  @Column(name = "turno")
  private String turno;
  
  @Column(name = "duracion")
  private Integer duracion;
 
  
}
