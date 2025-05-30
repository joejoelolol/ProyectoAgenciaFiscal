/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.persistencia;

import DAO.AutomovilDAO;
import DAO.LicenciaDAO;
import DAO.PersonaDAO;
import DAO.PlacaDAO;
import Entidades.Automovil;
import Entidades.Licencia;
import Entidades.Persona;
import Entidades.Placa;
import Excepciones.PersistenciaException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author joelr
 */
public class Persistencia {

    public static void main(String[] args) throws PersistenciaException {
        //Pruebas persona
//        PersonaDAO personad = new PersonaDAO();
        Date fechaHoy = new Date();
//        List<Automovil> autos = new ArrayList<>();
//        List<Licencia> licencias = new ArrayList<>();
//        Persona persona = new Persona("b","Joses","c","d","63311122",fechaHoy,licencias,autos);
//        personad.registrarPersona(persona);
//        System.out.println(personad.obtenerPersonaPorRfc("b").getRfc()); 
//        
//        Pruebas placa
        PlacaDAO placad = new PlacaDAO();
        Placa placa = new Placa("Habilitada","Nuevo",fechaHoy);
//        List<Placa> placas= placad.obtenerPlacasPorID("LZU-591");
//        System.out.println(placas.get(0));
        placad.ActualizarEstado("safalo");

//        placad.registrarPlaca(placa);
//        System.out.println(placad.obtenerPlacaPorID(placa.getIdPlaca()).getIdPlaca());
        //Pruebas licencia
//        Licencia licencia = new Licencia("3 años",1200.0,personad.obtenerClientes().get(0));
//        licencia.setFechaInicio(fechaHoy);
//        LicenciaDAO l = new LicenciaDAO();
////        l.registrarLicencia(licencia);
//        System.out.println(l.obtenerLicencias().get(0).getIdLicencia());

        //Pruebas Automoviles
//        AutomovilDAO autod = new AutomovilDAO();
//        List<Placa> placas = new ArrayList<>();
//        Automovil auto = new Automovil("SAD22","Rojo","Cadillac","Ford","2A",personad.obtenerPersonas().get(0));
////        autod.registrarLicencia(auto);
//        System.out.println(autod.obtenerAutomoviles().get(0).getNumeroSerie());
    }
}
