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
import org.una.api.examen_jzm.dto.MembresiaDTO;
import org.una.api.examen_jzm.entities.Membresia;
import org.una.api.examen_jzm.repositories.IMembresiaRepository;
import org.una.api.examen_jzm.utils.Convertir;
import org.una.api.examen_jzm.utils.MapperUtils;

/**
 *
 * @author Andres
 */
@Service
public class IMembresiaServiceImplementation implements IMembresiaService{
    @Autowired
    private IMembresiaRepository membresiaRepository;

    @Override
    @Transactional(readOnly = true)
    public Optional<List<MembresiaDTO>> findAll() {
         return  (Optional<List<MembresiaDTO>>) Convertir.findList(Optional.ofNullable(membresiaRepository.findAll()), MembresiaDTO.class);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<MembresiaDTO> findById(Long id) {
        return (Optional<MembresiaDTO>) Convertir.oneToDto(membresiaRepository.findById(id), MembresiaDTO.class);
    }
    @Override
    @Transactional
    public MembresiaDTO create(MembresiaDTO membresiaDTO) {
        Membresia membresia = MapperUtils.EntityFromDto(membresiaDTO, Membresia.class);
        membresia = membresiaRepository.save(membresia);
        return MapperUtils.DtoFromEntity(membresia, MembresiaDTO.class);
    }

    @Override
    @Transactional
    public Optional<MembresiaDTO> update(MembresiaDTO archivos_relacionadosDTO, Long id) {
        if (membresiaRepository.findById(id).isPresent()) {
            Membresia membresia = MapperUtils.EntityFromDto(archivos_relacionadosDTO, Membresia.class);
            membresia = membresiaRepository.save(membresia);
            return Optional.ofNullable(MapperUtils.DtoFromEntity(membresia, MembresiaDTO.class));
        } else {
            return null;
        }


    }

    @Override
    @Transactional
    public void delete(Long id) {

        membresiaRepository.deleteById(id);
    }

    @Override
    @Transactional
    public void deleteAll() {
        membresiaRepository.deleteAll();
    }
}
