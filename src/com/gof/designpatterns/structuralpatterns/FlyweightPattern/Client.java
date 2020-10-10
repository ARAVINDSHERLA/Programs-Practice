package com.gof.designpatterns.structuralpatterns.FlyweightPattern;


/*
 Flyweight is used when there is a need to create high number of objects of almost similar nature. High number of objects consumes high memory and flyweight design pattern gives a solution to reduce the load on memory by sharing objects. It is achieved by segregating object properties into two types intrinsic and extrinsic. In this article lets see about this in detail with a real world example and respective java implementation.

Intent as stated by GoF is, “Use sharing to support large numbers of fine-grained objects efficiently”. Sharing is key in flyweight pattern and we need to judiciously decide if this pattern can be applied.

When to Use Flyweight Design Pattern

We need to consider following factors when choosing flyweight,

Need to create large number of objects.
Because of the large number when memory cost is a constraint.
When most of the object attributes can be made external and shared.
The application must not mandate unique objects, as after implementation same object will be used repeatedly.
Its better when extrinsic state can be computed rather than stored. (explained below)
Flyweight is all about memory and sharing. Nowadays an average desktop comes with 500 GB hard disk, 4GB ram and with this you can stuff your whole home inside and will still have remaining space to put an elephant in it. Do we really need to bother about memory and usage? Since the cost has come down there is no restriction to use it effectively. Think about mobile devices that are increasing everyday and they still have memory constraint.
 */




import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Client extends JFrame {

	private static final int WIDTH = 400;
	private static final int HEIGHT = 400;

	private static final String shapes[] = { "R", "O" };
	private static final Color colors[] = { Color.red, Color.green, Color.blue };
	private static final boolean fill[] = { true, false };
	private static final String font[] = { "Arial", "Courier" };

	public Client() {
		Container contentPane = getContentPane();

		JButton startButton = new JButton("Draw Shapes");
		final JPanel panel = new JPanel();

		contentPane.add(panel, BorderLayout.CENTER);
		contentPane.add(startButton, BorderLayout.SOUTH);
		setSize(WIDTH, WIDTH);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);

		startButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				Graphics g = panel.getGraphics();
				for (int i = 0; i < 100; ++i) {
					MyShape shape = ShapeFactory.getShape(getRandomShape());
					shape.draw(g, getRandomX(), getRandomY(), getRandomWidth(),
							getRandomHeight(), getRandomColor(),
							getRandomFill(), getRandomFont());
				}
			}
		});
	}

	private String getRandomShape() {
		return shapes[(int) (Math.random() * shapes.length)];
	}

	private int getRandomX() {
		return (int) (Math.random() * WIDTH);
	}

	private int getRandomY() {
		return (int) (Math.random() * HEIGHT);
	}

	private int getRandomWidth() {
		return (int) (Math.random() * (WIDTH / 7));
	}

	private int getRandomHeight() {
		return (int) (Math.random() * (HEIGHT / 7));
	}

	private Color getRandomColor() {
		return colors[(int) (Math.random() * colors.length)];
	}

	private boolean getRandomFill() {
		return fill[(int) (Math.random() * fill.length)];
	}

	private String getRandomFont() {
		return font[(int) (Math.random() * font.length)];
	}

	public static void main(String[] args) {
		Client client = new Client();
	}
}
