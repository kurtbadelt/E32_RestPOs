package pos.kurtbadelt.elemento32.puntodeventav0.datalayer;

import android.content.ContentValues;

/**
 * Created by kurtbadelt on 11/2/16.
 */

/***
 * tipos posibles de estatus para los ingredientes, tabla de multivaluados
 */
public class EstatusIngrediente extends DataLayerObject {


    private String nombreTabla = "EstatusIngrediente";
    private int numeroEstatusIngrediente=0;
    private String nombreEstatusIngrediente="";
    private String descripcion="";
    private String estatusEnSistema="";

    public int getNumeroEstatusIngrediente() {
        return numeroEstatusIngrediente;
    }

    public void setNumeroEstatusIngrediente(int numeroEstatusIngrediente) {
        this.numeroEstatusIngrediente = numeroEstatusIngrediente;
    }

    public String getNombreEstatusIngrediente() {
        return nombreEstatusIngrediente;
    }

    public void setNombreEstatusIngrediente(String nombreEstatusIngrediente) {
        this.nombreEstatusIngrediente = nombreEstatusIngrediente;
    }

    public String getNombreTabla() {
        return nombreTabla;
    }

    public void setNombreTabla(String nombreTabla) {
        this.nombreTabla = nombreTabla;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getEstatusEnSistema() {
        return estatusEnSistema;
    }

    public void setEstatusEnSistema(String estatusEnSistema) {
        this.estatusEnSistema = estatusEnSistema;
    }
    public String toString(){
        String output="";
        output=this.getNumeroEstatusIngrediente()+";"+this.getNombreEstatusIngrediente()+";"+this.getDescripcion()+";"+this.getEstatusEnSistema();
        return output;
    }
    public ContentValues toDB(){
        ContentValues output = new ContentValues();
        output.put("NumeroEstatusIngrediente",this.getNumeroEstatusIngrediente());
        output.put("NombreEstatusIngrediente",this.getNombreEstatusIngrediente());
        output.put("Descripcion",this.getDescripcion());
        output.put("EstatusEnSistema",this.getEstatusEnSistema());

        return output;

    }
}
