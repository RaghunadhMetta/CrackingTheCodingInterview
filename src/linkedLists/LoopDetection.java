package linkedLists;

public class LoopDetection {
	public static void detectLoop(Node node1, Node node2) {
		if(node1==null||node2==null) {
			System.out.println("No Loop Found");
			return;
		}
		if(node1==node2) {
			System.out.println("Loop detected");
			return;
		}
		if(node1!=node2) {
			node1=node1.next;
			node2=node1.next.next;
			detectLoop(node1, node2);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// use hashmap
		// use 2 pointers and see if they meet
		//list with one node is a special case
		LinkedList list = new LinkedList();
		list.insert(5);
		list.insert(1);
		list.insert(3);
		list.insert(9);
		list.insert(15);
		Node node1 = list.head;
		Node node2 = list.head.next;
		detectLoop(node1, node2);
	}

}
