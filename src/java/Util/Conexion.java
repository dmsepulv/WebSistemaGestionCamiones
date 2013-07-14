/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 *
 * @author darwin
 */
public class Conexion {
    
    protected DataSource getSgc_connection() throws NamingException {
        Context c = new InitialContext();
        return (DataSource) c.lookup("java:comp/env/sgc_connection");
    }
    
}
