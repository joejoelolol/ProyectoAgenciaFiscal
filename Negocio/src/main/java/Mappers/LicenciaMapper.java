/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Mappers;

import DTOs.LicenciaDTO;
import Entidades.Licencia;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author joelr
 */
public class LicenciaMapper {
    /**
     * Convierte una entidad Licencia a un objeto LicenciaDTO.
     *
     * @param licencia la entidad Licencia a convertir
     * @return el DTO correspondiente o null si la entrada es null
     */
    public static LicenciaDTO toDTO(Licencia licencia) {
        if (licencia == null) {
            return null;
        }
        return new LicenciaDTO(
                licencia.getIdLicencia(),
                licencia.getTipoLicencia(),
                licencia.getCosto(),
                licencia.getDueno(),
                licencia.getFechaInicio(),
                licencia.getFechaFin()
        );
    }

    /**
     * Convierte un objeto LicenciaDTO a una entidad Licencia.
     *
     * @param dto el DTO a convertir
     * @return la entidad Licencia 
     */
    public static Licencia toEntity(LicenciaDTO dto) {
        if (dto == null) {
            return null;
        }
        Licencia licencia = new Licencia();

        licencia.setIdLicencia(dto.getIdLicencia());
        licencia.setTipoLicencia(dto.getTipoLicencia());
        licencia.setCosto(dto.getCosto());
        licencia.setDueno(dto.getRfcDueno());
        licencia.setFechaInicio(dto.getFechaInicio());
        licencia.setFechaFin(dto.getFechaFin());

        return licencia;
    }

    /**
     * Convierte una lista de entidades Licencia a una lista de DTOs LicenciaDTO.
     *
     * @param entidades lista de entidades Licencia
     * @return lista de DTOs LicenciaDTO
     */
    public static List<LicenciaDTO> entityListToDto(List<Licencia> entidades) {
        List<LicenciaDTO> lista = new ArrayList<>();
        for (Licencia licencia : entidades) {
            lista.add(toDTO(licencia));
        }
        return lista;
    }

    /**
     * Convierte una lista de DTOs LicenciaDTO a una lista de entidades Licencia.
     *
     * @param dtos lista de DTOs LicenciaDTO
     * @return lista de entidades Licencia
     */
    public static List<Licencia> dtoListToEntity(List<LicenciaDTO> dtos) {
        List<Licencia> lista = new ArrayList<>();
        for (LicenciaDTO dto : dtos) {
            lista.add(toEntity(dto));
        }
        return lista;
    }
}
