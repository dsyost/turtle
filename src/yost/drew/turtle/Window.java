package yost.drew.turtle;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;


public class Window extends JFrame {
	
	private Turtle turtle;
	private int height = 600;
	private int width = 800;
	
	public Window(Color color) {
		this.setSize(width, height);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Panel p = new Panel(width, height, color);
		p.setBounds(0,0,800,500);
		turtle = new Turtle(p);
		this.add(p);
		JButton reset = new JButton("Reset");
		reset.setBounds(0,500,200,60);
		reset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				p.reset();
			}
		});
		this.add(reset);
		JButton step = new JButton("Step");
		step.setBounds(300,500,200,60);
		step.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				p.step();
			}
		});
		this.add(step);
		JButton run = new JButton("Run");
		run.setBounds(600,500,200,60);
		run.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				p.run();
			}
		});
		this.add(run);
		this.setLayout(null);
		this.setVisible(true);
	}
	
	public Turtle getTurtle() {
		return turtle;
	}
	
	protected void setTurtle(Turtle t) {
		turtle = t;
	}
}
