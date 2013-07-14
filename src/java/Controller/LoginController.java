/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Entity.Usuario;
import Model.Service.UsuarioService;
import java.io.Serializable;
import java.sql.SQLException;
import javax.annotation.Resource;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;
import javax.sql.DataSource;

/**
 *
 * @author darwin
 */
@ManagedBean(name = "login")
@SessionScoped
public class LoginController implements Serializable {

    @Resource(name = "sgc_connection")
    private DataSource sgc_connection;
    private @Inject UsuarioService usuarioService;
    private String rut;
    private String nombre;
    private String apaterno;
    private String amaterno;
    private String password;
    private boolean loggedIn = false;

    /**
     * Creates a new instance of LoginController
     */
    public LoginController() {
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApaterno() {
        return apaterno;
    }

    public void setApaterno(String apaterno) {
        this.apaterno = apaterno;
    }

    public String getAmaterno() {
        return amaterno;
    }

    public void setAmaterno(String amaterno) {
        this.amaterno = amaterno;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String validateUser() {
        try {
            doLogin();
        } catch (SQLException ex) {
            ex.printStackTrace();
            return "internalError";
        }
        if (loggedIn) {
            return "validate";
        } else {
            return "invalidate";
        }
    }

    public String logout() {
        loggedIn = false;
        return "logout";
    }

    public void doLogin() throws SQLException {
        if (rut != null && !rut.equalsIgnoreCase("")) {
            Usuario user = usuarioService.doLogin(rut);
            if (user != null) {
                loggedIn = user.getPasswordUsu().equals(password);
                if (loggedIn) {
                    nombre = user.getNombreUsu();
                    apaterno = user.getApaternoUsu();
                    amaterno = user.getAmaternoUsu();
                }
            }
        } else {
            loggedIn = false;
        }

    }
}
