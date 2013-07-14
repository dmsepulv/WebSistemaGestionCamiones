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
public interface UsuarioDao {

    public boolean insertUsuario(
            String rutUsu,
            String passwordUsu,
            String nombreUsu,
            String apaternoUsu,
            String amaternoUsu,
            String emailUsu,
            String estadoUsu,
            String rolUsu) throws SQLException, NamingException;

    public Object selectUsuario(String rut) throws SQLException, NamingException;

    public Object selectAllUsuario() throws SQLException, NamingException;

    public boolean updateUsuario(
            String rutUsu,
            String passwordUsu,
            String nombreUsu,
            String apaternoUsu,
            String amaternoUsu,
            String emailUsu,
            String estadoUsu,
            String rolUsu) throws SQLException, NamingException;

    public boolean unableUsuario(String rutUsu) throws SQLException, NamingException;

    public boolean deleteUsuario(String rutUsu) throws SQLException, NamingException;
}
