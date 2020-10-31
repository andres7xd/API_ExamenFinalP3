/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.una.api.examen_jzm.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 *
 * @author Andres
 */
@Entity
@Table(name = "exa_jzm_membresias")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Membresia implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
      @Column(name = "Periosidad", length = 15)
    private String periosidad;
      
        @Column(name = "Monto")
    private double monto;
    
    @Column(name = "Descripcion", length = 50)
    private String descripcion;
    
    
    
    @Column(name = "fecha_inscripcion", updatable = false)
    @Temporal(TemporalType.DATE)
    @Setter(AccessLevel.NONE)
    private Date fecha_inscripcion;
}
