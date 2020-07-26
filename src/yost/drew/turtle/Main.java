package yost.drew.turtle;

import java.awt.Color;
import java.util.Random;

public class Main {
	
	public static void makeShape(Turtle t, int lines) {
		int x = 300;
		int y = 200;
		int r = 150;
		double tau = 2*Math.PI;
		t.turtleDown(false);
		t.moveTo((int)(x+Math.sin(0)*r),(int)(y+Math.cos(0)*r));
		t.turtleDown(true);
		for(double i=0;i<=tau+.01;i+=tau/lines) {
			int nx = (int)(x+Math.sin(i)*r);
			int ny = (int)(y+Math.cos(i)*r);
			t.moveTo(nx, ny);
		}
	}
	
	public static void main(String args[]) throws InterruptedException {
		Random rand = new Random();
		Window w = new Window(Color.white);
		Turtle t = w.getTurtle();
		for(int i=3;i<=30;i++) {
			System.out.println(i);
			t.setColor(new Color(rand.nextInt(255), rand.nextInt(255), rand.nextInt(255)));
			t.forgetPath();
			makeShape(t, i);
			Thread.sleep(500);
		}
	}
}
