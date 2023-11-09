/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.usuariotab;

import Modelo.Usuario;
import Modelo.UsuarioActualizar;
import Modelo.UsuarioAgregar;
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
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
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
public class ActualizarUsuarioController implements Initializable {

    @FXML
    private TextField txtNombre;
    @FXML
    private TextField txtApellidoPaterno;
    @FXML
    private TextField txtApellidoMaterno;
    @FXML
    private TextField txtContraseña;
    @FXML
    private Button btnCancelar;
    @FXML
    private Button btnActualizarUsuario;
    @FXML
    private Button btnRegresar;
    @FXML
    private Label lblIdUsuario;

    int numeroEntero;
    @FXML
    private TextField txtTelefonoCasa;
    @FXML
    private TextField txtTelefonoCelular;
    @FXML
    private TextField txtCurp;
    @FXML
    private TextField txtNumeroSeguroSocial;
    @FXML
    private TextField txtPuestoLaboral;
    @FXML
    private TextField txtDireccion;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void cancelarActualizacion(ActionEvent event) {
     Node source = (Node) event.getSource(); //Estas lineas de codigo son para cerrar la ventana
     Stage stage = (Stage) source.getScene().getWindow();
     stage.close();
    }

    void vistaSec(String IdUsuario) {
        numeroEntero = Integer.parseInt(IdUsuario);
        
        lblIdUsuario.setText(IdUsuario);  
        
        IUsuarioDaoImpl useDao = new IUsuarioDaoImpl();
        Usuario user1 = useDao.obtenerUsuariobyId(IdUsuario);
        
        //Imprime los campos del DAO en la ventana actualizar
        txtNombre.setText(user1.getNombre());
        txtApellidoPaterno.setText(user1.getApellidoPaterno());
        txtApellidoMaterno.setText(user1.getApellidoMaterno());
        txtContraseña.setText(user1.getContraseña());
        txtTelefonoCasa.setText(user1.getTelefonoCasa());
        txtTelefonoCelular.setText(user1.getTelefonoCelular());
        txtCurp.setText(user1.getCurp());
        txtNumeroSeguroSocial.setText(user1.getNumeroSeguroSocial());
        txtPuestoLaboral.setText(user1.getPuestoLaboral());
        txtDireccion.setText(user1.getDireccion());
        
        
    }

 @FXML
    private void regresarPantallaAnterior(ActionEvent event) throws IOException {
     try {
           FXMLLoader loader = new FXMLLoader(getClass().getResource("secondary.fxml"));
            Pane pan = (Pane) loader.load();
            SecondaryController vistaDatos = loader.getController();
            Scene escena = new Scene(pan);
            Stage datosPersona = new Stage();
           
            vistaDatos.vistaSec(this.lblIdUsuario.getText());
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
 @FXML
    private void actualizarUsuario(ActionEvent event) throws IOException {
     
      try{
            LocalDate fecha = LocalDate.now(); // Obtener la fecha actual
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy"); 
            String fechaDeModificacion = fecha.format(formatter);
           
            String nombre = this.txtNombre.getText();
            String apellidoPaterno = this.txtApellidoPaterno.getText();
            String apellidoMaterno = this.txtApellidoMaterno.getText();
            String numeroTelefonicoCasa = this.txtTelefonoCasa.getText();
            String contraseña = this.txtContraseña.getText();
            String numeroTelefonicoCelular = this.txtTelefonoCelular.getText();
            String curp = this.txtCurp.getText();
            String numeroSeguroSocial = this.txtNumeroSeguroSocial.getText();
            String puestoLaboral = this.txtPuestoLaboral.getText();
            String direccion = this.txtDireccion.getText();
            
            
            
           UsuarioActualizar c = new UsuarioActualizar( nombre, apellidoPaterno, apellidoMaterno, contraseña, numeroTelefonicoCasa, numeroTelefonicoCelular, curp, numeroSeguroSocial, puestoLaboral,  direccion, fechaDeModificacion);
           IUsuarioDaoImpl aux = new IUsuarioDaoImpl();
           aux.actualizarUsuarioPorId(numeroEntero,c);
           
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
           
            vistaDatos.vistaSec(this.lblIdUsuario.getText());
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
}
