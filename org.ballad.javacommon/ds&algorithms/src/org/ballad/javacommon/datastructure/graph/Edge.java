package org.ballad.javacommon.datastructure.graph;

public class Edge {
	public Vertex dist;
	public double cost;

	public Edge(Vertex d, double c) {
		dist = d;
		cost = c;
	}

	public Edge(Vertex d) {
		dist = d;
		cost = 0.0;
	}
}
