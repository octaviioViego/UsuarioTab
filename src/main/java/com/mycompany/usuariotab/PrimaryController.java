package com.mycompany.usuariotab;

import Modelo.Usuario;
import Modelo.UsuarioAgregar;
import ModeloDao.IUsuarioDaoImpl;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.MapValueFactory;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class PrimaryController implements Initializable {

    @FXML
    private TextField txtIdUsuario;
    @FXML
    private Button btnAgregra;
    @FXML
    private TableView<Usuario> tablaUsuarios;
    @FXML
    private TableColumn colId; 
    @FXML
    private TableColumn colNombre;
    @FXML
    private TableColumn colApellidoP;
    @FXML
    private TableColumn colApellidoM; 
    @FXML
    private TableColumn colContraseña; 
    @FXML
    private TableColumn colTelefonoCasa;
    @FXML
    private TableColumn colTelefonoCelular;
    @FXML
    private TableColumn colPuestoLabora;
    
    
   // public ObservableList<Usuario> usuario;
      public ObservableList<Usuario> usuario;
    String UsuarioId;
   // private Stage stage;
    @FXML
    private Button btnconsultarUsuario;
    
    @FXML
    private void buscarUsarioById(ActionEvent event) throws IOException {
        //this.tablaUsuarios.
       this.tablaUsuarios.getItems().clear();
     
        try {

            double buscarPorID = Double.parseDouble(this.txtIdUsuario.getText());
            //abrimos vista de campura de datos
            FXMLLoader loader = new FXMLLoader(getClass().getResource("secondary.fxml"));
            Pane pan = (Pane) loader.load();
            SecondaryController vistaDatos = loader.getController();
            Scene escena = new Scene(pan);
            Stage datosPersona = new Stage();

            vistaDatos.vistaSec(this.txtIdUsuario.getText());
            datosPersona.initModality(Modality.NONE);
            datosPersona.setScene(escena);
            datosPersona.show();

            txtIdUsuario.clear();

        } catch (RuntimeException e) { //NumberFormatException
            miAlerta("Formato Error", e.getClass().toString(), e.getMessage());
        }

    }

    private void miAlerta(String titulo, String cabecera, String cuerpo) {
        Alert alerta = new Alert(Alert.AlertType.ERROR);
        alerta.setTitle(titulo);
        alerta.setHeaderText(cabecera);
        alerta.setContentText("el ID no puede algo diferente de un numero entero ");
        alerta.showAndWait();
    }

    @FXML
    private void agregarUsuario(ActionEvent event) {
        try {
            //abrimos vista de campura de datos
            FXMLLoader loader = new FXMLLoader(getClass().getResource("agregarUsuario.fxml"));
            Pane pan = (Pane) loader.load();

            Scene escena = new Scene(pan);
            Stage datosPersona = new Stage();

            datosPersona.initModality(Modality.NONE);
            datosPersona.setScene(escena);
            datosPersona.show();
            
            
            
        } catch (IOException ex) {
            Alert alert2 = new Alert(Alert.AlertType.ERROR);
            alert2.setHeaderText(null);
            alert2.setTitle("Error en la carga de usuarios");
            alert2.setContentText("¡Por favor intentelo mas tarde!");
            alert2.showAndWait();
        }
    
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        usuario = FXCollections.observableArrayList();
        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        colApellidoP.setCellValueFactory(new PropertyValueFactory<>("apellidoPaterno"));
        colApellidoM.setCellValueFactory(new PropertyValueFactory<>("ApellidoMaterno"));
        colTelefonoCasa.setCellValueFactory(new PropertyValueFactory<>("telefonoCasa"));
        colTelefonoCelular.setCellValueFactory(new PropertyValueFactory<>("telefonoCelular"));
        colContraseña.setCellValueFactory(new PropertyValueFactory<>("contraseña"));
        colPuestoLabora.setCellValueFactory(new PropertyValueFactory<>("puestoLaboral"));
        
        IUsuarioDaoImpl useDao = new IUsuarioDaoImpl();
        ArrayList<Usuario> user = useDao.LLenarDatos();
        
        for (Usuario user2 : user) {
            this.usuario.add(user2);
            this.tablaUsuarios.setItems(usuario);
        }
    
    tablaUsuarios.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> mostrarDetallesPersona(newValue));
    
    
   /* usuario = FXCollections.observableArrayList();
    Usuario usuario2 = new Usuario();
     
    //usuario=(ObservableList<Usuario>) usuario2.obtenerTodosLosUsuarios();
       ArrayList<Usuario> user = (ArrayList<Usuario>) usuario2.obtenerTodosLosUsuarios();
      
       colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        colApellidoP.setCellValueFactory(new PropertyValueFactory<>("apellidoPaterno"));
        colApellidoM.setCellValueFactory(new PropertyValueFactory<>("ApellidoMaterno"));
        colTelefonoCasa.setCellValueFactory(new PropertyValueFactory<>("telefonoCasa"));
        colTelefonoCelular.setCellValueFactory(new PropertyValueFactory<>("telefonoCelular"));
        colContraseña.setCellValueFactory(new PropertyValueFactory<>("contraseña"));
        colPuestoLabora.setCellValueFactory(new PropertyValueFactory<>("puestoLaboral"));
         
        for (Usuario user2 : user) {
            this.usuario.add(user2);
            this.tablaUsuarios.setItems(usuario);
        }*/
        
    
    }


  
//Muestra los detalles de la persona seleccionada

    private void mostrarDetallesPersona(Usuario Id) {

        if (Id != null) {

            //Relleno los labels desde el objeto persona
            UsuarioId = Integer.toString(Id.getId());
            txtIdUsuario.setText(Integer.toString(Id.getId()));
            txtIdUsuario.clear();
            
        } else {

            //Persona es null, vacío todos los labels.
        }

    }

    
    

    @FXML
    private void consultarUsuario(ActionEvent event) throws IOException {
    try {

            //double buscarPorID = Double.parseDouble(this.txtIdUsuario.getText());
            //abrimos vista de campura de datos
            FXMLLoader loader = new FXMLLoader(getClass().getResource("secondary.fxml"));
            Pane pan = (Pane) loader.load();
            SecondaryController vistaDatos = loader.getController();
            Scene escena = new Scene(pan);
            Stage datosPersona = new Stage();

            vistaDatos.vistaSec(UsuarioId);
            datosPersona.initModality(Modality.NONE);
            datosPersona.setScene(escena);
            datosPersona.show();

            txtIdUsuario.clear();

        } catch (RuntimeException e) { //NumberFormatException
            miAlerta("Formato Error", e.getClass().toString(), e.getMessage());
        }
            
            }


}
