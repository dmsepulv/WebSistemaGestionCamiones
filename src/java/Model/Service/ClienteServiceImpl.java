/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Service;

import Model.Dao.ClienteDao;
import Model.Entity.Cliente;
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
public class ClienteServiceImpl implements ClienteService {

    private @Inject
    ClienteDao clienteDao;

    @Override
    public boolean guardarCliente(
            String codCli,
            int codComuna,
            String nombreCli,
            String apaternoCli,
            String amaternoCli,
            String fonoCli,
            String emailCli,
            String direccionCli) throws SQLException, NamingException {

        return clienteDao.insertCliente(
                codCli,
                codComuna,
                nombreCli,
                apaternoCli,
                amaternoCli,
                fonoCli,
                emailCli,
                direccionCli);

    }

    @Override
    public Cliente seleccionarCliente(String codCli) {

        Cliente cliente = null;
        try {
            LinkedList<Object> datosCliente = (LinkedList<Object>) clienteDao.selectCliente(codCli);
            if (datosCliente != null) {
                cliente = new Cliente();
                cliente.setCodCli((String) datosCliente.get(0));
                cliente.getComuna().setCodCom((Integer) datosCliente.get(1));
                cliente.getComuna().setNombreCom(datosCliente.get(8).toString());
                cliente.setNombreCli((String) datosCliente.get(2));
                cliente.setApaternoCli((String) datosCliente.get(3));
                cliente.setAmaternoCli((String) datosCliente.get(4));
                cliente.setTelefonoCli((String) datosCliente.get(5));
                cliente.setMailCli((String) datosCliente.get(6));
                cliente.setDireccionCli((String) datosCliente.get(7));

            }
        } catch (SQLException ex) {
            Logger.getLogger(CamionServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NamingException ex) {
            Logger.getLogger(CamionServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            return cliente;
        }
    }

    @Override
    public LinkedList<Cliente> seleccionarTodosLosCliente() {
        Cliente cliente;
        LinkedList<Cliente> clienteRetorno = null;
        LinkedList<Object> clientes;
        try {
            clientes = (LinkedList<Object>) clienteDao.selectAllCliente();
            if (clientes != null) {
                clienteRetorno = new LinkedList<Cliente>();
                for (int i = 0; i < clientes.size(); i++) {
                    ArrayList<Object> datosCliente = (ArrayList<Object>) clientes.get(i);
                    cliente = new Cliente();
                    cliente.setCodCli((String) datosCliente.get(0));
                    cliente.getComuna().setCodCom((Integer) datosCliente.get(1));
                    cliente.getComuna().setNombreCom(datosCliente.get(8).toString());
                    cliente.setNombreCli((String) datosCliente.get(2));
                    cliente.setApaternoCli((String) datosCliente.get(3));
                    cliente.setAmaternoCli((String) datosCliente.get(4));
                    cliente.setTelefonoCli((String) datosCliente.get(5));
                    cliente.setMailCli((String) datosCliente.get(6));
                    cliente.setDireccionCli((String) datosCliente.get(7));
                    clienteRetorno.add(cliente);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(CamionServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NamingException ex) {
            Logger.getLogger(CamionServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return clienteRetorno;
    }

    @Override
    public boolean actualizarCliente(
            String codCli,
            int codComuna,
            String nombreCli,
            String apaternoCli,
            String amaternoCli,
            String fonoCli,
            String emailCli,
            String direccionCli) throws SQLException, NamingException {

        return clienteDao.updateCliente(
                codCli,
                codComuna,
                nombreCli,
                apaternoCli,
                amaternoCli,
                fonoCli,
                emailCli,
                direccionCli);
    }

//    @Override
//    public boolean desactivarUsuario(
//            String rutUsu) throws SQLException, NamingException {
//
//        return clienteDao.unableCliente(rutUsu);
//    }
    @Override
    public boolean eliminarCliente(String cod_cli) throws SQLException, NamingException {

        return clienteDao.deleteCliente(cod_cli);
    }
}
