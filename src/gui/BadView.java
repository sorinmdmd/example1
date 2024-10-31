package gui;

import java.io.IOException;

import business.FReizeitbaederModel;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class BadView {

	private FReizeitbaederModel model;
	private FreizeitbaederControl control;
	private BorderPane pane = new BorderPane(); // trebuie de initiat
	
	private MenuBar mnbrMenuLeiste = new MenuBar();
	private Menu mnDatei = new Menu("Datei");
	private MenuItem item1 = new MenuItem("csv-export");
	private MenuItem item2 = new MenuItem("txt-export");
	
	private TextArea anzeigeText = new TextArea();
	private Button anzeigeButton = new Button("Anzeige");
	private VBox labelsInput = new VBox();

	private Label labelName = new Label("Name");
	private TextField inputName = new TextField();

	private Label labelNachname = new Label("Nachname");
	private TextField inputNachname = new TextField();

	private Label labelOpenAt = new Label("Geoffnet von");
	private TextField inputOpenAt = new TextField();

	private Label labelOpenUntil = new Label("Geoffnet bis");
	private TextField inputOpenUntil = new TextField();

	private Label labelTemperatur = new Label("Temperatur");
	private TextField inputTemperatur = new TextField();

	private Button submitButton = new Button("Submit");

	private HBox row1;
	private HBox row2;
	private HBox row3;
	private HBox row4;
	private HBox row5;

	// Elemente
	VBox vbox1 = new VBox();
	VBox vbox2 = new VBox();
	Text eingabe = new Text("Eingabe");
	Text anzeige = new Text("Anzeige");

	public BadView(FReizeitbaederModel model, FreizeitbaederControl control, Stage stage) {
		this.control = control;
		this.model = model;

		// Menu
		this.mnbrMenuLeiste.getMenus().add(mnDatei);
		this.mnDatei.getItems().add(item1);
		this.mnDatei.getItems().add(item2);
		this.mnbrMenuLeiste.setMaxWidth(70);

		// Labels and Input

		// Hbox for labels and input
		row1 = new HBox(labelName, inputName);
		row1.setSpacing(50);
		row2 = new HBox(labelNachname, inputNachname);
		row2.setSpacing(24);
		row3 = new HBox(labelOpenAt, inputOpenAt);
		row3.setSpacing(14);
		row4 = new HBox(labelOpenUntil, inputOpenUntil);
		row4.setSpacing(18);
		row5 = new HBox(labelTemperatur, inputTemperatur);
		row5.setSpacing(22);
		labelsInput.getChildren().addAll(row1, row2, row3, row4, row5, submitButton);
		labelsInput.setSpacing(10);

		// Vbox1
		vbox1.setAlignment(Pos.CENTER);
		vbox1.setSpacing(10);
		vbox1.setPadding(new Insets(10, 10, 10, 10));
		vbox1.getChildren().addAll(eingabe, labelsInput);
		eingabe.setStyle("-fx-font-size: 30px;");

		// VBox2
		vbox2.getChildren().addAll(anzeige, anzeigeText, anzeigeButton);
		vbox2.setAlignment(Pos.CENTER);
		vbox2.setSpacing(10);
		vbox2.setPadding(new Insets(10, 10, 10, 10));
		anzeige.setStyle("-fx-font-size: 30px;");
		anzeigeText.setMaxHeight(200);
		anzeigeText.setMaxWidth(200);

		pane.setTop(mnbrMenuLeiste);
		pane.setLeft(vbox1);
		pane.setRight(vbox2);
		Scene scene = new Scene(this.pane, 560, 340);
		stage.setScene(scene);
		stage.show();
		initListener();
	}

	private void schreibeFreizeitbaederInDatei(String typ) throws IOException {
		
		control.schreibeFreizeitbaederInDatei(typ);
	}

	public static void zeigeFehlermeldungAn(String meldung) {
		// TODO Auto-generated method stub
		Stage stage = new Stage();
		stage.setTitle(meldung);
		BorderPane pane = new BorderPane();
		Scene scene = new Scene(pane, 400, 400);
		stage.setScene(scene);
		stage.show();

	}

	void initListener() {
		submitButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				// TODO Auto-generated method stub
				try {
					control.recordPool(inputName.getText(), inputOpenAt.getText(), inputOpenUntil.getText(),
							inputTemperatur.getText());
					zeigeInformationsfensterAn("Gespeichert");
				} catch (Exception e) {
					// TODO Auto-generated catch block
					zeigeFehlermeldungAn("Fehler beim Submit");
					e.printStackTrace();
				}
			}
		});
		
		anzeigeButton.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				anzeigeText.setText(model.getFreizeitbad().gibFreizeitbadZurueck(';'));
			}
		});

		item1.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				try {
					schreibeFreizeitbaederInDatei("csv");
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		item2.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				try {
					schreibeFreizeitbaederInDatei("txt");
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
	}
	
	public static void zeigeInformationsfensterAn(String meldung) {
		
		Stage stage = new Stage();
		stage.setTitle(meldung);
		BorderPane pane = new BorderPane();
		Scene scene = new Scene(pane, 400, 400);
		stage.setScene(scene);
		stage.show();
	}

}
