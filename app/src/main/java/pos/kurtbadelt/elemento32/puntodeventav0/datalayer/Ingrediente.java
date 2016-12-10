package pos.kurtbadelt.elemento32.puntodeventav0.datalayer;

import android.content.ContentValues;

/**
 * Created by kurtbadelt on 11/2/16.
 */

public class Ingrediente extends DataLayerObject {


    private String nombreTabla = "Ingrediente";
    private int numeroIngrediente = 0;
    private String nombreIngrediente = "";
    private String descripcion = "";
    private double existencia = 0;
    private double precioCompra = 0;
    private double precioVenta = 0;
    private int tiempoEntregaDias = 0;
    private String formatoMedicion = "";
    private double inventarioMinimo = 0;
    private double inventarioMaximo = 0;
    private String estatusEnSistema = "";

    public int getNumeroIngrediente() {
        return numeroIngrediente;
    }

    public void setNumeroIngrediente(int numeroIngrediente) {
        this.numeroIngrediente = numeroIngrediente;
    }

    public String getNombreIngrediente() {
        return nombreIngrediente;
    }

    public void setNombreIngrediente(String nombreIngrediente) {
        this.nombreIngrediente = nombreIngrediente;
    }

    public String getNombreTabla() {
        return nombreTabla;
    }

    public void setNombreTabla(String nombreTabla) {
        this.nombreTabla = nombreTabla;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getExistencia() {
        return existencia;
    }

    public void setExistencia(double existencia) {
        this.existencia = existencia;
    }

    public double getPrecioCompra() {
        return precioCompra;
    }

    public void setPrecioCompra(double precioCompra) {
        this.precioCompra = precioCompra;
    }

    public double getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(double precioVenta) {
        this.precioVenta = precioVenta;
    }

    public int getTiempoEntregaDias() {
        return tiempoEntregaDias;
    }

    public void setTiempoEntregaDias(int tiempoEntregaDias) {
        this.tiempoEntregaDias = tiempoEntregaDias;
    }

    public String getFormatoMedicion() {
        return formatoMedicion;
    }

    public void setFormatoMedicion(String formatoMedicion) {
        this.formatoMedicion = formatoMedicion;
    }

    public double getInventarioMinimo() {
        return inventarioMinimo;
    }

    public void setInventarioMinimo(double inventarioMinimo) {
        this.inventarioMinimo = inventarioMinimo;
    }

    public double getInventarioMaximo() {
        return inventarioMaximo;
    }

    public void setInventarioMaximo(double inventarioMaximo) {
        this.inventarioMaximo = inventarioMaximo;
    }

    public String getEstatusEnSistema() {
        return estatusEnSistema;
    }

    public void setEstatusEnSistema(String estatusEnSistema) {
        this.estatusEnSistema = estatusEnSistema;
    }

    public String toString() {
        String output = "";
        output = this.getNumeroIngrediente() + ";" + this.getNombreIngrediente() + ";" + this.getDescripcion() + ";" + this.getExistencia() + ";" + this.getPrecioCompra() + ";" +
                this.getPrecioVenta() + ";" + this.getTiempoEntregaDias() + ";" + this.getFormatoMedicion() + ";" + this.getInventarioMinimo() + ";" + this.getInventarioMaximo() + ";" +
                this.getEstatusEnSistema();
        return output;
    }

    public ContentValues toDB() {
        ContentValues output = new ContentValues();
        output.put("NumeroIngrediente", this.getNumeroIngrediente());
        output.put("NombreIngrediente", this.getNombreIngrediente());
        output.put("Descripcion", this.getDescripcion());
        output.put("Existencia", this.getExistencia());
        output.put("PrecioCompra", this.precioCompra);
        output.put("PrecioVenta", this.getPrecioVenta());
        output.put("TiempoDeEntregaEnDias", this.getTiempoEntregaDias());
        output.put("FormatoMedicion", this.getFormatoMedicion());
        output.put("InventarioMaximo", this.getInventarioMaximo());
        output.put("InventarioMinimo", this.getInventarioMinimo());
        output.put("EstatusEnSistema", this.getEstatusEnSistema());

        return output;

    }
}
