/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Service;

import Model.Dao.PedidoDao;
import Model.Entity.Pedido;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.inject.Inject;
import javax.naming.NamingException;

/**
 *
 * @author darwin
 */
public class PedidoServiceImpl implements PedidoService {

    private @Inject
    PedidoDao pedidoDao;

    @Override
    public boolean guardarPedido(
            String cod_cli,
            String rut_usu,
            String tipo_ped,
            int cantidad_ped,
            String observacion_ped,
            String prioridad_ped,
            Date fecha_entrega_ped,
            Date fecha_solicitud_ped,
            int cod_ruta) throws SQLException, NamingException {

        return pedidoDao.insertPedido(
                cod_cli,
                rut_usu,
                tipo_ped,
                cantidad_ped,
                observacion_ped,
                prioridad_ped,
                fecha_entrega_ped,
                fecha_solicitud_ped,
                cod_ruta);
    }

    @Override
    public Pedido seleccionarPedido(int cod_ped) {
        Pedido pedido = null;
        try {
            LinkedList<Object> datosPedido = (LinkedList<Object>) pedidoDao.selectPedido(cod_ped);
            if (datosPedido != null) {
                pedido = new Pedido();
                pedido.setCod_ped((Integer) datosPedido.get(0));
                pedido.setCod_cli((String) datosPedido.get(1));
                pedido.setRut_usu((String) datosPedido.get(2));
                pedido.setTipo_ped((String) datosPedido.get(3));
                pedido.setCantidad_ped((Integer) datosPedido.get(4));
                pedido.setObservacion_ped((String) datosPedido.get(5));
                pedido.setPrioridad_ped((String) datosPedido.get(6));
                pedido.setFecha_entrega_ped((Date) datosPedido.get(7));
                pedido.setFecha_solicitud_ped((Date) datosPedido.get(8));
            }
        } catch (SQLException ex) {
            Logger.getLogger(CamionServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NamingException ex) {
            Logger.getLogger(CamionServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            return pedido;
        }

    }

    @Override
    public LinkedList<Pedido> seleccionarTodosLosPedido() {
        Pedido pedido;
        LinkedList<Pedido> pedidoRetorno = null;
        LinkedList<Object> pedidos;
        try {
            pedidos = (LinkedList<Object>) pedidoDao.selectAllPedido();
            if (pedidos != null) {
                pedidoRetorno = new LinkedList<Pedido>();
                for (int i = 0; i < pedidos.size(); i++) {
                    ArrayList<Object> datosPedido = (ArrayList<Object>) pedidos.get(i);
                    pedido = new Pedido();
                    pedido.setCod_ped((Integer) datosPedido.get(0));
                    pedido.setCod_cli((String) datosPedido.get(1));
                    pedido.setRut_usu((String) datosPedido.get(2));
                    pedido.setTipo_ped((String) datosPedido.get(3));
                    pedido.setCantidad_ped((Integer) datosPedido.get(4));
                    pedido.setObservacion_ped((String) datosPedido.get(5));
                    pedido.setPrioridad_ped((String) datosPedido.get(6));
                    pedido.setFecha_entrega_ped((Date) datosPedido.get(7));
                    pedido.setFecha_solicitud_ped((Date) datosPedido.get(8));
                    pedidoRetorno.add(pedido);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(CamionServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NamingException ex) {
            Logger.getLogger(CamionServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return pedidoRetorno;

    }

    @Override
    public boolean actualizarPedido(
            int cod_ped,
            String cod_cli,
            String rut_usu,
            String tipo_ped,
            int cantidad_ped,
            String observacion_ped,
            String prioridad_ped,
            Date fecha_entrega_ped,
            Date fecha_solicitud_ped) throws SQLException, NamingException {

        return pedidoDao.updatePedido(
                cod_ped,
                cod_cli,
                rut_usu,
                tipo_ped,
                cantidad_ped,
                observacion_ped,
                prioridad_ped,
                fecha_entrega_ped,
                fecha_solicitud_ped);
    }

    @Override
    public boolean eliminarPedido(int cod_ped) {
        boolean transaccionCorrecta = false;
        try {
            transaccionCorrecta = pedidoDao.deletePedido(cod_ped);
        } catch (SQLException ex) {
            Logger.getLogger(CamionServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NamingException ex) {
            Logger.getLogger(CamionServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return transaccionCorrecta;
    }
}
