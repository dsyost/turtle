package yost.drew.turtle;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class Panel extends JPanel{
	
	ArrayList<ArrayList<Line>> path;
	int[] drawTo = {0,0};
	Image turtle;
	
	public Panel(int width, int height, Color color) {
		this.setBackground(color);
		this.setPreferredSize(new Dimension(width,height));
		path = new ArrayList<>();
		path.add(new ArrayList<>());
		try {
			turtle = ImageIO.read(new File("turtle.png"));
		} catch (IOException ex) {
			System.out.println(ex.getMessage());
		}
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		if(drawTo[1] > 0) {
			drawLines(g);
		}
	}
	
	private void drawLines(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.setStroke(new BasicStroke(3));
		for(int i=0;i<drawTo[1];i++) {
			Line line = path.get(drawTo[0]).get(i);
			g2.setColor(line.color);
			g2.drawLine(line.x1, line.y1, line.x2, line.y2);
		}
		Line last = path.get(drawTo[0]).get(drawTo[1]-1);
		g2.drawImage(turtle, last.x2-5, last.y2-7, null);
	}

	public void addLine(Line line) {
		path.get(path.size()-1).add(line);
	}

	public void step() {
		if(drawTo[1] < path.get(drawTo[0]).size()) {
			repaint();
			drawTo[1]++;
		} else if(drawTo[0] < path.size()-1) {
			repaint();
			drawTo[0]++;
			drawTo[1] = 0;
		}
	}
	
	public void addClear() {
		path.add(new ArrayList<>());
	}
	
	//still needs work
	public void run() {
		for(int i=0; i<path.size();i++) {
			drawTo[0]=i;
			drawTo[1]=path.get(i).size();
			repaint();
		}
	}

	public void reset() {
		drawTo[0] = 0;
		drawTo[1] = 0;
		repaint();
	}

}
