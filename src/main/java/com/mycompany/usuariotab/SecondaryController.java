package com.mycompany.usuariotab;

import Modelo.Usuario;
import ModeloDao.IUsuarioDaoImpl;
import Persistencia.Conexion;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
//import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class SecondaryController {

    @FXML
    private Label txtId;
    @FXML
    private Button btnSalir;
    @FXML
    private Label lblNombre;
    @FXML
    private Label lblApellidoPaterno;
    @FXML
    private Label lblApellidoMaterno;
   
    @FXML
    private Label lblContraseña;
    @FXML
    private Button btnEliminar;
    @FXML
    private Button btnActualizar;
    @FXML
    private Label lblTelefonoCasa;
    @FXML
    private Label lblTelefonoCelular;
    @FXML
    private Label lblCurp;
    @FXML
    private Label lblNumeroSocial;
    @FXML
    private Label lblPuestoLaboral;
    @FXML
    private Label lblFechaDeIngreso;
    @FXML
    private Label lblDireccion;
    @FXML
    private Label lblUltimaModificacion;
    @FXML
    private Button btnConsulta;
    
    String nombreContactoEmergencia;
    String ApellidoPContactoEmergencia;
    String ApellidoMContactoEmergencia;
    String numeroTelefonicoContactoEmergencia;
    String parentescoContactoEmergencia;
    String id;
    String Nombre;
    String ApellidoP;
    void vistaSec(String buscarPorID) {
       
     txtId.setText(buscarPorID);  
      
     
      //  System.out.println("Hello World!");
       
        IUsuarioDaoImpl useDao = new IUsuarioDaoImpl();
        Usuario user1 = useDao.obtenerUsuariobyId(buscarPorID);
        
        //Imprime los campos del DAO en la ventana 
        
        lblNombre.setText(user1.getNombre());
        lblApellidoPaterno.setText(user1.getApellidoPaterno());
        lblApellidoMaterno.setText(user1.getApellidoMaterno());
        lblContraseña.setText(user1.getContraseña());
        lblTelefonoCasa.setText(user1.getTelefonoCasa());
        lblTelefonoCelular.setText(user1.getTelefonoCelular());
        lblCurp.setText(user1.getCurp());
        lblNumeroSocial.setText(user1.getNumeroSeguroSocial());
        lblPuestoLaboral.setText(user1.getPuestoLaboral());
        lblFechaDeIngreso.setText(user1.getFechaDeIngreso());
        lblDireccion.setText(user1.getDireccion());
        lblUltimaModificacion.setText(user1.getFechaDeModificacion());
        
        // Datos del contacto de emergencia
        nombreContactoEmergencia = user1.getNombreContactoEmergencia();
        ApellidoPContactoEmergencia = user1.getApellidoPaternoContactoEmergencia();
        ApellidoMContactoEmergencia = user1.getApellidoMaternoContactoEmergencia();
        numeroTelefonicoContactoEmergencia = user1.getNumeroEmergencia();
        parentescoContactoEmergencia = user1.getParentescocontactoEmergencia();
        // Datos del Usuarios   
       id = buscarPorID;
       Nombre=user1.getNombre();
       ApellidoP=user1.getApellidoPaterno();
       
       
        
    }

    @FXML
    private void Salir(ActionEvent event) {
    Node source = (Node) event.getSource(); //Estas lineas de codigo son para cerrar la ventana
    Stage stage = (Stage) source.getScene().getWindow();
    stage.close();
    
}

    @FXML
    private void eliminarUsuariobyId(ActionEvent event) {
    try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("eliminarUsuario.fxml"));
            Pane pan = (Pane) loader.load();
            EliminarUsuarioController vistaDatos = loader.getController();
            Scene escena = new Scene(pan);
            Stage datosPersona = new Stage();
           
            vistaDatos.vistaSec(this.txtId.getText(),this.lblNombre.getText(),this.lblApellidoPaterno.getText(),this.lblApellidoMaterno.getText(),this.lblPuestoLaboral.getText(),this.lblFechaDeIngreso.getText());
            datosPersona.initModality(Modality.NONE);
            datosPersona.setScene(escena);
            datosPersona.show();
            
             Node source = (Node) event.getSource(); //Estas lineas de codigo son para cerrar la ventana
             Stage stage = (Stage) source.getScene().getWindow();
             stage.close();
            
    }catch(IOException e){}
    
    }

    @FXML
    private void actualizarUsuario(ActionEvent event) throws IOException {
    try{
         FXMLLoader loader = new FXMLLoader(getClass().getResource("actualizarUsuario.fxml"));
            Pane pan = (Pane) loader.load();
            ActualizarUsuarioController vistaDatos = loader.getController();
            Scene escena = new Scene(pan);
            Stage datosPersona = new Stage();
           
            vistaDatos.vistaSec(this.txtId.getText());
            datosPersona.initModality(Modality.NONE);
            datosPersona.setScene(escena);
            datosPersona.show();
          
            Node source = (Node) event.getSource(); //Estas lineas de codigo son para cerrar la ventana
            Stage stage = (Stage) source.getScene().getWindow();
            stage.close();  
             
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setHeaderText(null);
                alert.setTitle("¡Alerta! Informacion importante");
                alert.setContentText("Al modificar los datos del usuario no se podra recuperar los datos anteriores");
                alert.showAndWait();
            
              
                
    }catch(IOException e){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setHeaderText(null);
                alert.setTitle("¡Alerta! Informacion importante");
                alert.setContentText("ocurrio un error por favor intentelo de nuevo");
                alert.showAndWait();
    }
    
  }    

    @FXML
    private void consultarContactoEmergencia(ActionEvent event) throws IOException {
        
        try {
           
        
            //abrimos vista de campura de datos
            FXMLLoader loader = new FXMLLoader(getClass().getResource("consultarContactoEmergencia.fxml"));
            Pane pan = (Pane) loader.load();
            ConsultarContactoEmergenciaController vistaDatos = loader.getController();
            Scene escena = new Scene(pan);
            Stage datosPersona = new Stage();
           
            vistaDatos.vistaSec(this.id,this.Nombre,this.ApellidoP,this.nombreContactoEmergencia,this.ApellidoPContactoEmergencia,this.ApellidoMContactoEmergencia,this.numeroTelefonicoContactoEmergencia,this.parentescoContactoEmergencia);
            datosPersona.initModality(Modality.NONE);
            datosPersona.setScene(escena);
            datosPersona.show();
            
            Node source = (Node) event.getSource(); //Estas lineas de codigo son para cerrar la ventana
            Stage stage = (Stage) source.getScene().getWindow();
            stage.close();  
             
           
       
            
       }catch(RuntimeException e){ //NumberFormatException
       //  miAlerta("Formato Error", e.getClass().toString(), e.getMessage());
        }
        
    }

}
    
    

    
    
