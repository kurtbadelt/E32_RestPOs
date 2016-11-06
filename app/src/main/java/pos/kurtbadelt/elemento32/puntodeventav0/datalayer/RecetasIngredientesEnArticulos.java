package pos.kurtbadelt.elemento32.puntodeventav0.datalayer;

import android.content.ContentValues;

/**
 * Created by kurtbadelt on 11/2/16.
 */

public class RecetasIngredientesEnArticulos {
    private int numeroReceta=0;
    private int articulo_NumeroArticulo=0;
    private int ingrediente_NumeroIngrediente=0;
    private double cantidad=0;
    private String formaMedicion="";
    private String comentarios="";
    private String estatusEnSistema="";

    public int getNumeroReceta() {
        return numeroReceta;
    }

    public void setNumeroReceta(int numeroReceta) {
        this.numeroReceta = numeroReceta;
    }

    public int getArticulo_NumeroArticulo() {
        return articulo_NumeroArticulo;
    }

    public void setArticulo_NumeroArticulo(int articulo_NumeroArticulo) {
        this.articulo_NumeroArticulo = articulo_NumeroArticulo;
    }

    public int getIngrediente_NumeroIngrediente() {
        return ingrediente_NumeroIngrediente;
    }

    public void setIngrediente_NumeroIngrediente(int ingrediente_NumeroIngrediente) {
        this.ingrediente_NumeroIngrediente = ingrediente_NumeroIngrediente;
    }

    public double getCantidad() {
        return cantidad;
    }

    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }

    public String getFormaMedicion() {
        return formaMedicion;
    }

    public void setFormaMedicion(String formaMedicion) {
        this.formaMedicion = formaMedicion;
    }

    public String getComentarios() {
        return comentarios;
    }

    public void setComentarios(String comentarios) {
        this.comentarios = comentarios;
    }

    public String getEstatusEnSistema() {
        return estatusEnSistema;
    }

    public void setEstatusEnSistema(String estatusEnSistema) {
        this.estatusEnSistema = estatusEnSistema;
    }
    public String toString(){
        String output="";
        output=this.getNumeroReceta()+";"+this.getArticulo_NumeroArticulo()+";"+this.getIngrediente_NumeroIngrediente()+";"+this.getCantidad()+";"+
                ";"+this.getFormaMedicion()+";"+this.getComentarios()+";"+this.getEstatusEnSistema();
        return output;
    }
    public ContentValues toDB(){
        ContentValues output = new ContentValues();


        return output;

    }
}
