package stacksAndQueues;

import java.util.Stack;

public class StackOfPlates {
	static Stack<Stack> stackStorage = new Stack<>();
	static Stack<Integer> stack = new Stack<>();
	static int length = 3;
	static int stackCount = 0;
	static int storageStackCount = 0;

	public static void pushIntoStack(int value) {
		if (stackCount == length) {
			System.out.println(stack);
			stackStorage.push(stack);
			Stack<Integer> stack = new Stack<>();
			storageStackCount++;
			System.out.println(stack);
		}
		stack.push(value);
		// System.out.println(stack.peek());
		stackCount++;
	}

	public static void popFromStack() {
		if (stack.isEmpty()) {
			stack = stackStorage.pop();
			storageStackCount--;
			System.out.println(stack);
		}
		// System.out.println(stack.pop());
		stackCount--;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// special cases not handled
		// when stackstorage is empty.
		pushIntoStack(5);
		pushIntoStack(1);
		pushIntoStack(7);
		pushIntoStack(4);
		popFromStack();
		pushIntoStack(13);
		popFromStack();
		popFromStack();
		popFromStack();
		popFromStack();

	}

}
