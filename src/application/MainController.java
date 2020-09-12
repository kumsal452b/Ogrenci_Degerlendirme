package application;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;

public class MainController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane kokMain;

    @FXML
    void cikti(ActionEvent event) {

    }

    @FXML
    void hesaplama(ActionEvent event) {

    }

    @FXML
    void kayit(ActionEvent event) {

    }

    @FXML
    void raporlama(ActionEvent event) {

    }

    @FXML
    void initialize() {
    	kokMain.toFront();
        assert kokMain != null : "fx:id=\"kokMain\" was not injected: check your FXML file 'Main_Menu.fxml'.";

    }
}
