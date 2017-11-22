package com.graph.distance;

import java.util.ArrayList;
import java.util.List;

public class Graph {

	private List<Vertex> vertexes;

	private List<Edge> edges;

	public Graph() {
		vertexes = new ArrayList<Vertex>();
		edges = new ArrayList<Edge>();
	}

	public Graph(List<Vertex> vertexes, List<Edge> edges) {
		this.vertexes = vertexes;
		this.edges = edges;
	}

	public List<Vertex> getVertexes() {
		return vertexes;
	}

	public List<Edge> getEdges() {
		return edges;
	}

}