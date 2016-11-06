package pos.kurtbadelt.elemento32.puntodeventav0.datalayer;

import android.content.ContentValues;

/**
 * Created by kurtbadelt on 11/2/16.
 */

public class TipoMesa {
    private int numeroTipoMesa=0;

    public String getNombreTipoMesa() {
        return nombreTipoMesa;
    }

    public void setNombreTipoMesa(String nombreTipoMesa) {
        this.nombreTipoMesa = nombreTipoMesa;
    }

    private String nombreTipoMesa="";
    private String descripcion="";
    private String estatusEnSistema="";

    public int getNumeroTipoMesa() {
        return numeroTipoMesa;
    }

    public void setNumeroTipoMesa(int numeroTipoMesa) {
        this.numeroTipoMesa = numeroTipoMesa;
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
        output=this.getNumeroTipoMesa()+";"+this.getNombreTipoMesa()+";"+this.getDescripcion()+";"+this.getEstatusEnSistema();
        return output;
    }
    public ContentValues toDB(){
        ContentValues output = new ContentValues();


        return output;

    }
}
