/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Service;

import Model.Entity.Cliente;
import java.sql.SQLException;
import java.util.LinkedList;
import javax.naming.NamingException;

/**
 *
 * @author darwin
 */
public interface ClienteService {
    
    public boolean guardarCliente(
            String codCli,
            int codComuna,
            String nombreCli,
            String apaternoCli,
            String amaternoCli,
            String fonoCli,
            String emailCli,
            String direccionCli) throws SQLException, NamingException;
    
    public Cliente seleccionarCliente(String codCli);
    
    public LinkedList<Cliente> seleccionarTodosLosCliente();
    
    public boolean actualizarCliente(
            String codCli,
            int codComuna,
            String nombreCli,
            String apaternoCli,
            String amaternoCli,
            String fonoCli,
            String emailCli,
            String direccionCli) throws SQLException, NamingException;
    
   // public boolean desactivarUsuario (String rutUsu) throws SQLException, NamingException;
    
    public boolean eliminarCliente(String cod_cli) throws SQLException, NamingException;
}
