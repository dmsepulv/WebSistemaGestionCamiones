/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Service;

import Model.Dao.TicketDao;
import Model.Entity.Ticket;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.inject.Inject;
import javax.naming.NamingException;

/**
 *
 * @author darwin
 */
public class TicketServiceImpl implements TicketService {

    private @Inject
    TicketDao ticketDao;
  
    

        public boolean guardarTicket(
            int cod_tic,
             int cod_via,
             String tipo_tic,
             int valor_tic) throws SQLException, NamingException {

        return  ticketDao.insertTicket(cod_tic,
				cod_via,
				tipo_tic,
				valor_tic);

    }

        public Ticket seleccionarTicket(int cod_tic) {
        Ticket ticket = null;
        try {
            LinkedList<Object> datosTicket = (LinkedList<Object>) ticketDao.selectTicket(cod_tic);
            if (datosTicket != null) {
                ticket = new Ticket();
                
                
                ticket.setCod_tic((Integer) datosTicket.get(0));
                ticket.setCod_via((Integer) datosTicket.get(1));
                ticket.setTipo_tic((String) datosTicket.get(2));
                ticket.setValor_tic((Integer) datosTicket.get(3));
                

            }
        } catch (SQLException ex) {
            Logger.getLogger(TicketServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NamingException ex) {
            Logger.getLogger(TicketServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            return ticket;
        }

    }

        public LinkedList<Ticket> seleccionarTodosLosTicket() {
        Ticket ticket;
        LinkedList<Ticket> ticketRetorno = null;
        LinkedList<Object> tickets;;
        try {
            tickets = (LinkedList<Object>) ticketDao.selectAllTicket();
            if (tickets != null) {
                ticketRetorno = new LinkedList<Ticket>();
                for (int i = 0; i < tickets.size(); i++) {
                    ArrayList<Object> datosTicket = (ArrayList<Object>) tickets.get(i);
                    ticket = new Ticket();
                ticket.setCod_tic((Integer) datosTicket.get(0));
                ticket.setCod_via((Integer) datosTicket.get(1));
                ticket.setTipo_tic((String) datosTicket.get(2));
                ticket.setValor_tic((Integer) datosTicket.get(3));
                    ticketRetorno.add(ticket);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(CamionServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NamingException ex) {
            Logger.getLogger(CamionServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ticketRetorno;

    }

        public boolean actualizarTicket(
             int cod_tic,
             int cod_via,
             String tipo_tic,
             int valor_tic) throws SQLException, NamingException {

        return ticketDao.updateTicket(
             cod_tic,
             cod_via,
             tipo_tic,
             valor_tic);
    }

        public boolean eliminarTicket(int cod_tic) {
        boolean transaccionCorrecta = false;
        try {
            transaccionCorrecta = ticketDao.deleteTicket(cod_tic);
        } catch (SQLException ex) {
            Logger.getLogger(TicketServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NamingException ex) {
            Logger.getLogger(TicketServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return transaccionCorrecta;
    }

    
}
