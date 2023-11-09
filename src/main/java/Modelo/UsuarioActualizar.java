/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author octav
 */
public class UsuarioActualizar {
   
    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String contraseña;
    private String telefonoCasa;
    private String telefonoCelular;
    private String curp;
    private String numeroSeguroSocial;
    private String puestoLaboral;
    private String direccion;
    private String fechaDeModificacion;

    public UsuarioActualizar(String nombre, String apellidoPaterno, String apellidoMaterno, String contraseña, String telefonoCasa, String telefonoCelular, String curp, String numeroSeguroSocial, String puestoLaboral, String direccion, String fechaDeModificacion) {
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.contraseña = contraseña;
        this.telefonoCasa = telefonoCasa;
        this.telefonoCelular = telefonoCelular;
        this.curp = curp;
        this.numeroSeguroSocial = numeroSeguroSocial;
        this.puestoLaboral = puestoLaboral;
        this.direccion = direccion;
        this.fechaDeModificacion = fechaDeModificacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getTelefonoCasa() {
        return telefonoCasa;
    }

    public void setTelefonoCasa(String telefonoCasa) {
        this.telefonoCasa = telefonoCasa;
    }

    public String getTelefonoCelular() {
        return telefonoCelular;
    }

    public void setTelefonoCelular(String telefonoCelular) {
        this.telefonoCelular = telefonoCelular;
    }

    public String getCurp() {
        return curp;
    }

    public void setCurp(String curp) {
        this.curp = curp;
    }

    public String getNumeroSeguroSocial() {
        return numeroSeguroSocial;
    }

    public void setNumeroSeguroSocial(String numeroSeguroSocial) {
        this.numeroSeguroSocial = numeroSeguroSocial;
    }

    public String getPuestoLaboral() {
        return puestoLaboral;
    }

    public void setPuestoLaboral(String puestoLaboral) {
        this.puestoLaboral = puestoLaboral;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getFechaDeModificacion() {
        return fechaDeModificacion;
    }

    public void setFechaDeModificacion(String fechaDeModificacion) {
        this.fechaDeModificacion = fechaDeModificacion;
    }
    
    
    
    
    
    
}
