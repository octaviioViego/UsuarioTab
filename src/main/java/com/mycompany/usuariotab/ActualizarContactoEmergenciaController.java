/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.usuariotab;

import Modelo.Usuario;
import Modelo.UsuarioActualizar;
import Modelo.UsuarioDeEmergenciaActualizar;
import ModeloDao.IUsuarioDaoImpl;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author octav
 */
public class ActualizarContactoEmergenciaController implements Initializable {

    @FXML
    private TextField txtNombreContaco;
    @FXML
    private TextField txtApellidoPContacto;
    @FXML
    private TextField txtApellidoMContacto;
    @FXML
    private TextField txtTelefono;
    @FXML
    private TextField txtParentescoContacto;
    @FXML
    private Label lblNombreUsuario;
    @FXML
    private Label lblApellidoPUsuario;
    @FXML
    private Label lblIDusuario;
    int numeroEntero;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    void vistaSec(String id) {
        numeroEntero = Integer.parseInt(id);
        lblIDusuario.setText(id);  
        
        IUsuarioDaoImpl useDao = new IUsuarioDaoImpl();
        Usuario user1 = useDao.obtenerUsuariobyId(id);
        
        //Imprime los campos del DAO en la ventana actualizar del contacto de emergencia
        txtNombreContaco.setText(user1.getNombreContactoEmergencia());
        txtApellidoPContacto.setText(user1.getApellidoPaternoContactoEmergencia());
        txtApellidoMContacto.setText(user1.getApellidoMaternoContactoEmergencia());
        txtTelefono.setText(user1.getNumeroEmergencia());
        txtParentescoContacto.setText(user1.getParentescocontactoEmergencia());
        // Imprime los campos del usuario
        lblNombreUsuario.setText(user1.getNombre());
        lblApellidoPUsuario.setText(user1.getApellidoPaterno());
        
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText(null);
            alert.setTitle("¡Alerta! Informacion");
            alert.setContentText("Una vez actualizado el usuario no podra recuperar la informacion anterior");
            alert.showAndWait();
    }
   
    @FXML
    private void aceptarActualizacion(ActionEvent event) throws IOException {
    try{
            LocalDate fecha = LocalDate.now(); // Obtener la fecha actual
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy"); 
            String fechaDeModificacion = fecha.format(formatter);
           
            String numeroEmergencia = this.txtTelefono.getText();
            String nombreContactoEmergencia = this.txtNombreContaco.getText();
            String apellidoPaternoContactoEmergencia = this.txtApellidoPContacto.getText();
            String apellidoMaternoContactoEmergencia = this.txtApellidoMContacto.getText();
            String parentescocontactoEmergencia = this.txtParentescoContacto.getText();
            
            
            
            
           UsuarioDeEmergenciaActualizar c = new UsuarioDeEmergenciaActualizar(fechaDeModificacion, numeroEmergencia,  nombreContactoEmergencia,  apellidoPaternoContactoEmergencia, apellidoMaternoContactoEmergencia, parentescocontactoEmergencia);
           IUsuarioDaoImpl aux = new IUsuarioDaoImpl();
           aux.actualizarUsuarioContactoPorId(numeroEntero,c);
           
            Node source = (Node) event.getSource(); //Estas lineas de codigo son para cerrar la ventana
            Stage stage = (Stage) source.getScene().getWindow();
            stage.close();   
           
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText(null);
            alert.setTitle("¡Alerta! Informacion");
            alert.setContentText("El Usuario se actualizo correctamente");
            alert.showAndWait();
            
            //Regresamos a la pantalla de busqueda ya actualizada
            
            FXMLLoader loader = new FXMLLoader(getClass().getResource("secondary.fxml"));
            Pane pan = (Pane) loader.load();
            SecondaryController vistaDatos = loader.getController();
            Scene escena = new Scene(pan);
            Stage datosPersona = new Stage();
           
            vistaDatos.vistaSec(this.lblIDusuario.getText());
            datosPersona.initModality(Modality.NONE);
            datosPersona.setScene(escena);
            datosPersona.show();
            
            
            
      
    }catch(NumberFormatException e) {

            Alert alert2 = new Alert(Alert.AlertType.ERROR);
            alert2.setHeaderText(null);
            alert2.setTitle("Error");
            alert2.setContentText("No te funciono");
            alert2.showAndWait();  
       }   
    }     

   

    
    
    @FXML
    private void cancelarActualizacio(ActionEvent event) {
    Node source = (Node) event.getSource(); //Estas lineas de codigo son para cerrar la ventana
             Stage stage = (Stage) source.getScene().getWindow();
             stage.close(); 
    
    }

    
    
}
