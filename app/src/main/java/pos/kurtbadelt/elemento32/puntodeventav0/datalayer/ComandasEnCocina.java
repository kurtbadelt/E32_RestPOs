package pos.kurtbadelt.elemento32.puntodeventav0.datalayer;

import android.content.ContentValues;

/**
 * Created by kurtbadelt on 11/2/16.
 */

public class ComandasEnCocina {
    private int cocina_NumeroCocina=0;
    private int comanda_NumeroComanda=0;
    private String estatusEnSistema="";

    public int getCocina_NumeroCocina() {
        return cocina_NumeroCocina;
    }

    public void setCocina_NumeroCocina(int cocina_NumeroCocina) {
        this.cocina_NumeroCocina = cocina_NumeroCocina;
    }

    public int getComanda_NumeroComanda() {
        return comanda_NumeroComanda;
    }

    public void setComanda_NumeroComanda(int comanda_NumeroComanda) {
        this.comanda_NumeroComanda = comanda_NumeroComanda;
    }

    public String getEstatusEnSistema() {
        return estatusEnSistema;
    }

    public void setEstatusEnSistema(String estatusEnSistema) {
        this.estatusEnSistema = estatusEnSistema;
    }
    public String toString(){
        String output="";
        output=this.getCocina_NumeroCocina()+";"+this.getComanda_NumeroComanda()+";"+this.getEstatusEnSistema();
        return output;
    }
    public ContentValues toDB(){
        ContentValues output = new ContentValues();
        output.put("Cocina_NumeroCocina",this.getCocina_NumeroCocina());
        output.put("Comanda_NumeroComanda",this.getComanda_NumeroComanda());
        output.put("EstatusEnSistema",this.getEstatusEnSistema());

        return output;

    }
}
