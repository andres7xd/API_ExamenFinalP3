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
import org.una.api.examen_jzm.dto.ClienteDTO;
import org.una.api.examen_jzm.entities.Cliente;
import org.una.api.examen_jzm.repositories.IClienteRepository;
import org.una.api.examen_jzm.utils.Convertir;
import org.una.api.examen_jzm.utils.MapperUtils;

/**
 *
 * @author Andres
 */
@Service
public class ClienteServiceImplementation implements IClienteService{
    
    @Autowired
    private IClienteRepository clienteRepository;

    @Override
    @Transactional(readOnly = true)
    public Optional<List<ClienteDTO>> findAll() {
         return  (Optional<List<ClienteDTO>>) Convertir.findList(Optional.ofNullable(clienteRepository.findAll()), ClienteDTO.class);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<ClienteDTO> findById(Long id) {
        return (Optional<ClienteDTO>) Convertir.oneToDto(clienteRepository.findById(id), ClienteDTO.class);
    }
    @Override
    @Transactional
    public ClienteDTO create(ClienteDTO clienteDTO) {
        Cliente cliente = MapperUtils.EntityFromDto(clienteDTO, Cliente.class);
        cliente = clienteRepository.save(cliente);
        return MapperUtils.DtoFromEntity(cliente, ClienteDTO.class);
    }

    @Override
    @Transactional
    public Optional<ClienteDTO> update(ClienteDTO archivos_relacionadosDTO, Long id) {
        if (clienteRepository.findById(id).isPresent()) {
            Cliente cliente = MapperUtils.EntityFromDto(archivos_relacionadosDTO, Cliente.class);
            cliente = clienteRepository.save(cliente);
            return Optional.ofNullable(MapperUtils.DtoFromEntity(cliente, ClienteDTO.class));
        } else {
            return null;
        }


    }

    @Override
    @Transactional
    public void delete(Long id) {

        clienteRepository.deleteById(id);
    }

    @Override
    @Transactional
    public void deleteAll() {
        clienteRepository.deleteAll();
    }
}
