/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Service;

import Model.Entity.Ticket;
import java.sql.SQLException;
import java.util.LinkedList;
import javax.naming.NamingException;

/**
 *
 * @author darwin
 */
public interface TicketService {
    
    public boolean guardarTicket(int cod_tic,
             int cod_via,
             String tipo_tic,
             int valor_tic) throws SQLException, NamingException;
    
    public Ticket seleccionarTicket(int cod_tic);
    
    public LinkedList<Ticket> seleccionarTodosLosTicket();
    
    public boolean actualizarTicket(int cod_tic,
             int cod_via,
             String tipo_tic,
             int valor_tic) throws SQLException, NamingException;
    
    
    public boolean eliminarTicket(int cod_tic);
}
