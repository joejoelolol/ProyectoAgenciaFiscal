/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.negocio;

import BO.PersonaBO;
import DTOs.PersonaDTO;
import Entidades.Persona;
import Excepciones.NegocioException;
import Mappers.PersonaMapper;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author joelr
 */
public class Negocio {

    public static void main(String[] args) throws NegocioException {
        PersonaBO persona = new PersonaBO();
        PersonaDTO personas = new PersonaDTO();
        Persona personase = new Persona();
        PersonaMapper.toDTO(personase);
        System.out.println(persona.obtenerPersonaPorRFC("b").getRfc());
 }
}
