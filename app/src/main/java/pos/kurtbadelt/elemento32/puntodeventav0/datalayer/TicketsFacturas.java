package pos.kurtbadelt.elemento32.puntodeventav0.datalayer;

import android.content.ContentValues;

/**
 * Created by kurtbadelt on 11/2/16.
 */

public class TicketsFacturas extends DataLayerObject {


    private String nombreTabla = "TicketsFacturas";
    private int venta_NumeroTicket = 0;
    private int venta_NumeroTipoPago = 0;
    private int facturas_NumeroFactura = 0;
    private String estatusEnSistema = "";

    public int getVenta_NumeroTicket() {
        return venta_NumeroTicket;
    }

    public void setVenta_NumeroTicket(int venta_NumeroTicket) {
        this.venta_NumeroTicket = venta_NumeroTicket;
    }

    public String getNombreTabla() {
        return nombreTabla;
    }

    public void setNombreTabla(String nombreTabla) {
        this.nombreTabla = nombreTabla;
    }

    public int getVenta_NumeroTipoPago() {
        return venta_NumeroTipoPago;
    }

    public void setVenta_NumeroTipoPago(int venta_NumeroTipoPago) {
        this.venta_NumeroTipoPago = venta_NumeroTipoPago;
    }

    public int getFacturas_NumeroFactura() {
        return facturas_NumeroFactura;
    }

    public void setFacturas_NumeroFactura(int facturas_NumeroFactura) {
        this.facturas_NumeroFactura = facturas_NumeroFactura;
    }

    public String getEstatusEnSistema() {
        return estatusEnSistema;
    }

    public void setEstatusEnSistema(String estatusEnSistema) {
        this.estatusEnSistema = estatusEnSistema;
    }

    public String toString() {
        String output = "";
        output = this.getVenta_NumeroTicket() + ";" + this.getVenta_NumeroTipoPago() + ";" + this.getFacturas_NumeroFactura() + ";" + this.getEstatusEnSistema();
        return output;
    }

    public ContentValues toDB() {
        ContentValues output = new ContentValues();

        output.put("Venta_NumeroTicket", this.getVenta_NumeroTicket());
        output.put("Venta_NumeroTIpoPago", this.getVenta_NumeroTipoPago());
        output.put("Facturas_NumeroFactura", this.getFacturas_NumeroFactura());
        output.put("EstatusEnSistema", this.getEstatusEnSistema());

        return output;

    }
}
