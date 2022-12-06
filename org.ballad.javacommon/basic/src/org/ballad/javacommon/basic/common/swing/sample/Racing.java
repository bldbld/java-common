package org.ballad.javacommon.basic.common.swing.sample;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * 这是一个键盘控制的GUI程序 可用领域： 比如赛车游戏等等。
 * 
 * 源代码来源于网络
 */
public class Racing extends JFrame implements KeyListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int x, y;
	private int r;

	// 默认构造函数
	public Racing() {
		x = 300;
		y = 200;
		r = 50;
		this.setSize(600, 400);
		this.addKeyListener(this);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}

	// KeyListener方法
	public void keyReleased(KeyEvent e) {
	}

	public void keyTyped(KeyEvent e) {
	}

	public void keyPressed(KeyEvent e) {
		final KeyEvent eFinal = e;
		final Graphics g = this.getGraphics();
		new Thread() {
			public void run() {
				int key = eFinal.getKeyCode(); // 获取按键码
				switch (key) {
				case KeyEvent.VK_UP: // 向上
					y -= 10;
					break;
				case KeyEvent.VK_DOWN: // 向下
					y += 10;
					break;
				case KeyEvent.VK_LEFT: // 向左
					x -= 10;
					break;
				case KeyEvent.VK_RIGHT: // 向右
					x += 10;
					break;
				}

				// 绘制图形

				g.clearRect(0, 0, 600, 400);
				g.fillOval(x - r, y - r, 2 * r, r * 2);
			}
		}.start();
	}

	// main方法
	public static void main(String args[]) {
		new Racing();
	}
}
