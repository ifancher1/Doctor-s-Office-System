package application;
import java.util.ArrayList;

public class Patient {
	
	private String first, last, dob;
	public ArrayList<Vitals> pVitals = new ArrayList();
	public ArrayList<Allergies> pAllergies = new ArrayList();
	
	public Patient() {
		
	}
	
	public Patient(String f, String l, String bd) {
		first = f;
		last = l;
		dob = bd;
	}
	
	public String getFirst() {
		return first;
	}
	
	public String getLast() {
		return last;
	}
	
	public String getDOB() {
		return dob;
	}
	
	public void addVitals(Vitals v) {
		pVitals.add(v);
	}
	
	public void addAllergies(Allergies a) {
		pAllergies.add(a);
	}
	
 
}
