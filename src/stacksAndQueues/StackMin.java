package stacksAndQueues;

import java.util.Stack;

public class StackMin {
	static Stack<Integer> stack = new Stack<>();
	static Stack<Integer> minHolder = new Stack<>();

	public static void minTracker(int value) {
		if (minHolder.isEmpty()) {
			minHolder.push(value);
		} else if (value < minHolder.peek()) {
			minHolder.push(value);
		}
		stack.push(value);
	}

	public static void deleteFromStack() {
		if (stack.peek() == minHolder.peek()) {
			minHolder.pop();
		}
		stack.pop();
	}

	public static int getMinimum() {
		return minHolder.peek();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Non of the special cases were handled for null
		minTracker(5);
		minTracker(3);
		minTracker(1);
		minTracker(9);
		minTracker(7);
		minTracker(0);
		deleteFromStack();
		System.out.println(getMinimum());

	}

}
