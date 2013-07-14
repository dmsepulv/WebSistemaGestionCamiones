/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Entity;

import java.util.Date;

/**
 *
 * @author darwin
 */

public class Chofer {
    private String rutCho;
    private String nombreCho;
    private String aparternoCho;
    private String amaternoCho;
    private Date fnacCho;
    private Integer experienciaCho;
    private String tipoLicenciaCho;
    private Date expirLicenciaCho;

    public Chofer() {
    }

    public Chofer(String rutCho) {
        this.rutCho = rutCho;
    }

    public String getRutCho() {
        return rutCho;
    }

    public void setRutCho(String rutCho) {
        this.rutCho = rutCho;
    }

    public String getNombreCho() {
        return nombreCho;
    }

    public void setNombreCho(String nombreCho) {
        this.nombreCho = nombreCho;
    }

    public String getAparternoCho() {
        return aparternoCho;
    }

    public void setAparternoCho(String aparternoCho) {
        this.aparternoCho = aparternoCho;
    }

    public String getAmaternoCho() {
        return amaternoCho;
    }

    public void setAmaternoCho(String amaternoCho) {
        this.amaternoCho = amaternoCho;
    }

    public Date getFnacCho() {
        return fnacCho;
    }

    public void setFnacCho(Date fnacCho) {
        this.fnacCho = fnacCho;
    }

    public Integer getExperienciaCho() {
        return experienciaCho;
    }

    public void setExperienciaCho(Integer experienciaCho) {
        this.experienciaCho = experienciaCho;
    }

    public String getTipoLicenciaCho() {
        return tipoLicenciaCho;
    }

    public void setTipoLicenciaCho(String tipoLicenciaCho) {
        this.tipoLicenciaCho = tipoLicenciaCho;
    }

    public Date getExpirLicenciaCho() {
        return expirLicenciaCho;
    }

    public void setExpirLicenciaCho(Date expirLicenciaCho) {
        this.expirLicenciaCho = expirLicenciaCho;
    }


    @Override
    public String toString() {
        return "Model.Entity.Chofer[ rutCho=" + rutCho + " ]";
    }
    
}
