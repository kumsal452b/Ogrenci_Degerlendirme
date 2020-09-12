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
    private AnchorPane kokRapor;

    @FXML
    private AnchorPane kokHesap;

    @FXML
    private AnchorPane kokKayit;
    
    @FXML
    private AnchorPane kokCikti;

    @FXML
    void cikti(ActionEvent event) {
    	kokCikti.toFront();

    }

    @FXML
    void hesaplama(ActionEvent event) {
    	kokHesap.toFront();

    }

    @FXML
    void kayit(ActionEvent event) {
    	kokKayit.toFront();

    }

    @FXML
    void raporlama(ActionEvent event) {
    	kokRapor.toFront();

    }

    @FXML
    void initialize() {
        kokMain.toFront();
    }
}
