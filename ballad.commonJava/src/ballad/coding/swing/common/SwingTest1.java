package ballad.coding.swing.common;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTree;
import javax.swing.table.DefaultTableModel;

public class SwingTest1 {


	public static void main(String[] args) {
		JFrame mainFrame = new JFrame();
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.setSize(600, 450);

		JPanel selectPanel = new JPanel();
		JTree jTree = new JTree();
		selectPanel.add(jTree);

		JPanel showPanel = new JPanel();
		DefaultTableModel tm = new DefaultTableModel();
		tm.addColumn("NickName");
		tm.addColumn("Email");
		String[] data1 = { "KuroKy", "kky@ok.de" };
		tm.addRow(data1);
		String[] data2 = { "MiSeRy", "msry@lost.euro" };
		tm.addRow(data2);
		String[] data3 = { "MaNia", "mania@mym.de" };
		tm.addRow(data3);

		JTable jt = new JTable(tm);
		JScrollPane scro = new JScrollPane(jt);
		showPanel.add(scro);

		JSplitPane sp = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, false,
				selectPanel, showPanel);

		mainFrame.add(sp);

		mainFrame.setVisible(true);
	}

}
