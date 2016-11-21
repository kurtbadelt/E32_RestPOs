package pos.kurtbadelt.elemento32.puntodeventav0.datalayer;

import android.content.ContentValues;

/**
 * Created by kurtbadelt on 11/2/16.
 */

public class ReservacionMesa {

    private int mesa_numeroMesa=0;
    private int mesa_Empleado_NumeroEmpleado=0;
    private int mesa_Empleado_NumeroTipoEmpleado=0;
    private int mesa_NumeroTipoMesa=0;
    private int reservaciones_NumeroReservacion=0;
    private String estatusEnSistema="";

    public int getMesa_numeroMesa() {
        return mesa_numeroMesa;
    }

    public int getMesa_Empleado_NumeroEmpleado() {
        return mesa_Empleado_NumeroEmpleado;
    }

    public void setMesa_Empleado_NumeroEmpleado(int mesa_Empleado_NumeroEmpleado) {
        this.mesa_Empleado_NumeroEmpleado = mesa_Empleado_NumeroEmpleado;
    }

    public void setMesa_numeroMesa(int mesa_numeroMesa) {
        this.mesa_numeroMesa = mesa_numeroMesa;
    }

    public int getMesa_Empleado_NumeroTipoEmpleado() {
        return mesa_Empleado_NumeroTipoEmpleado;
    }

    public void setMesa_Empleado_NumeroTipoEmpleado(int mesa_Empleado_NumeroTipoEmpleado) {
        this.mesa_Empleado_NumeroTipoEmpleado = mesa_Empleado_NumeroTipoEmpleado;
    }

    public int getMesa_NumeroTipoMesa() {
        return mesa_NumeroTipoMesa;
    }

    public void setMesa_NumeroTipoMesa(int mesa_NumeroTipoMesa) {
        this.mesa_NumeroTipoMesa = mesa_NumeroTipoMesa;
    }

    public int getReservaciones_NumeroReservacion() {
        return reservaciones_NumeroReservacion;
    }

    public void setReservaciones_NumeroReservacion(int reservaciones_NumeroReservacion) {
        this.reservaciones_NumeroReservacion = reservaciones_NumeroReservacion;
    }

    public String getEstatusEnSistema() {
        return estatusEnSistema;
    }

    public void setEstatusEnSistema(String estatusEnSistema) {
        this.estatusEnSistema = estatusEnSistema;
    }
    public String toString(){
        String output="";
        output=this.getMesa_numeroMesa()+";"+this.getMesa_Empleado_NumeroTipoEmpleado()+";"+this.getMesa_NumeroTipoMesa()+";"+
                this.getReservaciones_NumeroReservacion()+";"+this.getEstatusEnSistema();
        return output;
    }
    public ContentValues toDB(){
        ContentValues output = new ContentValues();

        output.put("Mesa_NumeroDeMesa",this.getMesa_numeroMesa());
        output.put("Mesa_Empleado_NumeroEmpleado",this.getMesa_Empleado_NumeroEmpleado());
        output.put("Mesa_Empleado_NumeroTipoEmpleado",this.getMesa_Empleado_NumeroTipoEmpleado());
        output.put("Mesa_NumeroTipoMesa",this.getMesa_NumeroTipoMesa());
        output.put("Reservaciones_NumeroReservacion",this.getReservaciones_NumeroReservacion());
        output.put("EstatusEnSistema",this.getEstatusEnSistema());

        return output;

    }
}
