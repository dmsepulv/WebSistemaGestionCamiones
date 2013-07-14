/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Service;

import Model.Entity.Chofer;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import javax.naming.NamingException;

/**
 *
 * @author darwin
 */
public interface ChoferService {
    
    public boolean guardarChofer(
            String rutCho,
            String nombreCho,
            String aparternoCho,
            String amaternoCho,
            Date fnacCho,
            Integer experienciaCho,
            String tipoLicenciaCho,
            Date expirLicenciaCho) throws SQLException, NamingException;

    public Chofer seleccionarChofer(String rutCho) throws SQLException, NamingException; 
    
    public List<Chofer> seleccionarTodosLosChofer() throws SQLException, NamingException; 
    
    public boolean actualizarChofer(
            String rutCho,
            String nombreCho,
            String aparternoCho,
            String amaternoCho,
            Date fnacCho,
            Integer experienciaCho,
            String tipoLicenciaCho,
            Date expirLicenciaCho) throws SQLException, NamingException; 
    
    public boolean eliminarChofer(String rutCho) throws SQLException, NamingException;
    
}
