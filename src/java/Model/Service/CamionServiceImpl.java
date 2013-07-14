/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Service;

import Model.Dao.CamionDao;
import Model.Entity.Camion;
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
public class CamionServiceImpl implements CamionService {

    private @Inject CamionDao camionDao;

    @Override
    public boolean guardarCamion(String patente_cam,
            int capacidad_cam,
            String estado_cam,
            int anio_adq_cam,
            int costo_adq_cam,
            int anio_elab_cam) throws SQLException, NamingException {

        return camionDao.insertCamion(
                patente_cam,
                capacidad_cam,
                estado_cam,
                anio_adq_cam,
                costo_adq_cam,
                anio_elab_cam);

    }

    @Override
    public Camion seleccionarCamion(String patente_cam) {
        Camion camion = null;
        try {
            LinkedList<Object> datosCamion = (LinkedList<Object>) camionDao.selectCamion(patente_cam);
            if (datosCamion != null) {
                camion = new Camion();
                camion.setPatenteCam((String) datosCamion.get(0));
                camion.setEstadoCam((String) datosCamion.get(1));
                camion.setCapacidadCam((Integer) datosCamion.get(2));
                camion.setAnioAdqCam((Integer) datosCamion.get(3));
                camion.setCostoAdqCam((Integer) datosCamion.get(4));
                camion.setAnioElabCam((Integer) datosCamion.get(5));
            }
        } catch (SQLException ex) {
            Logger.getLogger(CamionServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NamingException ex) {
            Logger.getLogger(CamionServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            return camion;
        }

    }

    @Override
    public LinkedList<Camion> seleccionarTodosLosCamion() {
        Camion camion;
        LinkedList<Camion> camionRetorno = null;
        LinkedList<Object> camiones;
        try {
            camiones = (LinkedList<Object>) camionDao.selectAllCamion();
            if (camiones != null) {
            camionRetorno = new LinkedList<Camion>();
            for (int i = 0; i < camiones.size(); i++) {
                ArrayList<Object> datosCamion = (ArrayList<Object>) camiones.get(i);
                camion = new Camion();
                camion.setPatenteCam((String) datosCamion.get(0));
                camion.setEstadoCam((String) datosCamion.get(1));
                camion.setCapacidadCam((Integer) datosCamion.get(2));
                camion.setAnioAdqCam((Integer) datosCamion.get(3));
                camion.setCostoAdqCam((Integer) datosCamion.get(4));
                camion.setAnioElabCam((Integer) datosCamion.get(5));
                camionRetorno.add(camion);
            }
        }
        } catch (SQLException ex) {
            Logger.getLogger(CamionServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NamingException ex) {
            Logger.getLogger(CamionServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        } 
        return camionRetorno;

    }

    @Override
    public boolean actualizarCamion(
            String patente_cam, 
            int capacidad_cam, 
            String estado_cam, 
            int anio_adq_cam, 
            int costo_adq_cam, 
            int anio_elab_cam) throws SQLException, NamingException {
        
        return camionDao.updateCamion(
                patente_cam, 
                capacidad_cam, 
                estado_cam, 
                anio_adq_cam, 
                costo_adq_cam, 
                anio_elab_cam);
    }

    @Override
    public boolean eliminarCamion(String patente_cam) {
        boolean transaccionCorrecta = false;
        try {  
            transaccionCorrecta = camionDao.deleteCamion(patente_cam);
        } catch (SQLException ex) {
            Logger.getLogger(CamionServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NamingException ex) {
            Logger.getLogger(CamionServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return transaccionCorrecta;
    }

    @Override
    public boolean desactivarCamion(String patente_cam, int capacidad_cam, int anio_adq_cam, int costo_adq_cam, int anio_elab_cam) {
        boolean transaccionCorrecta = false;
        try {
            transaccionCorrecta = camionDao.updateCamion(
                    patente_cam, 
                    capacidad_cam, 
                    "INACTIVO", 
                    anio_adq_cam, 
                    costo_adq_cam,
                    anio_elab_cam);
            
        } catch (SQLException ex) {
            Logger.getLogger(CamionServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NamingException ex) {
            Logger.getLogger(CamionServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return transaccionCorrecta;
    }
}
