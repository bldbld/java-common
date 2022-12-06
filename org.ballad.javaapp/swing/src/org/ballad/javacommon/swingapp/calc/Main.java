package org.ballad.javacommon.swingapp.calc;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/*
 *一个带界面的计算器
 */
public class Main {
	public static void main(String[] args) {
		Calc c1 = new Calc();
	}

}

class Calc {
	private JFrame frame;
	private JPanel panel;
	private JPanel display;
	private JButton num1;
	private JButton num2;
	private JButton num3;
	private JButton num4;
	private JButton num5;
	private JButton num6;
	private JButton num7;
	private JButton num8;
	private JButton num9;
	private JButton num0;
	private JButton add;
	private JButton sub;
	private JButton mul;
	private JButton div;
	private JButton equ;
	private JButton clear;
	private int how;
	private JTextField show;
	private double a;
	private double b;
	private double ans;
	private String str;

	public Calc() {
		frame = new JFrame("CALC");
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setLayout(new FlowLayout());
		// frame.setResizable(false);
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension screenSize = kit.getScreenSize();
		int screenHeight = screenSize.height;
		int screenWidth = screenSize.width;
		frame.setLocation(screenWidth / 4, screenHeight / 4);
		frame.setSize(new Dimension(600, 300));

		display = new JPanel();
		panel = new JPanel();

		show = new JTextField();
		str = new String();
		display.add(show);
		show.setPreferredSize(new Dimension(300, 100));

		num1 = new JButton("1");
		num2 = new JButton("2");
		num3 = new JButton("3");
		num4 = new JButton("4");
		num5 = new JButton("5");
		num6 = new JButton("6");
		num7 = new JButton("7");
		num8 = new JButton("8");
		num9 = new JButton("9");
		num0 = new JButton("0");
		add = new JButton("+");
		sub = new JButton("-");
		mul = new JButton("*");
		div = new JButton("/");
		equ = new JButton("=");
		clear = new JButton("C");

		panel.setLayout(new GridLayout(4, 4));
		panel.setSize(500, 400);// :)

		panel.add(num7);
		panel.add(num8);
		panel.add(num9);
		panel.add(div);

		panel.add(num4);
		panel.add(num5);
		panel.add(num6);
		panel.add(mul);

		panel.add(num1);
		panel.add(num2);
		panel.add(num3);
		panel.add(sub);

		panel.add(num0);
		panel.add(clear);
		panel.add(equ);
		panel.add(add);

		frame.add(display);
		frame.add(panel);
		frame.setVisible(true);

		a = 0.0;
		b = 0.0;
		how = 5;
		num1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {

				str = show.getText();
				show.setText(str + "1");
				a += 1.0;

			}
		});
		num2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {

				str = show.getText();
				show.setText(str + "2");
				a += 2.0;
			}
		});
		num3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {

				str = show.getText();
				show.setText(str + "3");
				a += 3.0;

			}
		});

		num4.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent event) {
				str = show.getText();
				show.setText(str + "4");
				a += 4.0;
			}
		});

		num5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {

				str = show.getText();
				show.setText(str + "5");
				a += 5.0;

			}
		});
		num6.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent event) {

				str = show.getText();
				show.setText(str + "6");
				a += 6.0;

			}
		});
		num7.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent event) {

				str = show.getText();
				show.setText(str + "7");
				a += 7.0;

			}
		});
		num8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {

				str = show.getText();
				show.setText(str + "8");
				a += 8.0;
			}
		});

		num9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {

				str = show.getText();
				show.setText(str + "9");
				a += 9.0;

			}
		});
		num0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {

				str = show.getText();
				show.setText(str + "0");
				a += 0.0;

			}
		});
		add.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent event) {
				str = show.getText();
				a = Double.parseDouble(str);
				b = a;
				a = 0.0;
				show.setText("");
				how = 0;
			}
		});
		sub.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				str = show.getText();
				a = Double.parseDouble(str);
				b = a;
				a = 0.0;
				show.setText("");
				how = 1;
			}
		});

		mul.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				str = show.getText();
				a = Double.parseDouble(str);
				b = a;
				a = 0.0;
				show.setText("");
				how = 2;
			}
		});
		div.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent event) {
				str = show.getText();
				a = Double.parseDouble(str);
				b = a;
				a = 0.0;
				show.setText("");
				how = 3;
			}
		});

		clear.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent event) {
				show.setText("");
				a = 0.0;
				b = 0.0;

			}
		});

		equ.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent event) {
				str = show.getText();
				a = Double.parseDouble(str);

				if (how == 5) {

				} else if (how == 0) {
					ans = a + b;
					str = Double.toString(ans);
					show.setText(str);
				} else if (how == 1) {
					ans = b - a;
					str = Double.toString(ans);
					show.setText(str);
				} else if (how == 2) {
					ans = a * b;
					str = Double.toString(ans);
					show.setText(str);
				}

				else if (how == 3) {
					ans = b / a;
					str = Double.toString(ans);
					show.setText(str);
				}

			}
		});
	}
}
