/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.una.api.examen_jzm.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 *
 * @author Andres
 */
@Data
@AllArgsConstructor
@NoArgsConstructor 
@ToString
public class ClienteDTO {
     private Long id;
    private String nombre;
    private String cedula;
    private String direccion;
}
