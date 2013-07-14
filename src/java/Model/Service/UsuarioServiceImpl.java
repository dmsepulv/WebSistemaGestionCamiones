/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Service;

import Model.Dao.UsuarioDao;

import Model.Entity.Usuario;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.inject.Inject;
import javax.naming.NamingException;

/**
 *
 * @author darwin
 */
public class UsuarioServiceImpl implements UsuarioService {

    private @Inject
    UsuarioDao usuarioDao;

    @Override
    public Usuario doLogin(String rutUsu) {
        Usuario usuario = null;
        try {
            LinkedList<Object> datosUsuario = (LinkedList<Object>) usuarioDao.selectUsuario(rutUsu);
            if (datosUsuario != null) {
                usuario = new Usuario();
                usuario.setRutUsu((String) datosUsuario.get(0));
                usuario.setPasswordUsu((String) datosUsuario.get(1));
                usuario.setNombreUsu((String) datosUsuario.get(2));
                usuario.setApaternoUsu((String) datosUsuario.get(3));
                usuario.setAmaternoUsu((String) datosUsuario.get(4));
                usuario.setEmailUsu((String) datosUsuario.get(5));
                usuario.setEstadoUsu((String) datosUsuario.get(6));
                usuario.setRutUsu((String) datosUsuario.get(7));
            }
        } catch (SQLException ex) {
            Logger.getLogger(CamionServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NamingException ex) {
            Logger.getLogger(CamionServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            return usuario;
        }
    }

    @Override
    public boolean guardarUsuario(String rutUsu, String passwordUsu, String nombreUsu, String apaternoUsu, String amaternoUsu, String emailUsu, String estadoUsu, String rolUsu) throws SQLException, NamingException {

        return usuarioDao.insertUsuario(
                rutUsu,
                passwordUsu,
                nombreUsu,
                apaternoUsu,
                amaternoUsu,
                emailUsu,
                estadoUsu,
                rolUsu);

    }

    @Override
    public Usuario seleccionarUsuario(String rutUsu) {

        Usuario user = null;
        try {
            LinkedList<Object> datosUser = (LinkedList<Object>) usuarioDao.selectUsuario(rutUsu);
            if (datosUser != null) {
                user = new Usuario();
                user.setRutUsu((String) datosUser.get(0));
                user.setPasswordUsu((String) datosUser.get(1));
                user.setNombreUsu((String) datosUser.get(2));
                user.setApaternoUsu((String) datosUser.get(3));
                user.setAmaternoUsu((String) datosUser.get(4));
                user.setEmailUsu((String) datosUser.get(5));
                user.setEstadoUsu((String) datosUser.get(6));
                user.setRolUsu((String) datosUser.get(7));
            }
        } catch (SQLException ex) {
            Logger.getLogger(CamionServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NamingException ex) {
            Logger.getLogger(CamionServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            return user;
        }
    }

    @Override
    public LinkedList<Usuario> seleccionarTodosLosUsuarios() {
        Usuario user;
        LinkedList<Usuario> userRetorno = null;
        LinkedList<Object> usuarios;
        try {
            usuarios = (LinkedList<Object>) usuarioDao.selectAllUsuario();
            if (usuarios != null) {
                userRetorno = new LinkedList<Usuario>();
                for (Object usuario : usuarios) {
                    ArrayList<Object> datosUser = (ArrayList<Object>) usuario;
                    user = new Usuario();
                    user.setRutUsu((String) datosUser.get(0));
                    user.setPasswordUsu((String) datosUser.get(1));
                    user.setNombreUsu((String) datosUser.get(2));
                    user.setApaternoUsu((String) datosUser.get(3));
                    user.setAmaternoUsu((String) datosUser.get(4));
                    user.setEmailUsu((String) datosUser.get(5));
                    user.setEstadoUsu((String) datosUser.get(6));
                    user.setRolUsu((String) datosUser.get(7));
                    userRetorno.add(user);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(CamionServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NamingException ex) {
            Logger.getLogger(CamionServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return userRetorno;
    }

    @Override
    public boolean actualizarUsuario(
            String rutUsu,
            String password,
            String nombreUsu,
            String apaternoUsu,
            String amaternoUsu,
            String emailUsu,
            String estadoUsu,
            String rolUsu) throws SQLException, NamingException {

        return usuarioDao.updateUsuario(
                rutUsu,
                password,
                nombreUsu,
                apaternoUsu,
                amaternoUsu,
                emailUsu,
                estadoUsu,
                rolUsu);
    }

    @Override
    public boolean desactivarUsuario(
            String rutUsu) throws SQLException, NamingException {

        return usuarioDao.unableUsuario(rutUsu);
    }

    @Override
    public boolean eliminarUsuario(String rutUsu) throws SQLException, NamingException {

        return usuarioDao.deleteUsuario(rutUsu);
    }
}
