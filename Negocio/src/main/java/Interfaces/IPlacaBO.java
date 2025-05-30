/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interfaces;

import DTOs.PlacaDTO;
import Excepciones.NegocioException;
import java.util.List;

/**
 *
 * @author Tatzu
 */
public interface IPlacaBO {

    /**
     * Obtiene todas las placas desde la base de datos.
     *
     * @return lista de PlacaDTO
     * @throws NegocioException si ocurre un error de negocio o persistencia
     */
    List<PlacaDTO> obtenerPlacas() throws NegocioException;

    /**
     * Registra una nueva placa en la base de datos.
     *
     * @param placaDTO objeto PlacaDTO a registrar
     * @return true si se registró correctamente
     * @throws NegocioException si ocurre un error de negocio o persistencia
     */
    boolean registrarPlaca(PlacaDTO placaDTO) throws NegocioException;
public boolean actualizarPlaca(String serie) throws NegocioException;
}
