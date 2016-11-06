package pos.kurtbadelt.elemento32.puntodeventav0.datalayer;

import android.content.ContentValues;

/**
 * Created by kurtbadelt on 11/2/16.
 */

public class BodegaInventario {
    int numeroBodega=0;
    String nombreBodega="";
    String descripcion="";
    String ubicacion="";
    String estatusEnSistema="";

    public int getNumeroBodega() {
        return numeroBodega;
    }

    public void setNumeroBodega(int numeroBodega) {
        this.numeroBodega = numeroBodega;
    }

    public String getNombreBodega() {
        return nombreBodega;
    }

    public void setNombreBodega(String nombreBodega) {
        this.nombreBodega = nombreBodega;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getEstatusEnSistema() {
        return estatusEnSistema;
    }

    public void setEstatusEnSistema(String estatusEnSistema) {
        this.estatusEnSistema = estatusEnSistema;
    }
    public String toString(){
        String output="";
        output=this.getNumeroBodega()+";"+this.getNombreBodega()+";"+this.getDescripcion()+";"+this.getUbicacion()+";"+this.getEstatusEnSistema();
        return output;
    }
    public ContentValues toDB(){
        ContentValues output = new ContentValues();
        output.put("NumeroBodega",this.getNumeroBodega());
        output.put("NombreBodega",this.getNombreBodega());
        output.put("Descripcion",this.getDescripcion());
        output.put("Ubicacion",this.getUbicacion());
        output.put("EstatusEnSistema",this.getEstatusEnSistema());

        return output;

    }
}
