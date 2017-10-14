import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.geom.QuadCurve2D;
import java.text.DecimalFormat;

@SuppressWarnings("serial")
public class TrajectoryPlotter extends JPanel  {
	
	public static double b = 0, angle = 0, c = 0, totalDistance = 0, time = 0;
	public class Computations extends JPanel {
		
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			Graphics2D g2 = (Graphics2D) g;
		    
			//Basic computations...
			
			double vX = (c*Math.cos(Math.toRadians(angle)));
			totalDistance = (vX * time);
		
			//Output information to the Computations Panel...
			g2.setColor(Color.red);
			g2.drawString("Calculate total flight time of ball",10, 40);
			g2.drawString("using formula:", 10, 50);
			g2.setColor(Color.black);
			g2.drawString("U(t) = (1/2)at^2 + vt + u",38, 70);
			g2.setColor(Color.red);
			g2.drawString("Plug in available data...", 10, 90);
			g2.setColor(Color.black);
			g2.drawString("U(t) = (1/2)(-9.8)t^2 + " + c + "t + " + b, 10, 110); 
			g2.drawString("U(t) = -4.9t^2 + " + c + "t + " + b, 10, 125);
			g2.setColor(Color.red);
			g2.drawString("Set formula equal to zero...", 10, 145);
			g2.setColor(Color.black);
			g2.drawString("0 = -4.9t^2 + " + c + "t + " + b, 10, 165);
			g2.setColor(Color.red);
			g2.drawString("Find flight time using", 10,185);
			g2.drawString("Quadratic Formula, positive root...",10,195);
			g2.setColor(Color.black);
			DecimalFormat ft = new DecimalFormat("###,###,#00.0000");
			g2.drawString("Flight time = ~" + ft.format(time) + " seconds.", 10, 215);
			g2.setColor(Color.red);
			g2.drawString("Calculate horizontal velocity...", 10, 235);
			g2.setColor(Color.black);
			g2.drawString("V(x) = v*cos(angle)", 10, 255);
			g2.setColor(Color.red);
			g2.drawString("Plug in available data...", 10, 275);
			g2.setColor(Color.black);
			g2.drawString("V(x) =" + c + "*cos(" + angle + ")", 10,295);
			DecimalFormat hv = new DecimalFormat("###,#00.0000");
			g2.drawString("V(x) = ~" + hv.format(vX), 10, 310);
			g2.setColor(Color.red);
			g2.drawString("Calculate total distance traveled", 10, 330);
			g2.drawString("using D(x) = time * velocity...  ", 10, 340);
			g2.setColor(Color.black);
			g2.drawString("D(x) = ~" + ft.format(time) + " * ~" + hv.format(vX), 10, 360);
			g2.drawString("D(x) = " + hv.format(totalDistance) + " meter(s)." , 10, 375); 
			
			
			
			
		
			
			
	     }
		
		
	}
    public double s = 0;
    public double ang = 0;
	public TrajectoryPlotter(double sh, double angle) {
		s = sh;
		ang = angle;
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		
		//Create axes...
		g2.setStroke(new BasicStroke(5));
		g2.drawLine(20, 445, 20, 10);
		g2.drawLine(20, 445, 470, 445);
		
		//Draw axis arrow-ends and label axes...
		Polygon triangle = new Polygon();
		triangle.addPoint(10, 10);
		triangle.addPoint(30, 10);
		triangle.addPoint(20, 0);
		g2.fillPolygon(triangle);
		g2.drawString("Y", 30,30);
		
		Polygon triangle2 = new Polygon();
		triangle2.addPoint(470, 435);
		triangle2.addPoint(470, 455);
		triangle2.addPoint(480, 445);
		g2.fillPolygon(triangle2);
		g2.drawString("X", 460 ,435);
		g2.setStroke(new BasicStroke());
			
		if (ang == 90 && s == 0) {
			g2.setStroke(new BasicStroke(4.0f, BasicStroke.CAP_SQUARE, BasicStroke.JOIN_MITER, 10.0f, new float[] {16.0f, 20.0f}, 0.0f ));
			g2.setColor(Color.white);
			g2.drawLine(20,445, 20, 218);
			g2.setColor(Color.red);
			g2.fillOval(20 - 10, 218 - 10, 20, 20);
			DecimalFormat ft = new DecimalFormat("###,#00.0000");
			g2.drawString("Flight time = ~" + ft.format(time) + " second(s)." , 30, 218);
			g2.setColor(Color.blue);
			g2.fillOval(20 - 10, 445 - 10, 20, 20);
			g2.drawString("Starting height = " + b + " meter(s)", 30, 435);
		
			
		}
	    
		else if (ang == 0 && s == 0) {
			g2.setStroke(new BasicStroke(4.0f, BasicStroke.CAP_SQUARE, BasicStroke.JOIN_MITER, 10.0f, new float[] {16.0f, 20.0f}, 0.0f ));
			g2.setColor(Color.white);
			g2.drawLine(20,445, 338, 445);
			g2.setColor(Color.red);
			g2.fillOval(338 - 10, 445 - 10, 20, 20);
			DecimalFormat ft = new DecimalFormat("###,#00.0000");
			g2.drawString("Flight time = ~" + ft.format(time) + " second(s)." ,348, 415);
			g2.setColor(Color.blue);
			g2.fillOval(20 - 10, 445 - 10, 20, 20);
			g2.drawString("Starting height = " + b + " meter(s)", 30, 435);
		
			
		}
	    
		
		else if (s == 0) {
			    
			    //If starting height is zero... Use an arc as the plot!
				g2.setStroke(new BasicStroke(4.0f, BasicStroke.CAP_SQUARE, BasicStroke.JOIN_MITER, 10.0f, new float[] {16.0f, 20.0f}, 0.0f ));
				g2.setColor(Color.black);
				g2.translate(0,-160);
				g2.drawArc(20, 445, 318, 318, 0, 180);
				g2.translate(0,160);	
				g2.setColor(Color.red);
				g2.fillOval(338 - 10, 445 - 10, 20, 20);
				DecimalFormat ft = new DecimalFormat("###,#00.0000");
				g2.drawString("Flight time = ~" + ft.format(time) + " second(s)." , 348, 415);
				g2.setColor(Color.blue);
				g2.fillOval(20 - 10, 445 - 10, 20, 20);
				g2.drawString("Starting height = " + b + " meter(s)", 30, 435);
				
		} else {
			
			//If starting height isn't 0... Make a Quadratic curve for the plot!
			g2.setStroke(new BasicStroke(4.0f, BasicStroke.CAP_SQUARE, BasicStroke.JOIN_MITER, 10.0f, new float[] {16.0f, 20.0f}, 0.0f ));
			g2.setColor(Color.black);
			QuadCurve2D graph = new QuadCurve2D.Float();
			graph.setCurve(20,218, 159, 50, 338, 445);
			g2.draw(graph);
			g2.setColor(Color.red);
			g2.fillOval(338 - 10, 445 - 10, 20, 20);
			DecimalFormat ft = new DecimalFormat("###,#00.0000");
			g2.drawString("Flight time = ~" + ft.format(time) + " second(s)." , 348, 415);
			g2.setColor(Color.blue);
			g2.fillOval(20 - 10, 218 - 10, 20, 20);
			g2.drawString("Starting height = " + b + " meters", 35, 230);
		}
		
		g2.setStroke(new BasicStroke());
		
		
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
			
			//Return only the positive root...
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

	
	public static void main(String[] args) {

		//Set up JFrame and add an instance of TrajectoryPlotter to it
		JFrame application = new JFrame();
		application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		application.setSize(800,500);
		application.setVisible(true);
		
		//Get input from the user
		String input = JOptionPane.showInputDialog("Please enter an initial velocity (meters per second):");
		c = Double.parseDouble(input);
		input = JOptionPane.showInputDialog("Please enter the angle at which the ball is thrown (0 to 90 degrees):");
		angle = Double.parseDouble(input);
		if (angle > 90) {
			JOptionPane.showMessageDialog(null, "This angle is invalid for range (0-90) degrees. Now exiting program.");
			System.exit(1);
		}
		input = JOptionPane.showInputDialog("Please enter a starting height (meters):");
		b = Double.parseDouble(input);
		double a = (.5*-9.8);
		time = Roots(a,b,c);
		
		//Instantiate new TrajectoryPlotter and add to JFrame
		TrajectoryPlotter plot = new TrajectoryPlotter(b, angle);
		plot.setLayout(new BorderLayout());
		application.add(plot);
		
		//Instantiate new Computations Panel and add to the TrajectoryPlotter panel.
		Computations plot2 = plot.new Computations();
		Border line = BorderFactory.createLineBorder(Color.black);
		TitledBorder border;
		border = BorderFactory.createTitledBorder(line, "Computations");
	    border.setTitleJustification(TitledBorder.CENTER);
	    plot2.setBorder(border);
	    plot2.setPreferredSize(new Dimension(200,500));
	    plot.add(plot2, BorderLayout.EAST);
	    
	    //Force redraw of application
	    application.validate();
       
	}

}
