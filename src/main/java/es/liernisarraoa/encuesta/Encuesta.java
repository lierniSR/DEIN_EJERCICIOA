/**
 * Clase principal de la aplicación de encuesta.
 * Esta clase hereda de Application y sobrescribe el método start para inicializar la interfaz gráfica.
 *
 * @author LierniSarraoa
 * @version 1.0
 */
package es.liernisarraoa.encuesta;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Clase principal de la aplicación de encuesta.
 *
 * @see javafx.application.Application
 */
public class Encuesta extends Application {

    /**
     * Escena principal de la aplicación.
     * Se utiliza para almacenar la escena cargada desde el archivo FXML.
     */
    private static Scene scene;

    /**
     * Método principal de la aplicación.
     * Se llama automáticamente cuando se inicia la aplicación.
     *
     * @param stage Etapa principal de la aplicación.
     * @throws Exception Si ocurre un error al cargar la escena.
     */
    @Override
    public void start(Stage stage) throws Exception {
        /**
         * Carga la escena desde el archivo FXML.
         * El archivo FXML debe estar en el mismo paquete que esta clase.
         */
        FXMLLoader fxmlLoader = new FXMLLoader(Encuesta.class.getResource("encuesta.fxml"));
        scene = new Scene(fxmlLoader.load(), 625, 580);
        stage.setTitle("Encuesta!");
        /**
         * Permite que la ventana principal sea redimensionable.
         */
        stage.setResizable(true);
        stage.setScene(scene);
        stage.show();
    }

    /**
     * Método principal de la aplicación.
     * Se llama automáticamente cuando se inicia la aplicación.
     *
     * @param args Argumentos de la línea de comandos.
     */
    public static void main(String[] args) {
        launch();
    }

    /**
     * Devuelve la escena principal de la aplicación.
     *
     * @return Escena principal de la aplicación.
     */
    public static Scene getScene(){
        return scene;
    }
}