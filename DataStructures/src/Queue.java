public class Queue<E extends Comparable<E>> {
	protected Node<E> front;
	private Node<E> back;

	/**
	 * Adds data to the back of the queue
	 * @param data the data to be added
	 */
	void enqueue(E data) {
		if (front == null) {
			back = new Node<E>(data);
			front = back;
		} else {
			back.setNext(new Node<E>(data));
			back = back.getNext();
		}
	}

	/**
	 * Removes data from the front of the queue
	 * @return the data to be removed
	 */
	E dequeue() {
		E data = null;
		if (front != null) {
			data = front.getData();
			front = front.getNext();
		}
		return data;
	}

	/**
	 * Recursively finds the size of the queue
	 * 
	 * @return the size of the queue
	 */
	int size() {
		Node<E> current = front;
		return findSize(current);
	}

	int findSize(Node<E> start) {
		if (start == null)
			return 0;
		return 1 + findSize(start.getNext());
	}

	/**
	 * Prints out the queue
	 */
	public String toString() {

		StringBuilder print = new StringBuilder();
		print.append('[');
		Node<E> current = front;
		while (current != null) {
			print.append(current.getData().toString());
			current = current.getNext();
			if (current != null)
				print.append(',');
		}
		print.append(']');
		return print.toString();

	}
}
