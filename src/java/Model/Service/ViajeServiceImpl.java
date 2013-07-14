/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Service;

import Model.Dao.ViajeDao;
import Model.Entity.Viaje;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.inject.Inject;
import javax.naming.NamingException;

/**
 *
 * @author darwin
 */
public class ViajeServiceImpl implements ViajeService {

    private @Inject
    ViajeDao viajeDao;

        public boolean guardarViaje(
            int cod_via,
            int cod_ruta,
            String patente_cam,
            String rut_cho,
            Date fecha_carga_via,
            Date fecha_descarga_via) throws SQLException, NamingException {

        return viajeDao.insertViaje(
                cod_via,
                cod_ruta,
                patente_cam,
                rut_cho,
                fecha_carga_via,
                fecha_descarga_via);

    }

    
public Viaje seleccionarViaje(int cod_via) {        
        Viaje viaje = null;
        try {
            LinkedList<Object> datosViaje = (LinkedList<Object>) viajeDao.selectViaje(cod_via);
            if (datosViaje != null) {
                viaje = new Viaje();

                viaje.setCod_via((Integer) datosViaje.get(0));
                viaje.setCod_ruta((Integer) datosViaje.get(1));
                viaje.setPatente_cam((String) datosViaje.get(2));
                viaje.setRut_cho((String) datosViaje.get(3));
                viaje.setFecha_carga_via((Date) datosViaje.get(4));
                viaje.setFecha_descarga_via((Date) datosViaje.get(5));


				
            }
        } catch (SQLException ex) {
            Logger.getLogger(CamionServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NamingException ex) {
            Logger.getLogger(CamionServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            return viaje;
        }

    }

        public LinkedList<Viaje> seleccionarTodosLosViajes() {
        Viaje viaje;
        LinkedList<Viaje> viajeRetorno = null;
        LinkedList<Object> viajes;
        try {
            viajes = (LinkedList<Object>) viajeDao.selectAllViaje();
            if (viajes != null) {
                viajeRetorno = new LinkedList<Viaje>();
                for (int i = 0; i < viajes.size(); i++) {
                    ArrayList<Object> datosViaje = (ArrayList<Object>) viajes.get(i);
                    viaje = new Viaje();

                    viaje.setCod_via((Integer) datosViaje.get(0));
                    viaje.setCod_ruta((Integer) datosViaje.get(1));                
                    viaje.setPatente_cam((String) datosViaje.get(2));
                    viaje.setRut_cho((String) datosViaje.get(3));
                    viaje.setFecha_carga_via((Date) datosViaje.get(4));
                    viaje.setFecha_descarga_via((Date) datosViaje.get(5));
                    viajeRetorno.add(viaje);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(ViajeServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NamingException ex) {
            Logger.getLogger(ViajeServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return viajeRetorno;

    }

        public boolean actualizarViaje(
            int cod_via,
            int cod_ruta,
            String patente_cam,
            String rut_cho,
            Date fecha_carga_via,
            Date fecha_descarga_via
            
       ) throws SQLException, NamingException {

        return viajeDao.updateViaje(
                cod_via,
                cod_ruta,
                patente_cam,
                rut_cho,
                fecha_carga_via,
                fecha_descarga_via);
    }

        public boolean eliminarViaje(int cod_via) {
        boolean transaccionCorrecta = false;
        try {
            transaccionCorrecta = viajeDao.deleteViaje(cod_via);
        } catch (SQLException ex) {
            Logger.getLogger(ViajeServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NamingException ex) {
            Logger.getLogger(ViajeServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return transaccionCorrecta;
    }

   
    

    }

   



