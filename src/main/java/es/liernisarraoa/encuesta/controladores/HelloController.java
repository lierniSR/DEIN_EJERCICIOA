/**
 * Controlador de la aplicación de encuesta.
 *
 * @author LierniSarraoa
 */
package es.liernisarraoa.encuesta.controladores;

import es.liernisarraoa.encuesta.Encuesta;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;

import static java.lang.System.exit;

/**
 * Clase que controla la lógica de la aplicación de encuesta.
 */
public class HelloController implements Initializable {

    /**
     * Escena de la aplicación.
     */
    private Scene sceneApplication;

    /**
     * Cadena que almacena los errores encontrados en la validación de los campos.
     */
    private String errores = "";

    /**
     * Campo de texto para ingresar la profesión.
     */
    @FXML
    private TextField labelProfesion;

    /**
     * Campo de texto para ingresar el número de hermanos.
     */
    @FXML
    private TextField labelHermanos;

    /**
     * Combo box para seleccionar la edad.
     */
    @FXML
    private ComboBox<String> comboBoxEdad;

    /**
     * Grupo de botones de radio para seleccionar el sexo.
     */
    @FXML
    private ToggleGroup RadioGrupo;

    /**
     * Casilla de verificación para indicar si se practica algún deporte.
     */
    @FXML
    private CheckBox checkBoxPractica;

    /**
     * Lista de deportes que se pueden seleccionar.
     */
    @FXML
    private ListView<String> listaDeportes;

    /**
     * Control deslizante para indicar el grado de afición a las compras.
     */
    @FXML
    private Slider sliderCompras;

    /**
     * Control deslizante para indicar el grado de afición a ver la televisión.
     */
    @FXML
    private Slider sliderTelevision;

    /**
     * Control deslizante para indicar el grado de afición a ir al cine.
     */
    @FXML
    private Slider sliderCine;

    /**
     * Método que se ejecuta cuando se selecciona o deselecciona la casilla de verificación de práctica de deportes.
     *
     * @param actionEvent evento de acción
     */
    public void visualizarLista(ActionEvent actionEvent) {
        listaDeportes.setDisable(!checkBoxPractica.isSelected());
    }

    /**
     * Método que se ejecuta cuando se hace clic en el botón de aceptar.
     * Valida los campos y muestra un mensaje de error o información según sea necesario.
     *
     * @param actionEvent evento de acción
     */
    public void btnAceptar(ActionEvent actionEvent) {
        errores = "";
        sceneApplication = Encuesta.getScene();
        if (labelHermanos.getText().isEmpty()) {
            errores += "Hay que rellenar el campo de Número de Hermanos.\n";
        } else {
            try {
                int hermanos = Integer.parseInt(labelHermanos.getText());
            } catch (NumberFormatException e) {
                errores += "En el campo de Número de Hermanos solo se aceptan números.\n";
            }
        }
        if (labelProfesion.getText().isEmpty()) {
            errores += "Hay que rellenar el campo de Profesion.\n";
        }
        if (checkBoxPractica.isSelected()) {
            ObservableList<String> deportesSeleccionados = listaDeportes.getSelectionModel().getSelectedItems();
            if (deportesSeleccionados.isEmpty()) {
                errores += "Si se ha seleccionado la parte de (¿Practicas?), tiene que haber como mínimo un deporte seleccionado.\n";
            }
        }
        if (errores.isEmpty()) {
            alertaInfo();
        } else {
            alertaError();
        }
    }

    /**
     * Método que muestra un mensaje de error con los errores encontrados en la validación de los campos.
     */
    private void alertaError() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.initOwner(sceneApplication.getWindow());
        alert.setHeaderText(null);
        alert.setTitle("Error");
        alert.setContentText(errores);
        alert.showAndWait();
    }

    /**
     * Método que muestra un mensaje de información con los datos ingresados por el usuario.
     */
    public void alertaInfo() {
        ObservableList<String> deportesSeleccionados = listaDeportes.getSelectionModel().getSelectedItems();
        String deportes = "";
        for (int i = 0; i < deportesSeleccionados.size(); i++) {
            deportes += "\t" + deportesSeleccionados.get(i) + "\n";
        }
        SingleSelectionModel<String> edadSeleccionada = comboBoxEdad.getSelectionModel();
        String sexoSeleccionado = ((RadioButton) RadioGrupo.getSelectedToggle()).getText();
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.initOwner(sceneApplication.getWindow());
        alert.setHeaderText(null);
        alert.setTitle("TUS DATOS");
        if (checkBoxPractica.isSelected()) {
            alert.setContentText("Profesion: " + labelProfesion.getText() + "\n" +
                    "Nº de Hermanos: " + labelHermanos.getText() + "\n" +
                    "Edad: " + edadSeleccionada.getSelectedItem() + "\n" +
                    "Sexo: " + sexoSeleccionado + "\n" +
                    "Deportes que practicas: \n" +
                    deportes +
                    "Grado de afición a las compras: " + sliderCompras.getValue() + "\n" +
                    "Grado de afición a ver la televisión: " + sliderTelevision.getValue() + "\n" +
                    "Grado de afición a ir al cine: " + sliderCine.getValue() + "\n");
        } else {
            alert.setContentText("Profesion: " + labelProfesion.getText() + "\n" +
                    "Nº de Hermanos: " + labelHermanos.getText() + "\n" +
                    "Edad: " + edadSeleccionada.getSelectedItem() + "\n" +
                    "Sexo: " + sexoSeleccionado + "\n" +
                    "Grado de afición a las compras: " + sliderCompras.getValue() + "\n" +
                    "Grado de afición a ver la televisión: " + sliderTelevision.getValue() + "\n" +
                    "Grado de afición a ir al cine: " + sliderCine.getValue() + "\n");
        }

        alert.showAndWait();
    }

    /**
     * Método que se ejecuta cuando se hace clic en el botón de salir del programa.
     * Cierra la aplicación.
     *
     * @param actionEvent evento de acción
     */
    public void salirPrograma(ActionEvent actionEvent) {
        exit(0);
    }

    /**
     * Método que se ejecuta al inicializar la clase.
     * Inicializa los componentes de la interfaz gráfica.
     *
     * @param url            URL de la clase
     * @param resourceBundle recursos de la clase
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        String[] listaString = new String[]{"Futbol", "Tenis", "Baloncesto", "Natación", "Ciclismo", "Otro"};
        listaDeportes.getItems().addAll(listaString);
        listaDeportes.setDisable(true);
        listaDeportes.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        String[] edadesCombo = new String[]{"Menores de 18", "Entre 18 - 30", "Entre 31 - 50", "Entre 51 - 70", "Mayores de 70"};
        comboBoxEdad.getItems().addAll(edadesCombo);
    }
}