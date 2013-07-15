package Controller;

import java.util.ArrayList;
import javax.inject.Named;
import javax.enterprise.context.ApplicationScoped;
import Util.ElementoLista;
import Model.Entity.Comuna;
import javax.inject.Inject;
import Model.Service.ComunaService;
import java.util.LinkedList;

/**
 *
 * @author IGNACIO
 */
@Named(value = "listaDropController")
@ApplicationScoped
public class ListaDropController {

    private @Inject
    ComunaService comunaService;
    private ArrayList<ElementoLista> lista;

    public ListaDropController() {
        lista = new ArrayList<ElementoLista>();
    }

    public ArrayList<ElementoLista> getList() {
        return lista;
    }

    public void setList(ArrayList<ElementoLista> coffee3List) {
        this.lista = coffee3List;
    }
    
    public ArrayList<ElementoLista> cargaListaEstadosFiltro() {
        lista.clear();
        lista.add(new ElementoLista("TODOS", 1));
        lista.add(new ElementoLista("ACTIVO", 2));
        lista.add(new ElementoLista("NO ACTIVO", 3));
        lista.add(new ElementoLista("MANTENCION", 4));
        return lista;
    }

    public ArrayList<ElementoLista> cargaListaEstados() {
        lista.clear();
        lista.add(new ElementoLista("ACTIVO", 1));
        lista.add(new ElementoLista("NO ACTIVO", 2));
        lista.add(new ElementoLista("MANTENCION", 3));
        return lista;
    }

    public ArrayList<ElementoLista> cargaListaEstadoUsuario() {
        lista.clear();
        lista.add(new ElementoLista("ACTIVO", 1));
        lista.add(new ElementoLista("NO ACTIVO", 2));
        return lista;
    }

    public ArrayList<ElementoLista> cargaListaCiudades() {
        lista.clear();
        LinkedList<Comuna> comunas = comunaService.seleccionarTodosLosComuna();
        for (Comuna comuna : comunas) {
            lista.add(new ElementoLista(comuna.getNombreCom(), comuna.getCodCom()));
        }
        return lista;
    }
}
