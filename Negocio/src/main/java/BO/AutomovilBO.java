/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BO;

import Interfaces.IAutomovilBO;
import DTOs.AutomovilDTO;
import Entidades.Automovil;
import Excepciones.NegocioException;
import Excepciones.PersistenciaException;
import Interfaces.IAutomovilDAO;
import Mappers.AutomovilMapper;
import java.util.List;

/**
 *
 * @author joelr
 */
public class AutomovilBO implements IAutomovilBO {

    private IAutomovilDAO automovilDAO;

    /**
     * Constructor por defecto que obtiene una instancia del DAO de automovil.
     */
    public AutomovilBO() {
        this.automovilDAO = DAO.AutomovilDAO.getInstance();
    }

    /**
     * Constructor que permite inyectar un DAO personalizado.
     *
     * @param automovilDAO instancia personalizada de IAutomovilDAO
     */
    public AutomovilBO(IAutomovilDAO automovilDAO) {
        this.automovilDAO = automovilDAO;
    }

    /**
     * Método que obtiene la lista de automóviles de la base de datos.
     *
     * @return Lista de AutomovilDTO
     * @throws NegocioException si ocurre un error de negocio o de persistencia
     */
    @Override
    public List<AutomovilDTO> obtenerAutomoviles() throws NegocioException {
        try {
            List<Automovil> listaAutomoviles = automovilDAO.obtenerAutomoviles(); // nombre heredado del DAO
            if (listaAutomoviles == null || listaAutomoviles.isEmpty()) {
                throw new NegocioException("La lista de automóviles está vacía o es nula");
            }
            return AutomovilMapper.entityListToDto(listaAutomoviles);
        } catch (PersistenciaException e) {
            throw new NegocioException("No se pudieron obtener los automóviles", e);
        }
    }

    /**
     * Método que registra un nuevo automóvil en la base de datos.
     *
     * @param automovilDTO datos del automóvil a registrar
     * @return true si el automóvil se registró correctamente
     * @throws NegocioException si ocurre un error al registrar
     */
    @Override
    public boolean registrarAutomovil(AutomovilDTO automovilDTO) throws NegocioException {
        try {
            Automovil automovil = AutomovilMapper.toEntity(automovilDTO); 
            automovilDAO.registrarAutomovil(automovil); 
            return true;
        } catch (PersistenciaException e) {
            throw new NegocioException("Error al registrar el automóvil", e);
        }
    }
}
