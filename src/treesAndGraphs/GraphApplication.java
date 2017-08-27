package treesAndGraphs;

import java.util.HashMap;
import java.util.LinkedList;

class GraphNode {
	int value;
}

public class GraphApplication {
	static int visited[] = new int[5];

	static void depthFirstSearch(GraphNode node, HashMap map) {
		if (node == null) {
			return;
		}
		System.out.println(node.value);
		visited[node.value] = 1;
		LinkedList list = (LinkedList) map.get(node);
		node = (GraphNode)list.remove();
		while (!list.isEmpty() && visited[node.value] != 1) {
			
			depthFirstSearch(node, map);
		}
	}

	public static void main(String[] args) {
		HashMap<GraphNode, LinkedList> map = new HashMap<GraphNode, LinkedList>();
		GraphNode node0 = new GraphNode();
		GraphNode node1 = new GraphNode();
		GraphNode node2 = new GraphNode();
		GraphNode node3 = new GraphNode();
		GraphNode node4 = new GraphNode();
		node0.value = 0;
		node1.value = 1;
		node2.value = 2;
		node3.value = 3;
		node4.value = 4;
		depthFirstSearch(node0, map);
	}

}
