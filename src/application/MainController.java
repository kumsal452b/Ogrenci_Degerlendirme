package application;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;

import javafx.collections.FXCollections;
import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.util.Callback;

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
    private TableView<Kayitlar> tbl;

    @FXML
    private TableColumn<Kayitlar, String> tbl_ad;

    @FXML
    private TableColumn<Kayitlar,String> tbl_soyad;

    @FXML
    private TableColumn<Kayitlar,String> tbl_no;

    @FXML
    private TableColumn<Kayitlar,String> tbl_vize;

    @FXML
    private TableColumn<Kayitlar,String> tbl_final;

    @FXML
    private TableColumn<Kayitlar,String> tbl_bp;

    @FXML
    private TableColumn<Kayitlar,String> tbl_hn;

    @FXML
    private Button guncellle;

    @FXML
    private Button kok_hesaplama_geri;

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

    ObservableList<Kayitlar> kayit;
    int sayac=0;
    static FileReader fileReader;
    @FXML
    void hesaplama(ActionEvent event) throws IOException {
    	kokHesap.toFront();
		String[][] bilgiler = new String[10][5];
		String[][] bilgiler2 = new String[10][7];
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 5; j++) {
				bilgiler[i][j] = "";
				bilgiler2[i][j] = "";
			}
		}
		int satir = 0;
		int sutun = 0;
		int ch = fileReader.read();
		//okuma mekanizmasý yukarýda anlatýldý
		while (ch != -1) {
			if (ch != '-') {
				if (ch != '*') {
					if (sayac == 0) {
						bilgiler[satir][sayac] += (char) ch;
					}
					if (sayac == 1) {
						bilgiler[satir][sayac] += (char) ch;
					}
					if (sayac == 2) {
						bilgiler[satir][sayac] += (char) ch;
					}
					if (sayac == 3) {
						bilgiler[satir][sayac] += (char) ch;
					}
					if (sayac == 4) {
						bilgiler[satir][sayac] += (char) ch;
					}

				} else {
					sayac++;
				}
			} else {
				sayac = 0;
				satir++;
			}
			ch = fileReader.read();
		}
		int count = 0;
		int counter = 0;
		satir=0;
		int a = 0,b = 0,c = 0;
		int count2=0;
		String not="",durumS="";
		boolean karar=true;
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 7; j++) {
				count = 0;
//				if (bilgiler[i][j].equals("")) {
//					i=9;
//					break;
//				}
				
				count = 0;
				//Vizr ve final notlarýnýn bulunduðu sutun bulunup gerekkli
				//iþlemler yürütülüyor
				if (counter % 7 == 6 || counter % 7 == 5) {
					if (karar) {
						try {
							a=(int) (Integer.parseInt(bilgiler[satir][3])*0.4);
						} catch (Exception e) {
							continue;
						}
						count2++;
					}
					else{
						b=(int) (Integer.parseInt(bilgiler[satir][4])*0.6);
						count2++;
						c=a+b;
						bilgiler2[satir][j-1]=c+"";
					}
					
					karar=false;
			
					if (count2==2) {
						not=c+"";
						if (100>= c && c>75) {
							durumS="A";
						}
						else if (75>= c && c>50) {
							durumS="B";
						}
						else if (50>= c && c>25) {
							durumS="C";
						}
						else if (25>= c && c>0) {
							durumS="D";
						}
						else {
							durumS="Belirsiz";
						}
						bilgiler2[satir][j]=durumS;
					}
					
				}else {
					bilgiler2[satir][j]=bilgiler[satir][j];
				}
//				bosluk = "";
				count = 0;
				counter++;
			}
			karar=true;
			satir++;
			counter=0;
			System.out.println();
		}
		System.out.println("AD        |SOYAD     |NUMARA    |NOT       |DURUM");
		System.out.println("________________________________________________________");
		for (int i = 0; i < 10; i++) {
			for (int k = 0; k < 7; k++) {
				if (bilgiler2[i][k].equals("")) {
					i=9;
					break;
				}
				String yedek = bilgiler2[i][k];
				String bosluk = "";
				int sayim = 10 - yedek.length();
				while (sayim > count) {
					bosluk += " ";
					count++;
				}
				count=0;
				System.out.print(bilgiler2[i][k]+bosluk+"|");
			}
			System.out.println();
			System.out.println("________________________________________________________");
		}

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
    void initialize() throws FileNotFoundException {
    	fileReader = new FileReader("D:\\ogrbilgileri3.txt");
        kokMain.toFront();
        kayit=FXCollections.observableArrayList();
        tbl_ad.setCellValueFactory(new PropertyValueFactory<>("adi"));
        tbl_soyad.setCellValueFactory(new PropertyValueFactory<>("soyad"));
        tbl_bp.setCellValueFactory(new PropertyValueFactory<>("b_p"));
        tbl_final.setCellValueFactory(new PropertyValueFactory<>("final"));
        tbl_hn.setCellValueFactory(new PropertyValueFactory<>("h_n"));
        tbl_vize.setCellValueFactory(new PropertyValueFactory<>("vize"));
        tbl_no.setCellValueFactory(new PropertyValueFactory<>("numara"));
        kok_kayit_geri.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				kokMain.toFront();
				
			}
		});
    }
}
