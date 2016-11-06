package pos.kurtbadelt.elemento32.puntodeventav0.datalayer;

import android.content.ContentValues;

/**
 * Created by kurtbadelt on 11/2/16.
 */

public class MotivosCancelacion {
    private int numeroMotivo=0;
    private String nombreMotivo="";
    private String descripcion="";
    private String estatusEnSistema="";

    public int getNumeroMotivo() {
        return numeroMotivo;
    }

    public void setNumeroMotivo(int numeroMotivo) {
        this.numeroMotivo = numeroMotivo;
    }

    public String getNombreMotivo() {
        return nombreMotivo;
    }

    public void setNombreMotivo(String nombreMotivo) {
        this.nombreMotivo = nombreMotivo;
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
        output = this.getNumeroMotivo()+";"+this.getNombreMotivo()+";"+this.getDescripcion()+";"+this.getEstatusEnSistema();
        return output;
    }
    public ContentValues toDB(){
        ContentValues output = new ContentValues();


        return output;

    }

}
