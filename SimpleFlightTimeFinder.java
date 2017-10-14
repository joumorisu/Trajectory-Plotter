import javax.swing.JOptionPane;

public class SimpleFlightTimeFinder {

	public static void main(String[] args) {

	double a = (.5*-9.8);	
	String input = JOptionPane.showInputDialog("Please input an initial height (meters):");
	double c = Double.parseDouble(input);
	input = JOptionPane.showInputDialog("Please input an initial velocity (meters per second):");
	double b = Double.parseDouble(input);
	
	Roots(a,b,c);
		
	}
	
	public static void Roots(double a, double b, double c) {
		double disc = ((b*b) - 4*a*c); 
		
		//If no real roots, end program. Else, calculate and display roots.
		if (disc < 0) {
			JOptionPane.showMessageDialog(null, "This equation does not have real roots. Now exiting program.");
			System.exit(1);
		} else {
		
			double r1 = ((-b + Math.sqrt(disc))/(2.0*a));
			double r2 = ((-b - Math.sqrt(disc))/(2.0*a));
			double flightTime;
			if (r1 < 0) {
				flightTime = r2;
			}
			else if (r1 > 0) {
				flightTime = r1;
			}
			else if (r1 == 0 && r2 != 0) {
				flightTime = r2;
			}
			else {
				flightTime = 0;
			}
		
			JOptionPane.showMessageDialog(null, "The flight time is: " + flightTime + " second(s).");
		}
	}
	

}
