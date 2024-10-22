// import org.w3c.dom.Node;

/**
 * A generic queue implementation using a singly linked list.
 *
 * @param <T> the type of elements stored in the queue
 */
public class Queue<T> {
	/** The underlying singly linked list for the queue. */
	SList<T> list = new SList<T>();

	/** Default constructor to initialize an empty queue. */
	Queue() {
	}

	/**
	 * Enqueues an element into the queue.
	 *
	 * @param element the element to enqueue
	 */
	void enqueue(T element) {
		// Exercise 1a
		list.addLast(element);
	}

	/**
	 * Dequeues an element from the queue.
	 *
	 * @return the dequeued element
	 */
	T dequeue() {
		// Exercise 1b
		return list.removeFirst();
	}

	/**
	 * Gets the element at the front of the queue without removing it.
	 *
	 * @return the element at the front of the queue
	 */
	T queuefront() {
		// Exercise 1c
		return list.first.element; 
	}

	/**
	 * Gets the element at the rear of the queue without removing it.
	 *
	 * @return the element at the rear of the queue
	 */
	T queuerear() {
		// Exercise 1d
		return list.last.element; 
	}

	/**
	 * Checks if the queue is empty.
	 *
	 * @return true if the queue is empty, false otherwise
	 */
	boolean isEmpty() {
		return list.isEmpty();
	}

	/**
	 * Creates a copy of this queue.
	 *
	 * @return a new queue containing the same elements as this queue
	 */
	Queue<T> copyQueue() { 
		// Exercise 2
		Queue<T> Q2 = new Queue<T>();
		int size = list.size;
		for (int i = 0; i < size; i++) {
			T tmp = this.dequeue();
			Q2.enqueue(tmp);
			this.enqueue(tmp);
		}
		return Q2;
	}

	/**
	 * Checks if this queue is identical to another queue in terms of content and
	 * sequence.
	 *
	 * @param Q2 the queue to compare with
	 * @return true if the queues are identical, false otherwise
	 */
	boolean isIdentical(Queue<T> Q2) {
		// Exercise 3
		if (list.getSize() != Q2.list.getSize()) {
			return false;
		}

		boolean isIdentical = true;
		int size = Q2.list.size;

		for (int i = 0; i < size; i++) {
			T e1 = Q2.dequeue();
			T e2 = this.dequeue();
			if (e1 != e2) {
				isIdentical = false;
			}
			Q2.enqueue(e1);
			this.enqueue(e2);
		}
		return isIdentical;
	}

	/**
	 * Prints the elements of the queue horizontally. Handles potential
	 * 
	 */
	void printHorizontal() {
		SNode<T> walker = list.first;
		while (walker != null) {
			System.out.print(walker.element + " ");
			walker = walker.next;
		}

	}

	public int getSize() {
		return list.getSize();
	}


}