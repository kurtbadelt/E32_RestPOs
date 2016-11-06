package pos.kurtbadelt.elemento32.puntodeventav0.datalayer;

import android.content.ContentValues;

/**
 * Created by kurtbadelt on 11/2/16.
 */

public class ArticulosEnMenu {
    private int menu_NumeroMenu=0;
    private int articulos_NumeroArticulo=0;
    private String estatusEnSistema="";

    public String getEstatusEnSistema() {
        return estatusEnSistema;
    }

    public void setEstatusEnSistema(String estatusEnSistema) {
        this.estatusEnSistema = estatusEnSistema;
    }

    public int getMenu_NumeroMenu() {
        return menu_NumeroMenu;
    }

    public void setMenu_NumeroMenu(int menu_NumeroMenu) {
        this.menu_NumeroMenu = menu_NumeroMenu;
    }

    public int getArticulos_NumeroArticulo() {
        return articulos_NumeroArticulo;
    }

    public void setArticulos_NumeroArticulo(int articulos_NumeroArticulo) {
        this.articulos_NumeroArticulo = articulos_NumeroArticulo;
    }
    public String toString(){
        String output="";
        output=this.getMenu_NumeroMenu()+";"+this.getArticulos_NumeroArticulo()+";"+this.getEstatusEnSistema();
        return output;
    }
    public ContentValues toDB(){
        ContentValues output = new ContentValues();
        output.put("Menu_NumeroMenu",this.getMenu_NumeroMenu());
        output.put("Articulos_NumeroArticulo",this.getArticulos_NumeroArticulo());
        output.put("EstatusEnSistema",this.getEstatusEnSistema());

        return output;

    }
}
