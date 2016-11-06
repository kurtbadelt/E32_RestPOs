package pos.kurtbadelt.elemento32.puntodeventav0.datalayer;

import android.content.ContentValues;

/**
 * Created by kurtbadelt on 11/2/16.
 */

public class Empleado {

    private int numeroEmpleado=0;
    private String nombre="";
    private String apellido="";
    private String fechaNacimiento="";
    private String telefonoCasa="";
    private String telefonoMovil="";
    private String calle="";
    private String numeroExterior_Interior="";
    private String municipio_Delegacion="";
    private String estado="";
    private String codigoPostal="";
    private int tipoEmpleado_NumeroTipoEmpleado=0;
    private String estatusEnSistema="";
    private String usuarioSistema="";
    private String password="";

    public int getNumeroEmpleado() {
        return numeroEmpleado;
    }

    public void setNumeroEmpleado(int numeroEmpleado) {
        this.numeroEmpleado = numeroEmpleado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getTelefonoCasa() {
        return telefonoCasa;
    }

    public void setTelefonoCasa(String telefonoCasa) {
        this.telefonoCasa = telefonoCasa;
    }

    public String getTelefonoMovil() {
        return telefonoMovil;
    }

    public void setTelefonoMovil(String telefonoMovil) {
        this.telefonoMovil = telefonoMovil;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getNumeroExterior_Interior() {
        return numeroExterior_Interior;
    }

    public void setNumeroExterior_Interior(String numeroExterior_Interior) {
        this.numeroExterior_Interior = numeroExterior_Interior;
    }

    public String getMunicipio_Delegacion() {
        return municipio_Delegacion;
    }

    public void setMunicipio_Delegacion(String municipio_Delegacion) {
        this.municipio_Delegacion = municipio_Delegacion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public int getTipoEmpleado_NumeroTipoEmpleado() {
        return tipoEmpleado_NumeroTipoEmpleado;
    }

    public void setTipoEmpleado_NumeroTipoEmpleado(int tipoEmpleado_NumeroTipoEmpleado) {
        this.tipoEmpleado_NumeroTipoEmpleado = tipoEmpleado_NumeroTipoEmpleado;
    }

    public String getEstatusEnSistema() {
        return estatusEnSistema;
    }

    public void setEstatusEnSistema(String estatusEnSistema) {
        this.estatusEnSistema = estatusEnSistema;
    }

    public String getUsuarioSistema() {
        return usuarioSistema;
    }

    public void setUsuarioSistema(String usuarioSistema) {
        this.usuarioSistema = usuarioSistema;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String toString(){
        String output="";
        output=this.getNumeroEmpleado()+";"+this.getNombre()+";"+this.getApellido()+";"+this.getFechaNacimiento()+";"+this.getTelefonoCasa()+";"+this.getTelefonoMovil()+
                ";"+this.getCalle()+";"+this.getNumeroExterior_Interior()+";"+this.getMunicipio_Delegacion()+";"+this.getEstado()+";"+this.getCodigoPostal()+";"+
                this.getTipoEmpleado_NumeroTipoEmpleado()+";"+this.getEstatusEnSistema()+";"+this.getUsuarioSistema()+";"+this.getPassword();
        return output;
    }

    public ContentValues toDB(){
        ContentValues output = new ContentValues();

        output.put("NumeroEmpleado",this.getNumeroEmpleado());
        output.put("Nombre",this.getNombre());
        output.put("Apellido",this.getApellido());
        output.put("FechaNacimiento",this.getFechaNacimiento());
        output.put("TelefonoCasa",this.getTelefonoCasa());
        output.put("TelefonoMovil",this.telefonoMovil);
        output.put("Calle",this.getCalle());
        output.put("NumeroExterior_interior",this.getNumeroExterior_Interior());
        output.put("Municipio_Delegacion",this.getMunicipio_Delegacion());
        output.put("Estado",this.getEstado());
        output.put("CodigoPostal",this.getCodigoPostal());
        output.put("TipoEmpleado_NumeroTipoEmpleado",this.getTipoEmpleado_NumeroTipoEmpleado());
        output.put("EstatusEnSistema",this.getEstatusEnSistema());
        output.put("UsuarioSistema",this.getUsuarioSistema());
        output.put("Password",this.getPassword());

        return output;

    }
}
