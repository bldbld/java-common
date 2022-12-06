package org.ballad.javacommon.basic.common.swing.common;

import javax.swing.*;

public class TabbedPaneTest {
	public static void main(String[] args) {
		JFrame mainFrame = new JFrame();
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.setSize(800, 600);

		JTabbedPane jtp = new JTabbedPane ();
		jtp.add("Nirvana.cn",new JPanel ());
		jtp.add("EHome",new JPanel ());
		jtp.add("LGD.Sgty",new JPanel ());
		jtp.add("Nivana.eu",new JPanel ());
		jtp.add("LOST",new JPanel ());
		jtp.add("OK",new JPanel ());
		jtp.add("MYM",new JPanel ());
		mainFrame.add(jtp);

		mainFrame.setVisible(true);
	}
}
