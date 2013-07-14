/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Service;

import Model.Entity.Usuario;
import java.sql.SQLException;
import java.util.LinkedList;
import javax.naming.NamingException;

/**
 *
 * @author darwin
 */
public interface UsuarioService {
    
    public Usuario doLogin(String rutUsu);
    
    public boolean guardarUsuario(
            String rutUsu,
            String passwordUsu,
            String nombreUsu ,
            String apaternoUsu ,
            String amaternoUsu ,
            String emailUsu ,
            String estadoUsu,
            String rolUsu) throws SQLException, NamingException;
    
    public Usuario seleccionarUsuario(String patente_cam);
    
    public LinkedList<Usuario> seleccionarTodosLosUsuarios();
    
    public boolean actualizarUsuario(
            String rutUsu,
            String password,
            String nombreUsu ,
            String apaternoUsu ,
            String amaternoUsu ,
            String emailUsu ,
            String estadoUsu,
            String rolUsu) throws SQLException, NamingException;
    
    public boolean desactivarUsuario (String rutUsu) throws SQLException, NamingException;
    
    public boolean eliminarUsuario(String rutUsu) throws SQLException, NamingException;
}
