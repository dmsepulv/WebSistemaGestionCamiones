/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Entity.Chofer;
import Model.Service.ChoferService;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.inject.Inject;
import javax.naming.NamingException;

/**
 *
 * @author ignacio
 */
@ManagedBean
@RequestScoped
public class ChoferController {

    private @Inject
    ChoferService choferService;
    private String rut_cho;
    private String nombre_cho;
    private String apaterno_cho;
    private String amaterno_cho;
    private Date fnac_cho;
    private Integer experiencia_cho;
    private String tipo_licencia_cho;
    private Date expir_licencia_cho;

    public ChoferController() {
    }

    public String getRut_cho() {
        return rut_cho;
    }

    public void setRut_cho(String rut_cho) {
        this.rut_cho = rut_cho;
    }

    public String getNombre_cho() {
        return nombre_cho;
    }

    public void setNombre_cho(String nombre_cho) {
        this.nombre_cho = nombre_cho;
    }

    public String getApaterno_cho() {
        return apaterno_cho;
    }

    public void setApaterno_cho(String apaterno_cho) {
        this.apaterno_cho = apaterno_cho;
    }

    public String getAmaterno_cho() {
        return amaterno_cho;
    }

    public void setAmaterno_cho(String amaterno_cho) {
        this.amaterno_cho = amaterno_cho;
    }

    public Date getFnac_cho() {
        return fnac_cho;
    }

    public void setFnac_cho(Date fnac_cho) {
        this.fnac_cho = fnac_cho;
    }

    public Integer getExperiencia_cho() {
        return experiencia_cho;
    }

    public void setExperiencia_cho(Integer experiencia_cho) {
        this.experiencia_cho = experiencia_cho;
    }

    public String getTipo_licencia_cho() {
        return tipo_licencia_cho;
    }

    public void setTipo_licencia_cho(String tipo_licencia_cho) {
        this.tipo_licencia_cho = tipo_licencia_cho;
    }

    public Date getExpir_licencia_cho() {
        return expir_licencia_cho;
    }

    public void setExpir_licencia_cho(Date expir_licencia_cho) {
        this.expir_licencia_cho = expir_licencia_cho;
    }

    public String saveChofer() {
        boolean transaccionCorrecta = false;
        try {
            transaccionCorrecta = choferService.guardarChofer(
                    rut_cho,
                    nombre_cho,
                    apaterno_cho,
                    amaterno_cho,
                    fnac_cho,
                    experiencia_cho,
                    tipo_licencia_cho,
                    expir_licencia_cho);

        } catch (SQLException ex) {
            Logger.getLogger(CamionController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NamingException ex) {
            Logger.getLogger(CamionController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return transaccionCorrecta ? "guardado" : "noguardado";
    }

    public String updateChofer() {
        boolean transaccionCorrecta = false;
        try {
            transaccionCorrecta = choferService.actualizarChofer(rut_cho,
                    nombre_cho,
                    apaterno_cho,
                    amaterno_cho,
                    fnac_cho,
                    experiencia_cho,
                    tipo_licencia_cho,
                    expir_licencia_cho);

        } catch (SQLException ex) {
            Logger.getLogger(CamionController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NamingException ex) {
            Logger.getLogger(CamionController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return transaccionCorrecta ? "actualizado" : "noactualizado";
    }

    public List<Chofer> obtenerChoferes() throws SQLException, NamingException {
        return choferService.seleccionarTodosLosChofer();
    }

    public String deleteChofer() throws SQLException, NamingException {
        return choferService.eliminarChofer(rut_cho) ? "eliminado" : "noeliminado";
    }

    public String seleccionarChofer(Chofer chofer) throws SQLException, NamingException {
        Chofer c = choferService.seleccionarChofer(chofer.getRutCho());
        rut_cho = c.getRutCho();
        nombre_cho = c.getNombreCho();
        apaterno_cho = c.getAparternoCho();
        amaterno_cho = c.getAmaternoCho();
        fnac_cho = c.getFnacCho();
        experiencia_cho = c.getExperienciaCho();
        tipo_licencia_cho = c.getTipoLicenciaCho();
        expir_licencia_cho = c.getExpirLicenciaCho();

        return c != null ? "encontrado" : "no_encontrado";
    }

    @Override
    public String toString() {
        return apaterno_cho + " " + amaterno_cho + " " + nombre_cho;
    }
}
