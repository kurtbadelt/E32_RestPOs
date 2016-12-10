package pos.kurtbadelt.elemento32.puntodeventav0.datalayer;

import android.content.ContentValues;

/**
 * Created by kurtbadelt on 11/2/16.
 */

public class ComandasEnMesa extends DataLayerObject {

    private String nombreTabla = "ComandasEnMesa";
    private int comanda_NumeroComanda = 0;
    private int mesa_NumeroMesa = 0;
    private int mesa_NumeroEmpleado = 0;
    private int mesa_NumeroTipoEmpleado = 0;
    private int mesa_NumeroTipoMesa = 0;
    private String estatusEnSistema = "";

    public int getComanda_NumeroComanda() {
        return comanda_NumeroComanda;
    }

    public void setComanda_NumeroComanda(int comanda_NumeroComanda) {
        this.comanda_NumeroComanda = comanda_NumeroComanda;
    }

    public String getNombreTabla() {
        return nombreTabla;
    }

    public void setNombreTabla(String nombreTabla) {
        this.nombreTabla = nombreTabla;
    }


    public int getMesa_NumeroMesa() {
        return mesa_NumeroMesa;
    }

    public void setMesa_NumeroMesa(int mesa_NumeroMesa) {
        this.mesa_NumeroMesa = mesa_NumeroMesa;
    }

    public int getMesa_NumeroEmpleado() {
        return mesa_NumeroEmpleado;
    }

    public void setMesa_NumeroEmpleado(int mesa_NumerEmpleado) {
        this.mesa_NumeroEmpleado = mesa_NumerEmpleado;
    }

    public int getMesa_NumeroTipoEmpleado() {
        return mesa_NumeroTipoEmpleado;
    }

    public void setMesa_NumeroTipoEmpleado(int mesa_NumeroTipoEmpleado) {
        this.mesa_NumeroTipoEmpleado = mesa_NumeroTipoEmpleado;
    }

    public int getMesa_NumeroTipoMesa() {
        return mesa_NumeroTipoMesa;
    }

    public void setMesa_NumeroTipoMesa(int mesa_NumeroTipoMesa) {
        this.mesa_NumeroTipoMesa = mesa_NumeroTipoMesa;
    }

    public String getEstatusEnSistema() {
        return estatusEnSistema;
    }

    public void setEstatusEnSistema(String estatusEnSistema) {
        this.estatusEnSistema = estatusEnSistema;
    }

    public String toString() {
        String output = "";
        output = this.getComanda_NumeroComanda() + ";" + this.getMesa_NumeroMesa() + ";" + this.getMesa_NumeroEmpleado() + ";" + this.getMesa_NumeroTipoEmpleado() + ";"
                + this.getMesa_NumeroTipoMesa() + ";" + this.getEstatusEnSistema();
        return output;
    }

    public ContentValues toDB() {
        ContentValues output = new ContentValues();

        output.put("Comanda_NumeroComanda", this.getComanda_NumeroComanda());
        output.put("Mesa_NumerDeMesa", this.getMesa_NumeroMesa());
        output.put("Mesa_NumeroEmpleado", this.getMesa_NumeroEmpleado());
        output.put("Mesa_NumeroTipoEmpleado", this.getMesa_NumeroTipoEmpleado());
        output.put("Mesa_NumeroTipoMesa", this.getMesa_NumeroTipoMesa());
        output.put("EstatusEnSistema", this.getEstatusEnSistema());

        return output;

    }
}
