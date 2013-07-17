/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Entity.Ruta;
import Model.Service.RutaService;
import java.util.List;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;
import javax.inject.Inject;
import javax.naming.NamingException;

/**
 *
 * @author darwin
 */
@ManagedBean(name = "ruta")
@RequestScoped
public class RutaController {

    private @Inject
    RutaService rutaService;
    private int cod_ruta;
    private String cod_com_ini;
    private String cod_com_dest;
    private double t_prom_ruta;
    private double dist_prom_ruta;

    public RutaController() {
    }

    public int getCod_ruta() {
        return cod_ruta;
    }

    public void setCod_ruta(int cod_ruta) {
        this.cod_ruta = cod_ruta;
    }

    public RutaService getRutaService() {
        return rutaService;
    }

    public void setRutaService(RutaService rutaService) {
        this.rutaService = rutaService;
    }

    public String getCod_com_ini() {
        return cod_com_ini;
    }

    public void setCod_com_ini(String cod_com_ini) {
        this.cod_com_ini = cod_com_ini;
    }

    public String getCod_com_dest() {
        return cod_com_dest;
    }

    public void setCod_com_dest(String cod_com_dest) {
        this.cod_com_dest = cod_com_dest;
    }

    public double getT_prom_ruta() {
        return t_prom_ruta;
    }

    public void setT_prom_ruta(double t_prom_ruta) {
        this.t_prom_ruta = t_prom_ruta;
    }

    public double getDist_prom_ruta() {
        return dist_prom_ruta;
    }

    public void setDist_prom_ruta(double dist_prom_ruta) {
        this.dist_prom_ruta = dist_prom_ruta;
    }

    public int saveRuta() {
        try {
            return rutaService.guardarRuta(Integer.parseInt(cod_com_ini), Integer.parseInt(cod_com_dest));
        } catch (SQLException ex) {
            Logger.getLogger(RutaController.class.getName()).log(Level.SEVERE, null, ex);
            return -1;
        } catch (NamingException ex) {
            Logger.getLogger(RutaController.class.getName()).log(Level.SEVERE, null, ex);
            return -1;
        }
    }

    public List<Ruta> obtenerRutas() {
        return rutaService.seleccionarTodasLasRutas();
    }

    public void seleccionarRuta(int cod_ruta) {
        Ruta c = rutaService.seleccionarRuta(cod_ruta);
        if (c != null) {
            this.cod_ruta=cod_ruta;
            cod_com_ini=c.getInicio();
            cod_com_dest=c.getDestino();
        } 
    }
}
