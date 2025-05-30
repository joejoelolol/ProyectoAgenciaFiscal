/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Interfaces.IAutomovilDAO;
import Conexion.Conexion;
import Entidades.Automovil;
import Excepciones.PersistenciaException;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author joelr
 */
public class AutomovilDAO implements IAutomovilDAO {

    private static AutomovilDAO instanceAutomovilDAO;

    public AutomovilDAO() {
    }

    public static AutomovilDAO getInstance() {
        if (instanceAutomovilDAO == null) {
            instanceAutomovilDAO = new AutomovilDAO();
        }
        return instanceAutomovilDAO;
    }

    /**
     * Metodo para registrar un automovil en la base de datos.
     *
     * @param automovil
     * @return
     * @throws PersistenciaException
     */
    @Override
    public Automovil registrarAutomovil(Automovil automovil) throws PersistenciaException {
        if (automovil == null) {
            throw new PersistenciaException("El automovil esta vacio");
        }
        EntityManager em = Conexion.crearConexion();
        try {
            em.getTransaction().begin();
            em.persist(automovil);
            em.getTransaction().commit();
            return automovil;
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw new PersistenciaException("Error: No se pudo registrar el automovil");
        } finally {
            em.close();
        }
    }

    /**
     * Metodo para obtener la lista de licencias.
     *
     * @return Lista de licencias.
     * @throws PersistenciaException
     */
    @Override
    public List<Automovil> obtenerAutomoviles() throws PersistenciaException {
        EntityManager em = Conexion.crearConexion();
        try {
            em.getTransaction().begin();
            List<Automovil> resultados = em.createQuery(
                    "SELECT a FROM Automovil a",
                    Automovil.class
            ).getResultList();

            return resultados;

        } catch (Exception e) {
            throw new PersistenciaException("No se pudieron obtener los automoviles.");
        } finally {
            em.close();
        }
    }
}
