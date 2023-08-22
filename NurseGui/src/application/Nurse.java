package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.Parent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.AnchorPane;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.fxml.FXMLLoader;
import java.net.URL;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import java.util.ArrayList;
import java.util.List;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.File;
import java.net.URL;
import java.util.Scanner;

public class Nurse extends Application {
	
	static AnchorPane root;
	static List<AnchorPane> panes = new ArrayList<AnchorPane>();
	private static int index = 0;
	private static int pInd;//index of current patient
	public static ArrayList<Patient> patients = new ArrayList<Patient>();//list of patients in the system
	
	
	@Override	
	public void start(Stage stage) throws Exception{
		
		File f = new File("Database.txt");
		Scanner sc = new Scanner(f);
		
		while(sc.hasNextLine()) {
			String line = sc.nextLine();
			String[] info = line.split(",");
			String first = info[0];
			String last = info[1];
			String dob = info[2];
			Patient temp = new Patient(first, last, dob);
			patients.add(temp);
		}
		
		//for(int i=0; i<patients.size(); i++) {
		//	System.out.println(patients.get(i).getFirst());
		//}
		
		root = FXMLLoader.load(getClass().getResource("MainPane.fxml"));
		
		panes.add((AnchorPane)FXMLLoader.load(getClass().getResource("home2.fxml")));
		panes.add((AnchorPane)FXMLLoader.load(getClass().getResource("patientInfo2.fxml")));
		panes.add((AnchorPane)FXMLLoader.load(getClass().getResource("patientVitals2.fxml")));
		panes.add((AnchorPane)FXMLLoader.load(getClass().getResource("allergyInfo.fxml")));
		panes.add((AnchorPane)FXMLLoader.load(getClass().getResource("mRecords.fxml")));
		
		root.getChildren().add(panes.get(0));
		Scene scene = new Scene(root);
		
		String css = Nurse.class.getResource("application.css").toExternalForm();
		scene.getStylesheets().add(css);
		stage.setTitle("Nurse");
		stage.setScene(scene);
		stage.show();
	}
	
	public static boolean findPatient(String fname,String lname,String date) {//this method goes through the list of patients and returns true if the patient exists in the list
		
		boolean exists = false;
		
		for (int i=0; i<patients.size(); i++) {
			if(patients.get(i).getFirst().equals(fname) && patients.get(i).getLast().equals(lname) && patients.get(i).getDOB().equals(date)) {
				pInd = i;
				exists = true;
			}
		}
		
		return exists;
	}
	public static String getPatientName() {
		return patients.get(pInd).getFirst();
	}
	
	public static Patient getPatient() {
		return patients.get(pInd);
	}
	
	public static void addVitalsToPatient(Vitals v) {//this will add vitals info to the patient
		patients.get(pInd).addVitals(v);
	}
	
	public static void addAllergyInfo(Allergies a) {//add allergy info to the patient
		patients.get(pInd).addAllergies(a);
	}
	
	public static AnchorPane getPane(int ind) {
		return panes.get(ind);
	}
	
	public static void set_pane(int ind) {//switches the current screen
		root.getChildren().remove(panes.get(index));
		root.getChildren().add(panes.get(ind));
		index = ind;
	}
	
	public static void save() throws Exception{
		String filename = "PatientData.txt";
		BufferedWriter bw = new BufferedWriter(new FileWriter(filename));
		for(int i=0; i<patients.size(); i++) {
			bw.write(patients.get(i).getFirst() + ',' + patients.get(i).getLast() + ',' + patients.get(i).getDOB() + '\n');
		}
		bw.close();
	}
	
	public static void main(String[] args) throws Exception{
		launch(args);
	}
}
