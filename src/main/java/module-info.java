module es.etg.dam {
    requires javafx.controls;
    requires javafx.fxml;

    opens es.etg.dam to javafx.fxml;
    opens es.etg.dam.view to java.fxml;

    exports es.etg.dam.controller;
    exports es.etg.dam.view;
}
