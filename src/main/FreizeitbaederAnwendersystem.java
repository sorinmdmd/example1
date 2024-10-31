package main;

import gui.FreizeitbaederControl;
import javafx.application.Application;
import javafx.stage.Stage;

public class FreizeitbaederAnwendersystem extends Application{

	@Override
	public void start(Stage stage) {
		// TODO Auto-generated method stub
		new FreizeitbaederControl(stage);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}

}
