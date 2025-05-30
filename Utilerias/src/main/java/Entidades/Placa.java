/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

import java.util.Date;
import javax.persistence.*;

/**
 *
 * @author joelr Entidad Placa. Representa la tabla placa en la base de datos.
 */
@Entity
public class Placa {

    @Id
    private String idPlaca;
    @Column
    private String estado;
    @Column
    private String tipoAuto;

    @Temporal(TemporalType.DATE)
    private Date fechaRecepcion;

    @Temporal(TemporalType.DATE)
    private Date fechaEmision;

    @ManyToOne
    @JoinColumn(name = "numeroSerie")
    private Automovil numeroSerie;

    public Placa() {
    }

    public Placa(String idPlaca, String estado, String tipoAuto, Date fechaRecepcion, Date fechaEmision,Automovil numeroSerie) {
        this.idPlaca = idPlaca;
        this.estado = estado;
        this.tipoAuto = tipoAuto;
        this.fechaRecepcion = fechaRecepcion;
        this.fechaEmision = fechaEmision;
        this.numeroSerie = numeroSerie;
    }

    public Placa(String idPlaca, String estado, String tipoAuto, Date fechaEmision) {
        this.idPlaca = idPlaca;
        this.estado = estado;
        this.tipoAuto = tipoAuto;
        this.fechaEmision = fechaEmision;
    }

    public Placa(String estado, String tipoAuto, Date fechaEmision) {
        this.estado = estado;
        this.tipoAuto = tipoAuto;
        this.fechaEmision = fechaEmision;
    }

    public Placa(String estado, String tipoAuto, Date fechaEmision, Date fechaRecepcion) {
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

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getTipoAuto() {
        return tipoAuto;
    }

    public void setTipoAuto(String tipoAuto) {
        this.tipoAuto = tipoAuto;
    }

    public Date getFechaRecepcion() {
        return fechaRecepcion;
    }

    public void setFechaRecepcion(Date fechaRecepcion) {
        this.fechaRecepcion = fechaRecepcion;
    }

    public Date getFechaEmision() {
        return fechaEmision;
    }

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
