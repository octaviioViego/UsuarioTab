/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.usuariotab;

import Modelo.Usuario;
import ModeloDao.IUsuarioDaoImpl;
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
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author octav
 */
public class EliminarUsuarioController implements Initializable {

    @FXML
    private Button btnEliminar;
    @FXML
    private Button btnCancelar;
    @FXML
    private Label lblId;
    @FXML
    private Label lblNombre;
    @FXML
    private Label lblApellidoPaterno;
     @FXML
    private Label lblPuestoDesempeñado;
    @FXML
    private Label lblApellidoMaterno1;
    @FXML
    private Label lblFechaIngreso;
    /**
     * Initializes the controller class.
     */
    int numeroEntero;
    
   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
void vistaSec(String idUsuario, String nombre, String apellidoPaterno, String apellidoMaterno, String puesto,String fechaIngreso) {
        numeroEntero = Integer.parseInt(idUsuario);

     lblId.setText(idUsuario);   
     lblNombre.setText(nombre);
     lblApellidoPaterno.setText(apellidoPaterno);
     lblApellidoMaterno1.setText(apellidoMaterno);
     lblPuestoDesempeñado.setText(puesto);
     lblFechaIngreso.setText(fechaIngreso);
    }
    
    
    
    @FXML
    private void cancelarEliminarUsuariobyId(ActionEvent event) throws IOException {
    FXMLLoader loader = new FXMLLoader(getClass().getResource("secondary.fxml"));
            Pane pan = (Pane) loader.load();
            SecondaryController vistaDatos = loader.getController();
            Scene escena = new Scene(pan);
            Stage datosPersona = new Stage();
           
            vistaDatos.vistaSec(this.lblId.getText());
            datosPersona.initModality(Modality.NONE);
            datosPersona.setScene(escena);
            datosPersona.show();
            
             Node source = (Node) event.getSource(); //Estas lineas de codigo son para cerrar la ventana
             Stage stage = (Stage) source.getScene().getWindow();
             stage.close(); 
    }

   
    @FXML
    private void confirmarEliminarUsuariobyId(ActionEvent event) throws IOException {
           
        
            IUsuarioDaoImpl useDao = new IUsuarioDaoImpl();
            useDao.eliminarUsuario(numeroEntero);
            
            Node source = (Node) event.getSource(); //Estas lineas de codigo son para cerrar la ventana
            Stage stage = (Stage) source.getScene().getWindow();
            stage.close();
            
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText(null);
            alert.setTitle("¡Alerta! usuario eliminado");
            alert.setContentText("El usuario se elimino correctamente");
            alert.showAndWait(); 
             
            
             
             
   
    }          

    

   

    
}
