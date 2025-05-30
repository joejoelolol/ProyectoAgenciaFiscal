/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Interfaces.ILicenciaDAO;
import Conexion.Conexion;
import Entidades.Licencia;
import Excepciones.PersistenciaException;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author joelr
 */
public class LicenciaDAO implements ILicenciaDAO{

    private static LicenciaDAO instanceLicenciaDAO;

    public LicenciaDAO() {
    }

    public static LicenciaDAO getInstance() {
        if (instanceLicenciaDAO == null) {
            instanceLicenciaDAO = new LicenciaDAO();
        }
        return instanceLicenciaDAO;
    }

    /**
     * Metodo para registrar una licencia en la base de datos.
     *
     * @return
     * @throws PersistenciaException
     */
    @Override
    public Licencia registrarLicencia(Licencia licencia) throws PersistenciaException {
        if (licencia == null) {
            throw new PersistenciaException("La licencia esta vacia");
        }
        EntityManager em = Conexion.crearConexion();
        try {
            Date fechaHoy = new Date();
            em.getTransaction().begin();
            em.persist(licencia);
            em.getTransaction().commit();
            return licencia;
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw new PersistenciaException("Error: No se pudo registrar la licencia");
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
    public List<Licencia> obtenerLicencias() throws PersistenciaException {
        EntityManager em = Conexion.crearConexion();
        try {
            em.getTransaction().begin();
            List<Licencia> resultados = em.createQuery(
                    "SELECT l FROM Licencia l",
                    Licencia.class
            ).getResultList();
            
            return resultados;

        } catch (Exception e) {
            throw new PersistenciaException("No se pudieron obtener las licencias.");
        } finally {
            em.close();
        }
    }
}
