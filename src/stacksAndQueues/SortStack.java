package stacksAndQueues;

import java.util.Stack;

public class SortStack {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Stack<Integer> stack1 = new Stack<>();
		Stack<Integer> stack2 = new Stack<>();
		stack1.push(4);
		stack1.push(1);
		stack1.push(8);
		stack1.push(10);
		stack1.push(0);
		stack1.push(3);
		stack2.push(Integer.MAX_VALUE);
		while (!stack1.isEmpty()) {
			if (stack1.peek() < stack2.peek()) {
				stack2.push(stack1.pop());
			} else {
				int temp = stack1.pop();
				while (temp > stack2.peek()) {
					stack1.push(stack2.pop());
				}
				stack2.push(temp);
			}
		}
		System.out.println(stack2.pop());

	}

}
