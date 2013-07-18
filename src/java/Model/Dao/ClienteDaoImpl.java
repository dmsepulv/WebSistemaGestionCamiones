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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 *
 * @author darwin
 */
public class ClienteDaoImpl extends Conexion implements ClienteDao {

    @Override
    public boolean insertCliente(
            String codCli,
            int codComuna,
            String nombreCli,
            String apaternoCli,
            String amaternoCli,
            String fonoCli,
            String emailCli,
            String direccionCli) throws SQLException, NamingException {

        boolean transaccionCorrecta = false;
        Connection conn = getConnection();
        if (conn == null) {
            throw new SQLException("No connection");
        }

        try {
            StringBuilder stb = new StringBuilder();
            stb.append("INSERT INTO \"CLIENTE\"");
            stb.append("       (cod_cli , ");
            stb.append("       cod_com , ");
            stb.append("       nombre_cli , ");
            stb.append("       apaterno_cli , ");
            stb.append("       amaterno_cli , ");
            stb.append("       telefono_cli,  ");
            stb.append("       mail_cli,  ");
            stb.append("       direccion_cli)  ");
            stb.append(" values ( ? , ? , ? , ? , ? , ? ,? , ? ) ;");
            PreparedStatement query = conn.prepareStatement(stb.toString());

            query.setString(1, codCli);
            query.setInt(2, codComuna);
            query.setString(3, nombreCli);
            query.setString(4, apaternoCli);
            query.setString(5, amaternoCli);
            query.setString(6, fonoCli);
            query.setString(7, emailCli);
            query.setString(8, direccionCli);
            query.executeUpdate();
            transaccionCorrecta = true;

        } catch (SQLException ex) {
            Logger.getLogger(ClienteDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conn.close();
        }
        return transaccionCorrecta;

    }

    @Override
    public Object selectCliente(String cod) throws SQLException, NamingException {

        LinkedList<Object> datosCliente = null;

        Connection conn = getConnection();
        if (conn == null) {
            throw new SQLException("No connection");
        }

        try {
            StringBuilder stb = new StringBuilder();
            stb.append("SELECT \"CLIENTE\".cod_cli , ");
            stb.append("       \"CLIENTE\".cod_com , ");
            stb.append("       \"CLIENTE\".nombre_cli , ");
            stb.append("       \"CLIENTE\".apaterno_cli , ");
            stb.append("       \"CLIENTE\".amaterno_cli , ");
            stb.append("       \"CLIENTE\".telefono_cli,  ");
            stb.append("       \"CLIENTE\".mail_cli,  ");
            stb.append("       \"CLIENTE\".direccion_cli,  ");
            stb.append("       \"COMUNA\".nombre_com ");
            stb.append("FROM   \"CLIENTE\"  ");
            stb.append("       NATURAL JOIN \"COMUNA\" ");
            stb.append("WHERE  \"CLIENTE\".cod_cli = ? ; ");

            PreparedStatement query = conn.prepareStatement(stb.toString());
            query.setString(1, cod);
            ResultSet rs = query.executeQuery();

            if (rs.next()) {
                datosCliente = new LinkedList<Object>();
                datosCliente.add(rs.getString("cod_cli"));
                datosCliente.add(rs.getInt("cod_com"));
                datosCliente.add(rs.getString("nombre_cli"));
                datosCliente.add(rs.getString("apaterno_cli"));
                datosCliente.add(rs.getString("amaterno_cli"));
                datosCliente.add(rs.getString("telefono_cli"));
                datosCliente.add(rs.getString("mail_cli"));
                datosCliente.add(rs.getString("direccion_cli"));
                datosCliente.add(rs.getString("nombre_com"));
            }
        } finally {
            conn.close();
        }
        return datosCliente;
    }

    @Override
    public Object selectAllCliente() throws SQLException, NamingException {

        LinkedList<Object> usuarios = null;

        Connection conn = getConnection();
        if (conn == null) {
            throw new SQLException("No connection");
        }
        try {
            StringBuilder stb = new StringBuilder();
            stb.append("SELECT \"CLIENTE\".cod_cli , ");
            stb.append("       \"CLIENTE\".cod_com , ");
            stb.append("       \"CLIENTE\".nombre_cli , ");
            stb.append("       \"CLIENTE\".apaterno_cli , ");
            stb.append("       \"CLIENTE\".amaterno_cli , ");
            stb.append("       \"CLIENTE\".telefono_cli,  ");
            stb.append("       \"CLIENTE\".mail_cli,  ");
            stb.append("       \"CLIENTE\".direccion_cli,  ");
            stb.append("       \"COMUNA\".nombre_com ");
            stb.append("FROM   \"CLIENTE\"  ");
            stb.append("       NATURAL JOIN \"COMUNA\" ; ");

            PreparedStatement query = conn.prepareStatement(stb.toString());
            ResultSet rs = query.executeQuery();
            if (rs.next()) {
                usuarios = new LinkedList<Object>();
                do {
                    ArrayList<Object> datosCliente = new ArrayList<Object>();
                    datosCliente.add(rs.getString("cod_cli"));
                    datosCliente.add(rs.getInt("cod_com"));
                    datosCliente.add(rs.getString("nombre_cli"));
                    datosCliente.add(rs.getString("apaterno_cli"));
                    datosCliente.add(rs.getString("amaterno_cli"));
                    datosCliente.add(rs.getString("telefono_cli"));
                    datosCliente.add(rs.getString("mail_cli"));
                    datosCliente.add(rs.getString("direccion_cli"));
                    datosCliente.add(rs.getString("nombre_com"));
                    usuarios.add(datosCliente);
                } while (rs.next());
            }
        } finally {
            conn.close();
        }
        return usuarios;
    }

    @Override
    public boolean updateCliente(
            String codCli,
            int codComuna,
            String nombreCli,
            String apaternoCli,
            String amaternoCli,
            String fonoCli,
            String emailCli,
            String direccionCli) throws SQLException, NamingException {

        boolean transaccionCorrecta = false;
        Connection conn = getConnection();
        if (conn == null) {
            throw new SQLException("No connection");
        }

        try {
            StringBuilder stb = new StringBuilder();
            stb.append("UPDATE \"CLIENTE\"");
            stb.append("SET cod_com = ? ,");
            stb.append(" nombre_cli = ? ,");
            stb.append(" apaterno_cli = ? ,");
            stb.append(" amaterno_cli = ? ,");
            stb.append(" telefono_cli = ? ,");
            stb.append(" mail_cli = ? ,");
            stb.append(" direccion_cli = ? ");
            stb.append(" WHERE  cod_cli = ? ;  ");
            PreparedStatement query = conn.prepareStatement(stb.toString());

            query.setInt(1, codComuna);
            query.setString(2, nombreCli);
            query.setString(3, apaternoCli);
            query.setString(4, amaternoCli);
            query.setString(5, fonoCli);
            query.setString(6, emailCli);
            query.setString(7, direccionCli);
            query.setString(8, codCli);
            query.executeUpdate();
            transaccionCorrecta = true;
        } finally {
            conn.close();
        }
        return transaccionCorrecta;

    }

    @Override
    public boolean deleteCliente(String codCli) throws SQLException, NamingException {

        boolean transaccionCorrecta = false;
        Connection conn = getConnection();
        if (conn == null) {
            throw new SQLException("No connection");
        }

        try {
            StringBuilder stb = new StringBuilder();
            stb.append("DELETE FROM \"CLIENTE\" ");
            stb.append("WHERE  cod_cli = ? ;  ");
            PreparedStatement query = conn.prepareStatement(stb.toString());
            query.setString(1, codCli);
            query.executeUpdate();
            transaccionCorrecta = true;
        } finally {
            conn.close();
        }
        return transaccionCorrecta;

    }

    @Override
    public boolean unableCliente(String codCli) throws SQLException, NamingException {
        boolean transaccionCorrecta = false;
        Connection conn = getConnection();
        if (conn == null) {
            throw new SQLException("No connection");
        }

        try {
            StringBuilder stb = new StringBuilder();
            stb.append("UPDATE \"CLIENTE\" ");
            stb.append("SET  estado_cli = 'NO ACTIVO'  ");
            stb.append("WHERE  cod_cli = ? ;  ");
            PreparedStatement query = conn.prepareStatement(stb.toString());
            query.setString(1, codCli);
            query.executeUpdate();
            transaccionCorrecta = true;
        } finally {
            conn.close();
        }
        return transaccionCorrecta;
    }
}
