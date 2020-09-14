package application;

import java.io.File;
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
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
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
    private PieChart piachart;
    
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
    private Button kok_raporlama_geri;
    
    @FXML
    private Button kok_raporlama_kpt;
    
    @FXML
    private Label kok_cikti_durum;

    @FXML
    private Button kok_cikti_geri;

    @FXML
    private Button kok_cikti_kpt;

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
    void cikti(ActionEvent event) throws IOException {
    	kokCikti.toFront();
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
		String durumS="";
		boolean karar=true;
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 7; j++) {
				count = 0;	
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
//						not=c+"";
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
				count = 0;
				counter++;
			}
			karar=true;
			satir++;
			counter=0;
		}
		String genelKayitlar="";
		for (int i = 0; i < 10; i++) {
			for (int k = 0; k < 5; k++) {
				if (bilgiler2[i][k].equals("")) {
					i=9;
					break;
				}
				int graf=16;
				
				genelKayitlar+=bilgiler2[i][k];
				genelKayitlar+=" ";
				String grafik="=";
				if (sayac%7==6) {
					int aa=10;
					if (bilgiler2[i][4].equals("A")) {
						for (int l = 0; l < graf; l++) {
							grafik+="=";
						}
					}
					if (bilgiler2[i][4].equals("B")) {
						for (int l = 0; l < graf/2; l++) {
							grafik+="=";
						}
					}
					if (bilgiler2[i][4].equals("C")) {
						for (int l = 0; l < graf/4; l++) {
							grafik+="=";
						}
					}
					if (bilgiler2[i][4].equals("D")) {
						for (int l = 0; l < graf/8; l++) {
							grafik+="=";
						}
					}
					genelKayitlar+=grafik;
				}
				sayac++;
			}
			genelKayitlar+=" *";
			
		}
		fileWriter2.write(genelKayitlar);
		fileWriter2.close();
		kok_cikti_durum.setText("Öðrencilere ait grafik verileri "+file.getPath()+" konumuna baþarýlý bir þekilde kaydedildi.");
    	

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
		String durumS="";
		boolean karar=true;
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 7; j++) {
				count = 0;	
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
//						not=c+"";
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
				count = 0;
				counter++;
			}
			karar=true;
			satir++;
			counter=0;
		}

		for (int i = 0; i < 10; i++) {
			for (int k = 0; k < 7; k++) {
				if (bilgiler2[i][k].equals("")) {
					i=9;
					break;
				}
				nesne=new Kayitlar(bilgiler2[i][0], bilgiler2[i][1], bilgiler2[i][2], bilgiler2[i][3], bilgiler2[i][4], bilgiler2[i][5], bilgiler2[i][6]);
				kayit.add(nesne);
				k=6;
			}

		}
		tbl.setItems(kayit);

    }
    

    Kayitlar nesne=new Kayitlar();
    @FXML
    void kayit(ActionEvent event) {
    	kokKayit.toFront();

    }
    ObservableList<PieChart.Data> piechartdata;

    @FXML
    void raporlama(ActionEvent event) throws IOException {
    	kokRapor.toFront();
    	String[][] bilgiler = new String[10][5];
		String[][] bilgiler2 = new String[10][7];
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 5; j++) {
				bilgiler[i][j] = "";
			}
		}
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 7; j++) {
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
		String durumS="";
		boolean karar=true;
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 7; j++) {
				count = 0;	
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
//						not=c+"";
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
				count = 0;
				counter++;
			}
			karar=true;
			satir++;
			counter=0;
		}
		int toplamNot=0;
		int kisisayisi=0;
		counter=0;
		for (int i = 0; i < 10; i++) {
			for (int k = 0; k <7; k++) {
				if (bilgiler2[i][k].equals("")){
					k=6;
					kisisayisi--;	
					break;
				}
				if (counter%7==5) {
					int not=Integer.valueOf(bilgiler2[i][k]);
					toplamNot+=not;
				}
				counter++;
			}
			counter=0;
			kisisayisi++;
		}
		counter=0;
		String ad_soyad="";
		int AnlikBasariPuani=0;
		PieChart.Data nesneData;
		for (int i = 0; i < 10; i++) {
			for (int k = 0; k <7; k++) {
				if (bilgiler2[i][k].equals("")){
					k=6;
					break;
				}
				if (counter%7==0 || counter%7==1) {
					ad_soyad+=bilgiler2[i][k];
					ad_soyad+=" ";
				}
				if (counter%7==5){
					AnlikBasariPuani=Integer.valueOf(bilgiler2[i][k]);
					double sonuc=(double)100*AnlikBasariPuani/toplamNot;
					System.out.println(sonuc);
					System.out.println(ad_soyad);
					nesneData=new PieChart.Data(ad_soyad,sonuc);
					piechartdata.add(nesneData);
				}
				counter++;
			}
			ad_soyad="";
			counter=0;
		}
    	piachart.setData(piechartdata);
    }

    File file;
    FileWriter fileWriter;
    PrintWriter fileWriter2;
    @FXML
    void initialize() throws IOException {
    	fileReader = new FileReader("D:\\ogrbilgileri3.txt");
		file=new File("D:\\ogrencibilgivegraf.txt");
		fileWriter=new FileWriter(file);
		fileWriter2=new PrintWriter(fileWriter);
    	
        kokMain.toFront();
        kayit=FXCollections.observableArrayList();
        piechartdata=FXCollections.observableArrayList();
        tbl_ad.setCellValueFactory(new PropertyValueFactory<>("ad"));
        tbl_soyad.setCellValueFactory(new PropertyValueFactory<>("soyad"));
        tbl_bp.setCellValueFactory(new PropertyValueFactory<>("b_n"));
        tbl_final.setCellValueFactory(new PropertyValueFactory<>("finall"));
        tbl_hn.setCellValueFactory(new PropertyValueFactory<>("h_n"));
        tbl_vize.setCellValueFactory(new PropertyValueFactory<>("vize"));
        tbl_no.setCellValueFactory(new PropertyValueFactory<>("numara"));
        kok_kayit_geri.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				kokMain.toFront();
				
			}
		});
        kok_hesaplama_geri.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				kokMain.toFront();
				
			}
		});
        kok_raporlama_geri.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				kokMain.toFront();
				
			}
		});
        kok_cikti_geri.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				kokMain.toFront();
				
			}
		});
    }
}
