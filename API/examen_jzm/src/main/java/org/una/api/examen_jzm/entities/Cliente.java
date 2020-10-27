/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.una.api.examen_jzm.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 *
 * @author Andres
 */
@Entity
@Table(name = "exa_jzm_clientes")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Cliente implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "Nombre", length = 50)
    private String nombre;
    
    @Column(name = "Cedula", length = 15)
    private String cedula;
    
     @Column(name = "Direccion", length = 200)
    private String direccion;
    
}
