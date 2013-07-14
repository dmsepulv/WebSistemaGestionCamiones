/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Service;

import Model.Entity.Pedido;
import java.sql.SQLException;
import java.util.Date;
import java.util.LinkedList;
import javax.naming.NamingException;

/**
 *
 * @author darwin
 */
public interface PedidoService {
    
    public boolean guardarPedido(int cod_ped,
            String cod_cli,
            String rut_usu,
            String tipo_ped,
            int cantidad_ped,
            String observacion_ped,
            String prioridad_ped,
            Date fecha_entrega_ped,
            Date fecha_solicitud_ped) throws SQLException, NamingException;
    
    public Pedido seleccionarPedido(int cod_ped);
    
    public LinkedList<Pedido> seleccionarTodosLosPedido();
    
    public boolean actualizarPedido(int cod_ped,
            String cod_cli,
            String rut_usu,
            String tipo_ped,
            int cantidad_ped,
            String observacion_ped,
            String prioridad_ped,
            Date fecha_entrega_ped,
            Date fecha_solicitud_ped) throws SQLException, NamingException;
    
    
    public boolean eliminarPedido(int cod_ped);
}
