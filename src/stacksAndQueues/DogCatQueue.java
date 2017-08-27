package stacksAndQueues;

import java.util.LinkedList;
import java.util.Queue;
public class DogCatQueue {
	static Queue queueA = new LinkedList();

	public static void enQueue(String value) {
		if(value.equals("dog")) {
			queueA.add(1);
		}
		else {
			queueA.add(0);
		}
	}
	public static void deQueueAny() {
		queueA.remove();
	}
	public void deQueueCat() {
		queueA.remove(0);
	}
	public void deQueueDog() {
		queueA.remove(1);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//can keep counter to differentiate which element is removed or added
//		queueA.add(1);
//		queueA.add(0);
//		queueA.add(1);
//		queueA.add(0);
//		queueA.add(0);
//		queueA.remove(1);
		enQueue("dog");

	}

}
