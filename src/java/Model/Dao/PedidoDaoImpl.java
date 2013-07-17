/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Dao;

import Util.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 *
 * @author darwin
 */
public class PedidoDaoImpl extends Conexion implements PedidoDao {

    @Override
    public boolean insertPedido(
            String cod_cli,
            String rut_usu,
            String tipo_ped,
            int cantidad_ped,
            String observacion_ped,
            String prioridad_ped,
            Date fecha_entrega_ped,
            Date fecha_solicitud_ped,
            int cod_ruta) throws SQLException, NamingException {

        boolean transaccionCorrecta = false;
        DataSource sgc_connection = getSgc_connection();
        if (sgc_connection == null) {
            throw new SQLException("No data source");
        }
        Connection conn = sgc_connection.getConnection();
        if (conn == null) {
            throw new SQLException("No connection");
        }
        StringBuilder stb = new StringBuilder();
        stb.append("INSERT INTO \"PEDIDO\"");
        stb.append("       (cod_cli , ");
        stb.append("       rut_usu , ");
        stb.append("       tipo_ped , ");
        stb.append("       cantidad_ped , ");
        stb.append("       observacion_ped,  ");
        stb.append("       prioridad_ped,  ");
        stb.append("       fecha_entrega_ped,  ");
        stb.append("       fecha_solicitud_ped,  ");
        stb.append("       cod_ruta)  ");
        stb.append(" values ( ? , ? , ? , ? , ? , ? , ? , ?, ?) ;");
        PreparedStatement query = conn.prepareStatement(stb.toString());

        query.setString(1, cod_cli);
        query.setString(2, rut_usu);
        query.setString(3, tipo_ped);
        query.setInt(4, cantidad_ped);
        query.setString(5, observacion_ped);
        query.setString(6, prioridad_ped);
        query.setDate(7,new java.sql.Date(fecha_entrega_ped.getTime()));
        query.setDate(8, new java.sql.Date(fecha_solicitud_ped.getTime()));
        query.setInt(9, cod_ruta);
        query.executeUpdate();

        transaccionCorrecta = true;
        return transaccionCorrecta;
    }

    @Override
    public Object selectPedido(int cod_ped) throws SQLException, NamingException {

        LinkedList<Object> datosPedido = null;

        DataSource sgc_connection = getSgc_connection();
        if (sgc_connection == null) {
            throw new SQLException("No data source");
        }
        Connection conn = sgc_connection.getConnection();
        if (conn == null) {
            throw new SQLException("No connection");
        }

        StringBuilder stb = new StringBuilder();
        stb.append(" SELECT cod_ped , ");
        stb.append("       cod_cli , ");
        stb.append("       rut_usu , ");
        stb.append("       tipo_ped , ");
        stb.append("       cantidad_ped , ");
        stb.append("       observacion_ped,  ");
        stb.append("       prioridad_ped,  ");
        stb.append("       fecha_entrega_ped,  ");
        stb.append("       fecha_solicitud_ped,  ");
        stb.append("       cod_ruta  ");
        stb.append(" FROM  \"PEDIDO\"  ");
        stb.append(" WHERE cod_ped = ? ; ");

        PreparedStatement query = conn.prepareStatement(stb.toString());
        query.setInt(1, cod_ped);
        ResultSet rs = query.executeQuery();

        if (rs.next()) {
            datosPedido = new LinkedList<Object>();
            datosPedido.add(rs.getInt("cod_ped"));
            datosPedido.add(rs.getString("cod_cli"));
            datosPedido.add(rs.getString("rut_usu"));
            datosPedido.add(rs.getString("tipo_ped"));
            datosPedido.add(rs.getInt("cantidad_ped"));
            datosPedido.add(rs.getString("observacion_ped"));
            datosPedido.add(rs.getString("prioridad_ped"));
            datosPedido.add(rs.getDate("fecha_entrega_ped"));
            datosPedido.add(rs.getDate("fecha_solicitud_ped"));
            datosPedido.add(rs.getInt("cod_ruta"));
        }

        conn.close();

        return datosPedido;
    }

    @Override
    public Object selectAllPedido() throws SQLException, NamingException {
        LinkedList<Object> pedidos = null;

        DataSource sgc_connection = getSgc_connection();
        if (sgc_connection == null) {
            throw new SQLException("No data source");
        }
        Connection conn = sgc_connection.getConnection();
        if (conn == null) {
            throw new SQLException("No connection");
        }

        StringBuilder stb = new StringBuilder();
        stb.append(" SELECT cod_ped , ");
        stb.append("       cod_cli , ");
        stb.append("       rut_usu , ");
        stb.append("       tipo_ped , ");
        stb.append("       cantidad_ped , ");
        stb.append("       observacion_ped,  ");
        stb.append("       prioridad_ped,  ");
        stb.append("       fecha_entrega_ped,  ");
        stb.append("       fecha_solicitud_ped  ");
        stb.append(" FROM  \"PEDIDO\"  ");

        PreparedStatement query = conn.prepareStatement(stb.toString());
        ResultSet rs = query.executeQuery();
        if (rs.next()) {
            pedidos = new LinkedList<Object>();
            do {
                ArrayList<Object> datosPedido = new ArrayList<Object>();
                datosPedido.add(rs.getInt("cod_ped"));
                datosPedido.add(rs.getString("cod_cli"));
                datosPedido.add(rs.getString("rut_usu"));
                datosPedido.add(rs.getString("tipo_ped"));
                datosPedido.add(rs.getInt("cantidad_ped"));
                datosPedido.add(rs.getString("observacion_ped"));
                datosPedido.add(rs.getString("prioridad_ped"));
                datosPedido.add(rs.getDate("fecha_entrega_ped"));
                datosPedido.add(rs.getDate("fecha_solicitud_ped"));
                pedidos.add(datosPedido);
            } while (rs.next());
        }

        conn.close();

        return pedidos;
    }

    @Override
    public boolean updatePedido(
            int cod_ped,
            String cod_cli,
            String rut_usu,
            String tipo_ped,
            int cantidad_ped,
            String observacion_ped,
            String prioridad_ped,
            Date fecha_entrega_ped,
            Date fecha_solicitud_ped) throws SQLException, NamingException {
        boolean transaccionCorrecta = false;
        DataSource sgc_connection = getSgc_connection();
        if (sgc_connection == null) {
            throw new SQLException("No data source");
        }
        Connection conn = sgc_connection.getConnection();
        if (conn == null) {
            throw new SQLException("No connection");
        }
        StringBuilder stb = new StringBuilder();
        stb.append("UPDATE \"PEDIDO\" ");
        stb.append("SET     cod_ped = ? , ");
        stb.append("        cod_cli = ? , ");

        stb.append("        rut_usu = ? , ");
        stb.append("        tipo_ped = ? , ");
        stb.append("        cantidad_ped = ? , ");
        stb.append("        observacion_ped = ?  ");
        stb.append("        prioridad_ped = ?  ");
        stb.append("        fecha_entrega_ped = ?  ");
        stb.append("        fecha_solicitud_ped = ?  ");

        stb.append("WHERE   cod_ped = ? ;  ");
        PreparedStatement query = conn.prepareStatement(stb.toString());

        query.setInt(1, cod_ped);
        query.setString(2, cod_cli);

        query.setString(3, rut_usu);
        query.setString(4, tipo_ped);
        query.setInt(5, cantidad_ped);
        query.setString(6, observacion_ped);
        query.setString(7, prioridad_ped);
        query.setDate(8, new java.sql.Date(fecha_entrega_ped.getTime()));
        query.setDate(9, new java.sql.Date(fecha_solicitud_ped.getTime()));

        query.executeUpdate();
        transaccionCorrecta = true;
        conn.close();

        return transaccionCorrecta;
    }

    @Override
    public boolean deletePedido(int cod_ped) throws SQLException, NamingException {

        boolean transaccionCorrecta = false;
        DataSource sgc_connection = getSgc_connection();
        if (sgc_connection == null) {
            throw new SQLException("No data source");
        }
        Connection conn = sgc_connection.getConnection();
        if (conn == null) {
            throw new SQLException("No connection");
        }
        StringBuilder stb = new StringBuilder();
        stb.append("DELETE  FROM \"PEDIDO\" ");
        stb.append("WHERE  cod_ped = ? ;  ");
        PreparedStatement query = conn.prepareStatement(stb.toString());
        query.setInt(1, cod_ped);
        query.executeUpdate();
        transaccionCorrecta = true;
        conn.close();
        return transaccionCorrecta;
    }
}
