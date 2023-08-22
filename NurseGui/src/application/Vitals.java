package application;
import java.util.ArrayList;

public class Vitals {
	private double height, weight, bloodP, bodyTemp;
	private String comments;
	
	public Vitals() {
	}
	
	public Vitals(double h, double w, double bp, double bt, String c) {
		height = h;
		weight = w;
		bloodP = bp;
		bodyTemp = bt;
		comments = c;
	}
	
	public double getHeight() {
		return height;
	}
	
	public double getWeight() {
		return weight;
	}
	
	public double getPressure() {
		return bloodP;
	}
	
	public double getTemp() {
		return bodyTemp;
	}
	
	public String getComments() {
		return comments;
	}
	
}
