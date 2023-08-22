package application;

public class Allergies {
	private String allergies;
	
	public Allergies() {
		
	}
	
	public Allergies(String s) {
		allergies = s;
	}
	
	public void addInfo(String s) {
		allergies = s;
	}
	
	public String getInfo() {
		return allergies;
	}
}
