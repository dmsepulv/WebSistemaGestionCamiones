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
public class TicketDaoImpl extends Conexion implements TicketDao {

    public boolean insertTicket(
             int cod_tic,
             int cod_via,
             String tipo_tic,
             int valor_tic) throws SQLException, NamingException {

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
        stb.append("INSERT INTO \"TICKET\"");
        stb.append("       (cod_tic , ");
        stb.append("        cod_via , ");
        stb.append("        tipo_tic , ");
        stb.append("        valor_tic , ");
        stb.append(" values ( ? , ? , ? , ? , ? , ? , ? , ? , ?) ;");
        PreparedStatement query = conn.prepareStatement(stb.toString());

        query.setInt(1, cod_tic);
        query.setInt(2, cod_via);
        query.setString(3, tipo_tic);
        query.setInt(4, valor_tic);

        query.executeUpdate();

        transaccionCorrecta = true;
        return transaccionCorrecta;
    }

    @Override
    public Object selectTicket(int cod_tic) throws SQLException, NamingException {

        LinkedList<Object> datosTicket = null;

        DataSource sgc_connection = getSgc_connection();
        if (sgc_connection == null) {
            throw new SQLException("No data source");
        }
        Connection conn = sgc_connection.getConnection();
        if (conn == null) {
            throw new SQLException("No connection");
        }

        StringBuilder stb = new StringBuilder();
        stb.append(" SELECT cod_tic , ");
        stb.append("       cod_via , ");
        stb.append("       tipo_tic , ");
        stb.append("       valor_tic , ");
        stb.append(" FROM  \"TICKET\"  ");
        stb.append(" WHERE cod_tic = ? ; ");

        PreparedStatement query = conn.prepareStatement(stb.toString());
        query.setInt(1, cod_tic);
        ResultSet rs = query.executeQuery();

        if (rs.next()) {
            datosTicket = new LinkedList<Object>();
            datosTicket.add(rs.getInt("cod_tic"));
            datosTicket.add(rs.getInt("cod_via"));
            datosTicket.add(rs.getString("tipo_tic"));
            datosTicket.add(rs.getInt("valor_tic"));
        }

        conn.close();

        return datosTicket;
    }

    @Override
    public Object selectAllTicket() throws SQLException, NamingException {
        LinkedList<Object> ticket = null;

        DataSource sgc_connection = getSgc_connection();
        if (sgc_connection == null) {
            throw new SQLException("No data source");
        }
        Connection conn = sgc_connection.getConnection();
        if (conn == null) {
            throw new SQLException("No connection");
        }

        StringBuilder stb = new StringBuilder();
        stb.append(" SELECT cod_tic , ");
        stb.append("       cod_via , ");
        stb.append("       tipo_tic , ");
        stb.append("       valor_tic , ");
        stb.append(" FROM  \"TICKET\"  ");

        PreparedStatement query = conn.prepareStatement(stb.toString());
        ResultSet rs = query.executeQuery();
        if (rs.next()) {
            ticket = new LinkedList<Object>();
            do {
                ArrayList<Object> datosTicket = new ArrayList<Object>();
                datosTicket.add(rs.getInt("cod_tic"));
                datosTicket.add(rs.getInt("cod_via"));
                datosTicket.add(rs.getString("tipo_tic"));
                datosTicket.add(rs.getInt("valor_tic"));
                ticket.add(datosTicket);
            } while (rs.next());
        }

        conn.close();

        return ticket;
    }

    public boolean updateTicket(
            int cod_tic,
            int cod_via,
            String tipo_tic,
            int valor_tic) throws SQLException, NamingException {
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
        stb.append("UPDATE \"TICKET\" ");
        stb.append("SET     cod_tic = ? , ");
        stb.append("        cod_via = ? , ");
        stb.append("        tipo_tic = ? , ");
        stb.append("        valor_tic , ");

        stb.append("WHERE   cod_tic = ? ;  ");
        PreparedStatement query = conn.prepareStatement(stb.toString());

        query.setInt(1, cod_tic);
        query.setInt(2, cod_via);
        query.setString(3, tipo_tic);
        query.setInt(4, valor_tic);

        query.executeUpdate();
        transaccionCorrecta = true;
        conn.close();

        return transaccionCorrecta;
    }

    public boolean deleteTicket(int cod_tic) throws SQLException, NamingException {

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
        stb.append("DELETE  FROM \"TICKET\" ");
        stb.append("WHERE  cod_tic = ? ;  ");
        PreparedStatement query = conn.prepareStatement(stb.toString());
        query.setInt(1, cod_tic);
        query.executeUpdate();
        transaccionCorrecta = true;
        conn.close();
        return transaccionCorrecta;
    }


}