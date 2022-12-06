/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * MainFrame.java
 *
 * Created on 2010-4-5, 19:40:24
 */

package org.ballad.mibbrowser;

/**
 *
 * @author bkin
 */

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Vector;
public class MainFrame extends JFrame {

    /** Creates new form MainFrame */
    public MainFrame() {
    }
    public void run (){
    	this.initComponents();
    }
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new JScrollPane();
        jTree1 = new JTree();
        jScrollPane2 = new JScrollPane();
        jTextArea1 = new JTextArea();
        jMenuBar1 = new JMenuBar();
        jMenu1 = new JMenu();
        jMenuItem1 = new JMenuItem();
        jMenu2 = new JMenu();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        DefaultMutableTreeNode treeNode1 = new DefaultMutableTreeNode("root");
        jTree1.setModel(new DefaultTreeModel(treeNode1));
        
        jScrollPane1.setViewportView(jTree1);

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jTextArea1.setWrapStyleWord(true);
        jScrollPane2.setViewportView(jTextArea1);

        jMenu1.setText("File");
        jMenu1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu1MouseClicked(evt);
            }
        });

        jMenuItem1.setText("Open");
        jMenuItem1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenuItem1MouseClicked(evt);
            }
        });
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Help");
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 438, GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addContainerGap(34, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane2, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 377, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 377, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
        OpenFile of = new OpenFile ();
        of.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuItem1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem1MouseClicked

    private void jMenu1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenu1MouseClicked

    private void jTree1ValueChanged(javax.swing.event.TreeSelectionEvent evt) {//GEN-FIRST:event_jTree1ValueChanged
        // TODO add your handling code here:
       // System.out.println("3");
        DefaultMutableTreeNode selnode=(DefaultMutableTreeNode)jTree1.getLastSelectedPathComponent();
        String name=selnode.toString();
        String ss = new String ();
        String des= new String ();
        try {
            FileReader fr = new FileReader(selectedFile);
            BufferedReader br = new BufferedReader(fr);
            String str;          
            while ((str= br.readLine())!=null){
                if (str.contains(name)){
                	while (((str= br.readLine())!=null)&&(!str.contains("::="))){
                        if (str.contains("DESCRIPTION")){
                        	ss = str;
                        }
                        if (str.contains("STATUS")){
                        	des= str;
                        }
                	}
                }
            }
            br.close();
            fr.close();

        }catch (Exception e){

        }
        jTextArea1.setText(ss);
        jTextArea1.append("\r\n");
        jTextArea1.append(des);
        this.validateTree();
        this.validate();
    }//GEN-LAST:event_jTree1ValueChanged

    /**
    * @param args the command line arguments
    */
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private JMenu jMenu1;
    private JMenu jMenu2;
    private JMenuBar jMenuBar1;
    private JMenuItem jMenuItem1;
    private JScrollPane jScrollPane1;
    private JScrollPane jScrollPane2;
    private JTextArea jTextArea1;
    private JTree jTree1;
    // End of variables declaration//GEN-END:variables
    static public String fileName;
    static public String dirName;
    static public File selectedFile;
    private String rootName;
    private DefaultMutableTreeNode rootNode;
    private Vector<DefaultMutableTreeNode> nodes;

    public void loadMib(){
    	this.initComponents();
    	nodes = new Vector ();
    	try{
    		FileReader fr = new FileReader(selectedFile);
    		
    		BufferedReader br = new BufferedReader(fr);
    		String str;
    		int debug = 0;
    		
    		while ((str = br.readLine())!= null) {
    			str.trim();
    			if (str.length()==0)
    				continue;
    			if (str.indexOf("--")==0)
    				continue;
    			if (str.indexOf("--")>0)
    				str = str.substring(0,str.length()-str.indexOf("--")-1);
    			str.trim();

    			if (str.contains("DEFINITIONS ::=")){
    				rootName = str.substring(0,str.indexOf("DEFINITIONS ::="));
    				
    		    	rootNode = new DefaultMutableTreeNode(rootName,true);
    		        //jTree1.setModel(new javax.swing.tree.DefaultTreeModel(rootNode));
    		    	nodes.add(rootNode);
    			}
    			
    			//
    			if (str.contains("IMPORTS")){
    				int hasModule = 0;
    				while ((str = br.readLine())!=null){
    					if (str.contains("MODULE-IDENTITY")){
    						hasModule = 1;
    						break;
    					}
    					
    				}
    				if (hasModule == 1){
						;
					}
					else {
						// MessageBox.Show("Invalid mid files");
					}
    			}
    			
    			if (str.contains("OBJECT IDENTIFIER") && (!str.contains("::="))){
    				String pos;
    				String nodeName = str.substring(0,str.indexOf("OBJECT IDENTIFIER"));

                    str = br.readLine();
                    if (0 == str.length())
                    {
                        continue;
                    }
                    if (0 == str.indexOf("--"))
                    {
                        continue;
                    }
                    if (str.indexOf("--") > 0)
                    {
                    	str = str.substring(0, str.indexOf("--"));
                    }

                    str.trim();

                    str = str.substring(str.indexOf('{')+2);
                    str.trim();
                    String parentName = str.substring(0,str.indexOf(' '));

                    pos = str.substring(str.indexOf(' '));
                    if (parentName.equals("enterprises"))
                    {
                        parentName = rootName;
                    }
                    //AddToTree(parentName.trim(),nodeName.trim(),pos.trim());
                    DefaultMutableTreeNode node1 = new DefaultMutableTreeNode(nodeName.trim(),true);
                    nodes.add(node1);
                    //锟揭碉拷锟斤拷锟节碉拷  锟斤拷锟斤拷锟斤拷
                    int length= nodes.size();
                    for (int i = 0 ;i<length;i++){
                    	if (nodes.get(i).toString().equals(parentName)){
                    		nodes.get(i).add(node1);
                    		break;
                    	}
                    }      
                    
                    continue;
    			}
    			
    			if (str.indexOf("OBJECT IDENTIFIER ::=")>2){
    				if ((str.indexOf("{") > 10) && str.indexOf("}") > 10){
                        String ParentName, NodeName, Pos;
                        NodeName = str.substring(0,str.indexOf("OBJECT IDENTIFIER ::="));

                        int n1 = str.indexOf("{");
                        int n2 = str.indexOf("}")-n1-1;
                        str = str.substring(n1+1,n2);

                        str.trim();

                        ParentName = str.substring(0,str.indexOf(" "));

                        Pos = str.substring(str.indexOf(" "),1);

                        //add to list view
                        //AddToTree(ParentName.trim(),NodeName.trim(),Pos.trim());
                        
                        DefaultMutableTreeNode node1 = new DefaultMutableTreeNode(NodeName.trim(),true);
                        nodes.add(node1);
                        //锟揭碉拷锟斤拷锟节碉拷  锟斤拷锟斤拷锟斤拷
                        int length= nodes.size();
                        for (int i = 0 ;i<length;i++){
                        	if (nodes.get(i).toString().equals(ParentName)){
                        		nodes.get(i).add(node1);
                        		break;
                        	}
                        }             
                        continue;
                    }
    			}
    			if (str.indexOf("MODULE-IDENTITY") > 2 && str.indexOf(",") == -1)
                {
                    String ParentName, NodeName, Pos;
                    NodeName = str.substring(0,str.indexOf("MODULE-IDENTITY"));

                    //锟斤拷取锟斤拷锟斤拷锟斤拷
                    //锟斤拷锟斤拷源锟斤拷锟斤拷锟斤拷readstr 锟斤拷锟斤拷要注锟斤拷
                    
                    while( (str = br.readLine())!= null)
                    {
                        if (0 == str.length())
                        {
                            continue;
                        }
                        if (0 == str.indexOf("--"))
                        {
                            continue;
                        }
                        if (str.indexOf("--") > 0)
                        {
                            str = str.substring(0,str.indexOf("--"));
                        }

                        str.trim();

                        //锟叫讹拷锟角凤拷锟角讹拷锟斤拷慕锟斤拷锟斤拷锟�                      
                        if ((str.contains("::="))&&(str.contains("{"))&&(str.contains("}")))
                        {
                            int n1 = str.indexOf("{");
                            int n2 = str.indexOf("}")-n1-1;

                            str = str.substring(n1+1,n2);
                            str.trim();
                            ParentName = str.substring(0, str.indexOf(" "));

                            Pos = str.substring(str.indexOf(" "), 1);

                            //add to list view
                            //AddToTree(ParentName, NodeName, Pos);
                            break;
                        }
                    }
                    continue;
                }
    			if ((str.contains("OBJECT-IDENTITY")) && (!str.contains(","))&&(str.contains("{")))
                {
                    String ParentName, NodeName, Pos;
                    NodeName = str.substring(0,str.indexOf("OBJECT-IDENTITY"));
                    int n1 = str.indexOf("{");
                    int n2 = str.indexOf("}")-n1-1;

                    str = str.substring(n1+1,n2);
                    str.trim();

                    ParentName = str.substring(0, str.indexOf(" "));

                    Pos = str.substring(str.indexOf(" "), 1);

                    //add to list view
                    DefaultMutableTreeNode node1 = new DefaultMutableTreeNode(NodeName.trim(),true);
                    nodes.add(node1);
                    //锟揭碉拷锟斤拷锟节碉拷  锟斤拷锟斤拷锟斤拷
                    int length= nodes.size();
                    for (int i = 0 ;i<length;i++){
                    	if (nodes.get(i).toString().equals(ParentName)){
                    		nodes.get(i).add(node1);
                    		break;
                    	}
                    }        
                    continue;
                }
    			if (str.contains("OBJECT-IDENTITY") && (!str.contains(",")) && (!str.contains("{")))
                {
                    String ParentName = null;
                    String NodeName = null;
                    String Pos = null;
                    NodeName = str.substring(0, str.indexOf("OBJECT-IDENTITY"));
                    while ((str = br.readLine()) != null)//readstr!!!!!!!
                    {
                        if (0 == str.length())
                        {
                            continue;
                        }
                        if (0 == str.indexOf("--"))
                        {
                            continue;
                        }
                        if (str.indexOf("--") > 0)
                        {
                            str = str.substring(0, str.indexOf("--"));
                        }

                        str.trim();
                        if (str.contains("::=")) break;
                    }
                    str = str.substring(str.indexOf('{')+2);
                    ParentName = str.substring(0,str.indexOf(' '));

                    //Pos = str.substring(str.indexOf(' ')+1,1);

                    DefaultMutableTreeNode node1 = new DefaultMutableTreeNode(NodeName.trim(),true);
                    nodes.add(node1);
                    //锟揭碉拷锟斤拷锟节碉拷  锟斤拷锟斤拷锟斤拷
                    int length= nodes.size();
                    for (int i = 0 ;i<length;i++){
                    	if (nodes.get(i).toString().equals(ParentName)){
                    		nodes.get(i).add(node1);
                    		break;
                    	}
                    }  
                }
    			if ((str.contains("OBJECT-TYPE")) && (!str.contains(",")))
                {
                    String ParentName, NodeName, Pos;
                    NodeName = str.substring(0,str.indexOf("OBJECT-TYPE"));
                    NodeName.trim();

                    //锟斤拷锟叫讹拷锟斤拷锟斤拷锟侥讹拷锟斤拷锟斤拷STR!!!!!!!!
                    while( (str = br.readLine())!= null)
                    {
                        if (0 == str.length())
                        {
                            continue;
                        }
                        if (0 == str.indexOf("--"))
                        {
                            continue;
                        }
                        if (str.indexOf("--") > 0)
                        {
                            str = str.substring(0, str.indexOf("--"));
                        }

                        str.trim();

                        if ((str.contains("::=")) && (str.contains("}")) && (str.contains("{")))
                        {
                            str = str.substring(str.indexOf('{') + 2);
                            ParentName = str.substring(0, str.indexOf(' '));

                            Pos = str.substring(str.indexOf(' ') + 1, 1);

                            DefaultMutableTreeNode node1 = new DefaultMutableTreeNode(NodeName.trim(),true);
                            nodes.add(node1);
                            //锟揭碉拷锟斤拷锟节碉拷  锟斤拷锟斤拷锟斤拷
                            int length= nodes.size();
                            for (int i = 0 ;i<length;i++){
                            	if (nodes.get(i).toString().equals(ParentName)){
                            		nodes.get(i).add(node1);
                            		break;
                            	}
                            }  
                            break;
                        }
                    }
                    continue;
                }

    		}
    		br.close();
    		fr.close();
    		jTree1 = new JTree();
    		jTree1.setModel(new DefaultTreeModel(rootNode));
    		jTree1.addTreeSelectionListener(new javax.swing.event.TreeSelectionListener() {
                public void valueChanged(javax.swing.event.TreeSelectionEvent evt) {
                    jTree1ValueChanged(evt);
                }
            });
    		jScrollPane1.setViewportView(jTree1);
    		jTextArea1.setEnabled(false);
            jTextArea1.setEnabled(true);
                	
    	}catch(IOException e){
    		System.err.println(e.toString());
    	}
    }
}
