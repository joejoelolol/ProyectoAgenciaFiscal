/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interfaces;

import DTOs.PersonaDTO;
import Excepciones.NegocioException;
import java.util.List;

/**
 *
 * @author Tatzu
 */
public interface IPersonaBO {
     public List<PersonaDTO> obtenerPersonas() throws NegocioException;
    public boolean registrarPersona(PersonaDTO personaDTO) throws NegocioException;
    public PersonaDTO obtenerPersonaPorRFC(String rfc) throws NegocioException;
}
