package yost.drew.turtle;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import javax.swing.JPanel;

public class Panel extends JPanel{
	
	ArrayList<Line> lines;
	
	public Panel(int width, int height, Color color) {
		this.setBackground(color);
		this.setPreferredSize(new Dimension(width,height));
		lines = new ArrayList<>();
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		drawLines(g);
	}
	
	private void drawLines(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.setStroke(new BasicStroke(3));
		for(Line line : lines) {
			g2.setColor(line.color);
			g2.drawLine(line.x1, line.y1, line.x2, line.y2);
		}
	}

	public void addLine(Line line) {
		lines.add(line);
	}

	public void clear() {
		lines.clear();
	}

}
