package treesAndGraphs;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class CheckDAG {
	// Class to store information about a vertex in this algorithm
	class DAGVertex {
		Graph.Vertex element;
		boolean seen;
		int preIndex;
		int postIndex;

		DAGVertex(Graph.Vertex u) {
			element = u;
			seen = false;
			preIndex = 0;
			postIndex = 0;
		}
	}
    // Algorithm uses a parallel array for storing information about vertices
	DAGVertex[] dagVertex;
	Graph g;
	int count;

	public CheckDAG(Graph g) {
		this.g = g;
		this.count = 0;
		dagVertex = new DAGVertex[g.size()];
		for (Graph.Vertex v : g) {
			dagVertex[v.name] = new DAGVertex(v);
		}
	}
//actual method that checks if a graph is DAG or NOT and returns true or false accordingly 
	boolean isDAG() {
		for (Graph.Vertex u : g) {
			
			if (!seen(u)) {
				dfs(u);
			}
		}
		for (Graph.Vertex u : g) {
			for (Graph.Edge e : u) {
				Graph.Vertex v = e.otherEnd(u);
				if ((getDAGVertex(u).preIndex > getDAGVertex(v).preIndex)
						&& (getDAGVertex(u).postIndex < getDAGVertex(v).postIndex)) {
					return false;
				}
			}
		}

		return true;
	}
//depth first search implementation for traversing the graph
	void dfs(Graph.Vertex u) {
		visit(u);

		getDAGVertex(u).preIndex = count;
		count++;
		for (Graph.Edge e : u) {
			Graph.Vertex v = e.otherEnd(u);
			if (!seen(v)) {
				dfs(v);
			}
		}
		getDAGVertex(u).postIndex=count;
		count++;
	}
//helper method to make a vertex into a visited vertex
	void visit(Graph.Vertex u) {
		DAGVertex dagu = getDAGVertex(u);
		dagu.seen = true;
	}
//helper method to check if a vertex is visited or not
	boolean seen(Graph.Vertex u) {
		DAGVertex dagu = getDAGVertex(u);
		return dagu.seen;
	}
//converting standard vertex into our DAGVertex
	DAGVertex getDAGVertex(Graph.Vertex u) {
		return dagVertex[u.name];
	}
//main method to give an input graph 
	public static void main(String[] args) throws FileNotFoundException {
		Scanner in;
		if (args.length > 0) {
			File inputFile = new File(args[0]);
			in = new Scanner(inputFile);
		} else {
			in = new Scanner(System.in);
		}
		Graph g = Graph.readGraph(in, true);
		CheckDAG checkDAG = new CheckDAG(g);
		System.out.println(checkDAG.isDAG());
	}

}
