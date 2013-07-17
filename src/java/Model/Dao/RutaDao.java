package Model.Dao;

import java.sql.SQLException;
import javax.naming.NamingException;

/**
 *
 * @author darwin
 */
public interface RutaDao {

    public int insertRuta(
            int cod_com_ini,
            int cod_com_dest) throws SQLException, NamingException;
            
    public Object selectRuta(int cod_ruta) throws SQLException, NamingException;

    public Object selectAllRuta() throws SQLException, NamingException;

    public boolean updateRuta(
           int cod_ruta,
            int cod_com_ini,
            int cod_com_dest,
			float t_prom_ruta,
			float dist_prom_ruta) throws SQLException, NamingException;

    public boolean deleteRuta(int cod_Ruta) throws SQLException, NamingException;
}