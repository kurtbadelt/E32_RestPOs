package pos.kurtbadelt.elemento32.puntodeventav0.datalayer;

import android.content.ContentValues;

/**
 * Created by kurtbadelt on 11/2/16.
 */

public class Mesa extends DataLayerObject {

    private String nombreTabla = "Mesa";
    private int numeroDeMesa=0;
    private int numeroDeComensales=0;
    private int empleado_NumeroEmpleado=0;
    private int empleado_NumeroTipoEmpleado=0;
    private int comensales_NumeroComensal=0;
    private int tipoMesa_NumeroTipoMesa=0;
    private String estatusEnSistema="";

    public int getNumeroDeMesa() {
        return numeroDeMesa;
    }

    public void setNumeroDeMesa(int numeroDeMesa) {
        this.numeroDeMesa = numeroDeMesa;
    }

    public int getNumeroDeComensales() {
        return numeroDeComensales;
    }

    public void setNumeroDeComensales(int numeroDeComensales) {
        this.numeroDeComensales = numeroDeComensales;
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

    public int getEmpleado_NumeroTipoEmpleado() {
        return empleado_NumeroTipoEmpleado;
    }

    public void setEmpleado_NumeroTipoEmpleado(int empleado_NumeroTipoEmpleado) {
        this.empleado_NumeroTipoEmpleado = empleado_NumeroTipoEmpleado;
    }

    public int getComensales_NumeroComensal() {
        return comensales_NumeroComensal;
    }

    public void setComensales_NumeroComensal(int comensales_NumeroComensal) {
        this.comensales_NumeroComensal = comensales_NumeroComensal;
    }

    public int getTipoMesa_NumeroTipoMesa() {
        return tipoMesa_NumeroTipoMesa;
    }

    public void setTipoMesa_NumeroTipoMesa(int tipoMesa_NumeroTipoMesa) {
        this.tipoMesa_NumeroTipoMesa = tipoMesa_NumeroTipoMesa;
    }

    public String getEstatusEnSistema() {
        return estatusEnSistema;
    }

    public void setEstatusEnSistema(String estatusEnSistema) {
        this.estatusEnSistema = estatusEnSistema;
    }
    public String toString(){
        String output="";
        output=this.getNumeroDeMesa()+";"+this.getNumeroDeComensales()+";"+this.getEmpleado_NumeroEmpleado()+";"+
                this.getEmpleado_NumeroTipoEmpleado()+";"+this.getComensales_NumeroComensal()+";"+this.getTipoMesa_NumeroTipoMesa()+";"+this.getEstatusEnSistema();
        return output;
    }
    public ContentValues toDB(){
        ContentValues output = new ContentValues();

        output.put("NumeroDeMesa",this.getNumeroDeMesa());
        output.put("NumeroComensales",this.getNumeroDeComensales());
        output.put("Empleado_NumeroEmpleado",this.getEmpleado_NumeroEmpleado());
        output.put("Empleado_NumeroTipoEmpleado",this.getEmpleado_NumeroTipoEmpleado());
        output.put("Comensales_NumeroComensal",this.getComensales_NumeroComensal());
        output.put("TipoMesa_NumeroTipoMesa",this.getTipoMesa_NumeroTipoMesa());
        output.put("EstatusEnSistema",this.getEstatusEnSistema());

        return output;

    }
}
