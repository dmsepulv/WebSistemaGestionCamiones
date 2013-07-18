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
public class RutaDaoImpl extends Conexion implements RutaDao {

    @Override
    public int insertRuta(
            int cod_com_ini,
            int cod_com_dest) throws SQLException, NamingException {
        
        int transaccionCorrecta = -1;
        Connection conn = getConnection();
        if (conn == null) {
            throw new SQLException("No connection");
        }

        StringBuilder stb = new StringBuilder();
        stb.append(" SELECT cod_ruta , ");
        stb.append("       cod_com_ini , ");
        stb.append("       cod_com_dest , ");
        stb.append("       t_prom_ruta , ");
        stb.append("       dist_prom_ruta  ");
        stb.append(" FROM  \"RUTA\"  ");
        stb.append(" WHERE cod_com_ini = ? AND cod_com_dest = ? ; ");

        PreparedStatement query = conn.prepareStatement(stb.toString());
        query.setInt(1, cod_com_ini);
        query.setInt(2, cod_com_dest);
        ResultSet rs = query.executeQuery();

        if (!rs.next()) {
            stb = new StringBuilder();
            stb.append("INSERT INTO \"RUTA\"");
            stb.append("       (cod_com_ini , ");
            stb.append("       cod_com_dest )  ");
            stb.append("VALUES ( ? , ? ) ;");
            query = conn.prepareStatement(stb.toString());

            query.setInt(1, cod_com_ini);
            query.setInt(2, cod_com_dest);

            query.executeUpdate();

            stb = new StringBuilder();
            stb.append(" SELECT cod_ruta , ");
            stb.append("       cod_com_ini , ");
            stb.append("       cod_com_dest , ");
            stb.append("       t_prom_ruta , ");
            stb.append("       dist_prom_ruta  ");
            stb.append(" FROM  \"RUTA\"  ");
            stb.append(" WHERE cod_com_ini = ? AND cod_com_dest = ? ; ");

            query = conn.prepareStatement(stb.toString());
            query.setInt(1, cod_com_ini);
            query.setInt(2, cod_com_dest);
            rs = query.executeQuery();
            if(rs.next()){
                transaccionCorrecta=rs.getInt("cod_ruta");
            }
            
        }
        return transaccionCorrecta;
    }

    @Override
    public Object selectRuta(int cod_ruta) throws SQLException, NamingException {

        LinkedList<Object> datosRuta = null;
        Connection conn = getConnection();
        if (conn == null) {
            throw new SQLException("No connection");
        }

        StringBuilder stb = new StringBuilder();
        stb.append(" SELECT cod_ruta , ");
        stb.append("       cod_com_ini , ");
        stb.append("       cod_com_dest , ");
        stb.append("       t_prom_ruta , ");
        stb.append("       dist_prom_ruta , ");
        stb.append(" FROM  \"RUTA\"  ");
        stb.append(" WHERE cod_ruta = ? ; ");

        PreparedStatement query = conn.prepareStatement(stb.toString());
        query.setInt(1, cod_ruta);
        ResultSet rs = query.executeQuery();

        if (rs.next()) {
            datosRuta = new LinkedList<Object>();
            datosRuta.add(rs.getInt("cod_ruta"));
            datosRuta.add(rs.getInt("cod_com_ini"));
            datosRuta.add(rs.getInt("cod_com_dest"));
            datosRuta.add(rs.getFloat("t_prom_ruta"));
            datosRuta.add(rs.getFloat("dist_prom_ruta"));
        }

        conn.close();

        return datosRuta;
    }

    @Override
    public Object selectAllRuta() throws SQLException, NamingException {
        LinkedList<Object> rutas = null;

        Connection conn = getConnection();
        if (conn == null) {
            throw new SQLException("No connection");
        }

        StringBuilder stb = new StringBuilder();
        stb.append(" SELECT cod_ruta , ");
        stb.append("       cod_com_ini , ");
        stb.append("       cod_com_dest , ");
        stb.append("       t_prom_ruta , ");
        stb.append("       dist_prom_ruta , ");
        stb.append(" FROM  \"RUTA\"  ");

        PreparedStatement query = conn.prepareStatement(stb.toString());
        ResultSet rs = query.executeQuery();
        if (rs.next()) {
            rutas = new LinkedList<Object>();
            do {
                ArrayList<Object> datosRuta = new ArrayList<Object>();
                datosRuta.add(rs.getInt("cod_ruta"));
                datosRuta.add(rs.getInt("cod_com_ini"));

                datosRuta.add(rs.getInt("cod_com_dest"));
                datosRuta.add(rs.getFloat("t_prom_ruta"));
                datosRuta.add(rs.getFloat("dist_prom_ruta"));
                rutas.add(datosRuta);
            } while (rs.next());
        }

        conn.close();

        return rutas;
    }

    @Override
    public boolean updateRuta(
            int cod_ruta,
            int cod_com_ini,
            int cod_com_dest,
            float t_prom_ruta,
            float dist_prom_ruta) throws SQLException, NamingException {
        boolean transaccionCorrecta = false;

        Connection conn = getConnection();
        if (conn == null) {
            throw new SQLException("No connection");
        }
        StringBuilder stb = new StringBuilder();
        stb.append("UPDATE \"RUTA\" ");
        stb.append("SET     cod_ruta = ? , ");
        stb.append("        cod_com_ini = ? , ");
        stb.append("        cod_com_dest = ? , ");
        stb.append("        t_prom_ruta , ");
        stb.append("        dist_prom_ruta = ? , ");

        stb.append("WHERE   cod_ruta = ? ;  ");
        PreparedStatement query = conn.prepareStatement(stb.toString());

        query.setInt(1, cod_ruta);
        query.setInt(2, cod_com_ini);
        query.setInt(3, cod_com_dest);
        query.setFloat(4, t_prom_ruta);
        query.setFloat(5, dist_prom_ruta);

        query.executeUpdate();
        transaccionCorrecta = true;
        conn.close();

        return transaccionCorrecta;
    }

    @Override
    public boolean deleteRuta(int cod_ruta) throws SQLException, NamingException {

        boolean transaccionCorrecta = false;
        Connection conn = getConnection();
        if (conn == null) {
            throw new SQLException("No connection");
        }
        StringBuilder stb = new StringBuilder();
        stb.append("DELETE  FROM \"RUTA\" ");
        stb.append("WHERE  cod_ruta = ? ;  ");
        PreparedStatement query = conn.prepareStatement(stb.toString());
        query.setInt(1, cod_ruta);
        query.executeUpdate();
        transaccionCorrecta = true;
        conn.close();
        return transaccionCorrecta;
    }

    @Override
    public Object selectRutaExacta(int cod_ruta) throws SQLException, NamingException {

        LinkedList<Object> datosRuta = null;

        Connection conn = getConnection();
        if (conn == null) {
            throw new SQLException("No connection");
        }

        StringBuilder stb = new StringBuilder();
        //el nombre de las tablas deven ir en comillas "" pero produce error de sintaxis al colocarlas.
        stb.append("WITH ");
        stb.append("COMUNA_TEMP as ( ");
        stb.append("select * from \"COMUNA\") ");
        stb.append("SELECT \"RUTA\".cod_ruta, ");
        stb.append("       \"RUTA\".cod_com_ini, ");
        stb.append("       \"COMUNA\".nombre_com as nombre_com_ini, ");
        stb.append("       \"RUTA\".cod_com_dest, ");
        stb.append("       COMUNA_TEMP.nombre_com as nombre_com_des ");
        stb.append("FROM   public.\"RUTA\", ");
        stb.append("       public.\"COMUNA\", ");
        stb.append("       COMUNA_TEMP	");
        stb.append("WHERE  \"COMUNA\".cod_com = \"RUTA\".cod_com_ini and ");
        stb.append("       COMUNA_TEMP.cod_com = \"RUTA\".cod_com_dest and ");
        stb.append("       \"RUTA\".cod_ruta = ?; ");

        PreparedStatement query = conn.prepareStatement(stb.toString());
        query.setInt(1, cod_ruta);
        ResultSet rs = query.executeQuery();

        if (rs.next()) {
            datosRuta = new LinkedList<Object>();
            datosRuta.add(rs.getInt("cod_ruta"));
            datosRuta.add(rs.getInt("cod_com_ini"));
            datosRuta.add(rs.getString("nombre_com_ini"));
            datosRuta.add(rs.getInt("cod_com_dest"));
            datosRuta.add(rs.getString("nombre_com_des"));

        }

        conn.close();

        return datosRuta;
    }
}