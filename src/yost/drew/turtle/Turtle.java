package yost.drew.turtle;

import java.awt.Color;

public class Turtle {

	private int x, y;
	private boolean penDown = true;
	private Panel panel;
	private Color color = Color.black;
	
	
	public Turtle(Panel p) {
		x = 300;
		y = 200;
		panel = p;
	}

	public void setColor(Color c) {
		color = c;
	}
	
	public void turtleDown(boolean b) {
		penDown = b;
	}
	
	public boolean isTurtleDown() {
		return penDown;
	}
	
	public void forgetPath() {
		panel.clear();
	}
	
	public void moveTo(int nx, int ny) {
		if(penDown) {
			panel.addLine(new Line(x,y,nx,ny,color));
			panel.repaint();
		}
		x = nx;
		y = ny;
	}
}
