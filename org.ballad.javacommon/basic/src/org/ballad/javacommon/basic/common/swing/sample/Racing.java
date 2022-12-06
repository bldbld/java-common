package org.ballad.javacommon.basic.common.swing.sample;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * ����һ�����̿��Ƶ�GUI���� �������� ����������Ϸ�ȵȡ�
 * 
 * Դ������Դ������
 */
public class Racing extends JFrame implements KeyListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int x, y;
	private int r;

	// Ĭ�Ϲ��캯��
	public Racing() {
		x = 300;
		y = 200;
		r = 50;
		this.setSize(600, 400);
		this.addKeyListener(this);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}

	// KeyListener����
	public void keyReleased(KeyEvent e) {
	}

	public void keyTyped(KeyEvent e) {
	}

	public void keyPressed(KeyEvent e) {
		final KeyEvent eFinal = e;
		final Graphics g = this.getGraphics();
		new Thread() {
			public void run() {
				int key = eFinal.getKeyCode(); // ��ȡ������
				switch (key) {
				case KeyEvent.VK_UP: // ����
					y -= 10;
					break;
				case KeyEvent.VK_DOWN: // ����
					y += 10;
					break;
				case KeyEvent.VK_LEFT: // ����
					x -= 10;
					break;
				case KeyEvent.VK_RIGHT: // ����
					x += 10;
					break;
				}

				// ����ͼ��

				g.clearRect(0, 0, 600, 400);
				g.fillOval(x - r, y - r, 2 * r, r * 2);
			}
		}.start();
	}

	// main����
	public static void main(String args[]) {
		new Racing();
	}
}
