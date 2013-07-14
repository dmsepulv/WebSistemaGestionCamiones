/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Entity.Usuario;
import Model.Service.UsuarioService;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.inject.Inject;
import javax.naming.NamingException;

/**
 *
 * @author darwin
 */
@ManagedBean(name = "usuarioController")
@RequestScoped
public class UsuarioController {

    private String rutUsu;
    private String passwordUsu;
    private String nombreUsu;
    private String apaternoUsu;
    private String amaternoUsu;
    private String emailUsu;
    private String estadoUsu;
    private String rolUsu;
     private @Inject
    UsuarioService usuarioService;

    public UsuarioController() {
    }

    public String getRutUsu() {
        return rutUsu;
    }

    public void setRutUsu(String rutUsu) {
        this.rutUsu = rutUsu;
    }

    public String getPasswordUsu() {
        return passwordUsu;
    }

    public void setPasswordUsu(String passwordUsu) {
        this.passwordUsu = passwordUsu;
    }

    public String getNombreUsu() {
        return nombreUsu;
    }

    public void setNombreUsu(String nombreUsu) {
        this.nombreUsu = nombreUsu;
    }

    public String getApaternoUsu() {
        return apaternoUsu;
    }

    public void setApaternoUsu(String apaternoUsu) {
        this.apaternoUsu = apaternoUsu;
    }

    public String getAmaternoUsu() {
        return amaternoUsu;
    }

    public void setAmaternoUsu(String amaternoUsu) {
        this.amaternoUsu = amaternoUsu;
    }

    public String getEmailUsu() {
        return emailUsu;
    }

    public void setEmailUsu(String emailUsu) {
        this.emailUsu = emailUsu;
    }

    public String getEstadoUsu() {
        return estadoUsu;
    }

    public void setEstadoUsu(String estadoUsu) {
        this.estadoUsu = estadoUsu;
    }

    public String getRolUsu() {
        return rolUsu;
    }

    public void setRolUsu(String rolUsu) {
        this.rolUsu = rolUsu;
    }

    public String saveUsuario() {
        boolean transaccionCorrecta = false;
        try {
            transaccionCorrecta = usuarioService.guardarUsuario(rutUsu,
                    passwordUsu,
                    nombreUsu,
                    apaternoUsu,
                    amaternoUsu,
                    emailUsu,
                    estadoUsu,
                    rolUsu);

        } catch (SQLException ex) {
            Logger.getLogger(UsuarioController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NamingException ex) {
            Logger.getLogger(UsuarioController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return transaccionCorrecta ? "guardado" : "noguardado";
    }

    public String updateUsuario() {
        boolean transaccionCorrecta = false;
        try {
            transaccionCorrecta = usuarioService.actualizarUsuario(rutUsu,
                    passwordUsu,
                    nombreUsu,
                    apaternoUsu,
                    amaternoUsu,
                    emailUsu,
                    estadoUsu,
                    rolUsu);

        } catch (SQLException ex) {
            Logger.getLogger(UsuarioController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NamingException ex) {
            Logger.getLogger(UsuarioController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return transaccionCorrecta ? "actualizado" : "noactualizado";
    }

    public List<Usuario> obtenerUsuarios() {
        return usuarioService.seleccionarTodosLosUsuarios();
    }

    public String deleteUsuario() throws SQLException, NamingException {
        return usuarioService.eliminarUsuario(rutUsu) ? "eliminado" : "noeliminado";
    }

    public String seleccionarUsuario(Usuario usuario) {
        Usuario c = usuarioService.seleccionarUsuario(usuario.getRutUsu());
        if (c != null) {
            rutUsu=
                    passwordUsu=c.getRutUsu();
                    nombreUsu=c.getNombreUsu();
                    apaternoUsu=c.getApaternoUsu();
                    amaternoUsu=c.getAmaternoUsu();
                    emailUsu=c.getEmailUsu();
                    estadoUsu=c.getEstadoUsu();
                    rolUsu=c.getRolUsu();
         
            return "encontrado";
        } else {
            return "no_encontrado";
        }
    }
}
