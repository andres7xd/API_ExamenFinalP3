/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.una.api.examen_jzm.controllers;

import java.util.Optional;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.una.api.examen_jzm.dto.ClienteDTO;
import org.una.api.examen_jzm.services.IClienteService;

/**
 *
 * @author Andres
 */
@RestController
@RequestMapping("/exa_jzm_clientes")
public class ClienteController {
    
     final String MENSAJE_VERIFICAR_INFORMACION = "Debe verifiar el formato y la información de su solicitud con el formato esperado";

    @Autowired
    private IClienteService clienteService;

    @GetMapping()
    @CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST})
    public @ResponseBody
    ResponseEntity<?> findAll() {
        try {
            return new ResponseEntity<>(clienteService.findAll(), HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    @CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST})
    public ResponseEntity<?> findById(@PathVariable(value = "id") Long id) {
        try {
            return new ResponseEntity(clienteService.findById(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/")
    @ResponseBody
    @CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST})
    
    public ResponseEntity<?> create(@Valid @RequestBody ClienteDTO clienteDTO, BindingResult bindingResult) {
        if (!bindingResult.hasErrors()) {
            try {
                return new ResponseEntity(clienteService.create(clienteDTO), HttpStatus.CREATED);
            } catch (Exception e) {
                return new ResponseEntity(e, HttpStatus.INTERNAL_SERVER_ERROR);
            }
        } else {
            return new ResponseEntity(MENSAJE_VERIFICAR_INFORMACION, HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/{id}")
    @ResponseBody
    @CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST})
    
   
    public ResponseEntity<?> update(@PathVariable(value = "id") Long id, @Valid @RequestBody ClienteDTO clienteDTO, BindingResult bindingResult) {
        if (!bindingResult.hasErrors()) {
            try {
                Optional<ClienteDTO> clienteUpdated = clienteService.update(clienteDTO, id);
                if (clienteUpdated.isPresent()) {
                    return new ResponseEntity(clienteUpdated, HttpStatus.OK);
                } else {
                    return new ResponseEntity(HttpStatus.NOT_FOUND);
                }
            } catch (Exception e) {
                return new ResponseEntity(e, HttpStatus.INTERNAL_SERVER_ERROR);
            }
        } else {
            return new ResponseEntity(MENSAJE_VERIFICAR_INFORMACION, HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{id}")
    @CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST})
    public ResponseEntity<?> delete(@PathVariable(value = "id") Long id) {
        try {
            clienteService.delete(id);
            return new ResponseEntity(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/")
    @CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST})
    public ResponseEntity<?> deleteAll() {
        try {
            clienteService.deleteAll();
            return new ResponseEntity(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
