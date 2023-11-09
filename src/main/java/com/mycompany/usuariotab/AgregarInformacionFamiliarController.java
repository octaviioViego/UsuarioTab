/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.usuariotab;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.binding.BooleanBinding;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.MenuButton;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author octav
 */
public class AgregarInformacionFamiliarController implements Initializable {

    @FXML
    private ChoiceBox<String> menuVivoFinitoPadre;
    @FXML
    private Button btnRegistrarDatosFamiliares;
    @FXML
    private Button btnCancelar;
    @FXML
    private ChoiceBox<String> menuVivoFinitoMadre;
    @FXML
    private RadioButton btnHijosSi;
    @FXML
    private ToggleGroup hijosSioNo;
    @FXML
    private RadioButton btnHijosNo;
    @FXML
    private RadioButton btnEsposa;
    @FXML
    private ToggleGroup esposaOconcubina;
    @FXML
    private RadioButton btnConcubina;
    @FXML
    private RadioButton rbnEsposaSi;
    @FXML
    private ToggleGroup registrarEsposaConcubina;
    @FXML
    private RadioButton btnEsposaNo;
    @FXML
    private TextField txtNombrePadre;
    @FXML
    private TextField txtApellidoPaternoPadre;
    @FXML
    private TextField txtApellidoMaternoPadre;
    @FXML
    private TextField txtNombreMadre;
    @FXML
    private TextField txtApellidoPaternoMadre;
    @FXML
    private TextField txtApellidoMaternoMadre;
    @FXML
    private TextField txtNombrePareja;
    @FXML
    private TextField txtApellidoPaternoPareja;
    @FXML
    private TextField txtApellidoMaternoPareja;
    @FXML
    private TextField txtEdadPareja;
    @FXML
    private TextField txtNombreHijo;
    @FXML
    private TextField txtApellidoPaternoHijo;
    @FXML
    private TextField txtApellidoMaternoHijo;
    @FXML
    private TextField txtEdadHijo;

    private String[] vivoFinito = {"Vivo","Finito"};
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
     System.out.println("Hola");
     BooleanBinding desactivadoUno=rbnEsposaSi.selectedProperty().not();//es un swing de encendido-apagado para la esposa
     btnEsposa.disableProperty().bind(desactivadoUno);
     btnConcubina.disableProperty().bind(desactivadoUno);
     txtNombrePareja.disableProperty().bind(desactivadoUno);
     txtApellidoPaternoPareja.disableProperty().bind(desactivadoUno);
     txtApellidoMaternoPareja.disableProperty().bind(desactivadoUno);
     txtEdadPareja.disableProperty().bind(desactivadoUno);
     
     BooleanBinding desactivado=btnHijosSi.selectedProperty().not();//es un swing de encendido-apagado para la hijo
     txtNombreHijo.disableProperty().bind(desactivado);
     txtApellidoPaternoHijo.disableProperty().bind(desactivado);
     txtApellidoMaternoHijo.disableProperty().bind(desactivado);
     txtEdadHijo.disableProperty().bind(desactivado);
     
     menuVivoFinitoPadre.getItems().addAll(vivoFinito);
     menuVivoFinitoMadre.getItems().addAll(vivoFinito);
    }    

    @FXML
    private void registrarDatosFamiliares(ActionEvent event) {
    }

    @FXML
    private void cancelar(ActionEvent event) {
     Node source = (Node) event.getSource(); //Estas lineas de codigo son para cerrar la ventana
    Stage stage = (Stage) source.getScene().getWindow();
    stage.close();
    }

    @FXML
    private void hijosSioNo(ActionEvent event) {
    }

    @FXML
    private void esposaOconcubina(ActionEvent event) {
    }

    @FXML
    private void registrarEsposaConcubina(ActionEvent event) {
    }
    
}
