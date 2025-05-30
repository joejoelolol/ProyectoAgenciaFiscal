/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interfaces;

import Entidades.Persona;
import Excepciones.PersistenciaException;
import java.util.List;

/**
 *
 * @author joelr
 */
public interface IPersonaDAO {

    /**
     * Metodo para registrar una persona en la base de datos.
     *
     * @param persona
     * @return
     * @throws PersistenciaException
     */
    Persona registrarPersona(Persona persona) throws PersistenciaException;

    public List<Persona> obtenerPersonas() throws PersistenciaException;

    public String encriptarTelefono(String telefono) throws Exception;

    public String desencriptarTelefono(String telefono) throws Exception;

    public Persona obtenerPersonaPorRfc(String rfc) throws PersistenciaException;
}
