package pos.kurtbadelt.elemento32.puntodeventav0.datalayer;

import android.content.ContentValues;

/**
 * Created by kurtbadelt on 11/2/16.
 */

public class CategoriaMenu extends DataLayerObject {


    private String nombreTabla = "CategoriaMenu";
    private int numeroCategoria = 0;
    private String NombreCategoria = "";
    private String Descripcion = "";
    private int menu_NumeroMenu = 0;
    private String estatusEnSistema = "";

    public int getNumeroCategoria() {
        return numeroCategoria;
    }

    public void setNumeroCategoria(int numeroCategoria) {
        this.numeroCategoria = numeroCategoria;
    }

    public String getNombreCategoria() {
        return NombreCategoria;
    }

    public void setNombreCategoria(String nombreCategoria) {
        NombreCategoria = nombreCategoria;
    }

    public String getNombreTabla() {
        return nombreTabla;
    }

    public void setNombreTabla(String nombreTabla) {
        this.nombreTabla = nombreTabla;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String descripcion) {
        Descripcion = descripcion;
    }

    public int getMenu_NumeroMenu() {
        return menu_NumeroMenu;
    }

    public void setMenu_NumeroMenu(int menu_NumeroMenu) {
        this.menu_NumeroMenu = menu_NumeroMenu;
    }

    public String getEstatusEnSistema() {
        return estatusEnSistema;
    }

    public void setEstatusEnSistema(String estatusEnSistema) {
        this.estatusEnSistema = estatusEnSistema;
    }

    public String toString() {
        String output = "";
        output = this.getNumeroCategoria() + ";" + this.getNombreCategoria() + ";" + this.getDescripcion() + ";" + this.getMenu_NumeroMenu() + ";" + this.getEstatusEnSistema();
        return output;
    }

    public ContentValues toDB() {
        ContentValues output = new ContentValues();

        output.put("NumeroCategoria", this.getNumeroCategoria());
        output.put("NombreCategoria", this.getNombreCategoria());
        output.put("Descripcion", this.getDescripcion());
        output.put("Menu_NumeroMenu", this.getMenu_NumeroMenu());
        output.put("EstatusEnSistema", this.getEstatusEnSistema());

        return output;

    }
}
