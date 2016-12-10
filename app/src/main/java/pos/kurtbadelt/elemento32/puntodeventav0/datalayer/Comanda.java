package pos.kurtbadelt.elemento32.puntodeventav0.datalayer;

import android.content.ContentValues;

/**
 * Created by kurtbadelt on 11/2/16.
 */

public class Comanda extends DataLayerObject {


    private String nombreTabla = "Comanda";
    private int numeroComanda = 0;
    private int numeroComensales = 0;
    private int empleado_NumeroEmpleado = 0;
    private String estatusEnSistema = "";
    private int empleado_NumeroTipoEmpleado = 0;

    public int getNumeroComanda() {
        return numeroComanda;
    }

    public void setNumeroComanda(int numeroComanda) {
        this.numeroComanda = numeroComanda;
    }

    public int getNumeroComensales() {
        return numeroComensales;
    }

    public void setNumeroComensales(int numeroComensales) {
        this.numeroComensales = numeroComensales;
    }

    public String getNombreTabla() {
        return nombreTabla;
    }

    public void setNombreTabla(String nombreTabla) {
        this.nombreTabla = nombreTabla;
    }

    public int getEmpleado_NumeroEmpleado() {
        return empleado_NumeroEmpleado;
    }

    public void setEmpleado_NumeroEmpleado(int empleado_NumeroEmpleado) {
        this.empleado_NumeroEmpleado = empleado_NumeroEmpleado;
    }

    public String getEstatusEnSistema() {
        return estatusEnSistema;
    }

    public void setEstatusEnSistema(String estatusEnSistema) {
        this.estatusEnSistema = estatusEnSistema;
    }

    public int getEmpleado_NumeroTipoEmpleado() {
        return empleado_NumeroTipoEmpleado;
    }

    public void setEmpleado_NumeroTipoEmpleado(int empleado_NumeroTipoEmpleado) {
        this.empleado_NumeroTipoEmpleado = empleado_NumeroTipoEmpleado;
    }

    public String toString() {
        String output = "";
        output = this.getNumeroComanda() + ";" + this.getNumeroComensales() + ";" + this.getEmpleado_NumeroEmpleado() + ";" + this.getEstatusEnSistema() + ";" +
                this.getEmpleado_NumeroTipoEmpleado();
        return output;
    }

    public ContentValues toDB() {
        ContentValues output = new ContentValues();

        output.put("NumeroComanda", this.getNumeroComanda());
        output.put("NumeroComensales", this.getNumeroComensales());
        output.put("Empleado_NumerEmpleado", this.getEmpleado_NumeroEmpleado());
        output.put("EstatusEnSistema", this.getEstatusEnSistema());
        output.put("Empleado_NumerTipoEmpleado", this.getEmpleado_NumeroTipoEmpleado());

        return output;

    }
}
