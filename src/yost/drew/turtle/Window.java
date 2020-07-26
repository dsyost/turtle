package yost.drew.turtle;

import java.awt.Color;
import javax.swing.JFrame;


public class Window extends JFrame {
	
	private Turtle turtle;
	private int height = 600;
	private int width = 800;
	
	public Window(Color color) {
		this.setSize(width, height);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Panel p = new Panel(width, height, color);
		turtle = new Turtle(p);
		this.add(p);
		this.setVisible(true);
	}
	
	public Turtle getTurtle() {
		return turtle;
	}
	
	protected void setTurtle(Turtle t) {
		turtle = t;
	}
}
