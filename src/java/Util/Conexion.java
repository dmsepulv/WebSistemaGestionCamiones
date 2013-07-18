/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 *
 * @author darwin
 */
public class Conexion {

    public static final String DRIVER = "org.postgresql.Driver";
    public static final String DBURL = "jdbc:postgresql://colvin.chillan.ubiobio.cl:5432/SGC";
    public static final String USER = "grupo4";
    public static final String PASSWORD = "grupo4";

    public static Connection getConnection(){
        Connection conn = null;
        try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException e) {
            System.out.println(DAOException.IMPOSIBLE_FIND_DRIVER);
        }
        try {
            conn = DriverManager.getConnection(DBURL, USER, PASSWORD);
        } catch (SQLException e) {
            System.out.println(DAOException.IMPOSIBLE_ESTABLISH_CONNECTION);
        }
        return conn;
    }
}
