package treesAndGraphs;

class Node {
	int value;
	Node left;
	Node right;
}

class BinaryTree {
	Node root;

	public BinaryTree() {
		root = null;
	}

	public void insert(int valueReceived) {
		Node node = new Node();
		node.value = valueReceived;
	}

	public void inOrderTraversal(Node node) {
		if (node != null) {
			System.out.print("	" + node.value);
			inOrderTraversal(node.left);
			inOrderTraversal(node.right);
		}
	}

	
}

public class BinaryTreeApplication {

	public static void main(String[] args) {
		BinaryTree binaryTree = new BinaryTree();
		Node node1 = new Node();
		Node node2 = new Node();
		Node node3 = new Node();
		Node node4 = new Node();
		Node node5 = new Node();
		Node node6 = new Node();
		Node node7 = new Node();
		Node node8 = new Node();
		Node node9 = new Node();
		Node node10 = new Node();
		node1.value = 1;
		node2.value = 2;
		node3.value = 3;
		node4.value = 4;
		node5.value = 5;
		node6.value = 6;
		node7.value = 7;
		node8.value = 8;
		node9.value = 9;
		node10.value = 10;
		node1.left = node2;
		node1.right = node3;
		node2.left = node4;
		node2.right = node5;
		node3.left = node6;
		node3.right = node7;
		node4.left = node8;
		node4.right = node9;
		node5.left = node10;
		binaryTree.inOrderTraversal(node1);
	}

}
