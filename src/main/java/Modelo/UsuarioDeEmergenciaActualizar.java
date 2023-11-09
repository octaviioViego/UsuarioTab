/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author octav
 */
public class UsuarioDeEmergenciaActualizar {
    private String fechaDeModificacion;
    private String numeroEmergencia;
    private String nombreContactoEmergencia;
    private String apellidoPaternoContactoEmergencia;
    private String apellidoMaternoContactoEmergencia;
    private String parentescocontactoEmergencia;

    public UsuarioDeEmergenciaActualizar(String fechaDeModificacion, String numeroEmergencia, String nombreContactoEmergencia, String apellidoPaternoContactoEmergencia, String apellidoMaternoContactoEmergencia, String parentescocontactoEmergencia) {
        this.fechaDeModificacion = fechaDeModificacion;
        this.numeroEmergencia = numeroEmergencia;
        this.nombreContactoEmergencia = nombreContactoEmergencia;
        this.apellidoPaternoContactoEmergencia = apellidoPaternoContactoEmergencia;
        this.apellidoMaternoContactoEmergencia = apellidoMaternoContactoEmergencia;
        this.parentescocontactoEmergencia = parentescocontactoEmergencia;
    }

    public String getFechaDeModificacion() {
        return fechaDeModificacion;
    }

    public void setFechaDeModificacion(String fechaDeModificacion) {
        this.fechaDeModificacion = fechaDeModificacion;
    }

    public String getNumeroEmergencia() {
        return numeroEmergencia;
    }

    public void setNumeroEmergencia(String numeroEmergencia) {
        this.numeroEmergencia = numeroEmergencia;
    }

    public String getNombreContactoEmergencia() {
        return nombreContactoEmergencia;
    }

    public void setNombreContactoEmergencia(String nombreContactoEmergencia) {
        this.nombreContactoEmergencia = nombreContactoEmergencia;
    }

    public String getApellidoPaternoContactoEmergencia() {
        return apellidoPaternoContactoEmergencia;
    }

    public void setApellidoPaternoContactoEmergencia(String apellidoPaternoContactoEmergencia) {
        this.apellidoPaternoContactoEmergencia = apellidoPaternoContactoEmergencia;
    }

    public String getApellidoMaternoContactoEmergencia() {
        return apellidoMaternoContactoEmergencia;
    }

    public void setApellidoMaternoContactoEmergencia(String apellidoMaternoContactoEmergencia) {
        this.apellidoMaternoContactoEmergencia = apellidoMaternoContactoEmergencia;
    }

    public String getParentescocontactoEmergencia() {
        return parentescocontactoEmergencia;
    }

    public void setParentescocontactoEmergencia(String parentescocontactoEmergencia) {
        this.parentescocontactoEmergencia = parentescocontactoEmergencia;
    }
   

   
}
