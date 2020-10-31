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

/**
 *
 * @author Andres
 */
@Data
@AllArgsConstructor
@NoArgsConstructor 
@ToString
public class CobroPendienteDTO {
     private Long id;
    private int año;
    private int periodo;
    private Date fecha_vencimiento;
    private double monto;
    private String tipo_de_servicio;
    private MembresiaDTO membresia_id;
}
