public class PriorityQueue<E extends Comparable<E>> extends Queue<E> {

	/**
	 * Adds an item to a queue based on priority
	 * 
	 * @param data
	 *            the item to be added to the queue
	 * @param priority
	 *            the priority of the item
	 */
	void enqueue(E data, int priority) {
		Node<E> current = front;
		if (current == null) {
			front = new Node<E>(data, priority);
		} else {
			Node<E> next = new Node<E>(data, priority);
			//If the item must be placed at the beginning of the queue
			if (priority > current.getPriority()) {
				next.setNext(front);
				front = next;
			} else {
				// While the current item is not the last item AND the next item
				// is
				// a higher or equal priority
				while (current.getNext() != null
						&& current.getNext().getPriority() >= priority) {
					current = current.getNext();
				}
				// If the current item is the last item
				if (current.getNext() != null)
					next.setNext(current.getNext());
				current.setNext(next);
			}
		}
	}

	/**
	 * Adding items with no priority defaults priority to 1
	 */
	void enqueue(E data) {
		enqueue(data, 1);
	}
}
