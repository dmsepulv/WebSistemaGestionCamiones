/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Dao;

import java.sql.SQLException;
import javax.naming.NamingException;

/**
 *
 * @author darwin
 */
public interface CamionDao{

    public boolean insertCamion(
            String patente_cam,
            int capacidad_cam,
            String estado_cam,
            int anio_adq_cam,
            int costo_adq_cam,
            int anio_elab_cam) throws SQLException, NamingException;

    public Object selectCamion(String patente_cam) throws SQLException, NamingException; 
    
    public Object selectAllCamion() throws SQLException, NamingException; 
    
    public boolean updateCamion(
            String patente_cam,
            int capacidad_cam,
            String estado_cam,
            int anio_adq_cam,
            int costo_adq_cam,
            int anio_elab_cam) throws SQLException, NamingException; 
    
    public boolean deleteCamion(String patente_cam) throws SQLException, NamingException;
}
