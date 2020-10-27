/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.una.api.examen_jzm.services;

import java.util.List;
import java.util.Optional;
import org.una.api.examen_jzm.dto.MembresiaDTO;

/**
 *
 * @author Andres
 */
public interface IMembresiaService {

    public Optional<List<MembresiaDTO>> findAll();

    public Optional<MembresiaDTO> findById(Long id);

    public MembresiaDTO create(MembresiaDTO membresiaDTO);

    public Optional<MembresiaDTO> update(MembresiaDTO membresiaDTO, Long id);

    public void delete(Long id);

    public void deleteAll();
}
