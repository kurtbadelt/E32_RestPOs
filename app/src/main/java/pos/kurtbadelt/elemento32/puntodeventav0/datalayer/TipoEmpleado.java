package pos.kurtbadelt.elemento32.puntodeventav0.datalayer;

import android.content.ContentValues;

/**
 * Created by kurtbadelt on 11/2/16.
 */

public class TipoEmpleado extends DataLayerObject {


    private String nombreTabla = "TipoEmpleado";
    private int numeroTipoEmpleado = 0;
    private String nombreTipoEmpleado = "";
    private String descripcion = "";
    private String estatusEnSistema = "";

    public int getNumeroTipoEmpleado() {
        return numeroTipoEmpleado;
    }

    public void setNumeroTipoEmpleado(int numeroTipoEmpleado) {
        this.numeroTipoEmpleado = numeroTipoEmpleado;
    }

    public String getNombreTabla() {
        return nombreTabla;
    }

    public void setNombreTabla(String nombreTabla) {
        this.nombreTabla = nombreTabla;
    }

    public String getNombreTipoEmpleado() {
        return nombreTipoEmpleado;
    }

    public void setNombreTipoEmpleado(String nombreTipoEmpleado) {
        this.nombreTipoEmpleado = nombreTipoEmpleado;
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

    public String toString() {
        String output = "";
        output = this.getNumeroTipoEmpleado() + ";" + this.getNombreTipoEmpleado() + ";" + this.getDescripcion() + ";" + this.getEstatusEnSistema();
        return output;
    }

    public ContentValues toDB() {
        ContentValues output = new ContentValues();
        output.put("NumeroTipoEmpleado", this.getNumeroTipoEmpleado());
        output.put("NombreTipoEmpleado", this.getNombreTipoEmpleado());
        output.put("Descripcion", this.getDescripcion());
        output.put("EstatusEnSistema", this.getEstatusEnSistema());

        return output;

    }
}
