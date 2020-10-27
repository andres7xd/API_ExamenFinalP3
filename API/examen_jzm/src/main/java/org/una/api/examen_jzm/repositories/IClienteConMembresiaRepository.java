/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.una.api.examen_jzm.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.una.api.examen_jzm.entities.ClienteConMembresia;

/**
 *
 * @author Andres
 */
public interface IClienteConMembresiaRepository extends JpaRepository<ClienteConMembresia, Long> {
    
}
