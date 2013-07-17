package Model.Entity;

/**
 *
 * @author darwin
 */
public class Ruta {

    private int cod_ruta;
    private int cod_com_ini;
    private int cod_com_dest;
    private String inicio;
    private String destino;
    private float t_prom_ruta;
    private float dist_prom_ruta;
    
     public Ruta() {
    }
    
   public int getCod_com_dest() {
        return cod_com_dest;
    }

    public void setCod_com_dest(int cod_com_dest) {
        this.cod_com_dest = cod_com_dest;
    }

    public int getCod_com_ini() {
        return cod_com_ini;
    }

    public void setCod_com_ini(int cod_com_ini) {
        this.cod_com_ini = cod_com_ini;
    }

    public int getCod_ruta() {
        return cod_ruta;
    }

    public void setCod_ruta(int cod_ruta) {
        this.cod_ruta = cod_ruta;
    }

    public float getDist_prom_ruta() {
        return dist_prom_ruta;
    }

    public void setDist_prom_ruta(float dist_prom_ruta) {
        this.dist_prom_ruta = dist_prom_ruta;
    }

    public float getT_prom_ruta() {
        return t_prom_ruta;
    }

    public String getInicio() {
        return inicio;
    }

    public void setInicio(String inicio) {
        this.inicio = inicio;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public void setT_prom_ruta(float t_prom_ruta) {
        this.t_prom_ruta = t_prom_ruta;
    }
 
    public Ruta(int cod_ruta, int cod_com_ini, int cod_com_dest, float t_prom_ruta, float dist_prom_ruta) {
        this.cod_ruta = cod_ruta;
        this.cod_com_ini = cod_com_ini;
        this.cod_com_dest = cod_com_dest;
        this.t_prom_ruta = t_prom_ruta;
        this.dist_prom_ruta = dist_prom_ruta;
    }
    
     @Override
    public String toString() {
        return "Ruta{" + "cod_ruta=" + cod_ruta + ", cod_com_ini=" + cod_com_ini + ", cod_com_dest=" + cod_com_dest + ", t_prom_ruta=" + t_prom_ruta + ", dist_prom_ruta=" + dist_prom_ruta + '}';
    }
}

    