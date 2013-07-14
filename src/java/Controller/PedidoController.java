/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Entity.Pedido;
import Model.Service.PedidoService;
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
 * @author ignacio
 */
@ManagedBean
@RequestScoped
public class PedidoController {

    private @Inject
    PedidoService pedidoService;
    private int cod_ped;
    private String cod_cli;
   
    private String rut_usu;
    private String tipo_ped;
    private int cantidad_ped;
    private String observacion_ped;
    private String prioridad_ped;
    private java.util.Date fecha_entrega_ped;
    private java.util.Date fecha_solicitud_ped;

    public PedidoController() {
    }

    public PedidoService getPedidoService() {
        return pedidoService;
    }

    public void setPedidoService(PedidoService pedidoService) {
        this.pedidoService = pedidoService;
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

    public java.util.Date getFecha_entrega_ped() {
        return fecha_entrega_ped;
    }

    public void setFecha_entrega_ped(java.util.Date fecha_entrega_ped) {
        this.fecha_entrega_ped = fecha_entrega_ped;
    }

    public java.util.Date getFecha_solicitud_ped() {
        return fecha_solicitud_ped;
    }

    public void setFecha_solicitud_ped(java.util.Date fecha_solicitud_ped) {
        this.fecha_solicitud_ped = fecha_solicitud_ped;
    }

    public boolean savePedido() {
        boolean transaccionCorrecta = false;
        try {
            transaccionCorrecta = pedidoService.guardarPedido(
                    cod_ped,
                    cod_cli,
               
                    rut_usu,
                    tipo_ped,
                    cantidad_ped,
                    observacion_ped,
                    prioridad_ped,
                    fecha_entrega_ped,
                    fecha_solicitud_ped);

        } catch (SQLException ex) {
            Logger.getLogger(CamionController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NamingException ex) {
            Logger.getLogger(CamionController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return transaccionCorrecta;
    }

    public boolean updatePedido() {
        boolean transaccionCorrecta = false;
        try {
            transaccionCorrecta = pedidoService.actualizarPedido(cod_ped,
                    cod_cli,
           
                    rut_usu,
                    tipo_ped,
                    cantidad_ped,
                    observacion_ped,
                    prioridad_ped,
                    fecha_entrega_ped,
                    fecha_solicitud_ped);

        } catch (SQLException ex) {
            Logger.getLogger(CamionController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NamingException ex) {
            Logger.getLogger(CamionController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return transaccionCorrecta;
    }

    public List<Pedido> obtenerPedidos() {
        return pedidoService.seleccionarTodosLosPedido();
    }

    public boolean deletePedido() {
        return pedidoService.eliminarPedido(cod_ped);
    }

    public String seleccionarPedido(Pedido pedido) {
        Pedido c = pedidoService.seleccionarPedido(pedido.getCod_ped());
        if (c != null) {


            cod_cli = c.getCod_cli();
        
            rut_usu = c.getRut_usu();
            tipo_ped = c.getTipo_ped();
            cantidad_ped = c.getCantidad_ped();
            observacion_ped = c.getObservacion_ped();
            prioridad_ped = c.getPrioridad_ped();
            fecha_entrega_ped = c.getFecha_entrega_ped();
            fecha_solicitud_ped = c.getFecha_solicitud_ped();

            return "encontrado";
        } else {
            return "no_encontrado";
        }
    }
}
