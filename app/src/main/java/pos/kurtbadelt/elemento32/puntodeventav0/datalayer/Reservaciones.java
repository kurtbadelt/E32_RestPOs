package pos.kurtbadelt.elemento32.puntodeventav0.datalayer;

import android.content.ContentValues;

/**
 * Created by kurtbadelt on 11/2/16.
 */

public class Reservaciones extends DataLayerObject {


    private String nombreTabla = "Reservaciones";
    private int numeroReservacion = 0;
    private String fechaReservacion = "";
    private String vigenciaReservacion = "";
    private String nombreComensal = "";
    private int numeroDeComensales = 0;
    private int comensales_NumeroComensal = 0;
    private String estatusEnSistema = "";

    public int getNumeroReservacion() {
        return numeroReservacion;
    }

    public void setNumeroReservacion(int numeroReservacion) {
        this.numeroReservacion = numeroReservacion;
    }

    public String getNombreTabla() {
        return nombreTabla;
    }

    public void setNombreTabla(String nombreTabla) {
        this.nombreTabla = nombreTabla;
    }

    public String getFechaReservacion() {
        return fechaReservacion;
    }

    public void setFechaReservacion(String fechaReservacion) {
        this.fechaReservacion = fechaReservacion;
    }

    public String getVigenciaReservacion() {
        return vigenciaReservacion;
    }

    public void setVigenciaReservacion(String vigenciaReservacion) {
        this.vigenciaReservacion = vigenciaReservacion;
    }

    public String getNombreComensal() {
        return nombreComensal;
    }

    public void setNombreComensal(String nombreComensal) {
        this.nombreComensal = nombreComensal;
    }

    public int getNumeroDeComensales() {
        return numeroDeComensales;
    }

    public void setNumeroDeComensales(int numeroDeComensales) {
        this.numeroDeComensales = numeroDeComensales;
    }

    public int getComensales_NumeroComensal() {
        return comensales_NumeroComensal;
    }

    public void setComensales_NumeroComensal(int comensales_NumeroComensal) {
        this.comensales_NumeroComensal = comensales_NumeroComensal;
    }

    public String getEstatusEnSistema() {
        return estatusEnSistema;
    }

    public void setEstatusEnSistema(String estatusEnSistema) {
        this.estatusEnSistema = estatusEnSistema;
    }

    public String toString() {
        String output = "";
        output = this.getNumeroReservacion() + ";" + this.getFechaReservacion() + ";" + this.getVigenciaReservacion() + ";" + this.getNombreComensal() + ";" +
                this.getNumeroDeComensales() + ";" + this.getComensales_NumeroComensal() + ";" + this.getEstatusEnSistema();
        return output;
    }

    public ContentValues toDB() {
        ContentValues output = new ContentValues();

        output.put("NumeroReservacion", this.getNumeroReservacion());
        output.put("FechaReservacion", this.getFechaReservacion());
        output.put("VigenciaReservacion", this.getVigenciaReservacion());
        output.put("NombreComensal", this.getNombreComensal());
        output.put("NumeroDeComensales", this.getNumeroDeComensales());
        output.put("Comensales_NumeroComensal", this.getComensales_NumeroComensal());
        output.put("EstatusEnSistema", this.getEstatusEnSistema());

        return output;

    }
}
