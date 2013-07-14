/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Dao;

import java.sql.SQLException;
import java.util.Date;
import javax.naming.NamingException;

/**
 *
 * @author darwin
 */
public interface ChoferDao {
    
    public boolean insertChofer(
            String rutCho,
            String nombreCho,
            String aparternoCho,
            String amaternoCho,
            Date fnacCho,
            Integer experienciaCho,
            String tipoLicenciaCho,
            Date expirLicenciaCho) throws SQLException, NamingException;

    public Object selectChofer(String rutCho) throws SQLException, NamingException; 
    
    public Object selectAllChofer() throws SQLException, NamingException; 
    
    public boolean updateChofer(
            String rutCho,
            String nombreCho,
            String aparternoCho,
            String amaternoCho,
            Date fnacCho,
            Integer experienciaCho,
            String tipoLicenciaCho,
            Date expirLicenciaCho) throws SQLException, NamingException; 
    
    public boolean deleteChofer(String rutCho) throws SQLException, NamingException;
}
