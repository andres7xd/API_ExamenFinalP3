/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.una.api.examen_jzm.services;

import java.util.List;
import java.util.Optional;
import org.una.api.examen_jzm.dto.ClienteConMembresiaDTO;

/**
 *
 * @author Andres
 */
public interface IClienteConMembresiaService {
      public Optional<List<ClienteConMembresiaDTO>> findAll();

    public Optional<ClienteConMembresiaDTO> findById(Long id);

    public ClienteConMembresiaDTO create(ClienteConMembresiaDTO cliente_con_membresiaDTO);

    public Optional<ClienteConMembresiaDTO> update(ClienteConMembresiaDTO cliente_con_membresiaDTO, Long id);

    public void delete(Long id);

    public void deleteAll();
}
