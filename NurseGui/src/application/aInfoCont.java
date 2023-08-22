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
import javafx.scene.control.TextArea;
import javafx.scene.control.ListView;

public class aInfoCont implements Initializable{
	
	private AnchorPane recordsRoot;
	@FXML private TextArea info;
	@FXML private TextArea records;
	
	public void toHome() throws Exception{
		Allergies pA = new Allergies(info.getText());
		Nurse.addAllergyInfo(pA);
		Nurse.save();
		Nurse.set_pane(0);
	}
	
	@Override
	public void initialize(URL url, ResourceBundle rb) {
		
	}
	
	
	@FXML
	public void ViewRecords() throws Exception{
		Nurse.set_pane(4);
		/*Stage recordsStage = new Stage();
		recordsRoot = FXMLLoader.load(getClass().getResource("mRecords.fxml"));
		Scene scene2 = new Scene(recordsRoot);
		
		String css = Nurse.class.getResource("application.css").toExternalForm();
		scene2.getStylesheets().add(css);
		recordsStage.setTitle("Medical Records");
		recordsStage.setScene(scene2);
		recordsStage.show();*/
		
	}
}
