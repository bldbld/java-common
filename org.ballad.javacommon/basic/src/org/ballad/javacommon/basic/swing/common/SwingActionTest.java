package org.ballad.javacommon.basic.swing.common;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SwingActionTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		JFrame mainFrame = new JFrame();
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.setSize(800, 600);

		
		final JPanel jpanel = new JPanel();
		// mainFrame.setLayout(new GridLayout(2,2));

		JButton jButton1 = new JButton("Start");
		jButton1.setSize(200, 50);
		jButton1.setPreferredSize(new Dimension(200, 50));

		jButton1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new Thread() {
					public void run() {
						Graphics g = jpanel.getGraphics();
						for (int i = 0; i < 500; i++) {
							g.setColor(Color.black);
							/* g.drawOval(i, i, i+100, i+100); */
							g.drawRoundRect(i, i, 50, 50, 20, 20);
							g.drawString("here", i, i);
							jpanel.paint(g);
						}
					}
				}.start();
			}
		});

		JButton jbutton2 = new JButton("DOTA!");
		jbutton2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "DotA-Allstars!");
			}

		});

		jpanel.add(jButton1);
		jpanel.add(jbutton2);
		mainFrame.add(jpanel);

		mainFrame.setVisible(true);
	}
}
