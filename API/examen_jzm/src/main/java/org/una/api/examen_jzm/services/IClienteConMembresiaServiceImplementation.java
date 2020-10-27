/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.una.api.examen_jzm.services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.una.api.examen_jzm.dto.ClienteConMembresiaDTO;
import org.una.api.examen_jzm.entities.ClienteConMembresia;
import org.una.api.examen_jzm.repositories.IClienteConMembresiaRepository;
import org.una.api.examen_jzm.utils.Convertir;
import org.una.api.examen_jzm.utils.MapperUtils;

/**
 *
 * @author Andres
 */
@Service
public class IClienteConMembresiaServiceImplementation implements IClienteConMembresiaService {
    @Autowired
    private IClienteConMembresiaRepository cliente_con_membresiaRepository;

    @Override
    @Transactional(readOnly = true)
    public Optional<List<ClienteConMembresiaDTO>> findAll() {
         return  (Optional<List<ClienteConMembresiaDTO>>) Convertir.findList(Optional.ofNullable(cliente_con_membresiaRepository.findAll()), ClienteConMembresiaDTO.class);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<ClienteConMembresiaDTO> findById(Long id) {
        return (Optional<ClienteConMembresiaDTO>) Convertir.oneToDto(cliente_con_membresiaRepository.findById(id), ClienteConMembresiaDTO.class);
    }
    @Override
    @Transactional
    public ClienteConMembresiaDTO create(ClienteConMembresiaDTO cliente_con_membresiaDTO) {
        ClienteConMembresia cliente_con_membresia = MapperUtils.EntityFromDto(cliente_con_membresiaDTO, ClienteConMembresia.class);
        cliente_con_membresia = cliente_con_membresiaRepository.save(cliente_con_membresia);
        return MapperUtils.DtoFromEntity(cliente_con_membresia, ClienteConMembresiaDTO.class);
    }

    @Override
    @Transactional
    public Optional<ClienteConMembresiaDTO> update(ClienteConMembresiaDTO archivos_relacionadosDTO, Long id) {
        if (cliente_con_membresiaRepository.findById(id).isPresent()) {
            ClienteConMembresia cliente_con_membresia = MapperUtils.EntityFromDto(archivos_relacionadosDTO, ClienteConMembresia.class);
            cliente_con_membresia = cliente_con_membresiaRepository.save(cliente_con_membresia);
            return Optional.ofNullable(MapperUtils.DtoFromEntity(cliente_con_membresia, ClienteConMembresiaDTO.class));
        } else {
            return null;
        }


    }

    @Override
    @Transactional
    public void delete(Long id) {

        cliente_con_membresiaRepository.deleteById(id);
    }

    @Override
    @Transactional
    public void deleteAll() {
        cliente_con_membresiaRepository.deleteAll();
    }
}
