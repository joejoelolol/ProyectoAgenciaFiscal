/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interfaces;

import Entidades.Placa;
import Excepciones.PersistenciaException;
import java.util.List;

/**
 *
 * @author joelr
 */
public interface IPlacaDAO {

    /**
     * Metodo para actualizar el estado de la placa cuando se soliciten placas
     * nuevas de un automovil ya registrado.
     *
     * @param placa
     * @return 
     * @throws Excepciones.PersistenciaException
     */
    public Placa ActualizarEstado(String serieAutomovil) throws PersistenciaException;

    /**
     * Genera un número de placa con el formato 3 letras + guión + 3 dígitos,
     * por ejemplo "ABC-123".
     *
     * @return Placa alfanumérica válida
     */
    String generarNumeroPlaca();

    /**
     * Metodo para obtener placas mediante su id.
     *
     * @param id
     * @throws Excepciones.PersistenciaException
     */
    Placa obtenerPlacaPorID(String id) throws PersistenciaException;

    /**
     * Metodo para registrar una placa en la base de datos.
     *
     * @param placa
     * @return
     * @throws PersistenciaException
     */
    Placa registrarPlaca(Placa placa) throws PersistenciaException;
    
    public List<Placa> obtenerPlacas() throws PersistenciaException;
    public List<Placa> obtenerPlacasPorID(String id) throws PersistenciaException;
}
