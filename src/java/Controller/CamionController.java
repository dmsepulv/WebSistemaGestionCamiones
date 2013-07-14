/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Entity.Camion;
import Model.Service.CamionService;
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
@ManagedBean
@RequestScoped
public class CamionController {

    private String patente_cam;
    private int capacidad_cam;
    private String estado_cam;
    private int anio_adq_cam;
    private int costo_adq_cam;
    private int anio_elab_cam;
    private @Inject
    CamionService camionService;

    /**
     * Creates a new instance of CamionController
     */
    public CamionController() {
    }

    public String getPatente_cam() {
        return patente_cam;
    }

    public void setPatente_cam(String patente_cam) {
        this.patente_cam = patente_cam;
    }

    public int getCapacidad_cam() {
        return capacidad_cam;
    }

    public void setCapacidad_cam(int capacidad_cam) {
        this.capacidad_cam = capacidad_cam;
    }

    public String getEstado_cam() {
        return estado_cam;
    }

    public void setEstado_cam(String estado_cam) {
        this.estado_cam = estado_cam;
    }

    public int getAnio_adq_cam() {
        return anio_adq_cam;
    }

    public void setAnio_adq_cam(int anio_adq_cam) {
        this.anio_adq_cam = anio_adq_cam;
    }

    public int getCosto_adq_cam() {
        return costo_adq_cam;
    }

    public void setCosto_adq_cam(int costo_adq_cam) {
        this.costo_adq_cam = costo_adq_cam;
    }

    public int getAnio_elab_cam() {
        return anio_elab_cam;
    }

    public void setAnio_elab_cam(int anio_elab_cam) {
        this.anio_elab_cam = anio_elab_cam;
    }

    public String saveCamion() {
        boolean transaccionCorrecta = false;
        try {
            transaccionCorrecta = camionService.guardarCamion(patente_cam,
                    capacidad_cam,
                    estado_cam,
                    anio_adq_cam,
                    costo_adq_cam,
                    anio_elab_cam);

        } catch (SQLException ex) {
            Logger.getLogger(CamionController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NamingException ex) {
            Logger.getLogger(CamionController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return transaccionCorrecta ? "guardado" : "noguardado";
    }

    public String updateCamion() {
        boolean transaccionCorrecta = false;
        try {
            transaccionCorrecta = camionService.actualizarCamion(patente_cam,
                    capacidad_cam,
                    estado_cam,
                    anio_adq_cam,
                    costo_adq_cam,
                    anio_elab_cam);

        } catch (SQLException ex) {
            Logger.getLogger(CamionController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NamingException ex) {
            Logger.getLogger(CamionController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return transaccionCorrecta ? "actualizado" : "noactualizado";
    }

    public List<Camion> obtenerCamiones() {
        return camionService.seleccionarTodosLosCamion();
    }

    public String deleteCamion() {
        return camionService.eliminarCamion(patente_cam) ? "eliminado" : "noeliminado";
    }

    public String seleccionarCamion(Camion camion) {
        Camion c = camionService.seleccionarCamion(camion.getPatenteCam());
        if (c != null) {
            patente_cam = c.getPatenteCam();
            capacidad_cam = c.getCapacidadCam();
            estado_cam = c.getEstadoCam();
            anio_adq_cam = c.getAnioAdqCam();
            costo_adq_cam = c.getCostoAdqCam();
            anio_elab_cam = c.getAnioElabCam();
            return "encontrado";
        } else {
            return "no_encontrado";
        }
    }
}
