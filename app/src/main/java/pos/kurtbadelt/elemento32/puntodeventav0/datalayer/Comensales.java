package pos.kurtbadelt.elemento32.puntodeventav0.datalayer;

import android.content.ContentValues;

/**
 * Created by kurtbadelt on 11/2/16.
 */

public class Comensales {
    private int numeroComensal=0;
    private String nombreComensal="";
    private String apellidoComensal="";
    private String correoElectronico="";
    private String estatusEnSistema="";

    public int getNumeroComensal() {
        return numeroComensal;
    }

    public void setNumeroComensal(int numeroComensal) {
        this.numeroComensal = numeroComensal;
    }

    public String getNombreComensal() {
        return nombreComensal;
    }

    public void setNombreComensal(String nombreComensal) {
        this.nombreComensal = nombreComensal;
    }

    public String getApellidoComensal() {
        return apellidoComensal;
    }

    public void setApellidoComensal(String apellidoComensal) {
        this.apellidoComensal = apellidoComensal;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public String getEstatusEnSistema() {
        return estatusEnSistema;
    }

    public void setEstatusEnSistema(String estatusEnSistema) {
        this.estatusEnSistema = estatusEnSistema;
    }
    public String toString(){
        String output="";
        output=this.getNumeroComensal()+";"+this.getNombreComensal()+";"+this.getApellidoComensal()+";"+this.getCorreoElectronico()+";"+this.getEstatusEnSistema();
        return output;
    }
    public ContentValues toDB(){
        ContentValues output = new ContentValues();

        output.put("NumeroComensal",this.getNumeroComensal());
        output.put("NombreComensal",this.getNombreComensal());
        output.put("ApellidoComensal",this.getApellidoComensal());
        output.put("CorreoElectronico",this.getCorreoElectronico());
        output.put("EstatusEnSistema",this.getEstatusEnSistema());

        return output;

    }
}
