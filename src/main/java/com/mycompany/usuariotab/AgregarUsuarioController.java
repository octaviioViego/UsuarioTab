/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.usuariotab;

import static Modelo.NumeroDeEmpleado.crearListaDeEnteros;
import Modelo.UsuarioAgregar;
import ModeloDao.IUsuarioDaoImpl;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.Year;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author octav
 */
public class AgregarUsuarioController implements Initializable {

    @FXML
    private TextField txtNombre;
    @FXML
    private TextField txtApellidoPaterno;
    @FXML
    private TextField txtApellidoMaterno;
    @FXML
    private Button btnCancelar;
    @FXML
    private Button btnAgregar;
    @FXML
    private TextField txtTelefonoCasa;
    @FXML
    private TextField txtTelefonoCelular;
    @FXML
    private TextField txtcurp;
    @FXML
    private TextField txtNumSeguro;
    @FXML
    private TextField txtDireccion;
    @FXML
    private TextField txtNumeroContactoEmergencia;
    @FXML
    private TextField txtNombreContactoEmergencia;
    @FXML
    private TextField txtApellidoPContactoEmergencia;
    @FXML
    private TextField txtApellidoMContactoEmergencia;
    @FXML
    private TextField txtParentescoContactoEmergencia;
    @FXML
    private ChoiceBox<String> chbParentesco;
    private final String[] puesto = {"Ayudante en general de tienda","Sub-gerente de tienda","Jefe de tienda"};
   
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         chbParentesco.getItems().addAll(puesto);
       
    }

    @FXML
    private void cancelarRegistro(ActionEvent event) {
     Node source = (Node) event.getSource(); //Estas lineas de codigo son para cerrar la ventana
     Stage stage = (Stage) source.getScene().getWindow();
     stage.close();
    }

    @FXML
    private void agregarUsuario(ActionEvent event) {
           try{
           
           double telefono = Double.parseDouble(this.txtTelefonoCasa.getText());
           double telefonocasa = Double.parseDouble(this.txtTelefonoCelular.getText());
           double telefonocontacto = Double.parseDouble(this.txtNumeroContactoEmergencia.getText());
           
           LocalDate fecha = LocalDate.now(); // Obtener la fecha actual
        // Formatear LocalDate como una cadena con un patrón específico
           DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy"); 
           String FechaDeIngreso = fecha.format(formatter);
       
           System.out.println("Fecha formateada como String: " + FechaDeIngreso);
         
           Year anioActual = Year.now(); // Obtener el año actual
        
        // Formatear el año en un formato específico
           DateTimeFormatter format = DateTimeFormatter.ofPattern("yy");
           String anioFormateado = anioActual.format(format);
        
           System.out.println("Año formateado: " + anioFormateado);
               
          String contraseña = crearListaDeEnteros("f",anioFormateado);
               
          
            String nombre = this.txtNombre.getText();
            String apellidoPaterno = this.txtApellidoPaterno.getText();
            String apellidoMaterno = this.txtApellidoMaterno.getText();
            String numeroTelefonicoCasa = this.txtTelefonoCasa.getText();
            String numeroTelefonicoCelular = this.txtTelefonoCelular.getText();
            //String contraseña = this.txtContraseña.getText();
            String curp = this.txtcurp.getText();
            String numeroSeguroSocial = this.txtNumSeguro.getText();
            String puestoLaboral = this.chbParentesco.getValue();
            String direccion = this.txtDireccion.getText();
            String numeroEmergencia = this.txtNumeroContactoEmergencia.getText();
            String nombreContactoEmergencia = this.txtNombreContactoEmergencia.getText();
            String ApellidoPContacto = this.txtApellidoPContactoEmergencia.getText();
            String apellidoMContacto = this.txtApellidoMContactoEmergencia.getText();
            String infParentecoContacto = this.txtParentescoContactoEmergencia.getText();
            String fechaDeModificacion = FechaDeIngreso;
            
            
           UsuarioAgregar c = new UsuarioAgregar( nombre, apellidoPaterno, apellidoMaterno, contraseña, numeroTelefonicoCasa, numeroTelefonicoCelular, curp, numeroSeguroSocial, puestoLaboral, FechaDeIngreso, direccion, fechaDeModificacion, numeroEmergencia, nombreContactoEmergencia, ApellidoPContacto, apellidoMContacto, infParentecoContacto);
           IUsuarioDaoImpl aux = new IUsuarioDaoImpl();
           aux.crearUsuario(c);
           
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setHeaderText(null);
                alert.setTitle("¡Alerta! Informacion");
                alert.setContentText("El Usuario se añadido correctamente");
                alert.showAndWait();
            
             Node source = (Node) event.getSource(); //Estas lineas de codigo son para cerrar la ventana
             Stage stage = (Stage) source.getScene().getWindow();
             stage.close();
  
           }catch(NumberFormatException e) {

            Alert alert2 = new Alert(Alert.AlertType.ERROR);
            alert2.setHeaderText(null);
            alert2.setTitle("Error");
            alert2.setContentText("Formato incorrecto");
            alert2.showAndWait();  
       }   
     } 
}