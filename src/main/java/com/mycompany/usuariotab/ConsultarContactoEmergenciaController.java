/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.usuariotab;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author octav
 */
public class ConsultarContactoEmergenciaController implements Initializable {

    @FXML
    private Button btnAceptar;
    @FXML
    private Button btnModificar;
    @FXML
    private Label lblNombre;
    @FXML
    private Label lblApellidoP;
    @FXML
    private Label lblApellidoM;
    @FXML
    private Label lblTelefono;
    @FXML
    private Label lblParentesco;
    @FXML
    private AnchorPane IdUsuario;
    @FXML
    private Label lblIDusuario;
    @FXML
    private Label lblNombreUsuario;
    @FXML
    private Label lblApellidoPUsuario;
   

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        
    }    

    @FXML
    private void aceptarInformacio(ActionEvent event) throws IOException {
    Node source = (Node) event.getSource(); //Estas lineas de codigo son para cerrar la ventana
            Stage stage = (Stage) source.getScene().getWindow();
            stage.close();
    
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
    
    }

    
    
    void vistaSec(String id, String Nombre, String ApellidoP, String nombreContactoEmergencia, String ApellidoPContactoEmergencia, String ApellidoMContactoEmergencia, String numeroTelefonicoContactoEmergencia, String parentescoContactoEmergencia) {
        lblIDusuario.setText(id);
        lblNombreUsuario.setText(Nombre);
        lblApellidoPUsuario.setText(ApellidoP);
        lblNombre.setText(nombreContactoEmergencia);
        lblApellidoP.setText(ApellidoPContactoEmergencia);
        lblApellidoM.setText(ApellidoMContactoEmergencia);
        lblTelefono.setText(numeroTelefonicoContactoEmergencia);
        lblParentesco.setText(parentescoContactoEmergencia);
    }
   
    @FXML
    private void mofidicarContacto(ActionEvent event) {
    
       try {
           FXMLLoader loader = new FXMLLoader(getClass().getResource("actualizarContactoEmergencia.fxml"));
            Pane pan = (Pane) loader.load();
            ActualizarContactoEmergenciaController vistaDatos = loader.getController();
            Scene escena = new Scene(pan);
            Stage datosPersona = new Stage();
           
            vistaDatos.vistaSec(this.lblIDusuario.getText());
            datosPersona.initModality(Modality.NONE);
            datosPersona.setScene(escena);
            datosPersona.show();
            
             Node source = (Node) event.getSource(); //Estas lineas de codigo son para cerrar la ventana
             Stage stage = (Stage) source.getScene().getWindow();
             stage.close();       
            
       }catch(IOException e){ 
           Alert alert2 = new Alert(Alert.AlertType.ERROR);
            alert2.setHeaderText(null);
            alert2.setTitle("Error en la carga");
            alert2.setContentText("¡Por favor intentelo de nuevo!");
            alert2.showAndWait();  
        
       }
    }

}
