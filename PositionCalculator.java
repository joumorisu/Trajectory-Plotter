import javax.swing.JOptionPane;

public class PositionCalculator {

	public static void main(String[] args) {
		
		//Get input from the user
		String input = JOptionPane.showInputDialog("Please input an acceleration rate (meters per seconds squared):");
		double a = Double.parseDouble(input);
		input = JOptionPane.showInputDialog("Please input a starting velocity (meters per second): ");
		double v = Double.parseDouble(input);
		input = JOptionPane.showInputDialog("Please input a starting position:");
		double u = Double.parseDouble(input);
		input = JOptionPane.showInputDialog("Please input an amount of time that passes (seconds):");
		double t = Double.parseDouble(input);
		
		//Calculate position
		double position = (.5*a)*(t*t) + (v*t) + u;
		
		//Show output
		JOptionPane.showMessageDialog(null, "When:  \nAcceleration = " + a + "\nStarting velocity = " + v + "\nStarting position = " + u + "\nTime passed = " + t + "\n The position of the ball = " + position);
		
	}//Main method close-bracket

}//Class close-bracket
