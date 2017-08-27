package linkedLists;

public class SumOfLists {

	public static void sumOfLists(Node node1, Node node2, LinkedList list, int carry) {
		int sum = 0;
		if (node1 == null && node2 == null && carry == 0) {
			return;
		}
			if (node1 != null) {
				sum = sum + node1.value;
				node1 = node1.next;
			}
			if (node2 != null) {
				sum = sum + node2.value;
				node2 = node2.next;
			}
			if (carry != 0) {
				sum = sum + carry;
			}
			list.insert(sum % 10);
			carry = sum / 10;
			sumOfLists(node1, node2, list, carry);
	}

	public static void main(String[] args) {

		// TODO Auto-generated method stub
		
		LinkedList list1 = new LinkedList();
		LinkedList list2 = new LinkedList();
		LinkedList list3 = new LinkedList(); // to store sum

		list1.insert(5);
		list1.insert(1);
		list1.insert(2);
		list1.insert(2);
		
		
		list2.insert(6);
		list2.insert(3);
		list2.insert(8);
		int carry = 0;
		sumOfLists(list1.head, list2.head, list3, carry);
		list3.display(list3.head);

	}

}
