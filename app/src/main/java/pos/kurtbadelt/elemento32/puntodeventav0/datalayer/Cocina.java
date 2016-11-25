package pos.kurtbadelt.elemento32.puntodeventav0.datalayer;

import android.content.ContentValues;

/**
 * Created by kurtbadelt on 11/2/16.
 */

public class Cocina extends DataLayerObject {


    private String nombreTabla="Cocina";
    private int numeroCocina=0;
    private int numeroCocineros=0;
    private int tipoCocina_NumeroTipoCocina=0;
    private String estatusEnSistema="";

    public int getNumeroCocina() {
        return numeroCocina;
    }

    public void setNumeroCocina(int numeroCocina) {
        this.numeroCocina = numeroCocina;
    }

    public String getNombreTabla() {
        return nombreTabla;
    }

    public void setNombreTabla(String nombreTabla) {
        this.nombreTabla = nombreTabla;
    }

    public int getNumeroCocineros() {
        return numeroCocineros;
    }

    public void setNumeroCocineros(int numeroCocineros) {
        this.numeroCocineros = numeroCocineros;
    }

    public int getTipoCocina_NumeroTipoCocina() {
        return tipoCocina_NumeroTipoCocina;
    }

    public void setTipoCocina_NumeroTipoCocina(int tipoCocina_NumeroTipoCocina) {
        this.tipoCocina_NumeroTipoCocina = tipoCocina_NumeroTipoCocina;
    }

    public String getEstatusEnSistema() {
        return estatusEnSistema;
    }

    public void setEstatusEnSistema(String estatusEnSistema) {
        this.estatusEnSistema = estatusEnSistema;
    }
    public String toString(){
        String output="";
        output=this.getNumeroCocina()+";"+this.getNumeroCocineros()+";"+this.getTipoCocina_NumeroTipoCocina()+";"+this.getEstatusEnSistema();
        return output;
    }
    public ContentValues toDB(){
        ContentValues output = new ContentValues();

        output.put("NumeroCocina",this.getNumeroCocina());
        output.put("NumerDeCocineros",this.getNumeroCocineros());
        output.put("TipoCocina",this.getTipoCocina_NumeroTipoCocina());
        output.put("EstatusEnSistema",this.getEstatusEnSistema());

        return output;

    }
}
