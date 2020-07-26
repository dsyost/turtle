package yost.drew.turtle;

import java.awt.Color;

public class Turtle {

	private int x, y;
	private boolean penDown = true;
	private Panel panel;
	private Color color = Color.black;
	
	
	public Turtle(Panel p) {
		x = p.getWidth()/2;
		y = p.getHeight()/2;
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
	
	public void moveTo(int nx, int ny) {
		if(penDown) {
			panel.addLine(new Line(x,y,nx,ny,color));
		}
		x = nx;
		y = ny;
	}

	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}

	public void forgetPath() {
		panel.addClear();
	}
}
