/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.una.api.examen_jzm.dto;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.una.api.examen_jzm.entities.CobroPendiente;

/**
 *
 * @author Andres
 */
@Data
@AllArgsConstructor
@NoArgsConstructor 
@ToString
public class MembresiaDTO {
    private String periosidad;
    private double monto;
    private String descripcion;
    private Date fecha_inscripcion;
    
}
