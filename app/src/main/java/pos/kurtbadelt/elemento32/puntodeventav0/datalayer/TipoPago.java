package pos.kurtbadelt.elemento32.puntodeventav0.datalayer;

import android.content.ContentValues;

/**
 * Created by kurtbadelt on 11/2/16.
 */

public class TipoPago {
    private int numeroTipoDePago=0;
    private String nombreTipoDePago="";
    private String descripcionTIpoDePago="";
    private String estatusEnSistema="";

    public String getNombreTipoDePago() {
        return nombreTipoDePago;
    }

    public void setNombreTipoDePago(String nombreTipoDePago) {
        this.nombreTipoDePago = nombreTipoDePago;
    }



    public int getNumeroTipoDePago() {
        return numeroTipoDePago;
    }

    public void setNumeroTipoDePago(int numeroTipoDePago) {
        this.numeroTipoDePago = numeroTipoDePago;
    }

    public String getDescripcionTIpoDePago() {
        return descripcionTIpoDePago;
    }

    public void setDescripcionTIpoDePago(String descripcionTIpoDePago) {
        this.descripcionTIpoDePago = descripcionTIpoDePago;
    }

    public String getEstatusEnSistema() {
        return estatusEnSistema;
    }

    public void setEstatusEnSistema(String estatusEnSistema) {
        this.estatusEnSistema = estatusEnSistema;
    }
    public String toString(){
        String output  ;
        output=this.getNumeroTipoDePago()+";"+this.getDescripcionTIpoDePago()+";"+this.getEstatusEnSistema();
        return output;
    }
    public ContentValues toDB(){
        ContentValues output = new ContentValues();
        output.put("NumeroTipoPago",this.getNumeroTipoDePago());
        output.put("NombreTipoPago",this.getNombreTipoDePago());
        output.put("DescripcionTipoPago",this.getDescripcionTIpoDePago());
        output.put("EstatusEnSistema",this.getEstatusEnSistema());

        return output;

    }
}
