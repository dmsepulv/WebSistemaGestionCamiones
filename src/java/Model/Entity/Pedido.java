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
public class Pedido {

    private int cod_ped;
    private String cod_cli;
    private String rut_usu;
    private String tipo_ped;
    private int cantidad_ped;
    private String observacion_ped;
    private String prioridad_ped;
    private Date fecha_entrega_ped;
    private Date fecha_solicitud_ped;

    public Pedido() {
    }

    public int getCod_ped() {
        return cod_ped;
    }

    public void setCod_ped(int cod_ped) {
        this.cod_ped = cod_ped;
    }

    public String getCod_cli() {
        return cod_cli;
    }

    public void setCod_cli(String cod_cli) {
        this.cod_cli = cod_cli;
    }

    public String getRut_usu() {
        return rut_usu;
    }

    public void setRut_usu(String rut_usu) {
        this.rut_usu = rut_usu;
    }

    public String getTipo_ped() {
        return tipo_ped;
    }

    public void setTipo_ped(String tipo_ped) {
        this.tipo_ped = tipo_ped;
    }

    public int getCantidad_ped() {
        return cantidad_ped;
    }

    public void setCantidad_ped(int cantidad_ped) {
        this.cantidad_ped = cantidad_ped;
    }

    public String getObservacion_ped() {
        return observacion_ped;
    }

    public void setObservacion_ped(String observacion_ped) {
        this.observacion_ped = observacion_ped;
    }

    public String getPrioridad_ped() {
        return prioridad_ped;
    }

    public void setPrioridad_ped(String prioridad_ped) {
        this.prioridad_ped = prioridad_ped;
    }

    public Date getFecha_entrega_ped() {
        return fecha_entrega_ped;
    }

    public void setFecha_entrega_ped(Date fecha_entrega_ped) {
        this.fecha_entrega_ped = fecha_entrega_ped;
    }

    public Date getFecha_solicitud_ped() {
        return fecha_solicitud_ped;
    }

    public void setFecha_solicitud_ped(Date fecha_solicitud_ped) {
        this.fecha_solicitud_ped = fecha_solicitud_ped;
    }

    @Override
    public String toString() {
        return "Pedido{" + "cod_ped=" + cod_ped + ", cod_cli=" + cod_cli + ", rut_usu=" + rut_usu + ", tipo_ped=" + tipo_ped + ", cantidad_ped=" + cantidad_ped + ", observacion_ped=" + observacion_ped + ", prioridad_ped=" + prioridad_ped + ", fecha_entrega_ped=" + fecha_entrega_ped + ", fecha_solicitud_ped=" + fecha_solicitud_ped + '}';
    }

   
}
