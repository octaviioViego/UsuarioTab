/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.usuariotab;

import static Modelo.NumeroDeEmpleado.crearListaDeEnteros;

import Modelo.UsuarioAgregarCompleto;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.Year;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import java.time.LocalDate;
import java.time.Year;
import java.time.format.DateTimeFormatter;
import ModeloDao.IUsuarioDaoImpl;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
/**
 * FXML Controller class
 *
 * @author octav
 */
public class AgregarUsuarioCompletoController implements Initializable {

    @FXML
    private TextField txtNombre;
    @FXML
    private TextField txtApellidoPaterno;
    @FXML
    private TextField txtApellidoMaterno;
    @FXML
    private TextField txtTelefonoCelular;
    @FXML
    private TextField txtTelefonoCasa;
    @FXML
    private TextField txtCurp;
    @FXML
    private TextField txtNumerodeSeguroSocial;
    @FXML
    private TextField txtRfc;
    @FXML
    private ChoiceBox<String> menuNivelEducativo;
    @FXML
    private TextField txtDireccion;
    @FXML
    private TextField txtNumerodeCuenta;
    @FXML
    private TextField txtContraseña;
    @FXML
    private RadioButton RbnSicuentoconFamilia;
    @FXML
    private ToggleGroup familiares;
    @FXML
    private RadioButton RdbNotengoFamilia;
    @FXML
    private ChoiceBox<String> menuPuesto;
    
    private final String[] nivelEducativo = {"Primaria","Secundaria","Preparatoria","Universidad"};
    private final String[] puesto = {"Ayudante en general de tienda","Sub-gerente de tienda","Jefe de tienda"};
    String familiaNoTiene; 
    @FXML
    private Button btnAgregar;
    @FXML
    private Button btnCancelar;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         menuNivelEducativo.getItems().addAll(nivelEducativo);
         menuPuesto.getItems().addAll(puesto);
    
    }    

    @FXML
    private void registroDeFamiliares(ActionEvent event) throws IOException {
   
    if(RbnSicuentoconFamilia.isSelected()){
    FXMLLoader loader = new FXMLLoader(getClass().getResource("agregarInformacionFamiliar.fxml"));
            Pane pan = (Pane) loader.load();
       
            Scene escena = new Scene(pan);
            Stage datosPersona = new Stage();
           
            datosPersona.initModality(Modality.NONE);
            datosPersona.setScene(escena);
            datosPersona.show();
        }else if(RdbNotengoFamilia.isSelected()){
            familiaNoTiene ="no tiene familia"; //aqui capture cuando el usuario no tenga familia
               }else{ //mandar una exepccion
                        } 
    }

       
    @FXML
    private void agregarUsuario(ActionEvent event) {
    
    try{
        //obtengo la fecha y el primera letra del nombre del usuario
        LocalDate fecha = LocalDate.now(); // Obtener la fecha actual
        // Formatear LocalDate como una cadena con un patrón específico
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy"); 
        String fechaFormateada = fecha.format(formatter);
       
        System.out.println("Fecha formateada como String: " + fechaFormateada);
         
        Year anioActual = Year.now(); // Obtener el año actual
        
        // Formatear el año en un formato específico
        DateTimeFormatter format = DateTimeFormatter.ofPattern("yy");
        String anioFormateado = anioActual.format(format);
        
        System.out.println("Año formateado: " + anioFormateado);
        
       // System.out.println( crearListaDeEnteros(valorIngresado,anioFormateado)); 
            String numEmpleado = crearListaDeEnteros("f",anioFormateado);
      
            String educaticion = menuNivelEducativo.getValue();
            String puestoDeTrabajo = menuPuesto.getValue();
            String nombre = this.txtNombre.getText();
            String apellidoPaterno = this.txtApellidoPaterno.getText();
            String apellidoMaterno = this.txtApellidoMaterno.getText();
            String numeroTelefonicoCelular = this.txtTelefonoCelular.getText();
            String numeroTelefonicoCasa = this.txtTelefonoCasa.getText();
            String curp = this.txtCurp.getText();
            String numeroSeguroSocial = this.txtNumerodeSeguroSocial.getText();
            String rfc = this.txtRfc.getText();
            String direccion = this.txtDireccion.getText();
            String numeroDeCuenta = this.txtNumerodeCuenta.getText();
            String contraseña = this.txtContraseña.getText();

          UsuarioAgregarCompleto b = new UsuarioAgregarCompleto(numEmpleado,nombre,apellidoPaterno,apellidoMaterno,numeroTelefonicoCasa,numeroTelefonicoCelular,contraseña,curp,numeroSeguroSocial,  educaticion, rfc,  direccion,  numeroDeCuenta, puestoDeTrabajo, familiaNoTiene, fechaFormateada);
          IUsuarioDaoImpl auxDos = new IUsuarioDaoImpl();
          auxDos.crearUsuarioCompleto(b);
    
           Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setHeaderText(null);
                alert.setTitle("¡Alerta! Informacion");
                alert.setContentText("El Usuario se añadido correctamente");
                alert.showAndWait();
            
             Node source = (Node) event.getSource(); //Estas lineas de codigo son para cerrar la ventana
             Stage stage = (Stage) source.getScene().getWindow();
             stage.close();
          
    }catch(Exception e){
    
    }
    }

    @FXML
    private void cancelar(ActionEvent event) {
         Node source = (Node) event.getSource(); //Estas lineas de codigo son para cerrar la ventana
         Stage stage = (Stage) source.getScene().getWindow();
         stage.close();
    
    }

                  
                  }
