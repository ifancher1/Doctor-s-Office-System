package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.TextField;

public class pInfoCont implements Initializable{
	
	@FXML private TextField firstName;
	@FXML private TextField lastName;
	@FXML private TextField dob;
	
	private int no = 0;
	private AnchorPane notFound;
	private String pFirst, pLast, pDOB;
	
	public void toVitals() throws Exception{
		
		pFirst = firstName.getText();
		pLast = lastName.getText();
		pDOB = dob.getText();
		
		if (Nurse.findPatient(pFirst, pLast, pDOB)) {
			Nurse.set_pane(2);
		}
		
		else {
			Stage nfStage = new Stage();
			notFound = FXMLLoader.load(getClass().getResource("notFound.fxml"));
			
			Scene sceneNF = new Scene(notFound);
			
			String css = Nurse.class.getResource("application.css").toExternalForm();
			sceneNF.getStylesheets().add(css);
			nfStage.setScene(sceneNF);
			nfStage.show();
		}
	}
	
	@Override
	public void initialize(URL url, ResourceBundle rb) {
	
	}
		

}
