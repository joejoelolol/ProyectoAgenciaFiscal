/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interfaces;

import Entidades.Licencia;
import Excepciones.PersistenciaException;
import java.util.List;

/**
 *
 * @author Tatzu
 */
public interface ILicenciaDAO {

    /**
     * Metodo para obtener una lista de personas.
     * @return Lista de personas.
     * @throws PersistenciaException
     */
    List<Licencia> obtenerLicencias() throws PersistenciaException;

    /**
     * Metodo para registrar una licencia en la base de datos.
     *
     * @return
     * @throws PersistenciaException
     */
    Licencia registrarLicencia(Licencia licencia) throws PersistenciaException;
    
}
