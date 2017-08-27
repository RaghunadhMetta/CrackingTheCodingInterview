package linkedLists;

class Node {
	int value;
	Node next;
}

class LinkedList {
	Node head;

	public LinkedList() {
		head = null;
	}

	public void insert(int value1) {
		Node node = new Node();
		node.value=value1;
		node.next=head;
		head=node;
	}
	
	public void delete() {
		head=head.next;
	}
	
	public void display(Node head) {
		Node node = head;
		while(node!=null) {
			System.out.print("	"+node.value);
			node=node.next;
		}
	}

}



public class LinkedListApplication {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedList ll = new LinkedList();
		ll.insert(4);
		ll.insert(6);
		ll.insert(9);
		ll.insert(1);
		ll.delete();

		ll.display(ll.head);
	}

}
