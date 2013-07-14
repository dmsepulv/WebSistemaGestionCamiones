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
public class Viaje {

    private int cod_via;
    private int cod_ruta;
    private String patente_cam;
    private String rut_cho;
    private Date fecha_carga_via;
    private Date fecha_descarga_via;

    public Viaje() {
    }

    public Viaje(int cod_via, int cod_ruta, String patente_cam, String rut_cho, Date fecha_carga_via, Date fecha_descarga_via) {
        this.cod_via = cod_via;
        this.cod_ruta = cod_ruta;
        this.patente_cam = patente_cam;
        this.rut_cho = rut_cho;
        this.fecha_carga_via = fecha_carga_via;
        this.fecha_descarga_via = fecha_descarga_via;
    }

    public int getCod_ruta() {
        return cod_ruta;
    }

    public void setCod_ruta(int cod_ruta) {
        this.cod_ruta = cod_ruta;
    }

    public int getCod_via() {
        return cod_via;
    }

    public void setCod_via(int cod_via) {
        this.cod_via = cod_via;
    }

    public Date getFecha_carga_via() {
        return fecha_carga_via;
    }

    public void setFecha_carga_via(Date fecha_carga_via) {
        this.fecha_carga_via = fecha_carga_via;
    }

    public Date getFecha_descarga_via() {
        return fecha_descarga_via;
    }

    public void setFecha_descarga_via(Date fecha_descarga_via) {
        this.fecha_descarga_via = fecha_descarga_via;
    }

    public String getPatente_cam() {
        return patente_cam;
    }

    public void setPatente_cam(String patente_cam) {
        this.patente_cam = patente_cam;
    }

    public String getRut_cho() {
        return rut_cho;
    }

    public void setRut_cho(String rut_cho) {
        this.rut_cho = rut_cho;
    }

    @Override
    public String toString() {
        return "Viaje{" + "cod_via=" + cod_via + ", cod_ruta=" + cod_ruta + ", patente_cam=" + patente_cam + ", rut_cho=" + rut_cho + ", fecha_carga_via=" + fecha_carga_via + ", fecha_descarga_via=" + fecha_descarga_via + '}';
    }
    
    
    
}
