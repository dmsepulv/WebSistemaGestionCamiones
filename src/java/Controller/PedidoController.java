/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Entity.Pedido;
import Model.Entity.Cliente;
import Model.Service.PedidoService;
import Model.Service.RutaService;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
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
    private @Inject
    RutaService rutaService;
    @ManagedProperty(value = "#{cliente}")
    private ClienteController clienteController;
    @ManagedProperty(value = "#{login}")
    private LoginController loginController;
    @ManagedProperty(value = "#{ruta}")
    private RutaController rutaController;
    private String cod_cli;
    private int cod_ped;
    private int cod_com_ini;
    private int cod_com_dest;
    private String rut_usu;
    private String tipo_ped;
    private int cantidad_ped;
    private String observacion_ped;
    private String prioridad_ped;
    private java.util.Date fecha_entrega_ped;
    private java.util.Date fecha_solicitud_ped;
    private int codigoRuta;

    public PedidoController() {
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

    public ClienteController getClienteController() {
        return clienteController;
    }

    public void setClienteController(ClienteController clienteController) {
        this.clienteController = clienteController;
    }

    public int getCod_com_ini() {
        return cod_com_ini;
    }

    public void setCod_com_ini(int cod_com_ini) {
        this.cod_com_ini = cod_com_ini;
    }

    public int getCod_com_dest() {
        return cod_com_dest;
    }

    public int getCodigoRuta() {
        return codigoRuta;
    }

    public void setCodigoRuta(int codigoRuta) {
        this.codigoRuta = codigoRuta;
    }

    public void setCod_com_dest(int cod_com_dest) {
        this.cod_com_dest = cod_com_dest;
    }

    public LoginController getLoginController() {
        return loginController;
    }

    public void setLoginController(LoginController loginController) {
        this.loginController = loginController;
    }

    public PedidoService getPedidoService() {
        return pedidoService;
    }

    public void setPedidoService(PedidoService pedidoService) {
        this.pedidoService = pedidoService;
    }

    public RutaController getRutaController() {
        return rutaController;
    }

    public void setRutaController(RutaController rutaController) {
        this.rutaController = rutaController;
    }

    public String cancelarPedido() {
        clienteController.clean();
        cod_cli = null;
        rut_usu = null;
        tipo_ped = null;
        cantidad_ped = 0;
        observacion_ped = null;
        prioridad_ped = null;
        fecha_entrega_ped = null;
        fecha_solicitud_ped = null;
        return "pedidoCancelado";

    }

    public boolean savePedido() {
        boolean transaccionCorrecta = false;
        if (!clienteController.isClienteEncontrado()) {
            clienteController.saveCliente();
        }
        try {
            int cod_ruta = rutaService.guardarRuta(cod_com_ini, cod_com_dest);
            if (cod_ruta > -1) {
                transaccionCorrecta = pedidoService.guardarPedido(
                        clienteController.getCod_cli(),
                        loginController.getRut(),
                        tipo_ped,
                        cantidad_ped,
                        observacion_ped,
                        "ALTA",
                        fecha_entrega_ped,
                        fecha_solicitud_ped,
                        cod_ruta);

            }
        } catch (SQLException ex) {
            Logger.getLogger(PedidoController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NamingException ex) {
            Logger.getLogger(PedidoController.class.getName()).log(Level.SEVERE, null, ex);
        }
        clienteController.clean();
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
            cod_ped=c.getCod_ped();
            cod_cli = c.getCod_cli();
            rut_usu = c.getRut_usu();
            tipo_ped = c.getTipo_ped();
            cantidad_ped = c.getCantidad_ped();
            observacion_ped = c.getObservacion_ped();
            prioridad_ped = c.getPrioridad_ped();
            fecha_entrega_ped = c.getFecha_entrega_ped();
            fecha_solicitud_ped = c.getFecha_solicitud_ped();
            codigoRuta = c.getCod_ruta();
            rutaController.seleccionarRuta(codigoRuta);
            Cliente cliente = new Cliente();
            cliente.setCodCli(cod_cli);
            clienteController.seleccionarClienteParaSeleccionPedido(cliente);
            return "encontrado";
        } else {
            return "no_encontrado";
        }
    }
    
    public String seleccionarPedidoPorID() {
        Pedido c = pedidoService.seleccionarPedido(cod_ped);
        if (c != null) {
            cod_ped=c.getCod_ped();
            cod_cli = c.getCod_cli();
            rut_usu = c.getRut_usu();
            tipo_ped = c.getTipo_ped();
            cantidad_ped = c.getCantidad_ped();
            observacion_ped = c.getObservacion_ped();
            prioridad_ped = c.getPrioridad_ped();
            fecha_entrega_ped = c.getFecha_entrega_ped();
            fecha_solicitud_ped = c.getFecha_solicitud_ped();
            codigoRuta = c.getCod_ruta();
            rutaController.seleccionarRuta(codigoRuta);
            Cliente cliente = new Cliente();
            cliente.setCodCli(cod_cli);
            clienteController.seleccionarClienteParaSeleccionPedido(cliente);
            return "encontrado";
        } else {
            return "no_encontrado";
        }
    }
}
