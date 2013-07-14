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
public class ViajeDaoImpl extends Conexion implements ViajeDao {

    public boolean insertViaje(
            int cod_via,
            int cod_ruta,
            String patente_cam,
            String rut_cho,
            Date fecha_carga_via,
            Date fecha_descarga_via) throws SQLException, NamingException {

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
        stb.append("INSERT INTO \"VIAJE\"");
        stb.append("       (cod_via , ");
         stb.append("       (cod_ruta , ");
        stb.append("       patente_cam , ");
        stb.append("       rut_cho , ");
        stb.append("       fecha_carga_via,  ");
        stb.append("       fecha_descarga_via)  ");
        stb.append(" values ( ? , ? , ? , ? , ? , ? , ? , ? , ?) ;");
        PreparedStatement query = conn.prepareStatement(stb.toString());

        query.setInt(1, cod_via);
        query.setInt(2, cod_ruta);
        query.setString(3, patente_cam);
        query.setString(4, rut_cho);
        query.setDate(8, new java.sql.Date(fecha_carga_via.getTime()));
        query.setDate(9, new java.sql.Date(fecha_descarga_via.getTime()));

        query.executeUpdate();

        transaccionCorrecta = true;
        return transaccionCorrecta;
    }

    public Object selectViaje(int cod_via) throws SQLException, NamingException {

        LinkedList<Object> datosViaje = null;

        DataSource sgc_connection = getSgc_connection();
        if (sgc_connection == null) {
            throw new SQLException("No data source");
        }
        Connection conn = sgc_connection.getConnection();
        if (conn == null) {
            throw new SQLException("No connection");
        }

        StringBuilder stb = new StringBuilder();
        stb.append(" SELECT cod_via , ");
        stb.append("       cod_ruta , ");
        stb.append("       patente_cam , ");
        stb.append("       rut_cho , ");
        stb.append("       fecha_carga_via,  ");
        stb.append("       fecha_descarga_via)  ");
        stb.append(" FROM  \"VIAJE\"  ");
        stb.append(" WHERE cod_via = ? ; ");

        PreparedStatement query = conn.prepareStatement(stb.toString());
        query.setInt(1, cod_via);
        ResultSet rs = query.executeQuery();

        if (rs.next()) {
            datosViaje = new LinkedList<Object>();
            datosViaje.add(rs.getInt("cod_via"));
            datosViaje.add(rs.getInt("cod_ruta"));
            datosViaje.add(rs.getString("patente_cam"));
            datosViaje.add(rs.getString("rut_cho"));
            datosViaje.add(rs.getDate("fecha_carga_via"));
            datosViaje.add(rs.getDate("fecha_descarga_via"));
        }

        conn.close();

        return datosViaje;
    }

    public Object selectAllViaje() throws SQLException, NamingException {
        LinkedList<Object> viajes = null;

        DataSource sgc_connection = getSgc_connection();
        if (sgc_connection == null) {
            throw new SQLException("No data source");
        }
        Connection conn = sgc_connection.getConnection();
        if (conn == null) {
            throw new SQLException("No connection");
        }

        StringBuilder stb = new StringBuilder();
        stb.append(" SELECT cod_via , ");
        stb.append("       cod_ruta , ");
        stb.append("       patente_cam , ");
        stb.append("       rut_cho , ");
        stb.append("       fecha_carga_via,  ");
        stb.append("       fecha_descarga_via)  ");
        stb.append(" FROM  \"VIAJE\"  ");

        PreparedStatement query = conn.prepareStatement(stb.toString());
        ResultSet rs = query.executeQuery();
        if (rs.next()) {
            viajes = new LinkedList<Object>();
            do {
                ArrayList<Object> datosViaje = new ArrayList<Object>();
                datosViaje.add(rs.getInt("cod_via"));
                datosViaje.add(rs.getInt("cod_ruta"));
                datosViaje.add(rs.getString("patente_cam"));
                datosViaje.add(rs.getString("rut_cho"));
                datosViaje.add(rs.getDate("fecha_carga_via"));
                datosViaje.add(rs.getDate("fecha_descarga_via"));
                viajes.add(datosViaje);
            } while (rs.next());
        }

        conn.close();

        return viajes;
    }

    public boolean updateViaje(
            int cod_via,
            int cod_ruta,
            String patente_cam,
            String rut_cho,
            Date fecha_carga_via,
            Date fecha_descarga_via) throws SQLException, NamingException {
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
        stb.append("UPDATE \"VIAJE\" ");
        stb.append("SET     cod_via = ? , ");
        stb.append("        cod_ruta = ? , ");
        stb.append("        patente_cam = ? , ");
        stb.append("        rut_cho = ? , ");
        stb.append("        fecha_carga_via = ? , ");
        stb.append("        fecha_descarga_via = ?  ");
        stb.append("WHERE   cod_via = ? ;  ");
        PreparedStatement query = conn.prepareStatement(stb.toString());

        query.setInt(1, cod_via);
        query.setInt(2, cod_ruta);
        query.setString(3, patente_cam);
        query.setString(4, rut_cho);
        query.setDate(5, new java.sql.Date(fecha_carga_via.getTime()));
        query.setDate(6, new java.sql.Date(fecha_descarga_via.getTime()));

        query.executeUpdate();
        transaccionCorrecta = true;
        conn.close();

        return transaccionCorrecta;
    }

    public boolean deleteViaje(int cod_via) throws SQLException, NamingException {

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
        stb.append("DELETE  FROM \"VIAJE\" ");
        stb.append("WHERE  cod_via = ? ;  ");
        PreparedStatement query = conn.prepareStatement(stb.toString());
        query.setInt(1, cod_via);
        query.executeUpdate();
        transaccionCorrecta = true;
        conn.close();
        return transaccionCorrecta;
    }

    
    
	
}
