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
public class ChoferDaoImpl extends Conexion implements ChoferDao {

    @Override
    public boolean insertChofer(
            String rutCho,
            String nombreCho,
            String aparternoCho,
            String amaternoCho,
            Date fnacCho,
            Integer experienciaCho,
            String tipoLicenciaCho,
            Date expirLicenciaCho) throws SQLException, NamingException {

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

        stb.append("INSERT INTO \"CHOFER\"");
        stb.append("       (rut_cho , ");
        stb.append("       nombre_cho , ");
        stb.append("       apaterno_cho , ");
        stb.append("       amaterno_cho , ");
        stb.append("       fnac_cho , ");
        stb.append("       experiencia_cho , ");
        stb.append("       tipo_licencia_cho , ");
        stb.append("       expir_licencia_cho)  ");
        stb.append(" values ( ? , ? , ? , ? , ? , ? , ? , ?) ;");

        PreparedStatement query = conn.prepareStatement(stb.toString());

        query.setString(1, rutCho);
        query.setString(2, nombreCho);
        query.setString(3, aparternoCho);
        query.setString(4, amaternoCho);
        query.setDate(5, new java.sql.Date(fnacCho.getTime()));
        query.setInt(6, experienciaCho);
        query.setString(7, tipoLicenciaCho);
        query.setDate(8, new java.sql.Date(expirLicenciaCho.getTime()));
        query.executeUpdate();
        transaccionCorrecta = true;

        return transaccionCorrecta;
    }

    @Override
    public Object selectChofer(String rutCho) throws SQLException, NamingException {

        LinkedList<Object> datosChofer = null;

        DataSource sgc_connection = getSgc_connection();
        if (sgc_connection == null) {
            throw new SQLException("No data source");
        }
        Connection conn = sgc_connection.getConnection();
        if (conn == null) {
            throw new SQLException("No connection");
        }
        StringBuilder stb = new StringBuilder();
        stb.append(" SELECT rut_cho , ");
        stb.append("        nombre_cho , ");
        stb.append("        apaterno_cho , ");
        stb.append("        amaterno_cho , ");
        stb.append("        fnac_cho , ");
        stb.append("        experiencia_cho , ");
        stb.append("        tipo_licencia_cho , ");
        stb.append("        expir_licencia_cho  ");
        stb.append(" FROM   \"CHOFER\"  ");
        stb.append(" WHERE  rut_cho = ? ; ");

        PreparedStatement query = conn.prepareStatement(stb.toString());
        query.setString(1, rutCho);
        ResultSet rs = query.executeQuery();

        if (rs.next()) {
            datosChofer = new LinkedList<Object>();
            datosChofer.add(rs.getString("rut_cho"));
            datosChofer.add(rs.getString("nombre_cho"));
            datosChofer.add(rs.getString("apaterno_cho"));
            datosChofer.add(rs.getString("amaterno_cho"));
            datosChofer.add(rs.getDate("fnac_cho"));
            datosChofer.add(rs.getString("experiencia_cho"));
            datosChofer.add(rs.getString("tipo_licencia_cho"));
            datosChofer.add(rs.getDate("expir_licencia_cho"));
        }
        conn.close();
        return datosChofer;

    }

    @Override
    public Object selectAllChofer() throws SQLException, NamingException {

        LinkedList<Object> choferes = null;

        DataSource sgc_connection = getSgc_connection();
        if (sgc_connection == null) {
            throw new SQLException("No data source");
        }
        Connection conn = sgc_connection.getConnection();
        if (conn == null) {
            throw new SQLException("No connection");
        }
        StringBuilder stb = new StringBuilder();
        stb.append(" SELECT rut_cho , ");
        stb.append("        nombre_cho , ");
        stb.append("        apaterno_cho , ");
        stb.append("        amaterno_cho , ");
        stb.append("        fnac_cho , ");
        stb.append("        experiencia_cho , ");
        stb.append("        tipo_licencia_cho , ");
        stb.append("        expir_licencia_cho  ");
        stb.append(" FROM   \"CHOFER\"  ");
        stb.append(" ORDER BY   apaterno_cho,  ");
        stb.append("            expir_licencia_cho asc  ");

        PreparedStatement query = conn.prepareStatement(stb.toString());
        ResultSet rs = query.executeQuery();
        if (rs.next()) {
            choferes = new LinkedList<Object>();
            do {
                ArrayList<Object> datosChofer = new ArrayList<Object>();
                datosChofer.add(rs.getString("rut_cho"));
                datosChofer.add(rs.getString("nombre_cho"));
                datosChofer.add(rs.getString("apaterno_cho"));
                datosChofer.add(rs.getString("amaterno_cho"));
                datosChofer.add(rs.getDate("fnac_cho"));
                datosChofer.add(rs.getString("experiencia_cho"));
                datosChofer.add(rs.getString("tipo_licencia_cho"));
                datosChofer.add(rs.getDate("expir_licencia_cho"));

                choferes.add(datosChofer);
            } while (rs.next());
        }
        conn.close();
        return choferes;

    }

    @Override
    public boolean updateChofer(String rutCho,
            String nombreCho,
            String aparternoCho,
            String amaternoCho,
            Date fnacCho,
            Integer experienciaCho,
            String tipoLicenciaCho,
            Date expirLicenciaCho) throws SQLException, NamingException {

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
        stb.append("UPDATE \"CAMION\" ");
        stb.append("SET     nombre_cho = ? , ");
        stb.append("        apaterno_cho = ? , ");
        stb.append("        amaterno_cho = ? , ");
        stb.append("        fnac_cho = ?  ");
        stb.append("        experiencia_cho = ?  ");
        stb.append("        tipo_licencia_cho = ?  ");
        stb.append("        expir_licencia_cho = ?  ");
        stb.append("WHERE   rut_cho = ? ;  ");

        PreparedStatement query = conn.prepareStatement(stb.toString());
        query.setString(1, nombreCho);
        query.setString(2, aparternoCho);
        query.setString(3, amaternoCho);
        query.setDate(4, new java.sql.Date(fnacCho.getTime()));
        query.setInt(5, experienciaCho);
        query.setString(6, tipoLicenciaCho);
        query.setDate(7, new java.sql.Date(expirLicenciaCho.getTime()));
        query.setString(8, rutCho);
        query.executeUpdate();
        transaccionCorrecta = true;
        conn.close();
        return transaccionCorrecta;

    }

    @Override
    public boolean deleteChofer(String rutCho) throws SQLException, NamingException {

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
        stb.append("DELETE  FROM \"CHOFER\" ");
        stb.append("WHERE  rut_cho = ? ;  ");
        PreparedStatement query = conn.prepareStatement(stb.toString());
        query.setString(1, rutCho);
        query.executeUpdate();
        transaccionCorrecta = true;
        conn.close();
        return transaccionCorrecta;

    }
}
