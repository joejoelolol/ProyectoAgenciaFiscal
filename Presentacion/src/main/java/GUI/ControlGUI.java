/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import BO.AutomovilBO;
import BO.LicenciaBO;
import BO.PersonaBO;
import BO.PlacaBO;
import DTOs.AutomovilDTO;
import DTOs.LicenciaDTO;
import DTOs.PersonaDTO;
import DTOs.PlacaDTO;
import Excepciones.NegocioException;
import Interfaces.IAutomovilBO;
import Interfaces.ILicenciaBO;
import Interfaces.IPersonaBO;
import Interfaces.IPlacaBO;
import Mappers.AutomovilMapper;
import Mappers.LicenciaMapper;
import Mappers.PersonaMapper;
import Mappers.PlacaMapper;
import java.util.List;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 * Clase central que gestiona la navegación entre las interfaces gráficas del
 * sistema y coordina las operaciones de lógica de negocio. Este controlador se
 * encarga de mostrar ventanas, llamar a las clases BO y actualizar datos en
 * pantalla.
 *
 * @author joelr
 */
public class ControlGUI {

    // Instancia
    private static ControlGUI instancia;
    frmMenu menu;
    frmRegistro registro;
    frmSolicitarPlacas solicitarPlacas;
    IPersonaBO MetodosPersona = new PersonaBO();
    IAutomovilBO MetodosAutomovil = new AutomovilBO();
    IPlacaBO MetodosPlaca = new PlacaBO();
    ILicenciaBO MetodosLicencia = new LicenciaBO();
    int autoExistente = 0;
    int diferenteDueño = 0;

    public ControlGUI() {
    }

    public static ControlGUI getInstancia() {
        if (instancia == null) {
            instancia = new ControlGUI();
        }
        return instancia;
    }

    /**
     * Muestra el formulario del menú principal.
     */
    public void mostrarMenuPrincipal() {
        this.menu = new frmMenu();
        this.menu.setLocationRelativeTo(null);
        this.menu.setVisible(true);
    }

    /**
     * Muestra el formulario de registro.
     */
    public void mostrarFormularioRegistro() {
        this.registro = new frmRegistro();
        this.registro.setLocationRelativeTo(null);
        this.registro.setVisible(true);
    }

    /**
     * Muestra el formulario de solicitarPlacas.
     */
    public void mostrarSolicitarPlacas() {
        this.solicitarPlacas = new frmSolicitarPlacas();
        this.solicitarPlacas.setLocationRelativeTo(null);
        this.solicitarPlacas.setVisible(true);
    }

    public boolean registrarPersona(String rfc, String nombre, String apellidoPaterno, String apellidoMaterno, String telefono, Date fechaNacimiento, String tipo) throws NegocioException {
        try {
            //Persona
            //Crea 2 listas vacias
            List<AutomovilDTO> automoviles = new ArrayList<>();
            List<LicenciaDTO> licencias = new ArrayList<>();
            this.MetodosPersona.registrarPersona(new PersonaDTO(rfc,
                    nombre,
                    apellidoPaterno,
                    apellidoMaterno,
                    telefono,
                    fechaNacimiento,
                    LicenciaMapper.dtoListToEntity(licencias),
                    AutomovilMapper.dtoListToEntity(automoviles)));
            //Licencia
            double costo = 0;
            Date fechaInicio = new Date(); // fecha actual
            Date fechaFin;
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(fechaInicio);

            if (tipo.equalsIgnoreCase("1 año")) {
                costo = 500.0;
                calendar.add(Calendar.YEAR, 1); // suma 1 años
                fechaFin = calendar.getTime();
            } else if (tipo.equalsIgnoreCase("2 años")) {
                costo = 900.0;
                calendar.add(Calendar.YEAR, 2); // suma 2 años
                fechaFin = calendar.getTime();
            } else {
                costo = 1200.0;
                int años = Integer.parseInt(tipo.split(" ")[0]);
                calendar.add(Calendar.YEAR, años); // suma 3 años o mas
                fechaFin = calendar.getTime();
            }
            this.MetodosLicencia.registrarLicencia(new LicenciaDTO(tipo,
                    costo,
                    PersonaMapper.toEntity(this.MetodosPersona.obtenerPersonaPorRFC(rfc)),
                    fechaInicio,
                    fechaFin));
            JOptionPane.showMessageDialog(null, "Licencia Registrada");
            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al registrar");
            throw new NegocioException("Error al registrar");
        }
    }

    public boolean AutomovilPlacas(String numeroSerie, String marca, String linea, String color, String modelo, String rfc) throws NegocioException {
        this.autoExistente = 0;
        String tipoAuto;
        PlacaDTO placa = new PlacaDTO();
        List<PlacaDTO> placas = new ArrayList<>();
        List<AutomovilDTO> automoviles = this.MetodosAutomovil.obtenerAutomoviles();
        AutomovilDTO automovil = new AutomovilDTO();
        for (int i = 0; i < automoviles.size(); i++) {
            if (automoviles.get(i).getNumeroSerie().equalsIgnoreCase(numeroSerie)) {
                this.autoExistente = 1; //Si es 1, el auto existe en la bd;
                automovil = automoviles.get(i);

            }
            if (this.autoExistente == 1) {
                if (automoviles.get(i).getRfcDueno().getRfc().equalsIgnoreCase(rfc)) {

                } else {
                    this.diferenteDueño = 1; //El auto ya esta registrado y tiene otro dueño.
                    JOptionPane.showMessageDialog(null, "El rfc introducido no coincide con el dueño registrado de este auto.");
                    throw new NegocioException("El rfc no coincide con el dueño");
                }

            }
        }
        if (this.autoExistente == 1) {
            tipoAuto = "Usado";
            placa.setTipoAuto(tipoAuto);
            placa.setNumeroSerie(AutomovilMapper.toEntity(automovil));
            
//            this.MetodosPlaca.actualizarPlaca(numeroSerie);
            this.MetodosPlaca.registrarPlaca(placa);
        } else {
            tipoAuto = "Nuevo";
            placa.setTipoAuto(tipoAuto);
            this.MetodosAutomovil.registrarAutomovil(new AutomovilDTO(numeroSerie, marca, linea, color, modelo, PersonaMapper.toEntity(this.MetodosPersona.obtenerPersonaPorRFC(rfc)), PlacaMapper.dtoListToEntity(placas)));
            automovil = new AutomovilDTO(numeroSerie, marca, linea, color, modelo, PersonaMapper.toEntity(this.MetodosPersona.obtenerPersonaPorRFC(rfc)), PlacaMapper.dtoListToEntity(placas));
            placa.setNumeroSerie(AutomovilMapper.toEntity(automovil));
            this.MetodosPlaca.registrarPlaca(placa);
        }

        return true;

    }

    public boolean ValidacionesRegistro(String rfc, String nombre, String apellidoPaterno, String apellidoMaterno, String telefono, Date fechaNacimiento, String tipo) throws NegocioException {
        boolean seguir = false; // Define si el proceso de registro continua.
        //Validacion Campos necesarios vacios
        if (nombre.equalsIgnoreCase("")
                || apellidoPaterno.equalsIgnoreCase("")
                || apellidoMaterno.equalsIgnoreCase("")
                || telefono.equalsIgnoreCase("")
                || fechaNacimiento == null
                || tipo.equalsIgnoreCase("")) {
            JOptionPane.showMessageDialog(null, "Necesita llenar los campos para registrar");
            throw new NegocioException("Le falta llenar un campo obligatorio");
            // Validación letras y no numeros.
        } else if (nombre.matches(".*\\d.*")
                || apellidoPaterno.matches(".*\\d.*")
                || apellidoMaterno.matches(".*\\d.*")) {
            JOptionPane.showMessageDialog(null, "Debe introducir solo texto en los campos de textos");
            throw new NegocioException("Hay numeros en los campos de texto");
            // Validación precio solo puede llevar numeros.
        } else if (telefono.matches(".*[a-zA-Z].*")) {
            JOptionPane.showMessageDialog(null, "El campo telefono solo puede llevar numeros");
            throw new NegocioException("El campo telefono solo puede llevar numeros");
            //Validación de productoBO ya existente.
        }
        seguir = true;

        return seguir;
    }
}
