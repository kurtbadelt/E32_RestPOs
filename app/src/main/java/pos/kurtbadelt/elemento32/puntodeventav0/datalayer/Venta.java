package pos.kurtbadelt.elemento32.puntodeventav0.datalayer;

import android.content.ContentValues;

/**
 * Created by kurtbadelt on 11/2/16.
 */

public class Venta {

    private int numeroTicket=0;
    private int numeroFactura=0;
    private double montoTotal=0;
    private String estatusEnSistema="";
    private int tipoDePago_NumeroTipoPago=0;

    public int getNumeroTicket() {
        return numeroTicket;
    }

    public void setNumeroTicket(int numeroTicket) {
        this.numeroTicket = numeroTicket;
    }

    public int getNumeroFactura() {
        return numeroFactura;
    }

    public void setNumeroFactura(int numeroFactura) {
        this.numeroFactura = numeroFactura;
    }

    public double getMontoTotal() {
        return montoTotal;
    }

    public void setMontoTotal(double montoTotal) {
        this.montoTotal = montoTotal;
    }

    public String getEstatusEnSistema() {
        return estatusEnSistema;
    }

    public void setEstatusEnSistema(String estatusEnSistema) {
        this.estatusEnSistema = estatusEnSistema;
    }

    public int getTipoDePago_NumeroTipoPago() {
        return tipoDePago_NumeroTipoPago;
    }

    public void setTipoDePago_NumeroTipoPago(int tipoDePago_NumeroTipoPago) {
        this.tipoDePago_NumeroTipoPago = tipoDePago_NumeroTipoPago;
    }
    public String toString(){
        String output="";
        output= this.getNumeroTicket()+";"+this.getNumeroFactura()+";"+this.getMontoTotal()+";"+this.getEstatusEnSistema()+";"+this.getTipoDePago_NumeroTipoPago();
        return output;
    }
    public ContentValues toDB(){
        ContentValues output = new ContentValues();
        output.put("NumeroTicket",this.getNumeroTicket());
        output.put("NumeroFactura",this.getNumeroFactura());
        output.put("MontoTotal",this.getMontoTotal());
        output.put("EstatusEnSistema",this.getEstatusEnSistema());
        output.put("TipoDePago_NumeroTipoPago",this.getTipoDePago_NumeroTipoPago());

        return output;

    }
}
