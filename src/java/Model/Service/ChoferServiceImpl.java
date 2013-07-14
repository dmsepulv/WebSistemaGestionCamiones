/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Service;

import Model.Dao.ChoferDao;
import Model.Entity.Chofer;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.inject.Inject;
import javax.naming.NamingException;

/**
 *
 * @author darwin
 */
public class ChoferServiceImpl implements ChoferService {

    private @Inject
    ChoferDao choferDao;

    @Override
    public boolean guardarChofer(String rutCho,
            String nombreCho,
            String aparternoCho,            
            String amaternoCho, 
            Date fnacCho,
            Integer experienciaCho, 
            String tipoLicenciaCho,
            Date expirLicenciaCho) throws SQLException, NamingException {

        return choferDao.insertChofer(
                rutCho,
                nombreCho,
                aparternoCho,
                amaternoCho,
                fnacCho,
                experienciaCho,
                tipoLicenciaCho,
                expirLicenciaCho);

    }

    @Override
    public Chofer seleccionarChofer(String rutCho) throws SQLException, NamingException {

        Chofer chofer = null;
        try {
            LinkedList<Object> datosChofer = (LinkedList<Object>) choferDao.selectChofer(rutCho);
            if (datosChofer != null) {
                chofer = new Chofer();
                chofer.setRutCho((String) datosChofer.get(0));
                chofer.setNombreCho((String) datosChofer.get(1));
                chofer.setAparternoCho((String) datosChofer.get(2));
                chofer.setAmaternoCho((String) datosChofer.get(3));
                chofer.setFnacCho((Date) datosChofer.get(4));
                chofer.setExperienciaCho(Integer.parseInt((String) datosChofer.get(5)));
                chofer.setTipoLicenciaCho((String) datosChofer.get(6));
                chofer.setExpirLicenciaCho((Date) datosChofer.get(7));
            }
        } catch (SQLException ex) {
            Logger.getLogger(CamionServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NamingException ex) {
            Logger.getLogger(CamionServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            return chofer;
        }

    }

    @Override
    public List<Chofer> seleccionarTodosLosChofer() throws SQLException, NamingException {
        Chofer chofer;
        LinkedList<Chofer> choferRetorno = null;
        LinkedList<Object> choferes;
        try {
            choferes = (LinkedList<Object>) choferDao.selectAllChofer();
            if (choferes != null) {
                choferRetorno = new LinkedList<Chofer>();
                for (int i = 0; i < choferes.size(); i++) {
                    ArrayList<Object> datosChofer = (ArrayList<Object>) choferes.get(i);
                    chofer = new Chofer();
                    chofer.setRutCho((String) datosChofer.get(0));
                    chofer.setNombreCho((String) datosChofer.get(1));
                    chofer.setAparternoCho((String) datosChofer.get(2));
                    chofer.setAmaternoCho((String) datosChofer.get(3));
                    chofer.setFnacCho((Date) datosChofer.get(4));
                    chofer.setExperienciaCho(Integer.parseInt((String) datosChofer.get(5)));
                    chofer.setTipoLicenciaCho((String) datosChofer.get(6));
                    chofer.setExpirLicenciaCho((Date) datosChofer.get(7));
                    choferRetorno.add(chofer);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(CamionServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NamingException ex) {
            Logger.getLogger(CamionServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return choferRetorno;
    }

    @Override
    public boolean actualizarChofer(
            String rutCho,
            String nombreCho,
            String aparternoCho,
            String amaternoCho,
            Date fnacCho,
            Integer experienciaCho,
            String tipoLicenciaCho,
            Date expirLicenciaCho) throws SQLException, NamingException {


        return choferDao.updateChofer(
                rutCho,
                nombreCho,
                aparternoCho,
                amaternoCho,
                fnacCho,
                experienciaCho,
                tipoLicenciaCho,
                expirLicenciaCho);
    }

    @Override
    public boolean eliminarChofer(String rutCho) throws SQLException, NamingException {

        return choferDao.deleteChofer(rutCho);

    }
}
