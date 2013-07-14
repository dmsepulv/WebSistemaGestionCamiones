package Model.Dao;

import java.sql.SQLException;
import javax.naming.NamingException;

/**
 *
 * @author darwin
 */
public interface TicketDao {

    public boolean insertTicket(
            int cod_tic,
            int cod_via,
            String tipo_tic,
            int valor_tic) throws SQLException, NamingException;
            
            

    public Object selectTicket(int cod_tic) throws SQLException, NamingException;

    public Object selectAllTicket() throws SQLException, NamingException;

    public boolean updateTicket(
            int cod_tic,
            int cod_via,
            String tipo_tic,
            int valor_tic) throws SQLException, NamingException;

    public boolean deleteTicket(int cod_tic) throws SQLException, NamingException;
}