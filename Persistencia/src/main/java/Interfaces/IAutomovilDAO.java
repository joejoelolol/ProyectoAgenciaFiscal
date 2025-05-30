/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interfaces;

import Entidades.Automovil;
import Excepciones.PersistenciaException;
import java.util.List;

/**
 *
 * @author joelr
 */
public interface IAutomovilDAO {

    /**
     * Metodo para obtener la lista de licencias.
     * @return Lista de licencias.
     * @throws PersistenciaException
     */
    List<Automovil> obtenerAutomoviles() throws PersistenciaException;

    /**
     * Metodo para registrar un automovil en la base de datos.
     *
     * @param automovil
     * @return
     * @throws PersistenciaException
     */
    Automovil registrarAutomovil(Automovil automovil) throws PersistenciaException;
    
}
