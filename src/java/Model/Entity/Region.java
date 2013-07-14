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
public class Region{
    private Integer codReg;
    private String nombreReg;
    private Collection<Comuna> comunaCollection;

    public Region() {
    }

    public Region(Integer codReg) {
        this.codReg = codReg;
    }

    public Integer getCodReg() {
        return codReg;
    }

    public void setCodReg(Integer codReg) {
        this.codReg = codReg;
    }

    public String getNombreReg() {
        return nombreReg;
    }

    public void setNombreReg(String nombreReg) {
        this.nombreReg = nombreReg;
    }

    public Collection<Comuna> getComunaCollection() {
        return comunaCollection;
    }

    public void setComunaCollection(Collection<Comuna> comunaCollection) {
        this.comunaCollection = comunaCollection;
    }

    @Override
    public String toString() {
        return "Model.Entity.Region[ codReg=" + codReg + " ]";
    }
    
}
