package pos.kurtbadelt.elemento32.puntodeventav0.datalayer;

import android.content.ContentValues;

/**
 * Created by kurtbadelt on 11/2/16.
 */

public class Facturas extends DataLayerObject {


    private String nombreTabla = "Facturas";
    private int numeroFactura=0;
    private String UUID="";
    private String RFC="";
    private double subTotal=0;
    private double iva=0;
    private double total=0;
    private String descripcion="";
    private String estatusEnSistema="";

    public int getNumeroFactura() {
        return numeroFactura;
    }

    public void setNumeroFactura(int numeroFactura) {
        this.numeroFactura = numeroFactura;
    }

    public String getNombreTabla() {
        return nombreTabla;
    }

    public void setNombreTabla(String nombreTabla) {
        this.nombreTabla = nombreTabla;
    }

    public String getUUID() {
        return UUID;
    }

    public void setUUID(String UUID) {
        this.UUID = UUID;
    }

    public String getRFC() {
        return RFC;
    }

    public void setRFC(String RFC) {
        this.RFC = RFC;
    }

    public double getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(double subTotal) {
        this.subTotal = subTotal;
    }

    public double getIva() {
        return iva;
    }

    public void setIva(double iva) {
        this.iva = iva;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
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
        output=this.getNumeroFactura()+";"+this.getUUID()+";"+this.getRFC()+";"+this.getSubTotal()+";"+this.getIva()+";"+this.getTotal()+";"+
                this.getDescripcion()+";"+this.getEstatusEnSistema();
        return output;
    }
    public ContentValues toDB(){
        ContentValues output = new ContentValues();
        output.put("NumeroFactura",this.getNumeroFactura());
        output.put("UUID",this.getUUID());
        output.put("RFC",this.getRFC());
        output.put("SubTotal",this.getSubTotal());
        output.put("IVA",this.getIva());
        output.put("Total",this.getTotal());
        output.put("Descripcion",this.getDescripcion());
        output.put("EstatusEnSistema",this.getEstatusEnSistema());

        return output;

    }
}
