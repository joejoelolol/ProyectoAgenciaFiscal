/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BO;

import Interfaces.ILicenciaBO;
import DTOs.LicenciaDTO;
import Entidades.Licencia;
import Excepciones.NegocioException;
import Excepciones.PersistenciaException;
import Interfaces.ILicenciaDAO;
import Mappers.LicenciaMapper;
import java.util.List;

/**
 *
 * @author joelr
 */
public class LicenciaBO implements ILicenciaBO {

    private ILicenciaDAO licenciaDAO;

    /**
     * Constructor por defecto que obtiene una instancia del DAO de licencia.
     */
    public LicenciaBO() {
        this.licenciaDAO = DAO.LicenciaDAO.getInstance();
    }

    /**
     * Constructor con inyección de dependencia para pruebas o personalización.
     *
     * @param licenciaDAO instancia personalizada de ILicenciaDAO
     */
    public LicenciaBO(ILicenciaDAO licenciaDAO) {
        this.licenciaDAO = licenciaDAO;
    }

    /**
     * Obtiene la lista de licencias desde la base de datos.
     *
     * @return lista de LicenciaDTO
     * @throws NegocioException si ocurre un error de negocio o persistencia
     */
    @Override
    public List<LicenciaDTO> obtenerLicencias() throws NegocioException {
        try {
            List<Licencia> listaLicencias = licenciaDAO.obtenerLicencias();
            if (listaLicencias == null || listaLicencias.isEmpty()) {
                throw new NegocioException("La lista de licencias es nula o vacía");
            }
            return LicenciaMapper.entityListToDto(listaLicencias);
        } catch (PersistenciaException e) {
            throw new NegocioException("No se pudieron obtener las licencias", e);
        }
    }

    /**
     * Registra una nueva licencia en la base de datos.
     *
     * @param licenciaDTO objeto LicenciaDTO a registrar
     * @return true si se registró correctamente
     * @throws NegocioException si ocurre un error durante el registro
     */
    @Override
    public boolean registrarLicencia(LicenciaDTO licenciaDTO) throws NegocioException {
        try {
            Licencia licencia = LicenciaMapper.toEntity(licenciaDTO);
            licenciaDAO.registrarLicencia(licencia);
            return true;
        } catch (PersistenciaException e) {
            throw new NegocioException("Error al registrar la licencia", e);
        }
    }
}
