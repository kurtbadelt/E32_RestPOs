package pos.kurtbadelt.elemento32.puntodeventav0.datalayer;

import android.content.ContentValues;

/**
 * Created by kurtbadelt on 11/2/16.
 */

public class EstatusDeComandas {
    private int estatusComanda_NumeroEstatus=0;
    private int comanda_NumeroComanda=0;
    private String fechaHoraIngreso="";
    private String estatusEnSistema="";

    public int getEstatusComanda_NumeroEstatus() {
        return estatusComanda_NumeroEstatus;
    }

    public void setEstatusComanda_NumeroEstatus(int estatusComanda_NumeroEstatus) {
        this.estatusComanda_NumeroEstatus = estatusComanda_NumeroEstatus;
    }

    public int getComanda_NumeroComanda() {
        return comanda_NumeroComanda;
    }

    public void setComanda_NumeroComanda(int comanda_NumeroComanda) {
        this.comanda_NumeroComanda = comanda_NumeroComanda;
    }

    public String getFechaHoraIngreso() {
        return fechaHoraIngreso;
    }

    public void setFechaHoraIngreso(String fechaHoraIngreso) {
        this.fechaHoraIngreso = fechaHoraIngreso;
    }

    public String getEstatusEnSistema() {
        return estatusEnSistema;
    }

    public void setEstatusEnSistema(String estatusEnSistema) {
        this.estatusEnSistema = estatusEnSistema;
    }
    public String toString(){
        String output="";
        output=this.getEstatusComanda_NumeroEstatus()+";"+this.getComanda_NumeroComanda()+";"+this.getFechaHoraIngreso()+";"+this.getEstatusEnSistema();
        return output;
    }
    public ContentValues toDB(){
        ContentValues output = new ContentValues();


        return output;

    }
}
