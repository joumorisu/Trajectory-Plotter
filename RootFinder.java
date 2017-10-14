import javax.swing.JOptionPane;

public class RootFinder {

	public static void main(String[] args) {
	
	//Get coefficients	
	String input = JOptionPane.showInputDialog("For the equation, ax^2+bx+c, enter the coefficient \"a\":");
	double a = Double.parseDouble(input);
	input = JOptionPane.showInputDialog("For the equation, ax^2+bx+c, enter the coefficient \"b\":");
	double b = Double.parseDouble(input);
	input = JOptionPane.showInputDialog("For the equation, ax^2+bx+c, enter the coefficient \"c\":");
	double c = Double.parseDouble(input);
	
	//Calculate discriminant
	double disc = ((b*b) - 4*a*c); 
	
	//If no real roots, end program. Else, calculate and display roots.
	if (disc < 0) {
		JOptionPane.showMessageDialog(null, "This equation does not have real roots. Now exiting program.");
		System.exit(1);
	} else {
	
	double r1 = ((-b + Math.sqrt(disc))/(2.0*a));
	double r2 = ((-b - Math.sqrt(disc))/(2.0*a));
	
	JOptionPane.showMessageDialog(null, "The roots are: (" + r1 + ", " + r2 + ")");
		}
		
	}//Main method close-bracket

}//Class close-bracket
