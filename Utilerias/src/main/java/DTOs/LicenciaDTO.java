/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTOs;

import Entidades.Persona;
import java.util.Date;
import javax.persistence.Column;

/**
 *
 * @author joelr Clase DTO que representa los datos básicos de las licencias en
 * el sistema. Esta clase se utiliza para transportar información entre capas
 * (por ejemplo, de la capa de negocio a la capa de presentación) sin exponer
 * directamente la entidad de base de datos.
 *
 * Incluye el id de licencia, tipo de licencia, costo, las fechas de inicio y expiración y el rfc del dueño.
 *
 */
public class LicenciaDTO {

    private Long idLicencia;
    private String tipoLicencia;
    private double costo;
    private Persona rfcDueno;
    private Date fechaInicio;
    private Date fechaFin;
    public LicenciaDTO() {
    }

    public LicenciaDTO(Long idLicencia, String tipoLicencia, double costo, Persona rfcDueno, Date fechaInicio, Date fechaFin) {
        this.idLicencia = idLicencia;
        this.tipoLicencia = tipoLicencia;
        this.costo = costo;
        this.rfcDueno = rfcDueno;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
    }
    public LicenciaDTO( String tipoLicencia, double costo, Persona rfcDueno, Date fechaInicio, Date fechaFin) {
        this.tipoLicencia = tipoLicencia;
        this.costo = costo;
        this.rfcDueno = rfcDueno;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
    }

    /**
     * Devuelve el ID de la licencia.
     */
    public Long getIdLicencia() {
        return idLicencia;
    }

    /**
     * Establece el ID de la licencia.
     */
    public void setIdLicencia(Long idLicencia) {
        this.idLicencia = idLicencia;
    }

    /**
     * Devuelve el tipo de licencia.
     */
    public String getTipoLicencia() {
        return tipoLicencia;
    }

    /**
     * Establece el tipo de licencia.
     */
    public void setTipoLicencia(String tipoLicencia) {
        this.tipoLicencia = tipoLicencia;
    }

    /**
     * Devuelve el costo de la licencia.
     */
    public double getCosto() {
        return costo;
    }

    /**
     * Establece el costo de la licencia.
     */
    public void setCosto(double costo) {
        this.costo = costo;
    }

    public Persona getRfcDueno() {
        return rfcDueno;
    }

    public void setRfcDueno(Persona rfcDueno) {
        this.rfcDueno = rfcDueno;
    }

    

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }
    
}
