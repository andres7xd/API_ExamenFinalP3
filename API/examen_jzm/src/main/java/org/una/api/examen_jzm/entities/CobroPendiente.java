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
@Table(name = "exa_jzm_cobros_pendientes")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CobroPendiente implements Serializable{
     
    @ManyToOne
    @JoinColumn(name = "membresia_id")
    private Membresia membresia_id;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "año")
    private int año;
    
    @Column(name = "periodo")
    private int periodo;
    
     @Column(name = "tipo_de_servicio", length = 15)
    private String tipo_de_servicio;
    
    @Column(name = "fecha_vencimiento", updatable = false)
    @Temporal(TemporalType.DATE)
    @Setter(AccessLevel.NONE)
    private Date fecha_vencimiento;
      
     @Column(name = "monto")
    private double monto;
    
}
