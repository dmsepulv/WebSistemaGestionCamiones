/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Service;

import Model.Dao.ComunaDao;
import Model.Entity.Camion;

import Model.Entity.Comuna;
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
public class ComunaServiceImpl implements ComunaService {

    private @Inject
    ComunaDao comunaDao;

    @Override
    public LinkedList<Comuna> seleccionarTodosLosComuna() {
        Comuna comuna;
        LinkedList<Comuna> comunaRetorno = null;
        LinkedList<Object> comunas;
        try {
            comunas = (LinkedList<Object>) comunaDao.selectAllComuna();
            if (comunas != null) {
                comunaRetorno = new LinkedList<Comuna>();
                for (int i = 0; i < comunas.size(); i++) {
                    ArrayList<Object> datosComuna = (ArrayList<Object>) comunas.get(i);
                    comuna = new Comuna();
                    comuna.setCodCom((Integer) datosComuna.get(0));
                    comuna.setNombreCom((String)datosComuna.get(2));
                    comunaRetorno.add(comuna);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(ComunaServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NamingException ex) {
            Logger.getLogger(ComunaServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return comunaRetorno;

    }

 
}
