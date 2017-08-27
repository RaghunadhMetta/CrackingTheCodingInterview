package linkedLists;

public class PartitionAroundElement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedList list = new LinkedList();
		list.insert(1);
		list.insert(8);
		list.insert(6);
		list.insert(2);
		list.insert(10);
		int partitionElement = 3;
		list.display(list.head);
		System.out.println();
		Node currentNode = list.head.next;
		Node previousNode = list.head;
		while (currentNode != null) {
			if (currentNode.value < partitionElement) {
				Node temp = currentNode;
				previousNode.next = currentNode.next;
				currentNode = previousNode.next;
				// node.next=head;
				// head=node;
				temp.next = list.head;
				list.head = temp;
			} else {
				previousNode = currentNode;
				currentNode = currentNode.next;
			}

		}
		list.display(list.head);
	}
}
