/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.usuariotab;

import Modelo.Usuario;
import Modelo.UsuarioAgregarCompleto;
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
public class VerInformacionController implements Initializable {

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
    private Label lblNumeroDeSeguroSocial;
    @FXML
    private Label lblDireccion;
    @FXML
    private Label lblRfc;
    @FXML
    private Label lblFechaDeIngreso;
    @FXML
    private Label lblPuestoLaboral;
    @FXML
    private Button btnActnformacion;
    @FXML
    private Button BtnMostrarInformacionCompleta;
    @FXML
    private Label lblIdUsuario;
    @FXML
    private Label lblNumeroEmpleado;

    /**
     * Initializes the controller class.
     */
    /* void vistaSec(String numeroEmpleado) {
       
     lblNumeroEmpleado.setText(numeroEmpleado);  
      
     
      //  System.out.println("Hello World!");
       
        IUsuarioDaoImpl useDao = new IUsuarioDaoImpl();
        Usuario user1 = useDao.obtenerUsuariobyId(buscarPorID);
        
        //Imprime los campos del DAO en la ventana 
      //  lblNumeroEmpleado.setText(user1.getApellidoPaterno());
        lblNombre.setText(user1.getNombre());
        lblApellidoPaterno.setText(user1.getApellidoPaterno());
        lblApellidoMaterno.setText(user1.getApellidoMaterno());
        lblTelefonoCelular.setText(user1.getTelefono());
        lblTelefonoCasa.setText(user1.getContraseña());
        lblCurp.setText(user1.getApellidoPaterno());
        lblNumeroDeSeguroSocial.setText(user1.getApellidoPaterno());
        lblDireccion.setText(user1.getApellidoPaterno());
        lblRfc.setText(user1.getApellidoPaterno());    
        lblFechaDeIngreso.setText(user1.getApellidoPaterno());
        lblPuestoLaboral.setText(user1.getApellidoPaterno());        
                
                
                
    }*/
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void aceptarInformacion(ActionEvent event) {
     Node source = (Node) event.getSource(); //Estas lineas de codigo son para cerrar la ventana
             Stage stage = (Stage) source.getScene().getWindow();
             stage.close();
    }

    @FXML
    private void MostrarInformacionCompleta(ActionEvent event) {
    
    }

    void vistaSec(String numeroEmpleado) {
        
        lblNumeroEmpleado.setText(numeroEmpleado);  
      //estraigo los datos de la base de datos
        IUsuarioDaoImpl useDao = new IUsuarioDaoImpl();
        UsuarioAgregarCompleto user1 = useDao.obtenerUsuariobyNumeroEmpleado(numeroEmpleado);
        //Imprime los campos del DAO en la ventana 
        
        lblNombre.setText(user1.getNombre());
        lblApellidoPaterno.setText(user1.getApellidoPaterno());
        lblApellidoMaterno.setText(user1.getApellidoMaterno());
        lblTelefonoCasa.setText(user1.getTelefonoCasa());
        lblTelefonoCelular.setText(user1.getTelefonoCelular());
        lblCurp.setText(user1.getCurp());
        lblNumeroDeSeguroSocial.setText(user1.getNumeroDeSeguroSocial());
        lblDireccion.setText(user1.getDireccion());
        lblRfc.setText(user1.getRfc());
        lblFechaDeIngreso.setText(user1.getFechaDeingreso());
        lblPuestoLaboral.setText(user1.getPuestoaDesempenar());
        
    }
    
}
