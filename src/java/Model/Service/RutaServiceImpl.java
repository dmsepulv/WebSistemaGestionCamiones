/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Service;

import Model.Dao.RutaDao;
import Model.Entity.Ruta;
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
public class RutaServiceImpl implements RutaService {

    private @Inject
    RutaDao rutaDao;

    @Override
    public int guardarRuta(
            int cod_com_ini,
            int cod_com_dest) throws SQLException, NamingException {

        return rutaDao.insertRuta(cod_com_ini,
                cod_com_dest);

    }

    @Override
    public Ruta seleccionarRuta(int cod_ruta) {
        Ruta ruta = null;
        try {
            LinkedList<Object> datosRuta = (LinkedList<Object>) rutaDao.selectRuta(cod_ruta);
            if (datosRuta != null) {
                ruta = new Ruta();

                ruta.setCod_ruta((Integer) datosRuta.get(0));
                ruta.setCod_com_ini((Integer) datosRuta.get(1));
                ruta.setCod_com_dest((Integer) datosRuta.get(2));
                ruta.setT_prom_ruta((Float) datosRuta.get(3));
                ruta.setDist_prom_ruta((Float) datosRuta.get(4));

            }
        } catch (SQLException ex) {
            Logger.getLogger(CamionServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NamingException ex) {
            Logger.getLogger(CamionServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            return ruta;
        }

    }

    @Override
    @SuppressWarnings("empty-statement")
    public LinkedList<Ruta> seleccionarTodasLasRutas() {
        Ruta ruta;
        LinkedList<Ruta> rutaRetorno = null;
        LinkedList<Object> rutas;;
        try {
            rutas = (LinkedList<Object>) rutaDao.selectAllRuta();
            if (rutas != null) {
                rutaRetorno = new LinkedList<Ruta>();
                for (int i = 0; i < rutas.size(); i++) {
                    ArrayList<Object> datosRuta = (ArrayList<Object>) rutas.get(i);
                    ruta = new Ruta();
                    ruta.setCod_ruta((Integer) datosRuta.get(0));
                    ruta.setCod_com_ini((Integer) datosRuta.get(1));
                    ruta.setCod_com_dest((Integer) datosRuta.get(2));
                    ruta.setT_prom_ruta((Float) datosRuta.get(3));
                    ruta.setDist_prom_ruta((Float) datosRuta.get(4));
                    rutaRetorno.add(ruta);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(CamionServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NamingException ex) {
            Logger.getLogger(CamionServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rutaRetorno;

    }

    @Override
    public boolean actualizarRuta(
            int cod_ruta,
            int cod_com_ini,
            int cod_com_dest,
            float t_prom_ruta,
            float dist_prom_ruta) throws SQLException, NamingException {

        return rutaDao.updateRuta(
                cod_ruta,
                cod_com_ini,
                cod_com_dest,
                t_prom_ruta,
                dist_prom_ruta);
    }

    @Override
    public boolean eliminarRuta(int cod_ruta) {
        boolean transaccionCorrecta = false;
        try {
            transaccionCorrecta = rutaDao.deleteRuta(cod_ruta);
        } catch (SQLException ex) {
            Logger.getLogger(RutaServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NamingException ex) {
            Logger.getLogger(RutaServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return transaccionCorrecta;
    }
}
