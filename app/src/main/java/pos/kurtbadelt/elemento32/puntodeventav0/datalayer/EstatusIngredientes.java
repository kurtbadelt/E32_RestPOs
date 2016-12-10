package pos.kurtbadelt.elemento32.puntodeventav0.datalayer;

import android.content.ContentValues;

/**
 * Created by kurtbadelt on 11/2/16.
 */

/**
 * Almacena el estatus del ingrediente
 */
public class EstatusIngredientes extends DataLayerObject {


    private String nombreTabla = "EstatusIngredientes";
    private int ingrediente_NumeroIngrediente = 0;
    private int estatusIngrediente_NumeroEstatusIngrediente = 0;
    private String estatusEnSistema = "";

    public int getIngrediente_NumeroIngrediente() {
        return ingrediente_NumeroIngrediente;
    }

    public void setIngrediente_NumeroIngrediente(int ingrediente_NumeroIngrediente) {
        this.ingrediente_NumeroIngrediente = ingrediente_NumeroIngrediente;
    }

    public String getNombreTabla() {
        return nombreTabla;
    }

    public void setNombreTabla(String nombreTabla) {
        this.nombreTabla = nombreTabla;
    }

    public int getEstatusIngrediente_NumeroEstatusIngrediente() {
        return estatusIngrediente_NumeroEstatusIngrediente;
    }

    public void setEstatusIngrediente_NumeroEstatusIngrediente(int estatusIngrediente_NumeroEstatusIngrediente) {
        this.estatusIngrediente_NumeroEstatusIngrediente = estatusIngrediente_NumeroEstatusIngrediente;
    }

    public String getEstatusEnSistema() {
        return estatusEnSistema;
    }

    public void setEstatusEnSistema(String estatusEnSistema) {
        this.estatusEnSistema = estatusEnSistema;
    }

    public String toString() {
        String output = "";
        output = this.getIngrediente_NumeroIngrediente() + ";" + this.getEstatusIngrediente_NumeroEstatusIngrediente() + ";" + this.getEstatusEnSistema();
        return output;
    }

    public ContentValues toDB() {
        ContentValues output = new ContentValues();
        output.put("Ingrediente_NumeroIngrediente", this.getIngrediente_NumeroIngrediente());
        output.put("EstatusIngrediente_NumeroEstatusIngrediente", this.getEstatusIngrediente_NumeroEstatusIngrediente());
        output.put("EstatusEnSistema", this.getEstatusEnSistema());

        return output;

    }
}

