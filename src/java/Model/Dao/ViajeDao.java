package Model.Dao;

import java.sql.SQLException;
import java.util.Date;
import javax.naming.NamingException;

/**
 *
 * @author darwin
 */
public interface ViajeDao {

    public boolean insertViaje(
            int cod_via,
            int cod_ruta,
            String patente_cam,
            String rut_cho,
            Date fecha_carga_via,
            Date fecha_descarga_via) throws SQLException, NamingException;
            
            

    public Object selectViaje(int cod_via) throws SQLException, NamingException;

    public Object selectAllViaje() throws SQLException, NamingException;

    public boolean updateViaje(
            int cod_via,
            int cod_ruta,
            String patente_cam,
            String rut_cho,
            Date fecha_carga_via,
            Date fecha_descarga_via) throws SQLException, NamingException;

    public boolean deleteViaje(int cod_viaje) throws SQLException, NamingException;
}