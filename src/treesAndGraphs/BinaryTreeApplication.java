package treesAndGraphs;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Map;

class TreeNode {
	int value;
	TreeNode left;
	TreeNode right;
}

class BinaryTree {
	TreeNode root;

	public BinaryTree() {
		root = null;
	}

	public void createListEachDepth(TreeNode node) {
		int depth = 0;
		HashMap<Integer, LinkedList<TreeNode>> map = new HashMap<>();
		LinkedList<TreeNode> currentList = new LinkedList<>();
		currentList.add(node);
		LinkedList<TreeNode> childrenList = new LinkedList<>();
		map.put(depth, currentList);
		ListIterator<TreeNode> iterator = currentList.listIterator();
		while (iterator.hasNext()) {
			while (iterator.hasNext()) {
				TreeNode node1 = iterator.next();
				if (node1.left != null) {
					childrenList.add(node1.left);
				}
				if (node1.right != null) {
					childrenList.add(node1.right);
				}
			}
		}
			while (!childrenList.isEmpty()) {
				depth++;
				map.put(depth, childrenList);

				currentList = childrenList;
				childrenList = new LinkedList<>();
				iterator = currentList.listIterator();
			}
		
		for (Map.Entry m : map.entrySet()) {
			LinkedList<TreeNode> list = (LinkedList<TreeNode>) m.getValue();
			System.out.println(list.remove());
		}
	}

	public void insert(int valueReceived) {
		TreeNode node = new TreeNode();
		node.value = valueReceived;
	}

	public void inOrderTraversal(TreeNode node) {
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
		TreeNode node1 = new TreeNode();
		TreeNode node2 = new TreeNode();
		TreeNode node3 = new TreeNode();
		TreeNode node4 = new TreeNode();
		TreeNode node5 = new TreeNode();
		TreeNode node6 = new TreeNode();
		TreeNode node7 = new TreeNode();
		TreeNode node8 = new TreeNode();
		TreeNode node9 = new TreeNode();
		TreeNode node10 = new TreeNode();
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
		// binaryTree.inOrderTraversal(node1);
		binaryTree.createListEachDepth(node1);
	}

}
