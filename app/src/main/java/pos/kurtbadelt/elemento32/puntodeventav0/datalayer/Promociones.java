package pos.kurtbadelt.elemento32.puntodeventav0.datalayer;

import android.content.ContentValues;

/**
 * Created by kurtbadelt on 11/2/16.
 */

public class Promociones {
    private int numeroPromocion=0;
    private String nombrePromocion="";
    private String descripcion="";
    private String inicioPromocion="";
    private String finPromocion="";
    private double descuento=0;
    private String estatusEnSistema="";

    public int getNumeroPromocion() {
        return numeroPromocion;
    }

    public void setNumeroPromocion(int numeroPromocion) {
        this.numeroPromocion = numeroPromocion;
    }

    public String getNombrePromocion() {
        return nombrePromocion;
    }

    public void setNombrePromocion(String nombrePromocion) {
        this.nombrePromocion = nombrePromocion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getInicioPromocion() {
        return inicioPromocion;
    }

    public void setInicioPromocion(String inicioPromocion) {
        this.inicioPromocion = inicioPromocion;
    }

    public String getFinPromocion() {
        return finPromocion;
    }

    public void setFinPromocion(String finPromocion) {
        this.finPromocion = finPromocion;
    }

    public double getDescuento() {
        return descuento;
    }

    public void setDescuento(double descuento) {
        this.descuento = descuento;
    }

    public String getEstatusEnSistema() {
        return estatusEnSistema;
    }

    public void setEstatusEnSistema(String estatusEnSistema) {
        this.estatusEnSistema = estatusEnSistema;
    }
    public String toString(){
        String output="";
        output=this.getNumeroPromocion()+";"+this.getNombrePromocion()+";"+this.getDescripcion()+";"+this.getInicioPromocion()+";"+this.getFinPromocion()+";"+
                this.getDescuento()+";"+this.getEstatusEnSistema();
        return output;
    }
    public ContentValues toDB(){
        ContentValues output = new ContentValues();


        return output;

    }
}
