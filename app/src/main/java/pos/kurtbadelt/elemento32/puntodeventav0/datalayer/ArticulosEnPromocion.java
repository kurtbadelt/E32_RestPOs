package pos.kurtbadelt.elemento32.puntodeventav0.datalayer;

import android.content.ContentValues;

/**
 * Created by kurtbadelt on 11/2/16.
 */

public class ArticulosEnPromocion  {
    private int articulos_NumeroArticulo=0;
    private int promociones_NumeroPromocion=0;
    private String estatusEnSistema="";

    public int getArticulos_NumeroArticulo() {
        return articulos_NumeroArticulo;
    }

    public void setArticulos_NumeroArticulo(int articulos_NumeroArticulo) {
        this.articulos_NumeroArticulo = articulos_NumeroArticulo;
    }

    public int getPromociones_NumeroPromocion() {
        return promociones_NumeroPromocion;
    }

    public void setPromociones_NumeroPromocion(int promociones_NumeroPromocion) {
        this.promociones_NumeroPromocion = promociones_NumeroPromocion;
    }

    public String getEstatusEnSistema() {
        return estatusEnSistema;
    }

    public void setEstatusEnSistema(String estatusEnSistema) {
        this.estatusEnSistema = estatusEnSistema;
    }
    public String toString(){
        String output="";
        output=this.getArticulos_NumeroArticulo()+";"+this.getPromociones_NumeroPromocion()+";"+this.getEstatusEnSistema();
        return output;
    }
    public ContentValues toDB(){
        ContentValues output = new ContentValues();
        output.put("Articulos_NumeroArticulo",this.getArticulos_NumeroArticulo());
        output.put("Promociones_NumeroPromocion",this.getPromociones_NumeroPromocion());
        output.put("EstatusEnSistema",this.getEstatusEnSistema());

        return output;

    }
}
