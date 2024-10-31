package business;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class FReizeitbaederModel {
	
	private Feizeitbad freizeitbad;

	public FReizeitbaederModel() {
		// TODO Auto-generated constructor stub
	}

	public void schreibeFreizeitbaederInCsvDatei() throws IOException // Werfen einer IOException
	{
		BufferedWriter aus = new BufferedWriter(new FileWriter("Freizeitbaeder.csv", true));
		aus.write(this.getFreizeitbad().gibFreizeitbadZurueck(';'));
		aus.newLine();
		aus.close();
	}

	public Feizeitbad getFreizeitbad() {
		return freizeitbad;
	}

	public void setFreizeitbad(Feizeitbad freizeitbad) {
		this.freizeitbad = freizeitbad;
	}
}
