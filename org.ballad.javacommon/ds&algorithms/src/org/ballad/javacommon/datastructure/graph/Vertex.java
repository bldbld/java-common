package org.ballad.javacommon.datastructure.graph;

import java.util.LinkedList;
import java.util.List;

public class Vertex {
	public String name;
	public List<Edge> adj =new LinkedList<Edge>();//Adjacent
	public double cost; //cost
	public Vertex prev;//Previous vertex on shortest path
	public int scratch;// extra var used in algorithm
	
	public Vertex (String name){
		this.name = name;
	}
	
	public void reset(){
		
	}
}
