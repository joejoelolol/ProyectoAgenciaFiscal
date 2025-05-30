/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interfaces;

import DTOs.AutomovilDTO;
import Excepciones.NegocioException;
import java.util.List;

/**
 *
 * @author Tatzu
 */
public interface IAutomovilBO {

    /**
     * Método que obtiene la lista de automóviles de la base de datos.
     *
     * @return Lista de AutomovilDTO
     * @throws NegocioException si ocurre un error de negocio o de persistencia
     */
    List<AutomovilDTO> obtenerAutomoviles() throws NegocioException;

    /**
     * Método que registra un nuevo automóvil en la base de datos.
     *
     * @param automovilDTO datos del automóvil a registrar
     * @return true si el automóvil se registró correctamente
     * @throws NegocioException si ocurre un error al registrar
     */
    boolean registrarAutomovil(AutomovilDTO automovilDTO) throws NegocioException;
    
}
