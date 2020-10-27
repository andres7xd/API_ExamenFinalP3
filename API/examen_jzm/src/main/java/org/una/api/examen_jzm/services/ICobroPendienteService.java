/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.una.api.examen_jzm.services;

import java.util.List;
import java.util.Optional;
import org.una.api.examen_jzm.dto.CobroPendienteDTO;

/**
 *
 * @author Andres
 */
public interface ICobroPendienteService {
    
       public Optional<List<CobroPendienteDTO>> findAll();

    public Optional<CobroPendienteDTO> findById(Long id);

    public CobroPendienteDTO create(CobroPendienteDTO cobro_pendienteDTO);

    public Optional<CobroPendienteDTO> update(CobroPendienteDTO cobro_pendienteDTO, Long id);

    public void delete(Long id);

    public void deleteAll();
}
