package org.ballad.javacommon.basic.common.ds.graph;

import java.util.HashMap;
import java.util.Map;

/**
 * 一个简单的图的实例
 * 
 * @author ballad
 * @version 2010/06/01 initial
 * @version 2012/04/30 code format
 */
public class Graph {

	public void addVertex(String name) {
		Vertex v = new Vertex(name);
		vertexMap.put(name, v);
	}

	public void addEdge(String sour, String dest, double cost) {
		Vertex s = getVertex(sour);
		Vertex d = getVertex(dest);
		s.adj.add(new Edge(d, cost));
	}

	public Vertex getVertex(String name) {
		Vertex v = vertexMap.get(name);
		if (v == null) {
			v = new Vertex(name);
			vertexMap.put(name, v);
		}
		return v;
	}

	/**
	 * This function is just print a line
	 * 
	 * @param name
	 */
	public void printLine(String name) {
		Vertex v = vertexMap.get(name);
		System.out.println(v.name);
		while (!v.adj.isEmpty()) {
			v = v.adj.get(0).dist;
			System.out.println(v.name);
		}
	}

	private Map<String, Vertex> vertexMap = new HashMap<String, Vertex>();

	public static void main(String[] args) {
		Graph g = new Graph();
		g.addVertex("no-1");
		g.addEdge("no-1", "no-2", 3.0);
		g.addEdge("no-2", "no-3", 5.0);
		g.printLine("no-1");

	}
}
