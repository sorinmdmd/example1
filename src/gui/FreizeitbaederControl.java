package gui;

import java.io.IOException;

import business.FReizeitbaederModel;
import business.Feizeitbad;
import javafx.stage.Stage;

public class FreizeitbaederControl {

	private BadView view;
	private FReizeitbaederModel model;

	public FreizeitbaederControl(Stage stage) {
		this.model = new FReizeitbaederModel();
		this.view = new BadView(model, this, stage);
	}

	void schreibeFreizeitbaederInDatei(String typ) throws IOException {
		try {
			if ("csv".equals(typ)) { 
				
				model.schreibeFreizeitbaederInCsvDatei();
				// Aufruf des Models zum Schreiben des // Freizeitbads in die Datei des
										// vorgegebenen // Typs und Ausgabe der Meldung
			} else {
				BadView.zeigeInformationsfensterAn("Noch nicht implementiert!");
			}
		} catch (Exception exc) {
			BadView.zeigeFehlermeldungAn("Unbekannter Fehler beim Speichern!");
		}
	}

	public void recordPool(String name, String openAt, String openUntil, String temperatur) {
		model.setFreizeitbad(new Feizeitbad(name, openAt, openUntil, temperatur));
	}
}
