/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Conexion;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author joelr
 * Esta es la clase Conexion para conectarnos con la base de datos.
 */
public class Conexion {
     private static EntityManagerFactory em;

    public static EntityManager crearConexion() {
        if (em == null || !em.isOpen()) {
            em = Persistence.createEntityManagerFactory("Conexion");
        }

        return em.createEntityManager();
    }

    public static void cerrarConexion() {
        if (em != null || em.isOpen()) {
            em.close();
        }
    }
}
