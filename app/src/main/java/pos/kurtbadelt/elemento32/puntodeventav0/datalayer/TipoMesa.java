package pos.kurtbadelt.elemento32.puntodeventav0.datalayer;

import android.content.ContentValues;

/**
 * Created by kurtbadelt on 11/2/16.
 */

public class TipoMesa extends DataLayerObject {


    private String nombreTabla = "TipoMesa";
    private int numeroTipoMesa=0;
    private String nombreTipoMesa="";
    private String descripcion="";
    private String estatusEnSistema="";

    public String getNombreTipoMesa() {
        return nombreTipoMesa;
    }

    public void setNombreTipoMesa(String nombreTipoMesa) {
        this.nombreTipoMesa = nombreTipoMesa;
    }

    public String getNombreTabla() {
        return nombreTabla;
    }

    public void setNombreTabla(String nombreTabla) {
        this.nombreTabla = nombreTabla;
    }

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

        output.put("NumeroTipoMesa",this.getNumeroTipoMesa());
        output.put("NombreTipoMesa",this.getNombreTipoMesa());
        output.put("Descripcion",this.getDescripcion());
        output.put("EstatusEnSistema",this.getEstatusEnSistema());

        return output;

    }
}
