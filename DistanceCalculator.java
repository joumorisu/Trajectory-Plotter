import javax.swing.JOptionPane;

public class DistanceCalculator {

	public static void main(String[] args) {

		String input = JOptionPane.showInputDialog("Please enter an initial velocity (meters per second):");
		double c = Double.parseDouble(input);
		input = JOptionPane.showInputDialog("Please enter the angle at which the ball is thrown (0 to 90 degrees):");
		double angle = Double.parseDouble(input);
		if (angle > 90) {
			JOptionPane.showMessageDialog(null, "This angle is invalid for range (0-90) degrees. Now exiting program.");
			System.exit(1);
		}
		input = JOptionPane.showInputDialog("Please enter a starting height (meters):");
		double b = Double.parseDouble(input);
		
		double a = (.5*-9.8);
		double time = Roots(a,b,c);
		
		double vX = (c*Math.cos(Math.toRadians(angle)));
		
		double totalDistance = (vX * time);
		
		JOptionPane.showMessageDialog(null,"The total distance traveled by the ball is: " + totalDistance + " meters.");
		

	}
	
	public static double Roots(double a, double b, double c) {
		double disc = ((b*b) - 4*a*c); 
		double flightTime = 0;
		//If no real roots, end program. Else, calculate and display roots.
		if (disc < 0) {
			JOptionPane.showMessageDialog(null, "This equation does not have real roots. Now exiting program.");
			System.exit(1);
		} else {
		
			double r1 = ((-b + Math.sqrt(disc))/(2.0*a));
			double r2 = ((-b - Math.sqrt(disc))/(2.0*a));
			
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
			return flightTime;
		}
		return flightTime;
	}

}
