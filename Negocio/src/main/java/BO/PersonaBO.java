/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BO;

import DTOs.PersonaDTO;
import Entidades.Persona;
import Excepciones.NegocioException;
import Excepciones.PersistenciaException;
import Interfaces.IPersonaBO;
import Interfaces.IPersonaDAO;
import Mappers.PersonaMapper;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author joelr
 */
public class PersonaBO implements IPersonaBO{
    private IPersonaDAO personaDAO;

    public PersonaBO() {
        this.personaDAO = DAO.PersonaDAO.getInstance();
    }

    public PersonaBO(IPersonaDAO personaDAO) {
        this.personaDAO = personaDAO;
    }
    @Override
    public List<PersonaDTO> obtenerPersonas() throws NegocioException {
        try {
            List<Persona> listaPersonas = personaDAO.obtenerPersonas();
            if (listaPersonas == null || listaPersonas.isEmpty()) {
                throw new NegocioException("La lista de personas es nula o vacia");
            }
            List<PersonaDTO> listaDTOs = PersonaMapper.EntityListToDto(listaPersonas);
            return listaDTOs;
        } catch (PersistenciaException e) {
            throw new NegocioException("No se pudieron obtener las personas", e);
        }
    }
    @Override
    public PersonaDTO obtenerPersonaPorRFC(String rfc) throws NegocioException {
        try {
            Persona Persona = personaDAO.obtenerPersonaPorRfc(rfc);
            if (Persona == null) {
                throw new NegocioException("La persona esta vacia");
            }
            PersonaDTO DTO = PersonaMapper.toDTO(Persona);
            return DTO;
        } catch (PersistenciaException e) {
            throw new NegocioException("No se encontro a la persona", e);
        }
    }
    
    /**
     * Metodo que invoca el metodo de PersonaDAO para registrar una persona en
     * la BD.
     *
     * @param personaDTO
     * @return
     * @throws NegocioException
     */
    @Override
    public boolean registrarPersona(PersonaDTO personaDTO) throws NegocioException {
        try {
            Persona persona = PersonaMapper.toEntity(personaDTO);
            personaDAO.registrarPersona(persona);
            System.out.println("Persona registrada con exito");
            return true;
        } catch (PersistenciaException pe) {
            throw new NegocioException("Error al registrar la persona");
        }
    }
    

    
}
