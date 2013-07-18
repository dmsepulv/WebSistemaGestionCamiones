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
public class UsuarioDaoImpl extends Conexion implements UsuarioDao {

    @Override
    public boolean insertUsuario(
            String rutUsu,
            String passwordUsu,
            String nombreUsu,
            String apaternoUsu,
            String amaternoUsu,
            String emailUsu,
            String estadoUsu,
            String rolUsu) throws SQLException, NamingException {

        boolean transaccionCorrecta = false;

        Connection conn = getConnection();
        if (conn == null) {
            throw new SQLException("No connection");
        }

        try {
            StringBuilder stb = new StringBuilder();
            stb.append("INSERT INTO \"USUARIO\"");
            stb.append("       (rut_usu , ");
            stb.append("       password_usu , ");
            stb.append("       nombre_usu , ");
            stb.append("       apaterno_usu , ");
            stb.append("       amaterno_usu , ");
            stb.append("       email_usu,  ");
            stb.append("       estado_usu,  ");
            stb.append("       rol_usu)  ");
            stb.append(" values ( ? , ? , ? , ? , ? , ? ,? , ? ) ;");
            PreparedStatement query = conn.prepareStatement(stb.toString());

            query.setString(1, rutUsu);
            query.setString(2, passwordUsu);
            query.setString(3, nombreUsu);
            query.setString(4, apaternoUsu);
            query.setString(5, amaternoUsu);
            query.setString(6, emailUsu);
            query.setString(7, estadoUsu);
            query.setString(8, rolUsu);
            query.executeUpdate();
            transaccionCorrecta = true;

        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conn.close();
        }
        return transaccionCorrecta;

    }

    @Override
    public Object selectUsuario(String rut) throws SQLException, NamingException {

        LinkedList<Object> datosUsuario = null;

        Connection conn = getConnection();
        if (conn == null) {
            throw new SQLException("No connection");
        }

        try {
            StringBuilder stb = new StringBuilder();
            stb.append("SELECT rut_usu , ");
            stb.append("       password_usu , ");
            stb.append("       nombre_usu , ");
            stb.append("       apaterno_usu , ");
            stb.append("       amaterno_usu , ");
            stb.append("       email_usu,  ");
            stb.append("       estado_usu,  ");
            stb.append("       rol_usu  ");
            stb.append("FROM   \"USUARIO\"  ");
            stb.append(" WHERE rut_usu = ?  ");
            stb.append(" ; ");
            //   stb.append("       AND  estado_usu = 'ACTIVO' ; ");

            PreparedStatement query = conn.prepareStatement(stb.toString());
            query.setString(1, rut);
            ResultSet rs = query.executeQuery();

            if (rs.next()) {
                datosUsuario = new LinkedList<Object>();
                datosUsuario.add(rs.getString("rut_usu"));
                datosUsuario.add(rs.getString("password_usu"));
                datosUsuario.add(rs.getString("nombre_usu"));
                datosUsuario.add(rs.getString("apaterno_usu"));
                datosUsuario.add(rs.getString("amaterno_usu"));
                datosUsuario.add(rs.getString("email_usu"));
                datosUsuario.add(rs.getString("estado_usu"));
                datosUsuario.add(rs.getString("rol_usu"));
            }
        } finally {
            conn.close();
        }
        return datosUsuario;
    }

    @Override
    public Object selectAllUsuario() throws SQLException, NamingException {

        LinkedList<Object> usuarios = null;

        Connection conn = getConnection();
        if (conn == null) {
            throw new SQLException("No connection");
        }

        try {
            StringBuilder stb = new StringBuilder();
            stb.append("SELECT rut_usu , ");
            stb.append("       password_usu , ");
            stb.append("       nombre_usu , ");
            stb.append("       apaterno_usu , ");
            stb.append("       amaterno_usu , ");
            stb.append("       email_usu,  ");
            stb.append("       estado_usu,  ");
            stb.append("       rol_usu  ");
            stb.append("FROM   \"USUARIO\" ; ");

            PreparedStatement query = conn.prepareStatement(stb.toString());
            ResultSet rs = query.executeQuery();
            if (rs.next()) {
                usuarios = new LinkedList<Object>();
                do {
                    ArrayList<Object> datosUsuario = new ArrayList<Object>();
                    datosUsuario.add(rs.getString("rut_usu"));
                    datosUsuario.add(rs.getString("password_usu"));
                    datosUsuario.add(rs.getString("nombre_usu"));
                    datosUsuario.add(rs.getString("apaterno_usu"));
                    datosUsuario.add(rs.getString("amaterno_usu"));
                    datosUsuario.add(rs.getString("email_usu"));
                    datosUsuario.add(rs.getString("estado_usu"));
                    datosUsuario.add(rs.getString("rol_usu"));
                    usuarios.add(datosUsuario);
                } while (rs.next());
            }
        } finally {
            conn.close();
        }
        return usuarios;
    }

    @Override
    public boolean updateUsuario(
            String rutUsu,
            String passwordUsu,
            String nombreUsu,
            String apaternoUsu,
            String amaternoUsu,
            String emailUsu,
            String estadoUsu,
            String rolUsu) throws SQLException, NamingException {

        boolean transaccionCorrecta = false;
        Connection conn = getConnection();
        if (conn == null) {
            throw new SQLException("No connection");
        }

        try {
            StringBuilder stb = new StringBuilder();
            stb.append("UPDATE \"USUARIO\" ");
            stb.append("SET  nombre_usu = ? ,");
            stb.append(" apaterno_usu = ? ,");
            stb.append(" amaterno_usu = ? ,");
            stb.append(" email_usu = ? ,");
            stb.append(" estado_usu = ? ,");
            stb.append(" rol_usu = ? ");
            stb.append(" WHERE  rut_usu = ? ;  ");
            PreparedStatement query = conn.prepareStatement(stb.toString());

            query.setString(1, nombreUsu);
            query.setString(2, apaternoUsu);
            query.setString(3, amaternoUsu);
            query.setString(4, emailUsu);
            query.setString(5, estadoUsu);
            query.setString(6, rolUsu);
            query.setString(7, rutUsu);
            query.executeUpdate();
            transaccionCorrecta = true;
        } finally {
            conn.close();
        }
        return transaccionCorrecta;

    }

    @Override
    public boolean deleteUsuario(String rutUsu) throws SQLException, NamingException {

        boolean transaccionCorrecta = false;

        Connection conn = getConnection();
        if (conn == null) {
            throw new SQLException("No connection");
        }

        try {
            conn.setAutoCommit(false);
            boolean committed = false;
            try {
                StringBuilder stb = new StringBuilder();
                stb.append("DELETE FROM \"USUARIO\"");
                stb.append(" WHERE  rut_usu = ? ;  ");
                PreparedStatement query = conn.prepareStatement(stb.toString());
                query.setString(1, rutUsu);
                query.executeUpdate();
                conn.commit();
                committed = true;
                transaccionCorrecta = true;
            } finally {
                if (!committed) {
                    conn.rollback();
                }
            }
        } finally {
            conn.close();
        }
        return transaccionCorrecta;

    }

    @Override
    public boolean unableUsuario(String rutUsu) throws SQLException, NamingException {
        boolean transaccionCorrecta = false;

        Connection conn = getConnection();
        if (conn == null) {
            throw new SQLException("No connection");
        }

        try {
            StringBuilder stb = new StringBuilder();
            stb.append("UPDATE \"USUARIO\"");
            stb.append("SET ( estado_usu = ? )");
            stb.append(" WHERE  rut_usu = ? ;  ");
            PreparedStatement query = conn.prepareStatement(stb.toString());

            query.setString(1, "DESHABILITADO");
            query.setString(2, rutUsu);
            query.executeUpdate();
            conn.commit();
            transaccionCorrecta = true;
        } finally {
            conn.close();
        }
        return transaccionCorrecta;
    }

    @Override
    public Object selectUsuariosPorEstado(String estadoUsuario) throws SQLException, NamingException {
        LinkedList<Object> usuarios = null;

        Connection conn = getConnection();
        if (conn == null) {
            throw new SQLException("No connection");
        }

        try {
            StringBuilder stb = new StringBuilder();
            stb.append("SELECT rut_usu , ");
            stb.append("       password_usu , ");
            stb.append("       nombre_usu , ");
            stb.append("       apaterno_usu , ");
            stb.append("       amaterno_usu , ");
            stb.append("       email_usu,  ");
            stb.append("       estado_usu,  ");
            stb.append("       rol_usu  ");
            stb.append("FROM   \"USUARIO\"  ");
            stb.append("WHERE   estado_usu = ? ; ");

            PreparedStatement query = conn.prepareStatement(stb.toString());
            query.setString(1, estadoUsuario);
            ResultSet rs = query.executeQuery();
            if (rs.next()) {
                usuarios = new LinkedList<Object>();
                do {
                    ArrayList<Object> datosUsuario = new ArrayList<Object>();
                    datosUsuario.add(rs.getString("rut_usu"));
                    datosUsuario.add(rs.getString("password_usu"));
                    datosUsuario.add(rs.getString("nombre_usu"));
                    datosUsuario.add(rs.getString("apaterno_usu"));
                    datosUsuario.add(rs.getString("amaterno_usu"));
                    datosUsuario.add(rs.getString("email_usu"));
                    datosUsuario.add(rs.getString("estado_usu"));
                    datosUsuario.add(rs.getString("rol_usu"));
                    usuarios.add(datosUsuario);
                } while (rs.next());
            }
        } finally {
            conn.close();
        }
        return usuarios;
    }
}
