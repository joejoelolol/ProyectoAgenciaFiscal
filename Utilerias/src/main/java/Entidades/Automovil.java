/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

import java.util.List;
import javax.persistence.*;

/**
 *
 * @author joelr 
 * Entidad Automovil. 
 * Representa la tabla automovil en la base de datos.
 */
@Entity
public class Automovil {

    @Id
    private String numeroSerie;
    @Column
    private String marca;
    @Column
    private String linea;
    @Column
    private String color;
    @Column
    private String modelo;

    @ManyToOne
    @JoinColumn(name = "RFC_dueño")
    private Persona dueno;

    @OneToMany(mappedBy = "numeroSerie", cascade = CascadeType.ALL)
    @JoinColumn(name = "id_Placa")
    private List<Placa> placas;

    public Automovil() {
    }

    public Automovil(String numeroSerie, String marca, String linea, String color, String modelo, Persona dueno, List<Placa> placas) {
        this.numeroSerie = numeroSerie;
        this.marca = marca;
        this.linea = linea;
        this.color = color;
        this.modelo = modelo;
        this.dueno = dueno;
        this.placas = placas;
    }
    public Automovil(String numeroSerie, String marca, String linea, String color, String modelo, Persona dueno) {
        this.numeroSerie = numeroSerie;
        this.marca = marca;
        this.linea = linea;
        this.color = color;
        this.modelo = modelo;
        this.dueno = dueno;
    }

    public String getNumeroSerie() {
        return numeroSerie;
    }

    public void setNumeroSerie(String numeroSerie) {
        this.numeroSerie = numeroSerie;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getLinea() {
        return linea;
    }

    public void setLinea(String linea) {
        this.linea = linea;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public Persona getDueno() {
        return dueno;
    }

    public void setDueno(Persona dueno) {
        this.dueno = dueno;
    }

    public List<Placa> getPlacas() {
        return placas;
    }

    public void setPlacas(List<Placa> placas) {
        this.placas = placas;
    }

   
}
