package linkedLists;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.ListIterator;

public class RemoveDuplicates {
	//HashSet can be used
	// brute force algo
	//
	public static void removeDuplicates(Node head) {
		Node node = head;
		Node prev = head;
		HashSet<Integer> set = new HashSet<Integer>();
		while(node!=null) {
			if(set.contains(node.value)){
				prev.next=node.next;
				prev =node;
				node= node.next;
			}
			else {
				set.add(node.value);
				prev = node;
				node=node.next;
			}
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		linkedLists.LinkedList ll = new linkedLists.LinkedList();
		ll.insert(4);
		ll.insert(1);
		ll.insert(6);
		ll.insert(3);
		ll.insert(1);
		ll.insert(6);
		ll.insert(1);

		ll.display(ll.head);
		System.out.println();
		removeDuplicates(ll.head);
		ll.display(ll.head);
		
	}

}
