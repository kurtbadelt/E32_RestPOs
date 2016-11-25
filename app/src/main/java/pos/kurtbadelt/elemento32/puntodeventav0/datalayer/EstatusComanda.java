package pos.kurtbadelt.elemento32.puntodeventav0.datalayer;

import android.content.ContentValues;

/**
 * Created by kurtbadelt on 11/2/16.
 */

public class EstatusComanda extends DataLayerObject {


    private String nombreTabla = "EstatusComanda";
    private int numeroEstatus=0;
    private String nombreEstatus="";
    private String descripcion="";
    private String estatusEnSistema="";

    public int getNumeroEstatus() {
        return numeroEstatus;
    }

    public void setNumeroEstatus(int numeroEstatus) {
        this.numeroEstatus = numeroEstatus;
    }

    public String getNombreEstatus() {
        return nombreEstatus;
    }

    public void setNombreEstatus(String nombreEstatus) {
        this.nombreEstatus = nombreEstatus;
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
        output=this.getNumeroEstatus()+";"+this.getNombreEstatus()+";"+this.getDescripcion()+";"+this.getEstatusEnSistema();
        return output;
    }

    /**
     *
     *
     * @return
     */
    public ContentValues toDB(){
        ContentValues output = new ContentValues();
        output.put("NumeroEstatus",this.getNumeroEstatus());
        output.put("NombreEstatus",this.getNombreEstatus());
        output.put("Descripcion",this.getDescripcion());
        output.put("EstatusEnSistema",this.getEstatusEnSistema());
        return output;

    }
}
