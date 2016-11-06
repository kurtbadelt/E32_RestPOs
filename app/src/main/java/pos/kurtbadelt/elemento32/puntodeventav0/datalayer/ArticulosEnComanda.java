package pos.kurtbadelt.elemento32.puntodeventav0.datalayer;

import android.content.ContentValues;

/**
 * Created by kurtbadelt on 11/2/16.
 */

public class ArticulosEnComanda  {

    private int comanda_NumeroComanda=0;
    private int articulos_NumeroArticulo=0;
    private String estatusEnSistema="";

    public String getEstatusEnSistema() {
        return estatusEnSistema;
    }

    public void setEstatusEnSistema(String estatusEnSistema) {
        this.estatusEnSistema = estatusEnSistema;
    }

    public int getComanda_NumeroComanda() {
        return comanda_NumeroComanda;
    }

    public void setComanda_NumeroComanda(int comanda_NumeroComanda) {
        this.comanda_NumeroComanda = comanda_NumeroComanda;
    }

    public int getArticulos_NumeroArticulo() {
        return articulos_NumeroArticulo;
    }

    public void setArticulos_NumeroArticulo(int articulos_NumeroArticulo) {
        this.articulos_NumeroArticulo = articulos_NumeroArticulo;
    }

    public String toString(){
        String output=this.getComanda_NumeroComanda()+";"+this.getArticulos_NumeroArticulo()+";"+this.getEstatusEnSistema();
        return output;
    }
    public ContentValues toDB(){
        ContentValues output = new ContentValues();
        output.put("Comanda_NumeroComanda",this.getComanda_NumeroComanda());
        output.put("Articulos_NumeroArticulo",this.getArticulos_NumeroArticulo());
        output.put("EstatusEnSistema",this.getEstatusEnSistema());

        return output;

    }
}
