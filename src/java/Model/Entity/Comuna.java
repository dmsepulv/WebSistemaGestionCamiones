/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Entity;

import java.util.Collection;

/**
 *
 * @author darwin
 */
public class Comuna {
    private Integer codCom;
    private String nombreCom;
    private Region region;
    private Collection<Cliente> clienteCollection;

    public Comuna() {
    }

    public Comuna(Integer codCom) {
        this.codCom = codCom;
    }

    public Integer getCodCom() {
        return codCom;
    }

    public void setCodCom(Integer codCom) {
        this.codCom = codCom;
    }

    public String getNombreCom() {
        return nombreCom;
    }

    public void setNombreCom(String nombreCom) {
        this.nombreCom = nombreCom;
    }

    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {
        this.region = region;
    }

    public Collection<Cliente> getClienteCollection() {
        return clienteCollection;
    }

    public void setClienteCollection(Collection<Cliente> clienteCollection) {
        this.clienteCollection = clienteCollection;
    }




    @Override
    public String toString() {
        return "Model.Entity.Comuna[ codCom=" + codCom + " ]";
    }
    
}
