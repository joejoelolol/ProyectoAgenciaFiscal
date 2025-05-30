/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

import java.util.Date;
import javax.persistence.*;

/**
 *
 * @author joelr 
 * Entidad Licencia. 
 * Representa la tabla licencia en la base de datos.
 */
@Entity
public class Licencia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idLicencia;
    @Column
    private String tipoLicencia;
    @Column
    private double costo;
    @Column
    private Date fechaInicio;
    @Column
    private Date fechaFin;

    @ManyToOne
    @JoinColumn(name = "RFC_dueño")
    private Persona dueno;

    public Licencia() {
    }

    public Licencia(Long idLicencia, String tipoLicencia, double costo, Persona dueno) {
        this.idLicencia = idLicencia;
        this.tipoLicencia = tipoLicencia;
        this.costo = costo;
        this.dueno = dueno;
    }
    public Licencia(String tipoLicencia, double costo, Persona dueno) {
        this.tipoLicencia = tipoLicencia;
        this.costo = costo;
        this.dueno = dueno;
    }

    public Long getIdLicencia() {
        return idLicencia;
    }

    public void setIdLicencia(Long idLicencia) {
        this.idLicencia = idLicencia;
    }

    public String getTipoLicencia() {
        return tipoLicencia;
    }

    public void setTipoLicencia(String tipoLicencia) {
        this.tipoLicencia = tipoLicencia;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    public Persona getDueno() {
        return dueno;
    }

    public void setDueno(Persona dueno) {
        this.dueno = dueno;
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
