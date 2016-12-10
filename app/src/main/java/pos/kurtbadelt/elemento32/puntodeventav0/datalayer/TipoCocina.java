package pos.kurtbadelt.elemento32.puntodeventav0.datalayer;

import android.content.ContentValues;

/**
 * Created by kurtbadelt on 11/2/16.
 */

public class TipoCocina extends DataLayerObject {


    private String nombreTabla = "TipoCocina";
    private int numeroTipoCocina = 0;
    private String nombreTipoCocina = "";
    private String descripcionTipoCocina = "";
    private String estatusEnSistema = "";

    public int getNumeroTipoCocina() {
        return numeroTipoCocina;
    }

    public void setNumeroTipoCocina(int numeroTipoCocina) {
        this.numeroTipoCocina = numeroTipoCocina;
    }

    public String getNombreTabla() {
        return nombreTabla;
    }

    public void setNombreTabla(String nombreTabla) {
        this.nombreTabla = nombreTabla;
    }

    public String getNombreTipoCocina() {
        return nombreTipoCocina;
    }

    public void setNombreTipoCocina(String nombreTipoCocina) {
        this.nombreTipoCocina = nombreTipoCocina;
    }

    public String getDescripcionTipoCocina() {
        return descripcionTipoCocina;
    }

    public void setDescripcionTipoCocina(String descripcionTipoCocina) {
        this.descripcionTipoCocina = descripcionTipoCocina;
    }

    public String getEstatusEnSistema() {
        return estatusEnSistema;
    }

    public void setEstatusEnSistema(String estatusEnSistema) {
        this.estatusEnSistema = estatusEnSistema;
    }

    public String toString() {
        String output = "";
        output = this.getNumeroTipoCocina() + ";" + this.getNombreTipoCocina() + ";" + this.getDescripcionTipoCocina() + ";" + this.getEstatusEnSistema();
        return output;
    }

    public ContentValues toDB() {
        ContentValues output = new ContentValues();
        output.put("NumeroTipoCocina", this.getNumeroTipoCocina());
        output.put("NombreTipoCocina", this.getNombreTipoCocina());
        output.put("DescripcionTipoCocina", this.getDescripcionTipoCocina());
        output.put("EstatusEnSistema", this.getEstatusEnSistema());

        return output;

    }
}
