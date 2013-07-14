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
public interface ClienteDao {
    public boolean insertCliente(
            String codCli,
            int codComuna,
            String nombreCli,
            String apaternoCli,
            String amaternoCli,
            String fonoCli,
            String emailCli,
            String direccionCli) throws SQLException, NamingException;

    public Object selectCliente(String codCli) throws SQLException, NamingException;

    public Object selectAllCliente() throws SQLException, NamingException;

    public boolean updateCliente(
            String codCli,
            int codComuna,
            String nombreCli,
            String apaternoCli,
            String amaternoCli,
            String fonoCli,
            String emailCli,
            String direccionCli) throws SQLException, NamingException;

    public boolean unableCliente(String codCli) throws SQLException, NamingException;

    public boolean deleteCliente(String codCli) throws SQLException, NamingException;
}
