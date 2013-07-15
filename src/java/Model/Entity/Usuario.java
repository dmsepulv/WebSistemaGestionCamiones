/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Entity;

/**
 *
 * @author darwin
 */
public class Usuario {

    private String rutUsu;
    private String passwordUsu;
    private String nombreUsu;
    private String apaternoUsu;
    private String amaternoUsu;
    private String emailUsu;
    private String estadoUsu;
    private String rolUsu;

    public Usuario() {
    }

    public Usuario(String rutUsu) {
        this.rutUsu = rutUsu;
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

    @Override
    public String toString() {
        return nombreUsu + " " + apaternoUsu + " " + amaternoUsu;
    }
}
