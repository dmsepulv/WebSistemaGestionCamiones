/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Entity.Cliente;
import Model.Service.ClienteService;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.inject.Inject;
import javax.naming.NamingException;

/**
 *
 * @author darwin
 */
@ManagedBean(name = "cliente")
@RequestScoped
public class ClienteController {

    private String cod_cli;
    private int cod_com;
    private String nombre_com;
    private String nombre_cli;
    private String apaterno_cli;
    private String amaterno_cli;
    private String telefono_cli;
    private String mail_cli;
    private String direccion_cli;
    private @Inject
    ClienteService clienteService;

    /**
     * Creates a new instance of ClienteController
     */
    public ClienteController() {
    }

    public String getCod_cli() {
        return cod_cli;
    }

    public void setCod_cli(String cod_cli) {
        this.cod_cli = cod_cli;
    }

    public int getCod_com() {
        return cod_com;
    }

    public void setCod_com(int cod_com) {
        this.cod_com = cod_com;
    }

    public String getNombre_cli() {
        return nombre_cli;
    }

    public void setNombre_cli(String nombre_cli) {
        this.nombre_cli = nombre_cli;
    }

    public String getApaterno_cli() {
        return apaterno_cli;
    }

    public void setApaterno_cli(String apaterno_cli) {
        this.apaterno_cli = apaterno_cli;
    }

    public String getAmaterno_cli() {
        return amaterno_cli;
    }

    public void setAmaterno_cli(String amaterno_cli) {
        this.amaterno_cli = amaterno_cli;
    }

    public String getTelefono_cli() {
        return telefono_cli;
    }

    public void setTelefono_cli(String telefono_cli) {
        this.telefono_cli = telefono_cli;
    }

    public String getMail_cli() {
        return mail_cli;
    }

    public void setMail_cli(String mail_cli) {
        this.mail_cli = mail_cli;
    }

    public String getDireccion_cli() {
        return direccion_cli;
    }

    public void setDireccion_cli(String direccion_cli) {
        this.direccion_cli = direccion_cli;
    }

    public String getNombre_com() {
        return nombre_com;
    }

    public void setNombre_com(String nombre_com) {
        this.nombre_com = nombre_com;
    }

    public ClienteService getClienteService() {
        return clienteService;
    }

    public void setClienteService(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    public String saveCliente() {
        boolean transaccionCorrecta = false;
        try {
            transaccionCorrecta = clienteService.guardarCliente(cod_cli,
                    cod_com,
                    nombre_cli,
                    apaterno_cli,
                    amaterno_cli,
                    telefono_cli,
                    mail_cli,
                    direccion_cli);

        } catch (SQLException ex) {
            Logger.getLogger(ClienteController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NamingException ex) {
            Logger.getLogger(ClienteController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return transaccionCorrecta ? "guardado" : "noguardado";
    }

    public String updateCliente() {
        boolean transaccionCorrecta = false;
        try {
            transaccionCorrecta = clienteService.actualizarCliente(cod_cli,
                    cod_com,
                    nombre_cli,
                    apaterno_cli,
                    amaterno_cli,
                    telefono_cli,
                    mail_cli,
                    direccion_cli);

        } catch (SQLException ex) {
            Logger.getLogger(CamionController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NamingException ex) {
            Logger.getLogger(CamionController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return transaccionCorrecta ? "actualizado" : "noactualizado";
    }

    public List<Cliente> obtenerCliente() {
        return clienteService.seleccionarTodosLosCliente();
    }

    public String deleteCliente() throws SQLException, NamingException {
        return clienteService.eliminarCliente(cod_cli) ? "eliminado" : "noeliminado";
    }

    public String seleccionarCliente(Cliente cliente) {
        Cliente c = clienteService.seleccionarCliente(cliente.getCodCli());
        if (c != null) {
            cod_cli = c.getCodCli();
            cod_com = c.getComuna().getCodCom();
            nombre_com = c.getComuna().getNombreCom();
            nombre_cli = c.getNombreCli();
            apaterno_cli = c.getApaternoCli();
            amaterno_cli = c.getAmaternoCli();
            telefono_cli = c.getTelefonoCli();
            mail_cli = c.getMailCli();
            direccion_cli = c.getDireccionCli();
            return "encontrado";
        } else {
            return "no_encontrado";
        }
    }
}
