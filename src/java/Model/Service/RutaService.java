/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Service;

import Model.Entity.Ruta;
import java.sql.SQLException;
import java.util.LinkedList;
import javax.naming.NamingException;

/**
 *
 * @author darwin
 */
public interface RutaService {
    
    public boolean guardarRuta(int cod_ruta,
            int cod_com_ini,
            int cod_com_dest,
            float t_prom_ruta,
            float dist_prom_ruta) throws SQLException, NamingException;
    
    public Ruta seleccionarRuta(int cod_ped);
    
    public LinkedList<Ruta> seleccionarTodasLasRutas();
    
    public boolean actualizarRuta(int cod_ruta,
            int cod_com_ini,
            int cod_com_dest,
            float t_prom_ruta,
            float dist_prom_ruta) throws SQLException, NamingException;
    
    
    public boolean eliminarRuta(int cod_ped);
}
