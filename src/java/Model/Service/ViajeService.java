/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Service;

import Model.Entity.Viaje;
import java.sql.SQLException;
import java.util.Date;
import java.util.LinkedList;
import javax.naming.NamingException;


/**
 *
 * @author darwin
 */
public interface ViajeService {
    
    public boolean guardarViaje(
            int cod_via,
            int cod_ruta,
            String patente_cam,
            String rut_cho,
            Date fecha_carga_via,
            Date fecha_descarga_via) throws SQLException, NamingException;
    
    public Viaje seleccionarViaje(int cod_via);
    
    public LinkedList<Viaje> seleccionarTodosLosViajes();
    
    public boolean actualizarViaje(int cod_via,
            int cod_ruta,
            String patente_cam,
            String rut_cho,
            Date fecha_carga_via,
            Date fecha_descarga_via) throws SQLException, NamingException;
    
    
    public boolean eliminarViaje(int cod_via);
}
