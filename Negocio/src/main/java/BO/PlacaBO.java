/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BO;

import Interfaces.IPlacaBO;
import DTOs.PlacaDTO;
import Entidades.Placa;
import Excepciones.NegocioException;
import Excepciones.PersistenciaException;
import Interfaces.IPlacaDAO;
import Mappers.PlacaMapper;
import java.util.List;

/**
 *
 * @author joelr
 */
public class PlacaBO implements IPlacaBO {
    
    private IPlacaDAO placaDAO;

    public PlacaBO() {
        this.placaDAO = DAO.PlacaDAO.getInstance();
    }

    public PlacaBO(IPlacaDAO placaDAO) {
        this.placaDAO = placaDAO;
    }

    /**
     * Obtiene todas las placas desde la base de datos.
     *
     * @return lista de PlacaDTO
     * @throws NegocioException si ocurre un error de negocio o persistencia
     */
    @Override
    public List<PlacaDTO> obtenerPlacas() throws NegocioException {
        try {
            List<Placa> placas = placaDAO.obtenerPlacas();
            if (placas == null || placas.isEmpty()) {
                throw new NegocioException("La lista de placas es nula o vacía");
            }
            return PlacaMapper.entityListToDto(placas);
        } catch (PersistenciaException e) {
            throw new NegocioException("No se pudieron obtener las placas", e);
        }
    }

    /**
     * Registra una nueva placa en la base de datos.
     *
     * @param placaDTO objeto PlacaDTO a registrar
     * @return true si se registró correctamente
     * @throws NegocioException si ocurre un error de negocio o persistencia
     */
    @Override
    public boolean registrarPlaca(PlacaDTO placaDTO) throws NegocioException {
        try {
            // Se asume que el campo numeroSerie del DTO ya tiene un Automovil válido
            Placa placa = PlacaMapper.toEntity(placaDTO);
            placaDAO.registrarPlaca(placa);
            System.out.println("Placa registrada con éxito");
            return true;
        } catch (PersistenciaException e) {
            throw new NegocioException("Error al registrar la placa", e);
        }
    }
    @Override
    public boolean actualizarPlaca(String serie) throws NegocioException{
        try{
            placaDAO.ActualizarEstado(serie);
            return true;
        }catch(PersistenciaException e){
            throw new NegocioException("Error al actualizar", e);
        }
    }
    
}
