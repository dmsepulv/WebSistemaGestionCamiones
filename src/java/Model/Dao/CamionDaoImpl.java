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
import java.util.LinkedList;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 *
 * @author darwin
 */
public class CamionDaoImpl extends Conexion implements CamionDao {

    @Override
    public boolean insertCamion(String patente_cam,
            int capacidad_cam,
            String estado_cam,
            int anio_adq_cam,
            int costo_adq_cam,
            int anio_elab_cam) throws SQLException, NamingException {

        boolean transaccionCorrecta = false;
        Connection conn = getConnection();
        if (conn == null) {
            throw new SQLException("No connection");
        }
        StringBuilder stb = new StringBuilder();
        stb.append("INSERT INTO \"CAMION\"");
        stb.append("       (patente_cam , ");
        stb.append("       capacidad_cam , ");
        stb.append("       estado_cam , ");
        stb.append("       anio_adq_cam , ");
        stb.append("       costo_adq_cam , ");
        stb.append("       anio_elab_cam)  ");
        stb.append(" values ( ? , ? , ? , ? , ? , ? ) ;");
        PreparedStatement query = conn.prepareStatement(stb.toString());

        query.setString(1, patente_cam);
        query.setInt(2, capacidad_cam);
        query.setString(3, estado_cam);
        query.setInt(4, anio_adq_cam);
        query.setInt(5, costo_adq_cam);
        query.setInt(6, anio_elab_cam);
        query.executeUpdate();

        transaccionCorrecta = true;
        return transaccionCorrecta;
    }

    @Override
    public Object selectCamion(String patente_cam) throws SQLException, NamingException {

        LinkedList<Object> datosCamion = null;
        
        Connection conn = getConnection();
        if (conn == null) {
            throw new SQLException("No connection");
        }

        StringBuilder stb = new StringBuilder();
        stb.append(" SELECT patente_cam , ");
        stb.append("       capacidad_cam , ");
        stb.append("       estado_cam , ");
        stb.append("       anio_adq_cam , ");
        stb.append("       costo_adq_cam , ");
        stb.append("       anio_elab_cam  ");
        stb.append(" FROM  \"CAMION\"  ");
        stb.append(" WHERE patente_cam = ? ; ");

        PreparedStatement query = conn.prepareStatement(stb.toString());
        query.setString(1, patente_cam);
        ResultSet rs = query.executeQuery();

        if (rs.next()) {
            datosCamion = new LinkedList<Object>();
            datosCamion.add(rs.getString("patente_cam"));
            datosCamion.add(rs.getString("estado_cam"));
            datosCamion.add(rs.getInt("capacidad_cam"));
            datosCamion.add(rs.getInt("anio_adq_cam"));
            datosCamion.add(rs.getInt("costo_adq_cam"));
            datosCamion.add(rs.getInt("anio_elab_cam"));
        }

        conn.close();

        return datosCamion;
    }

    @Override
    public Object selectAllCamion() throws SQLException, NamingException {
        LinkedList<Object> camiones = null;
        
        Connection conn = getConnection();
        if (conn == null) {
            throw new SQLException("No connection");
        }

        StringBuilder stb = new StringBuilder();
        stb.append("SELECT patente_cam , ");
        stb.append("       capacidad_cam , ");
        stb.append("       estado_cam , ");
        stb.append("       anio_adq_cam , ");
        stb.append("       costo_adq_cam , ");
        stb.append("       anio_elab_cam  ");
        stb.append("FROM  \"CAMION\" ; ");

        PreparedStatement query = conn.prepareStatement(stb.toString());
        ResultSet rs = query.executeQuery();
        if (rs.next()) {
            camiones = new LinkedList<Object>();
            do {
                ArrayList<Object> datosCamion = new ArrayList<Object>();
                datosCamion.add(rs.getString("patente_cam"));
                datosCamion.add(rs.getString("estado_cam"));
                datosCamion.add(rs.getInt("capacidad_cam"));
                datosCamion.add(rs.getInt("anio_adq_cam"));
                datosCamion.add(rs.getInt("costo_adq_cam"));
                datosCamion.add(rs.getInt("anio_elab_cam"));
                camiones.add(datosCamion);
            } while (rs.next());
        }

        conn.close();

        return camiones;
    }

    @Override
    public boolean updateCamion(String patente_cam,
            int capacidad_cam,
            String estado_cam,
            int anio_adq_cam,
            int costo_adq_cam,
            int anio_elab_cam) throws SQLException, NamingException {
        boolean transaccionCorrecta = false;
        Connection conn = getConnection();
        if (conn == null) {
            throw new SQLException("No connection");
        }
        StringBuilder stb = new StringBuilder();
        stb.append("UPDATE \"CAMION\" ");
        stb.append("SET     capacidad_cam = ? , ");
        stb.append("        estado_cam = ? , ");
        stb.append("        anio_adq_cam = ? , ");
        stb.append("        costo_adq_cam = ? , ");
        stb.append("        anio_elab_cam = ?  ");
        stb.append("WHERE   patente_cam = ? ;  ");
        PreparedStatement query = conn.prepareStatement(stb.toString());
        query.setInt(1, capacidad_cam);
        query.setString(2, estado_cam);
        query.setInt(3, anio_adq_cam);
        query.setInt(4, costo_adq_cam);
        query.setInt(5, anio_elab_cam);
        query.setString(6, patente_cam);
        query.executeUpdate();
        transaccionCorrecta = true;
        conn.close();

        return transaccionCorrecta;
    }

    @Override
    public boolean deleteCamion(String patente_cam) throws SQLException, NamingException {

        boolean transaccionCorrecta = false;
        Connection conn = getConnection();
        if (conn == null) {
            throw new SQLException("No connection");
        }
        StringBuilder stb = new StringBuilder();
        stb.append("DELETE  FROM \"CAMION\" ");
        stb.append("WHERE  patente_cam = ? ;  ");
        PreparedStatement query = conn.prepareStatement(stb.toString());
        query.setString(1, patente_cam);
        query.executeUpdate();
        transaccionCorrecta = true;
        conn.close();
        return transaccionCorrecta;
    }
}
