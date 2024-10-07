package es.liernisarraoa.encuesta.controladores;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.util.ResourceBundle;


public class HelloController implements Initializable {
    @FXML
    private TextField labelProfesion;

    @FXML
    private TextField labelHermanos;

    @FXML
    private ComboBox comboBoxEdad;

    @FXML
    private RadioButton radioHombre;

    @FXML
    private RadioButton radioMujer;

    @FXML
    private RadioButton radioOtro;

    @FXML
    private ToggleGroup RadioGrupo;

    @FXML
    private CheckBox checkBoxPractica;

    @FXML
    private ListView<String> listaDeportes;

    @FXML
    private Slider sliderCompras;

    @FXML
    private Slider sliderTelevision;

    @FXML
    private Slider sliderCine;

    @FXML
    private Button botonAceptar;

    @FXML
    private Button botonCancelar;

    @FXML
    private VBox VBoxPantalla;
    
    public void visualizarLista(ActionEvent actionEvent) {
        String[] listaString = new String[] {"Futbol", "Tenis", "Baloncesto"};
        if(checkBoxPractica.isSelected()){
            listaDeportes.setDisable(false);
        } else {
            listaDeportes.setDisable(true);
        }
    }

    public void mensajeInfo(ActionEvent actionEvent) {
    }

    public void salirPrograma(ActionEvent actionEvent) {
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        String[] listaString = new String[] {"Futbol", "Tenis", "Baloncesto"};
        listaDeportes.getItems().addAll(listaString);
        listaDeportes.setDisable(true);
        listaDeportes.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
    }
}