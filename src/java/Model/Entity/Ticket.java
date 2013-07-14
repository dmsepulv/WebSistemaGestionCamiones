package Model.Entity;

public class Ticket {

    private int cod_tic;
    private int cod_via;
    private String tipo_tic;
    private int valor_tic;

    public Ticket() {
    }
            
    public Ticket(int cod_tic, int cod_via, String tipo_tic, int valor_tick) {
        this.cod_tic = cod_tic;
        this.cod_via = cod_via;
        this.tipo_tic = tipo_tic;
        this.valor_tic = valor_tick;
    }

    public int getCod_tic() {
        return cod_tic;
    }

    public void setCod_tic(int cod_tic) {
        this.cod_tic = cod_tic;
    }

    public int getCod_via() {
        return cod_via;
    }

    public void setCod_via(int cod_via) {
        this.cod_via = cod_via;
    }

    public String getTipo_tic() {
        return tipo_tic;
    }

    public void setTipo_tic(String tipo_tic) {
        this.tipo_tic = tipo_tic;
    }

    public int getValor_tick() {
        return valor_tic;
    }

    public void setValor_tic(int valor_tick) {
        this.valor_tic = valor_tick;
    }

    @Override
    public String toString() {
        return "Ticket{" + "cod_tic=" + cod_tic + ", cod_via=" + cod_via + ", tipo_tic=" + tipo_tic + ", valor_tic=" + valor_tic + '}';
    }
    
    
    
     
}