/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Entity;

/**
 *
 * @author darwin
 */
public class Cliente {

    private String codCli;
    private String nombreCli;
    private String apaternoCli;
    private String amaternoCli;
    private String telefonoCli;
    private String mailCli;
    private String direccionCli;
    private Comuna comuna;

    public Cliente() {
        comuna = new Comuna();
    }

    public Cliente(String codCli) {
        this.codCli = codCli;
    }

    public String getCodCli() {
        return codCli;
    }

    public void setCodCli(String codCli) {
        this.codCli = codCli;
    }

    public String getNombreCli() {
        return nombreCli;
    }

    public void setNombreCli(String nombreCli) {
        this.nombreCli = nombreCli;
    }

    public String getApaternoCli() {
        return apaternoCli;
    }

    public void setApaternoCli(String apaternoCli) {
        this.apaternoCli = apaternoCli;
    }

    public String getAmaternoCli() {
        return amaternoCli;
    }

    public void setAmaternoCli(String amaternoCli) {
        this.amaternoCli = amaternoCli;
    }

    public String getTelefonoCli() {
        return telefonoCli;
    }

    public void setTelefonoCli(String telefonoCli) {
        this.telefonoCli = telefonoCli;
    }

    public String getMailCli() {
        return mailCli;
    }

    public void setMailCli(String mailCli) {
        this.mailCli = mailCli;
    }

    public String getDireccionCli() {
        return direccionCli;
    }

    public void setDireccionCli(String direccionCli) {
        this.direccionCli = direccionCli;
    }

    public Comuna getComuna() {
        return comuna;
    }

    public void setComuna(Comuna comuna) {
        this.comuna = comuna;
    }

    @Override
    public String toString() {
        return apaternoCli + " " + amaternoCli + " " + nombreCli;
    }
}
