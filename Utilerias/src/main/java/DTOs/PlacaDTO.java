/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTOs;

import Entidades.Automovil;
import java.util.Date;

/**
 *
 * @author joelr Clase DTO que representa los datos básicos de las placas en el
 * sistema. Esta clase se utiliza para transportar información entre capas (por
 * ejemplo, de la capa de negocio a la capa de presentación) sin exponer
 * directamente la entidad de base de datos.
 *
 * Incluye el id de la placa, estado de la placa, tipo de auto, fecha de
 * recepción y fecha de emisión.
 *
 */
public class PlacaDTO {

    private String idPlaca;
    private String estado;
    private String tipoAuto;
    private Date fechaRecepcion;
    private Date fechaEmision;
    private Automovil numeroSerie;

    public PlacaDTO() {
    }

     public PlacaDTO(String idPlaca, String estado, String tipoAuto, Date fechaRecepcion, Date fechaEmision, Automovil numeroSerie) {
        this.idPlaca = idPlaca;
        this.estado = estado;
        this.tipoAuto = tipoAuto;
        this.fechaRecepcion = fechaRecepcion;
        this.fechaEmision = fechaEmision;
        this.numeroSerie = numeroSerie;
    }
    public PlacaDTO(String idPlaca, String estado, String tipoAuto, Date fechaEmision) {
        this.idPlaca = idPlaca;
        this.estado = estado;
        this.tipoAuto = tipoAuto;
        this.fechaEmision = fechaEmision;
    }
    public PlacaDTO(String estado, String tipoAuto, Date fechaEmision) {
        this.estado = estado;
        this.tipoAuto = tipoAuto;
        this.fechaEmision = fechaEmision;
    }
    public PlacaDTO(String tipoAuto, Date fechaRecepcion) {
        this.tipoAuto = tipoAuto;
    }
    public PlacaDTO(String tipoAuto,Automovil numeroSerie) {
        this.tipoAuto = tipoAuto;
    }
    public PlacaDTO(String tipoAuto) {
        this.tipoAuto = tipoAuto;
    }
    public PlacaDTO(String estado, String tipoAuto,Date fechaEmision, Date fechaRecepcion) {
        this.estado = estado;
        this.tipoAuto = tipoAuto;
        this.fechaRecepcion = fechaRecepcion;
        this.fechaEmision = fechaEmision;
    }

    public String getIdPlaca() {
        return idPlaca;
    }

    public void setIdPlaca(String idPlaca) {
        this.idPlaca = idPlaca;
    }

   

    /**
     * Devuelve el estado de la placa.
     */
    public String getEstado() {
        return estado;
    }

    /**
     * Establece el estado de la placa.
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }

    /**
     * Devuelve el tipo de automóvil asociado a la placa.
     */
    public String getTipoAuto() {
        return tipoAuto;
    }

    /**
     * Establece el tipo de automóvil asociado a la placa.
     */
    public void setTipoAuto(String tipoAuto) {
        this.tipoAuto = tipoAuto;
    }

    /**
     * Devuelve la fecha de recepción de la placa.
     */
    public Date getFechaRecepcion() {
        return fechaRecepcion;
    }

    /**
     * Establece la fecha de recepción de la placa.
     */
    public void setFechaRecepcion(Date fechaRecepcion) {
        this.fechaRecepcion = fechaRecepcion;
    }

    /**
     * Devuelve la fecha de emisión de la placa.
     */
    public Date getFechaEmision() {
        return fechaEmision;
    }

    /**
     * Establece la fecha de emisión de la placa.
     */
    public void setFechaEmision(Date fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

    public Automovil getNumeroSerie() {
        return numeroSerie;
    }

    public void setNumeroSerie(Automovil numeroSerie) {
        this.numeroSerie = numeroSerie;
    }
    
}
