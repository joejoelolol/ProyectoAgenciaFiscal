/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interfaces;

import DTOs.LicenciaDTO;
import Excepciones.NegocioException;
import java.util.List;

/**
 *
 * @author Tatzu
 */
public interface ILicenciaBO {

    /**
     * Obtiene la lista de licencias desde la base de datos.
     *
     * @return lista de LicenciaDTO
     * @throws NegocioException si ocurre un error de negocio o persistencia
     */
    List<LicenciaDTO> obtenerLicencias() throws NegocioException;

    /**
     * Registra una nueva licencia en la base de datos.
     *
     * @param licenciaDTO objeto LicenciaDTO a registrar
     * @return true si se registró correctamente
     * @throws NegocioException si ocurre un error durante el registro
     */
    boolean registrarLicencia(LicenciaDTO licenciaDTO) throws NegocioException;
    
}
