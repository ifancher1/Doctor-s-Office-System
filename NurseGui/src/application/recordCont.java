package application;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.control.ListView;

public class recordCont implements Initializable{
	
	@FXML private TextArea records;
	
	public void toAllergies() {
		Nurse.set_pane(3);
	}
	
	public void ViewRecords() {
		Patient temp = Nurse.getPatient();
		String info = "Records for: ";
		info += Nurse.getPatientName();
		for (int i=0; i<temp.pVitals.size(); i++) {
			info += "\n";
			info += "\t";
			info += "Weight: ";
			info += temp.pVitals.get(i).getWeight();
			
			info += "\n";
			info += "\t";
			info += "Height: ";
			info += temp.pVitals.get(i).getHeight();
			
			info += "\n";
			info += "\t";
			info += "Body Temp: ";
			info += temp.pVitals.get(i).getTemp();
			
			info += "\n";
			info += "\t";
			info += "Blood Pressure: ";
			info += temp.pVitals.get(i).getPressure();
			
			info += "\n";
			info += "\t";
			info += "Comments: ";
			info += temp.pVitals.get(i).getComments();
			info += "\n";
		}
		
		info += "\n";
		info += "Allergy Info: ";
		
		for (int i=0; i<temp.pAllergies.size(); i++) {
			info += "\n";
			info += "\t";
			info += temp.pAllergies.get(i).getInfo();
			info += "\n";
		}
		records.setText(info);
	}

	@Override
	public void initialize(URL url, ResourceBundle rb) {
		
	}
	
}
