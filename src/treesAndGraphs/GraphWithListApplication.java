package treesAndGraphs;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

class GraphWithList {

	class Edge {
		int v, w;

		public Edge(int v, int w) {
			this.v = v;
			this.w = w;
		}

		public String toString() {
			return "(" + v + "," + w + ")";
		}
	}

	private Map<Integer, LinkedList<Edge>> adjacentListMap;

	public GraphWithList(int vertices) {
		boolean visited[] = new boolean[vertices];
		adjacentListMap = new HashMap<>();
		for (int i = 0; i < vertices; i++) {
			LinkedList<Edge> neighbours = new LinkedList<>();
			adjacentListMap.put(i, neighbours);
		}
	}

	public void addEdge(int u, int v, int w) {
		adjacentListMap.get(u).add(new Edge(v, w));
	}

	public LinkedList<Edge> getNeighbours(int u) {
		return adjacentListMap.get(u);
	}

	public boolean isConnected(int u, int v) {
		LinkedList<Edge> list = (adjacentListMap.get(u));
		for (Edge e : list) {
			if (e.v == v) {
				return true;
			}
		}
		return false;
	}

	boolean visited[] = new boolean[6]; // should find a way to make it dynamic

	public boolean isVisited(int vertex) {
		return visited[vertex];
	}

	public void dfs(int vertex) {
		if (vertex > adjacentListMap.size()) {
			Arrays.fill(visited, false);
			return;
		} else {
			visited[vertex] = true;
			System.out.print(vertex + "	");
			LinkedList<Edge> neighbours = adjacentListMap.get(vertex);
			for (Edge e : neighbours) {
				if (!isVisited(e.v)) {
					dfs(e.v);
				}
			}
		}

	}

	public void bfs(int vertex) {
		Queue<Integer> queue = new LinkedList<>();
		visited[vertex] = true;
		queue.add(vertex);
		while (!queue.isEmpty()) {
			vertex = queue.remove();
			System.out.print(vertex + "	");
			LinkedList<Edge> neighbours = adjacentListMap.get(vertex);
			for (Edge e : neighbours) {
				if (!isVisited(e.v)) {
					visited[e.v] = true;
					queue.add(e.v);
				}
			}
		}
	}

	public String toString() {
		String result = "";
		for (int i = 0; i < adjacentListMap.size(); i++) {
			result = result + i + "->" + adjacentListMap.get(i) + "\n";
		}
		return result;
	}
}

public class GraphWithListApplication {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GraphWithList graph = new GraphWithList(6);
		graph.addEdge(0, 1, 1);
		graph.addEdge(0, 4, 1);
		graph.addEdge(0, 5, 1);
		graph.addEdge(1, 3, 1);
		graph.addEdge(1, 4, 1);
		graph.addEdge(2, 1, 1);
		graph.addEdge(3, 2, 1);
		graph.addEdge(3, 4, 1);

		// graph.dfs(0);
		graph.bfs(0);
		// System.out.println(graph.isConnected(0, 2));
		// System.out.println(graph);
	}
}
