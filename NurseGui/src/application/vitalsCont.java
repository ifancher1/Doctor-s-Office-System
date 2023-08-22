package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.control.TextArea;

public class vitalsCont implements Initializable{
	
	@FXML private TextField weight;
	@FXML private TextField height;
	@FXML private TextField bt;
	@FXML private TextField bp;
	@FXML private TextArea comments;
	
	public void toAllergies() {
		
		double w = Double.parseDouble(weight.getText());
		double h = Double.parseDouble(height.getText());
		double blood = Double.parseDouble(bp.getText());
		double temp = Double.parseDouble(bt.getText());
		String c = comments.getText();
		
		Vitals pv = new Vitals(h, w, blood, temp, c);
		Nurse.addVitalsToPatient(pv);
		Nurse.set_pane(3);
	}
	
	@Override
	public void initialize(URL url, ResourceBundle rb) {
	
	}
}
