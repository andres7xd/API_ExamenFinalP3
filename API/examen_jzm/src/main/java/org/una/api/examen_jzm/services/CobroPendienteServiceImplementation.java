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
import org.una.api.examen_jzm.dto.CobroPendienteDTO;
import org.una.api.examen_jzm.entities.CobroPendiente;
import org.una.api.examen_jzm.repositories.ICobroPendienteRepository;
import org.una.api.examen_jzm.utils.Convertir;
import org.una.api.examen_jzm.utils.MapperUtils;

/**
 *
 * @author Andres
 */
@Service
public class CobroPendienteServiceImplementation implements ICobroPendienteService{
    @Autowired
    private ICobroPendienteRepository cobro_pendienteRepository;

    @Override
    @Transactional(readOnly = true)
    public Optional<List<CobroPendienteDTO>> findAll() {
         return  (Optional<List<CobroPendienteDTO>>) Convertir.findList(Optional.ofNullable(cobro_pendienteRepository.findAll()), CobroPendienteDTO.class);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<CobroPendienteDTO> findById(Long id) {
        return (Optional<CobroPendienteDTO>) Convertir.oneToDto(cobro_pendienteRepository.findById(id), CobroPendienteDTO.class);
    }
    @Override
    @Transactional
    public CobroPendienteDTO create(CobroPendienteDTO cobro_pendienteDTO) {
        CobroPendiente cobro_pendiente = MapperUtils.EntityFromDto(cobro_pendienteDTO, CobroPendiente.class);
        cobro_pendiente = cobro_pendienteRepository.save(cobro_pendiente);
        return MapperUtils.DtoFromEntity(cobro_pendiente, CobroPendienteDTO.class);
    }

    @Override
    @Transactional
    public Optional<CobroPendienteDTO> update(CobroPendienteDTO archivos_relacionadosDTO, Long id) {
        if (cobro_pendienteRepository.findById(id).isPresent()) {
            CobroPendiente cobro_pendiente = MapperUtils.EntityFromDto(archivos_relacionadosDTO, CobroPendiente.class);
            cobro_pendiente = cobro_pendienteRepository.save(cobro_pendiente);
            return Optional.ofNullable(MapperUtils.DtoFromEntity(cobro_pendiente, CobroPendienteDTO.class));
        } else {
            return null;
        }


    }

    @Override
    @Transactional
    public void delete(Long id) {

        cobro_pendienteRepository.deleteById(id);
    }

    @Override
    @Transactional
    public void deleteAll() {
        cobro_pendienteRepository.deleteAll();
    }
    
}
