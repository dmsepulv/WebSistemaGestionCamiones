/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Service;

import Model.Entity.Camion;
import java.sql.SQLException;
import java.util.LinkedList;
import javax.naming.NamingException;

/**
 *
 * @author darwin
 */
public interface CamionService {
    
    public boolean guardarCamion(String patente_cam,
            int capacidad_cam,
            String estado_cam,
            int anio_adq_cam,
            int costo_adq_cam,
            int anio_elab_cam) throws SQLException, NamingException;
    
    public Camion seleccionarCamion(String patente_cam);
    
    public LinkedList<Camion> seleccionarTodosLosCamion();
    
    public boolean actualizarCamion(String patente_cam,
            int capacidad_cam,
            String estado_cam,
            int anio_adq_cam,
            int costo_adq_cam,
            int anio_elab_cam) throws SQLException, NamingException;
    
    public boolean desactivarCamion(String patente_cam,
            int capacidad_cam,
            int anio_adq_cam,
            int costo_adq_cam,
            int anio_elab_cam);
    
    public boolean eliminarCamion(String patente_cam);
}
