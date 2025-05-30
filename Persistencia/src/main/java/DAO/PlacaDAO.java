/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Interfaces.IPlacaDAO;
import Conexion.Conexion;
import Entidades.Placa;
import Excepciones.PersistenciaException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;
import javax.persistence.EntityManager;

/**
 *
 * @author joelr
 */
public class PlacaDAO implements IPlacaDAO {

    private static PlacaDAO instancePlacaDAO;

    public PlacaDAO() {
    }

    public static PlacaDAO getInstance() {
        if (instancePlacaDAO == null) {
            instancePlacaDAO = new PlacaDAO();
        }
        return instancePlacaDAO;
    }

    /**
     * Metodo para registrar una placa en la base de datos.
     *
     * @param placa
     * @return
     * @throws PersistenciaException
     */
    @Override
    public Placa registrarPlaca(Placa placa) throws PersistenciaException {
        if (placa == null) {
            throw new PersistenciaException("La placa esta vacia");
        }
        EntityManager em = Conexion.crearConexion();
        try {
            if (placa.getIdPlaca() == null) {

            }

            Date fechaHoy = new Date();
            placa.setIdPlaca(this.generarNumeroPlaca());
            placa.setFechaRecepcion(fechaHoy);
            placa.setEstado("Habilitada");
            em.getTransaction().begin();
            em.persist(placa);
            em.getTransaction().commit();
            return placa;
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw new PersistenciaException("Error: No se pudo registrar la placa");
        } finally {
            em.close();
        }
    }

    /**
     * Metodo para obtener placas mediante su id.
     *
     * @param id
     * @throws Excepciones.PersistenciaException
     */
    @Override
    public Placa obtenerPlacaPorID(String id) throws PersistenciaException {
        EntityManager em = Conexion.crearConexion();
        if (id == null) {
            throw new PersistenciaException("El id es nulo");
        }
        try {
            em.getTransaction().begin();
            Placa placa = em.createQuery("SELECT p FROM Placa p WHERE p.idPlaca = :id", Placa.class)
                    .setParameter("id", id)
                    .getSingleResult();
            return placa;
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw new PersistenciaException("No se pudo obtener la placa" + id);
        } finally {
            em.close();
        }
    }

    /**
     * Metodo para obtener placas mediante su id.
     *
     * @param id
     * @throws Excepciones.PersistenciaException
     */
    @Override
    public List<Placa> obtenerPlacasPorID(String id) throws PersistenciaException {
        EntityManager em = Conexion.crearConexion();
        if (id == null) {
            throw new PersistenciaException("El id es nulo");
        }
        try {
            em.getTransaction().begin();
            List<Placa> placa = em.createQuery("SELECT p FROM Placa p WHERE p.numeroSerie = :id", Placa.class)
                    .setParameter("id", id)
                    .getResultList();
            return placa;
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw new PersistenciaException("No se pudo obtener la placa" + id);
        } finally {
            em.close();
        }
    }

    /**
     * Metodo para actualizar el estado de la placa cuando se soliciten placas
     * nuevas de un automovil ya registrado.
     *
     */
    @Override
    public Placa ActualizarEstado(String serieAutomovil) throws PersistenciaException {
        EntityManager em = Conexion.crearConexion();
        if (serieAutomovil == null) {
            throw new PersistenciaException("id vacio");
        }
        try {
            Placa placa = new Placa();
            Date fecha = new Date(); // fecha actual
            List<Placa> placas = this.obtenerPlacasPorID(serieAutomovil);
//            for (int i = 0; i < placas.size(); i++) {
//                if (placas.get(i).getEstado().equalsIgnoreCase("Habilitado")
//                        && placas.get(i).getFechaEmision() == null) {
//                    placa = placas.get(i);
//                    placa.setEstado("Deshabilitado");
//                    placa.setFechaEmision(fecha);
//                }
//            }
//            em.getTransaction().begin();
//            em.merge(placa);
//            em.getTransaction().commit();
//            em.close();
            return placa;
        } catch (PersistenciaException pe) {
            em.getTransaction().rollback();
            throw new PersistenciaException("No se pudo actualizar la placa");
        } finally {
            em.close();
        }

    }

    /**
     * Método para obtener una lista de placas desde la base de datos.
     *
     * @return Lista de placas.
     * @throws PersistenciaException si ocurre un error durante la transacción.
     */
    @Override
    public List<Placa> obtenerPlacas() throws PersistenciaException {
        EntityManager em = Conexion.crearConexion();
        try {
            em.getTransaction().begin();
            List<Placa> resultados = em.createQuery(
                    "SELECT p FROM Placa p",
                    Placa.class
            ).getResultList();
            em.getTransaction().commit();
            return resultados;

        } catch (Exception e) {
            throw new PersistenciaException("No se pudieron obtener los datos de las placas.", e);
        } finally {
            em.close();
        }
    }

    /**
     * Genera un número de placa con el formato 3 letras + guión + 3 dígitos,
     * por ejemplo "ABC-123".
     *
     * @return Placa alfanumérica válida
     */
    @Override
    public String generarNumeroPlaca() {
        String letras = generarLetrasPlaca(3);
        String digitos = String.format("%03d", new Random().nextInt(1000));
        return letras + "-" + digitos;
    }

    /**
     * Genera una cadena de letras aleatorias en mayúsculas.
     *
     * @param cantidad número de letras a generar
     * @return cadena de letras aleatorias
     */
    private String generarLetrasPlaca(int cantidad) {
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < cantidad; i++) {
            char letra = (char) ('A' + random.nextInt(26));
            sb.append(letra);
        }
        return sb.toString();
    }

}
