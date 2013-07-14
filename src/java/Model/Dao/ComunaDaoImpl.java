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
public class ComunaDaoImpl extends Conexion implements ComunaDao {

    @Override
    public Object selectAllComuna() throws SQLException, NamingException {
        LinkedList<Object> comuna = null;

        DataSource sgc_connection = getSgc_connection();
        if (sgc_connection == null) {
            throw new SQLException("No data source");
        }
        Connection conn = sgc_connection.getConnection();
        if (conn == null) {
            throw new SQLException("No connection");
        }

        StringBuilder stb = new StringBuilder();
        stb.append("SELECT cod_com , ");
        stb.append("       cod_reg , ");
        stb.append("       nombre_com ");
        stb.append("FROM  \"COMUNA\" ; ");

        PreparedStatement query = conn.prepareStatement(stb.toString());
        ResultSet rs = query.executeQuery();
        if (rs.next()) {
            comuna = new LinkedList<Object>();
            do {
                ArrayList<Object> datosComuna = new ArrayList<Object>();
                datosComuna.add(rs.getInt("cod_com"));
                datosComuna.add(rs.getInt("cod_reg"));
                datosComuna.add(rs.getString("nombre_com"));
                comuna.add(datosComuna);
            } while (rs.next());
        }

        conn.close();

        return comuna;
    }
}
