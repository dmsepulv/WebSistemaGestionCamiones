/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Entity;


/**
 *
 * @author darwin
 */

public class Camion{
    private String patenteCam;
    private Integer capacidadCam;
    private String estadoCam;
    private Integer anioAdqCam;
    private Integer costoAdqCam;
    private Integer anioElabCam;

    public Camion() {
    }

    public Camion(String patenteCam) {
        this.patenteCam = patenteCam;
    }

    public String getPatenteCam() {
        return patenteCam;
    }

    public void setPatenteCam(String patenteCam) {
        this.patenteCam = patenteCam;
    }

    public Integer getCapacidadCam() {
        return capacidadCam;
    }

    public void setCapacidadCam(Integer capacidadCam) {
        this.capacidadCam = capacidadCam;
    }

    public String getEstadoCam() {
        return estadoCam;
    }

    public void setEstadoCam(String estadoCam) {
        this.estadoCam = estadoCam;
    }

    public Integer getAnioAdqCam() {
        return anioAdqCam;
    }

    public void setAnioAdqCam(Integer anioAdqCam) {
        this.anioAdqCam = anioAdqCam;
    }

    public Integer getCostoAdqCam() {
        return costoAdqCam;
    }

    public void setCostoAdqCam(Integer costoAdqCam) {
        this.costoAdqCam = costoAdqCam;
    }

    public Integer getAnioElabCam() {
        return anioElabCam;
    }

    public void setAnioElabCam(Integer anioElabCam) {
        this.anioElabCam = anioElabCam;
    }

    @Override
    public String toString() {
        return "Model.Beans.Entity.Camion[ patenteCam=" + patenteCam + " ]";
    }

}
