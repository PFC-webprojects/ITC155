/*	DrawFigure.java
 *  ITC 155, Seattle Central Caollege, Spring 2018
 *  Peter Caliandro
 *  Assignment 01
 */


import java.awt.*;

public class DrawFigure {

/*	Paint two circles, a square, and a line in a DrawingPanel.
 *  Note that the DrawingPanel class is provided in the DrawingPanel.java module.
 */
	public static void main(String[] args) {
		DrawingPanel canvas = new DrawingPanel(220, 150);  //  Note that creating a DrawingPanel automatically displays it.
		canvas.setBackground(Color.YELLOW);
		Graphics brush = canvas.getGraphics();
		
		//  Paint two circles. 
		brush.setColor(Color.BLUE);
		brush.fillOval(50, 25, 40, 40);
		brush.fillOval(130, 25, 40, 40);
		
		//  Paint a square.
		brush.setColor(Color.RED);
		brush.fillRect(70, 45, 80, 80);
		
		//  Paint a line.
		brush.setColor(Color.BLACK);
		brush.drawLine(70, 85, 150, 85);
	}
}
