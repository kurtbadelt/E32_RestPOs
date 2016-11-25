package pos.kurtbadelt.elemento32.puntodeventav0.datalayer;

import android.content.ContentValues;

/**
 * Created by kurtbadelt on 11/2/16.
 */

public class Asistencia extends DataLayerObject{


    private String nombreTabla="Asistencia";
   private int numeroAsistencia=0;
    private String fechaHoraEntrada="";
    private String fechaHoraSalida="";
    private String comentarios="";
    private String estatusEnSistema="";
    private int empleado_NumeroEmpleado=0;
    private int empleado_NumeroTipoEmpleado=0;

    public int getNumeroAsistencia() {
        return numeroAsistencia;
    }

    public void setNumeroAsistencia(int numeroAsistencia) {
        this.numeroAsistencia = numeroAsistencia;
    }
    public String getNombreTabla() {
        return nombreTabla;
    }

    public void setNombreTabla(String nombreTabla) {
        this.nombreTabla = nombreTabla;
    }

    public String getFechaHoraEntrada() {
        return fechaHoraEntrada;
    }

    public void setFechaHoraEntrada(String fechaHoraEntrada) {
        this.fechaHoraEntrada = fechaHoraEntrada;
    }

    public String getFechaHoraSalida() {
        return fechaHoraSalida;
    }

    public void setFechaHoraSalida(String fechaHoraSalida) {
        this.fechaHoraSalida = fechaHoraSalida;
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
    public String toString(){
        String output="";
        output=this.getNumeroAsistencia()+";"+this.getFechaHoraEntrada()+";"+this.getFechaHoraSalida()+";"+this.getComentarios()+";"+this.getEstatusEnSistema()+";"+
                this.getEmpleado_NumeroEmpleado()+";"+this.getEmpleado_NumeroTipoEmpleado();
        return output;
    }
    public ContentValues toDB(){
        ContentValues output = new ContentValues();

        output.put("NumeroAsistencia",this.getNumeroAsistencia());
        output.put("FechaHoraEntrada",this.getFechaHoraEntrada());
        output.put("FechaHoraSalida",this.getFechaHoraSalida());
        output.put("Comentarios",this.getComentarios());
        output.put("EstatusEnSistema",this.getEstatusEnSistema());
        output.put("Empleado_NumeroEmpleado",this.getEmpleado_NumeroEmpleado());
        output.put("Empleado_NumeroTipoEmpleado",this.getEmpleado_NumeroTipoEmpleado());

        return output;

    }
}
