/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Dao;

import java.sql.SQLException;
import java.util.Date;
import javax.naming.NamingException;

/**
 *
 * @author darwin
 */
public interface PedidoDao {

    public boolean insertPedido(
            String cod_cli,
            String rut_usu,
            String tipo_ped,
            int cantidad_ped,
            String observacion_ped,
            String prioridad_ped,
            Date fecha_entrega_ped,
            Date fecha_solicitud_ped,
            int cod_ruta) throws SQLException, NamingException;

    public Object selectPedido(int cod_ped) throws SQLException, NamingException;

    public Object selectAllPedido() throws SQLException, NamingException;

    public boolean updatePedido(
            int cod_ped,
            String cod_cli,
            String rut_usu,
            String tipo_ped,
            int cantidad_ped,
            String observacion_ped,
            String prioridad_ped,
            Date fecha_entrega_ped,
            Date fecha_solicitud_ped) throws SQLException, NamingException;

    public boolean deletePedido(int cod_ped) throws SQLException, NamingException;
}
