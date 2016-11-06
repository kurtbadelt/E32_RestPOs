package pos.kurtbadelt.elemento32.puntodeventav0.datalayer;

import android.content.ContentValues;

/**
 * Created by kurtbadelt on 11/2/16.
 */

public class Cancelaciones {
    private int numeroCancelacion=0;
    private String descripcion="";
    private String aprobacion="";
    private String estatusEnSistema="";
    private int comanda_NumeroComanda=0;
    private int motivosCancelacion_NumeroMotivo=0;

    public int getNumeroCancelacion() {
        return numeroCancelacion;
    }

    public void setNumeroCancelacion(int numeroCancelacion) {
        this.numeroCancelacion = numeroCancelacion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getAprobacion() {
        return aprobacion;
    }

    public void setAprobacion(String aprobacion) {
        this.aprobacion = aprobacion;
    }

    public String getEstatusEnSistema() {
        return estatusEnSistema;
    }

    public void setEstatusEnSistema(String estatusEnSistema) {
        this.estatusEnSistema = estatusEnSistema;
    }

    public int getComanda_NumeroComanda() {
        return comanda_NumeroComanda;
    }

    public void setComanda_NumeroComanda(int comanda_NumeroComanda) {
        this.comanda_NumeroComanda = comanda_NumeroComanda;
    }

    public int getMotivosCancelacion_NumeroMotivo() {
        return motivosCancelacion_NumeroMotivo;
    }

    public void setMotivosCancelacion_NumeroMotivo(int motivosCancelacion_NumeroMotivo) {
        this.motivosCancelacion_NumeroMotivo = motivosCancelacion_NumeroMotivo;
    }
    public String toString(){
        String output="";
        output=this.getNumeroCancelacion()+";"+this.getDescripcion()+";"+this.getAprobacion()+";"+this.getEstatusEnSistema()+this.getComanda_NumeroComanda()+";"+
                this.getMotivosCancelacion_NumeroMotivo();
        return output;
    }
    public ContentValues toDB(){
        ContentValues output = new ContentValues();

        output.put("NumeroCancelacion",this.getNumeroCancelacion());
        output.put("Descripcion",this.descripcion);
        output.put("Aprobacion",this.aprobacion);
        output.put("EstatusEnSistema",this.getEstatusEnSistema());
        output.put("Comanda_NumeroComanda",this.getComanda_NumeroComanda());
        output.put("MotivosCancelacion_NumeroMotivo",this.getMotivosCancelacion_NumeroMotivo());

        return output;

    }
}
