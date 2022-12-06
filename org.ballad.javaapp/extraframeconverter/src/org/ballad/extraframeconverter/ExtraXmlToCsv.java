package org.ballad.extraframeconverter;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * ������Extra�������ɵ������ļ�Main.xml��������CSV�ļ���<br>
 * Main.xml���ڴ洢���ڵ�CNAPSһ����Ŀ�Ĳ˵�<br>
 * 
 * @author Ballad
 * @date 2011-09-30
 */
public class ExtraXmlToCsv {
	// ����2�ָ�ʽ��CSV�ļ�
	// ��ID ��name��ǩ
	private File outFile1 = new File("Menu with NodeId.csv");
	// ����ID ˳����ʾLabel
	private File outFile2 = new File("Menu without NodeId.csv");

	public void convert() {
		File f = new File("Main.xml");
		
		try {
			FileWriter fw1 = new FileWriter(outFile1);
			FileWriter fw2 = new FileWriter(outFile2);

			DocumentBuilderFactory factory = DocumentBuilderFactory
					.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document doc = builder.parse(f);

			NodeList nl = doc.getElementsByTagName("name");

			for (int i = 0; i < nl.getLength(); i++) {
				String xmlLabel = doc.getElementsByTagName("label").item(i)
						.getFirstChild().getNodeValue();
				String xmlName = doc.getElementsByTagName("name").item(i)
						.getFirstChild().getNodeValue();

				// �����һ��CSV��ʽ
				if (xmlName.contains("0000")) {
					fw1.write(xmlName + ",,," + xmlLabel + "\n");
				} else if (xmlName.contains("00")) {
					fw1.write("," + xmlName + ",," + xmlLabel + "\n");
				} else {
					fw1.write(",," + xmlName + "," + xmlLabel + "\n");
				}

				// ����ڶ���CSV��ʽ
				if (xmlName.contains("0000")) {
					fw2.write(xmlLabel + "\n");
				} else if (xmlName.contains("00")) {
					fw2.write("," + xmlLabel + "\n");
				} else {
					fw2.write(",," + xmlLabel + "\n");
				}
			}

			fw1.close();
			fw2.close();

			System.out.println("Convert FINISH!");

		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		ExtraXmlToCsv convTool = new ExtraXmlToCsv();
		if (args.length == 0) {
			convTool.convert();
		}else if (args[0].equals("help")){
			System.out.println("������Extra�������ɵ������ļ�Main.xml��������CSV�ļ���");
			System.out.println("Main.xml���ڴ洢���ڵ�CNAPSһ����Ŀ�Ĳ˵���");
			System.out.println("������ڵ�ǰ����Ŀ¼����2�ָ�ʽ��CSV�ļ�");
			System.out.println("ʹ�÷�����");
			System.out.println("��Main.xml�ŵ�JAR�������ͬ·�����ɡ�");
		}else {
			System.out.println("Invalid Parameter, Program will exit!");
		}
		
	}
}
