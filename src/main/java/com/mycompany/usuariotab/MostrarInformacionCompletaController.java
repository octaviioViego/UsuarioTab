/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.usuariotab;

import Modelo.Usuario;
import ModeloDao.IUsuarioDaoImpl;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author octav
 */
public class MostrarInformacionCompletaController implements Initializable {

    @FXML
    private Label lblNombre;
    @FXML
    private Label lblApellidoPaterno;
    @FXML
    private Label lblApellidoMaterno;
    @FXML
    private Label lblTelefonoCelular;
    @FXML
    private Label lblTelefonoCasa;
    @FXML
    private Label lblCurp;
    @FXML
    private Label lblNumerodeSeguroSocial;
    @FXML
    private Label lblNivelEducativo;
    @FXML
    private Label lblRfc;
    @FXML
    private Label lblDireccion;
    @FXML
    private Label lblPuesto;
    @FXML
    private Label lblIdParientes;
    @FXML
    private Label lblNumerodeCuenta;
    @FXML
    private Label lblFechaDeIngreso;
    @FXML
    private Label lblContraseña;
    @FXML
    private Label lblNumerodeEmpleado;
    @FXML
    private Button btnAceptar;
    @FXML
    private Button btnActualizarUsuario;
    @FXML
    private Button btnEliminar;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

   void vistaSec(String buscarPorID) {
        
        lblNumerodeEmpleado.setText(buscarPorID);  
      
     
      //  System.out.println("Hello World!");
       
        IUsuarioDaoImpl useDao = new IUsuarioDaoImpl();
        Usuario user1 = useDao.obtenerUsuariobyId(buscarPorID);
        
        //Imprime los campos del DAO en la ventana 
        
        lblNombre.setText(user1.getNombre());
        lblApellidoPaterno.setText(user1.getApellidoPaterno());
        lblApellidoMaterno.setText(user1.getApellidoMaterno());
       // lblTelefonoCelular.setText(user1.getTelefono());
        lblContraseña.setText(user1.getContraseña());
       // lblTelefonoCasa.setText(user1.getTelefono());
    }
    
    
    
    
    
    @FXML
    private void aceptarInformacion(ActionEvent event) {
    Node source = (Node) event.getSource(); //Estas lineas de codigo son para cerrar la ventana
    Stage stage = (Stage) source.getScene().getWindow();
    stage.close();
    }

    @FXML
    private void actualizarUsuario(ActionEvent event) {
    }

    @FXML
    private void eliminarUsuario(ActionEvent event) {
    }

    
    
}
