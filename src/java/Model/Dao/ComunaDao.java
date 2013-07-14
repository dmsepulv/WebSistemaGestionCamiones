package Model.Dao;

import java.sql.SQLException;
import javax.naming.NamingException;

/**
 *
 * @author darwin
 */
public interface ComunaDao{

    
    public Object selectAllComuna() throws SQLException, NamingException; 
    
    
}
