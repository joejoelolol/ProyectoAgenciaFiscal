/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTOs;

import Entidades.Persona;
import Entidades.Placa;
import java.util.List;

/**
 *
 * @author joelr Clase DTO que representa los datos básicos de un automovil en
 * el sistema. Esta clase se utiliza para transportar información entre capas
 * (por ejemplo, de la capa de negocio a la capa de presentación) sin exponer
 * directamente la entidad de base de datos.
 *
 * Incluye numero de serie, marca, linea, color, modelo, el rfc de su dueño y su
 * id de su placa.
 *
 */
public class AutomovilDTO {

    private String numeroSerie;
    private String marca;
    private String linea;
    private String color;
    private String modelo;
    private Persona rfcDueno;
    private List<Placa> idPlacas;

    public AutomovilDTO() {
    }

    public AutomovilDTO(String numeroSerie, String marca, String linea, String color, String modelo, Persona rfcDueno, List<Placa> idPlacas) {
        this.numeroSerie = numeroSerie;
        this.marca = marca;
        this.linea = linea;
        this.color = color;
        this.modelo = modelo;
        this.rfcDueno = rfcDueno;
        this.idPlacas = idPlacas;
    }

    public String getNumeroSerie() {
        return numeroSerie;
    }

    public void setNumeroSerie(String numeroSerie) {
        this.numeroSerie = numeroSerie;
    }

    /**
     * Devuelve la marca del automóvil.
     */
    public String getMarca() {
        return marca;
    }

    /**
     * Establece la marca del automóvil.
     */
    public void setMarca(String marca) {
        this.marca = marca;
    }

    /**
     * Devuelve la línea del automóvil.
     */
    public String getLinea() {
        return linea;
    }

    /**
     * Establece la línea del automóvil.
     */
    public void setLinea(String linea) {
        this.linea = linea;
    }

    /**
     * Devuelve el color del automóvil.
     */
    public String getColor() {
        return color;
    }

    /**
     * Establece el color del automóvil.
     */
    public void setColor(String color) {
        this.color = color;
    }

    /**
     * Devuelve el modelo del automóvil.
     */
    public String getModelo() {
        return modelo;
    }

    /**
     * Establece el modelo del automóvil.
     */
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public Persona getRfcDueno() {
        return rfcDueno;
    }

    public void setRfcDueno(Persona rfcDueno) {
        this.rfcDueno = rfcDueno;
    }

    public List<Placa> getIdPlacas() {
        return idPlacas;
    }

    public void setIdPlacas(List<Placa> idPlacas) {
        this.idPlacas = idPlacas;
    }

    
}
