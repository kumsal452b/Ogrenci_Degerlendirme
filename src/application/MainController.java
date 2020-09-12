package application;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

public class MainController {
	static PrintWriter fqFileWriter;

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
    private Button kok_kayit_geri;
    @FXML
    private TextField textad;

    @FXML
    private TextField textsoyad;

    @FXML
    private TextField textnumara;

    @FXML
    private TextField textvize;

    @FXML
    private TextField textfinal;


    @FXML
    void kayitet(ActionEvent event) throws IOException {
		
    	fqFileWriter = new PrintWriter(new FileWriter("D:\\ogrbilgileri3.txt", true));
		String bilgiler = "";
		bilgiler = textad.getText();
		bilgiler += "*";

		bilgiler += textsoyad.getText();
		bilgiler += "*";
		

		bilgiler += textnumara.getText();
		bilgiler += "*";


		bilgiler += textvize.getText();
		bilgiler += "*";

		bilgiler += textfinal.getText();

		fqFileWriter.write(bilgiler+"-");
//		fqFileWriter.printf("", "-");

		fqFileWriter.close();
		fqFileWriter.flush();
    	
    }

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
        kok_kayit_geri.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				kokMain.toFront();
				
			}
		});
    }
}
