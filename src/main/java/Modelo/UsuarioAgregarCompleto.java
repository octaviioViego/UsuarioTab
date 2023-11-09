/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author octav
 */
public class UsuarioAgregarCompleto {
    private String numeroDeEmpleado;
    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String telefonoCasa;
    private String telefonoCelular;
    private String contraseña;
    private String curp;
    private String numeroDeSeguroSocial;
    private String nivelEducativo;
    private String rfc;
    private String direccion;
    private String numeroDeCuenta;
    private String puestoaDesempenar;
    private String familiaNo;
    private String fechaDeingreso;

    public UsuarioAgregarCompleto(String numeroDeEmpleado, String nombre, String apellidoPaterno, String apellidoMaterno, String telefonoCasa, String telefonoCelular, String contraseña, String curp, String numeroDeSeguroSocial, String nivelEducativo, String rfc, String direccion, String numeroDeCuenta, String puestoaDesempenar, String familiaNo, String fechaDeingreso) {
        this.numeroDeEmpleado = numeroDeEmpleado;
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.telefonoCasa = telefonoCasa;
        this.telefonoCelular = telefonoCelular;
        this.contraseña = contraseña;
        this.curp = curp;
        this.numeroDeSeguroSocial = numeroDeSeguroSocial;
        this.nivelEducativo = nivelEducativo;
        this.rfc = rfc;
        this.direccion = direccion;
        this.numeroDeCuenta = numeroDeCuenta;
        this.puestoaDesempenar = puestoaDesempenar;
        this.familiaNo = familiaNo;
        this.fechaDeingreso = fechaDeingreso;
    }

    public String getNumeroDeEmpleado() {
        return numeroDeEmpleado;
    }

    public void setNumeroDeEmpleado(String numeroDeEmpleado) {
        this.numeroDeEmpleado = numeroDeEmpleado;
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

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getCurp() {
        return curp;
    }

    public void setCurp(String curp) {
        this.curp = curp;
    }

    public String getNumeroDeSeguroSocial() {
        return numeroDeSeguroSocial;
    }

    public void setNumeroDeSeguroSocial(String numeroDeSeguroSocial) {
        this.numeroDeSeguroSocial = numeroDeSeguroSocial;
    }

    public String getNivelEducativo() {
        return nivelEducativo;
    }

    public void setNivelEducativo(String nivelEducativo) {
        this.nivelEducativo = nivelEducativo;
    }

    public String getRfc() {
        return rfc;
    }

    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getNumeroDeCuenta() {
        return numeroDeCuenta;
    }

    public void setNumeroDeCuenta(String numeroDeCuenta) {
        this.numeroDeCuenta = numeroDeCuenta;
    }

    public String getPuestoaDesempenar() {
        return puestoaDesempenar;
    }

    public void setPuestoaDesempenar(String puestoaDesempenar) {
        this.puestoaDesempenar = puestoaDesempenar;
    }

    public String getFamiliaNo() {
        return familiaNo;
    }

    public void setFamiliaNo(String familiaNo) {
        this.familiaNo = familiaNo;
    }

    public String getFechaDeingreso() {
        return fechaDeingreso;
    }

    public void setFechaDeingreso(String fechaDeingreso) {
        this.fechaDeingreso = fechaDeingreso;
    }

    
}
