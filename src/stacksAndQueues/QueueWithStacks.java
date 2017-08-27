package stacksAndQueues;

import java.util.Stack;

public class QueueWithStacks {
	static Stack<Integer> stack1 = new Stack<>();
	static Stack<Integer> stack2 = new Stack<>();

	public static void enQueue(int value) {
		stack1.push(value);
	}

	public static void deQueue() {
		stack2.removeAll(stack2);
		while(!stack1.isEmpty()) {
			stack2.push(stack1.pop());
		}
		System.out.println(stack2.pop());
		while(!stack2.isEmpty()) {  		//Hold this operation until the stack1 is completely empty 
			stack1.push(stack2.pop());	//for saving redundant operations
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		enQueue(5);
		enQueue(1);
		enQueue(3);
		deQueue();
		enQueue(8);
		deQueue();
		deQueue();
	}

}
