/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Mappers;

import DTOs.AutomovilDTO;
import Entidades.Automovil;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author joelr
 */
public class AutomovilMapper {
    /**
     * Convierte una entidad Automovil a un objeto AutomovilDTO.
     *
     * @param automovil la entidad Automovil a convertir
     * @return el DTO correspondiente o null si la entrada es null
     */
    public static AutomovilDTO toDTO(Automovil automovil) {
        if (automovil == null) {
            return null;
        }
        return new AutomovilDTO(
                automovil.getNumeroSerie(),
                automovil.getMarca(),
                automovil.getLinea(),
                automovil.getColor(),
                automovil.getModelo(),
                automovil.getDueno(),
                automovil.getPlacas()
        );
    }

    /**
     * Convierte un objeto AutomovilDTO a una entidad Automovil.
     *
     * @param dto el DTO a convertir
     * @return la entidad Automovil 
     */
    public static Automovil toEntity(AutomovilDTO dto) {
        if (dto == null) {
            return null;
        }
        return new Automovil(
                dto.getNumeroSerie(),
                dto.getMarca(),
                dto.getLinea(),
                dto.getColor(),
                dto.getModelo(),
                dto.getRfcDueno(),
                dto.getIdPlacas()
        );
    }

    /**
     * Convierte una lista de entidades Automovil a una lista de DTOs AutomovilDTO.
     *
     * @param entidades lista de entidades Automovil
     * @return lista de DTOs
     */
     public static List<AutomovilDTO> entityListToDto(List<Automovil> entidades) {
         if (entidades == null) {
             List<AutomovilDTO> lista = new ArrayList<>();
             return lista;
         }
        List<AutomovilDTO> lista = new ArrayList<>();
        for (Automovil automoviles : entidades) {
            lista.add(toDTO(automoviles));
        }
        return lista;
    }

    /**
     * Convierte una lista de DTOs AutomovilDTO a una lista de entidades Automovil.
     *
     * @param dtos lista de DTOs AutomovilDTO
     * @return 
     */
    public static List<Automovil> dtoListToEntity(List<AutomovilDTO> dtos) {
        List<Automovil> lista = new ArrayList<>();
        for (AutomovilDTO dto : dtos) {
            lista.add(toEntity(dto));
        }
        return lista;
    }
}
