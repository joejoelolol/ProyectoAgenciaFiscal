/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Mappers;

import DTOs.PlacaDTO;
import Entidades.Placa;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author joelr Clase utilitaria para mapear entre la entidad Placa y su DTO
 * correspondiente.
 */
public class PlacaMapper {

    /**
     * Convierte una entidad Placa a un objeto PlacaDTO.
     *
     * @param placa la entidad Placa a convertir
     * @return el DTO correspondiente o null si la entrada es null
     */
    public static PlacaDTO toDTO(Placa placa) {
        if (placa == null) {
            return null;
        }
        return new PlacaDTO(
                placa.getIdPlaca(),
                placa.getEstado(),
                placa.getTipoAuto(),
                placa.getFechaRecepcion(),
                placa.getFechaEmision(),
                placa.getNumeroSerie()
        );
    }

    /**
     * Convierte un objeto PlacaDTO a una entidad Placa.
     *
     * @param dto el DTO a convertir
     * @return la entidad Placa resultante o null si el DTO es null
     */
    public static Placa toEntity(PlacaDTO dto) {
        if (dto == null) {
            return null;
        }
        return new Placa(
                dto.getIdPlaca(),
                dto.getEstado(),
                dto.getTipoAuto(),
                dto.getFechaRecepcion(),
                dto.getFechaEmision(),
                dto.getNumeroSerie()
        );
    }

    /**
     * Convierte una lista de entidades Placa a una lista de DTOs PlacaDTO.
     *
     * @param entidades lista de entidades Placa
     * @return lista de DTOs PlacaDTO
     */
    public static List<PlacaDTO> entityListToDto(List<Placa> entidades) {
        List<PlacaDTO> lista = new ArrayList<>();
        for (Placa placa : entidades) {
            lista.add(toDTO(placa));
        }
        return lista;
    }

    /**
     * Convierte una lista de DTOs PlacaDTO a una lista de entidades Placa.
     *
     * @param dtos lista de DTOs PlacaDTO
     * @return lista de entidades Placa
     */
    public static List<Placa> dtoListToEntity(List<PlacaDTO> dtos) {
        List<Placa> lista = new ArrayList<>();
        for (PlacaDTO dto : dtos) {
            lista.add(toEntity(dto));
        }
        return lista;
    }
    
    /**
     * Convierte una lista de Placa Entidades a una lista de placasDTO.
     *
     * @param dtos lista de DTOs PlacaDTO
     * @return lista de entidades Placa
     */
    public static List<PlacaDTO> EntitytoDTOList(List<Placa> placas) {
        List<PlacaDTO> lista = new ArrayList<>();
        for (Placa entidades : placas) {
            lista.add(toDTO(entidades));
        }
        return lista;
    }
}
