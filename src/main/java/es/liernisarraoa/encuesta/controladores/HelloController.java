package es.liernisarraoa.encuesta.controladores;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.util.ResourceBundle;

import static java.lang.System.exit;


public class HelloController implements Initializable {
    @FXML
    private TextField labelProfesion;

    @FXML
    private TextField labelHermanos;

    @FXML
    private ComboBox<String> comboBoxEdad;

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
        exit(0);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        String[] listaString = new String[] {"Futbol", "Tenis", "Baloncesto", "Natacion", "Ciclismo", "Otro"};
        listaDeportes.getItems().addAll(listaString);
        listaDeportes.setDisable(true);
        listaDeportes.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        String[] edadesCombo = new String[] {"Menores de 18", "Entre 18 - 30", "Entre 31 - 50", "Entre 51 - 70", "Mayores de 70"};
        comboBoxEdad.getItems().addAll(edadesCombo);
    }
}