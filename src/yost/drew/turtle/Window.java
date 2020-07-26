package yost.drew.turtle;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;


public class Window extends JFrame {
	
	private Turtle turtle;
	private int height = 599;
	private int width = 815;
	private Thread runThread;
	
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
				if(runThread.isAlive()) {
					p.stop();
				}
				p.reset();
			}
		});
		this.add(reset);
		JButton step = new JButton("Step");
		step.setBounds(200,500,200,60);
		step.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				p.step();
			}
		});
		this.add(step);
		JButton run = new JButton("Run");
		run.setBounds(400,500,200,60);
		run.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				runThread = new Thread(p);
				runThread.start();
			}
		});
		this.add(run);
		JSlider speed = new JSlider(100,1000,100);
		speed.setBounds(605,500,200,60);
		speed.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				p.changeDelay(((JSlider) e.getSource()).getValue());
			}
		});
		this.add(speed);
		this.setLayout(null);
		this.setVisible(true);
	}
	
	public Turtle getTurtle() {
		return turtle;
	}
}
