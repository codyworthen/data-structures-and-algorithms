package queues;

/**
 * An array-based implementation of Queue. Memory usage is O(1) and time
 * complexity of all operations is O(1). Once instantiated, the size cannot be
 * changed. Default size is 1,000 unless otherwise specified.
 * 
 * @author Cody Worthen
 * @param <E>
 */
public class ArrayQueue<E> implements Queue<E> {

	private E[] data; // generic array used for storage
	private int front = 0; // index of the front element
	private int elementCount = 0; // current number of elements
	public static final int CAPACITY = 1000; // default array capacity

	public ArrayQueue() {
		this(CAPACITY);
	}

	public ArrayQueue(int capacity) {
		data = (E[]) new Object[capacity];
	}

	public int size() {
		return elementCount;
	}

	public boolean isEmpty() {
		return elementCount == 0;
	}

	public void enqueue(E element) {
		if (elementCount == data.length) {
			throw new IllegalStateException("Queue is full");
		}
		int available = (front + elementCount) % data.length;
		data[available] = element;
		elementCount++;
	}

	public E first() {
		if (isEmpty()) {
			return null;
		}
		return data[front];
	}

	public E dequeue() {
		if (isEmpty()) {
			return null;
		}
		E elementToDequeue = data[front];
		data[front] = null;
		front = (front + 1) % data.length;
		elementCount--;
		return elementToDequeue;
	}

}
