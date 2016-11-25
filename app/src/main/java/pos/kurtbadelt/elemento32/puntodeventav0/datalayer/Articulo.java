package pos.kurtbadelt.elemento32.puntodeventav0.datalayer;

import android.content.ContentValues;

/**
 * Created by kurtbadelt on 11/2/16.
 */

public class Articulo extends DataLayerObject {


    private String nombreTabla = "Articulo";
    private int numeroArticulo = 0;
    private String nombreArticulo = "";
    private String descripcion = "";
    private double precio = 0;
    private double costo = 0;

    private String estatusEnSistema = "";

    public String getEstatusEnSistema() {
        return estatusEnSistema;
    }

    public void setEstatusEnSistema(String estatusEnSistema) {
        this.estatusEnSistema = estatusEnSistema;
    }

    public int getNumeroArticulo() {
        return numeroArticulo;
    }

    public void setNumeroArticulo(int numeroArticulo) {
        this.numeroArticulo = numeroArticulo;
    }

    public String getNombreArticulo() {
        return nombreArticulo;
    }

    public void setNombreArticulo(String nombreArticulo) {
        this.nombreArticulo = nombreArticulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    public String getNombreTabla() {
        return nombreTabla;
    }

    public void setNombreTabla(String nombreTabla) {
        this.nombreTabla = nombreTabla;
    }


    public String toString() {
        String output = "";
        output = this.getNumeroArticulo() + ";" + this.getNombreArticulo() + ";" + this.getDescripcion() + ";" + this.getPrecio() + ";" + this.getCosto() + ";" + this.getEstatusEnSistema();
        return output;
    }

    public ContentValues toDB() {
        ContentValues output = new ContentValues();
        output.put("NumeroArticulo", this.getNumeroArticulo());
        output.put("NombreArticulo", this.getNombreArticulo());
        output.put("Descripcion", this.getDescripcion());
        output.put("Precio", this.getPrecio());
        output.put("Costo", this.getCosto());
        output.put("EstatusEnSistema", this.getCosto());


        return output;

    }

}
