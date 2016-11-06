package pos.kurtbadelt.elemento32.puntodeventav0.datalayer;

import android.content.ContentValues;

/**
 * Created by kurtbadelt on 11/2/16.
 */

public class ComandasEnVenta {
    private int venta_NumeroTicket=0;
    private int venta_NumeroTipoPago=0;
    private int comanda_NumeroComanda=0;
    private String estatusEnSistema="";

    public int getVenta_NumeroTicket() {
        return venta_NumeroTicket;
    }

    public void setVenta_NumeroTicket(int venta_NumeroTicket) {
        this.venta_NumeroTicket = venta_NumeroTicket;
    }

    public int getVenta_NumeroTipoPago() {
        return venta_NumeroTipoPago;
    }

    public void setVenta_NumeroTipoPago(int venta_NumeroTipoPago) {
        this.venta_NumeroTipoPago = venta_NumeroTipoPago;
    }

    public int getComanda_NumeroComanda() {
        return comanda_NumeroComanda;
    }

    public void setComanda_NumeroComanda(int comanda_NumeroComanda) {
        this.comanda_NumeroComanda = comanda_NumeroComanda;
    }

    public String getEstatusEnSistema() {
        return estatusEnSistema;
    }

    public void setEstatusEnSistema(String estatusEnSistema) {
        this.estatusEnSistema = estatusEnSistema;
    }
    public String toString(){
        String output="";
        output=this.getVenta_NumeroTicket()+";"+this.getVenta_NumeroTipoPago()+";"+this.getComanda_NumeroComanda()+";"+this.getEstatusEnSistema();
        return output;
    }
    public ContentValues toDB(){
        ContentValues output = new ContentValues();
        output.put("Venta_NumeroTicket",this.getVenta_NumeroTicket());
        output.put("Venta_NumeroTipoPago",this.getVenta_NumeroTipoPago());
        output.put("Comanda_NumeroComanda",this.getComanda_NumeroComanda());
        output.put("EstatusEnSistema",this.getEstatusEnSistema());

        return output;

    }
}
