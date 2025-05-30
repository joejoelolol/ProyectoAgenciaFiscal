/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Interfaces.IPersonaDAO;
import Conexion.Conexion;
import Encriptador.Encriptador;
import Entidades.Persona;
import Excepciones.PersistenciaException;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author joelr
 */
public class PersonaDAO implements IPersonaDAO {

    private static PersonaDAO instancePersonaDAO;

    public PersonaDAO() {
    }

    public static PersonaDAO getInstance() {
        if (instancePersonaDAO == null) {
            instancePersonaDAO = new PersonaDAO();
        }
        return instancePersonaDAO;
    }

    /**
     * Metodo para registrar una persona en la base de datos.
     *
     * @param persona
     * @return
     * @throws PersistenciaException
     */
    @Override
    public Persona registrarPersona(Persona persona) throws PersistenciaException {
        if (persona == null) {
            throw new PersistenciaException("La persona esta vacia");
        }
        EntityManager em = Conexion.crearConexion();

        try {
//            Encripta telefono.
            persona.setTelefono(this.encriptarTelefono(persona.getTelefono()));
            em.getTransaction().begin();
            em.persist(persona);
            em.getTransaction().commit();
            return persona;
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw new PersistenciaException("Error: No se pudo registrar la persona");
        } finally {
            em.close();
        }
    }
     /**
     * Metodo para obtener una lista de personas.
     * @return Lista de personas.
     * @throws PersistenciaException 
     */
    public List<Persona> obtenerPersonas() throws PersistenciaException {
        EntityManager em = Conexion.crearConexion();
        try {
            em.getTransaction().begin();
            List<Persona> resultados = em.createQuery(
                    "SELECT p FROM Persona p",
                    Persona.class
            ).getResultList();
            
            em.getTransaction().commit();
            for (int i = 0; i < resultados.size(); i++) {
                resultados.get(i).setTelefono(this.desencriptarTelefono(resultados.get(i).getTelefono()));
            }
            return resultados;

        } catch (Exception e) {
            throw new PersistenciaException("No se pudieron obtener los datos de las personas.");
        } finally {
            em.close();
        }
    }
     /**
     * Metodo para obtener una lista de personas.
     * @return Lista de personas.
     * @throws PersistenciaException 
     */
    @Override
    public Persona obtenerPersonaPorRfc(String rfc) throws PersistenciaException {
        EntityManager em = Conexion.crearConexion();
        try {
            em.getTransaction().begin();
            Persona resultado = em.createQuery(
                    "SELECT p FROM Persona p WHERE p.rfc = :rfc",
                    Persona.class
            ).setParameter("rfc", rfc).getSingleResult();
            
            em.getTransaction().commit();
            return resultado;

        } catch (Exception e) {
            throw new PersistenciaException("No se pudieron obtener los datos de la persona.");
        } finally {
            em.close();
        }
    }

    /**
     * Metodo para encriptar el telefono.
     *
     * @param telefono
     * @return
     * @throws Exception
     */
    @Override
    public String encriptarTelefono(String telefono) throws Exception {
        try {
            telefono = Encriptador.encriptar(telefono);
            return telefono;
        } catch (Exception ex) {
            throw new Exception("Error al encriptar el telefono");
        }
    }

    /**
     * Metodo para desencriptar el telefono.
     *
     * @param telefono
     * @return
     * @throws Exception
     */
    @Override
    public String desencriptarTelefono(String telefono) throws Exception {
        try {
            telefono = Encriptador.desencriptar(telefono);
            return telefono;
        } catch (Exception ex) {
            throw new Exception("Error al desencriptar el telefono");
        }
    }
}
