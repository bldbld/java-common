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
 * 解析由Extra工具生成的配置文件Main.xml，并生成CSV文件。<br>
 * Main.xml用于存储华腾的CNAPS一代项目的菜单<br>
 * 
 * @author Ballad
 * @date 2011-09-30
 */
public class ExtraXmlToCsv {
	// 生成2种格式的CSV文件
	// 带ID 即name标签
	private File outFile1 = new File("Menu with NodeId.csv");
	// 不带ID 顺序显示Label
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

				// 输出第一种CSV格式
				if (xmlName.contains("0000")) {
					fw1.write(xmlName + ",,," + xmlLabel + "\n");
				} else if (xmlName.contains("00")) {
					fw1.write("," + xmlName + ",," + xmlLabel + "\n");
				} else {
					fw1.write(",," + xmlName + "," + xmlLabel + "\n");
				}

				// 输出第二种CSV格式
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
			System.out.println("解析由Extra工具生成的配置文件Main.xml，并生成CSV文件。");
			System.out.println("Main.xml用于存储华腾的CNAPS一代项目的菜单。");
			System.out.println("结果会在当前工作目录生成2种格式的CSV文件");
			System.out.println("使用方法：");
			System.out.println("将Main.xml放到JAR程序的相同路径即可。");
		}else {
			System.out.println("Invalid Parameter, Program will exit!");
		}
		
	}
}
