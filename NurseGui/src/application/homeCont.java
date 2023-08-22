package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;

public class homeCont implements Initializable{
	
	public void patientInfo() {
		Nurse.set_pane(1);
	}
	
	@Override
	public void initialize(URL url, ResourceBundle rb) {
		
	}

}
