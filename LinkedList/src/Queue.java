public class Queue {

	private int front;

	private int rear;

	int size;

	int[] queue;

	public Queue(int inSize) {

		size = inSize;

		queue = new int[size];

		front = -1;

		rear = -1;

	}

	public void enqueue(int val) {

		if ((rear + 1) % size == front) {

			throw new IllegalStateException("Queue is fill");

		} else if (isEmpty()) {

			front++;

			rear++;

			queue[rear] = val;

		} else {

			rear = (rear + 1) % size;

			queue[rear] = val;

		}

	}

	public int dequeue() {

		int val1 = 0;

		if (isEmpty()) {

			throw new IllegalStateException("Queue is Empty");

		} else if (front == rear) {

			val1 = queue[front];

			front = -1;

			rear = -1;

		} else {

			val1 = queue[front];

			front = (front + 1) % size;

		}

		return val1;

	}

	public boolean isEmpty() {

		return (front == -1 && rear == -1);

	}

}