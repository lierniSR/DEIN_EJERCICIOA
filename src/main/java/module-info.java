module es.liernisarraoa.encuesta {
    requires javafx.controls;
    requires javafx.fxml;


    opens es.liernisarraoa.encuesta to javafx.fxml;
    exports es.liernisarraoa.encuesta;
    exports es.liernisarraoa.encuesta.controladores;
    opens es.liernisarraoa.encuesta.controladores to javafx.fxml;
}