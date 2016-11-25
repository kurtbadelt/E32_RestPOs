package pos.kurtbadelt.elemento32.puntodeventav0.datalayer;

import android.content.ContentValues;

/**
 * Created by kurtbadelt on 11/2/16.
 */

public class EvaluacionEmpleado extends DataLayerObject {


    private String nombreTabla = "EvaluacionEmpleado";
    private int numeroEvaluacion=0;
    private String descripcionPregunta1="";
    private int evaluacionPregunta1=0;
    private String descripcionPregunta2="";
    private int evaluacionPregunta2=0;
    private String descripcionPregunta3="";
    private int evaluacionPregunta3=0;
    private String descripcionPregunta4="";
    private int evaluacionPregunta4=0;
    private String descripcionPregunta5="";
    private int evaluacionPregunta5=0;
    private String comentariosSupervisor="";
    private int empleado_NumeroEmpleado=0;
    private int empleado_NumeroTipoEmpleado=0;
    private String estatusEnSistema="";

    public int getNumeroEvaluacion() {
        return numeroEvaluacion;
    }

    public void setNumeroEvaluacion(int numeroEvaluacion) {
        this.numeroEvaluacion = numeroEvaluacion;
    }

    public String getNombreTabla() {
        return nombreTabla;
    }

    public void setNombreTabla(String nombreTabla) {
        this.nombreTabla = nombreTabla;
    }


    public String getDescripcionPregunta1() {
        return descripcionPregunta1;
    }

    public void setDescripcionPregunta1(String descripcionPregunta1) {
        this.descripcionPregunta1 = descripcionPregunta1;
    }

    public int getEvaluacionPregunta1() {
        return evaluacionPregunta1;
    }

    public void setEvaluacionPregunta1(int evaluacionPregunta1) {
        this.evaluacionPregunta1 = evaluacionPregunta1;
    }

    public String getDescripcionPregunta2() {
        return descripcionPregunta2;
    }

    public void setDescripcionPregunta2(String descripcionPregunta2) {
        this.descripcionPregunta2 = descripcionPregunta2;
    }

    public int getEvaluacionPregunta2() {
        return evaluacionPregunta2;
    }

    public void setEvaluacionPregunta2(int evaluacionPregunta2) {
        this.evaluacionPregunta2 = evaluacionPregunta2;
    }

    public String getDescripcionPregunta3() {
        return descripcionPregunta3;
    }

    public void setDescripcionPregunta3(String descripcionPregunta3) {
        this.descripcionPregunta3 = descripcionPregunta3;
    }

    public int getEvaluacionPregunta3() {
        return evaluacionPregunta3;
    }

    public void setEvaluacionPregunta3(int evaluacionPregunta3) {
        this.evaluacionPregunta3 = evaluacionPregunta3;
    }

    public String getDescripcionPregunta4() {
        return descripcionPregunta4;
    }

    public void setDescripcionPregunta4(String descripcionPregunta4) {
        this.descripcionPregunta4 = descripcionPregunta4;
    }

    public int getEvaluacionPregunta4() {
        return evaluacionPregunta4;
    }

    public void setEvaluacionPregunta4(int evaluacionPregunta4) {
        this.evaluacionPregunta4 = evaluacionPregunta4;
    }

    public String getDescripcionPregunta5() {
        return descripcionPregunta5;
    }

    public void setDescripcionPregunta5(String descripcionPregunta5) {
        this.descripcionPregunta5 = descripcionPregunta5;
    }

    public int getEvaluacionPregunta5() {
        return evaluacionPregunta5;
    }

    public void setEvaluacionPregunta5(int evaluacionPregunta5) {
        this.evaluacionPregunta5 = evaluacionPregunta5;
    }

    public String getComentariosSupervisor() {
        return comentariosSupervisor;
    }

    public void setComentariosSupervisor(String comentariosSupervisor) {
        this.comentariosSupervisor = comentariosSupervisor;
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

    public String getEstatusEnSistema() {
        return estatusEnSistema;
    }

    public void setEstatusEnSistema(String estatusEnSistema) {
        this.estatusEnSistema = estatusEnSistema;
    }
    public String toString(){
        String output="";
        output=this.getNumeroEvaluacion()+";"+this.getDescripcionPregunta1()+";"+this.getEvaluacionPregunta1()+";"+this.getDescripcionPregunta2()+";"+
                this.getEvaluacionPregunta2()+";"+this.getDescripcionPregunta3()+";"+this.getEvaluacionPregunta3()+";"+this.getDescripcionPregunta4()+";"+
                this.getEvaluacionPregunta4()+";"+this.getDescripcionPregunta5()+";"+this.getEvaluacionPregunta5()+";"+this.getComentariosSupervisor()+";"+
                this.getEmpleado_NumeroEmpleado()+";"+this.getEmpleado_NumeroEmpleado()+";"+this.getEstatusEnSistema();
        return output;
    }
    public ContentValues toDB(){
        ContentValues output = new ContentValues();
        output.put("NumeroEvaluacion",this.getNumeroEvaluacion());
        output.put("DescripcionPregunta1",this.getDescripcionPregunta1());
        output.put("EvaluacionPregunta1",this.getEvaluacionPregunta1());
        output.put("DescripcionPregunta2",this.getDescripcionPregunta2());
        output.put("EvaluacionPregunta2",this.getEvaluacionPregunta2());
        output.put("DescripcionPregunta3",this.getDescripcionPregunta3());
        output.put("EvaluacionPregunta3",this.getEvaluacionPregunta3());
        output.put("DescripcionPregunta4",this.getDescripcionPregunta4());
        output.put("EvaluacionPregunta4",this.getEvaluacionPregunta4());
        output.put("DescripcionPregunta5",this.getDescripcionPregunta5());
        output.put("EvaluacionPregunta5",this.getEvaluacionPregunta5());
        output.put("ComentariosSupervisor",this.getComentariosSupervisor());
        output.put("Empleado_NumeroEmpleado",this.getEmpleado_NumeroEmpleado());
        output.put("Empleado_NumeroTipoEmpleado",this.getEmpleado_NumeroTipoEmpleado());
        output.put("EstatusEnSistema",this.getEstatusEnSistema());

        return output;

    }
}
