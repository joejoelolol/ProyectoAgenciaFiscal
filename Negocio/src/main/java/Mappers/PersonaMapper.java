/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Mappers;

import DTOs.PersonaDTO;
import Entidades.Persona;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author joelr
 */
public class PersonaMapper {

    /**
     * Metodo para convertir una persona Entidad a una personaDTO.
     *
     * @param persona Entidad a convertir
     * @return PersonaDTO
     */
    public static PersonaDTO toDTO(Persona persona) {
        if (persona == null) {
            return null;
        }
        PersonaDTO dto = new PersonaDTO(persona.getRfc(),
                persona.getNombre(),
                persona.getApellidoPaterno(),
                persona.getApellidoMaterno(),
                persona.getTelefono(),
                persona.getFechaNacimiento(),
                persona.getLicencias(),
                persona.getAutomoviles());
        return dto;
    }

    /**
     * Metodo para convertir un PersonaDTO a un Persona Entidad.
     *
     * @param dto PersonaDTO a convertir.
     * @return Persona Entidad
     */
    public static Persona toEntity(PersonaDTO dto) {
        if (dto == null) {
            return null;
        }
        if (dto.getRfc() == null) {
            Persona persona = new Persona(dto.getNombre(), dto.getApellidoPaterno(), dto.getApellidoMaterno(),
                    dto.getTelefono(), dto.getFechaNacimiento(), dto.getLicencias(), dto.getAutomoviles());
            return persona;
        } else {
            Persona persona = new Persona(dto.getRfc(), dto.getNombre(), dto.getApellidoPaterno(), dto.getApellidoMaterno(),
                    dto.getTelefono(), dto.getFechaNacimiento(), dto.getLicencias(), dto.getAutomoviles());
            return persona;
        }

    }

    public static List<PersonaDTO> EntityListToDto(List<Persona> Entidades) {
        List<PersonaDTO> lista = new ArrayList<>();
        for (int i = 0; i < Entidades.size(); i++) {
            PersonaDTO personaDTO = new PersonaDTO();
            personaDTO = new PersonaDTO(
                    personaDTO.getRfc(),
                    personaDTO.getNombre(),
                    personaDTO.getApellidoPaterno(),
                    personaDTO.getApellidoMaterno(),
                    personaDTO.getTelefono(),
                    personaDTO.getFechaNacimiento(),
                    personaDTO.getLicencias(),
                    personaDTO.getAutomoviles());
            lista.add(personaDTO);
        }
        return lista;
    }

    public static List<Persona> DTOListToEntity(List<PersonaDTO> Dtos) {
        List<Persona> lista = new ArrayList<>();
        for (int i = 0; i < Dtos.size(); i++) {
            Persona persona = new Persona();
            persona = new Persona(
                    persona.getRfc(),
                    persona.getNombre(),
                    persona.getApellidoPaterno(),
                    persona.getApellidoMaterno(),
                    persona.getTelefono(),
                    persona.getFechaNacimiento(),
                    persona.getLicencias(),
                    persona.getAutomoviles());
            lista.add(persona);
        }
        return lista;
    }
}
