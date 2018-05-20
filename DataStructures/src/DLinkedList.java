/**
 * A list where new items are added to the end
 * 
 * @author Will
 *
 */
public class DLinkedList<E extends Comparable<E>> {
	Dode<E> head;
	Dode<E> tail;

	/**
	 * DODE Adds an item to the end of the list
	 * 
	 * @param item
	 *            the item to be added
	 */
	void add(E item) {
		if (head == null) {
			head = new Dode<E>(item);
			tail = head;
		} else {
			Dode<E> current = head;
			// Traverse to the last Dode
			while (current.getNext() != null) {
				current = current.getNext();
			}
			tail = new Dode<E>(item);
			current.setNext(tail);
			tail.setPrev(current);
		}
	}

	/**
	 * Gets the element at the provided index
	 * 
	 * @param index
	 *            the specified index
	 * @return the item stored by the Dode
	 */
	E get(int index) {
		// Return null if there is no list or if the index is out of bounds
		if (head == null || index < 0 || index >= size())
			return null;
		else {
			Dode<E> current = head;
			// Traverse to the index
			for (int position = 0; position < index; position++)
				current = current.getNext();
			return current.getData();
		}
	}

	/**
	 * Gets the index of the provided item
	 * 
	 * @param item
	 *            the specified item
	 * @return the index of the item
	 */
	int indexOf(E item) {
		if (head == null)
			return -1;
		else {
			int index = 0;
			Dode<E> current = head;
			while (current != null) {
				if (current.getData().compareTo(item) == 0)
					return index;
				else {
					current = current.getNext();
					index++;
				}
			}
			return -1;
		}
	}

	/**
	 * DODE Gets the first item
	 * 
	 * @return the first item
	 */
	E getFirst() {
		return (head == null ? null : head.getData());
	}

	/**
	 * DODE Gets the last item
	 * 
	 * @return the last item
	 */
	E getLast() {
		return (tail == null ? null : tail.getData());
	}

	/**
	 * DODE Removes the Dode at the provided index
	 * 
	 * @param index
	 *            the specified index
	 * @return the data stored by the removed Dode
	 */
	E remove(int index) {
		if (head == null || index >= size())
			return null;
		E temp = null;
		Dode<E> current = head;
		if (index == 0) {
			temp = current.getData();
			// Removes the first item (works with 1 item and more)
			head = head.getNext();
			if (size() == 1) {
				tail = tail.getPrev();
			} else {
				head.setPrev(null);
			}
		} else if (index == size() - 1) {
			temp = tail.getData();
			tail = tail.getPrev();
			if (size() == 1) {
				head = head.getNext();
			} else {
				tail.setNext(null);
			}
		} else {

			// Removing items 1+
			for (int position = 0; position < index - 1; position++)
				current = current.getNext();
			temp = current.getNext().getData();
			current.setNext(current.getNext().getNext());
			current.getNext().setPrev(current);
		}
		return temp;
	}

	/**
	 * Removes the first Dode with the given item
	 * 
	 * @param item
	 *            the specified item
	 * @return whether the item has been removed
	 */
	boolean remove(E item) {
		int index = indexOf(item);
		if (index == -1)
			return false;
		else {
			remove(index);
			return true;
		}
	}

	/**
	 * Clears the list
	 */
	void clear() {
		head = null;
	}

	/**
	 * Counts the number of elements in the list
	 * 
	 * @return the total number of Dodes
	 */
	int size() {
		Dode<E> current = head;
		int counter = 0;
		while (current != null) {
			current = current.getNext();
			counter++;
		}
		return counter;
	}

	/**
	 * Recursively counts the number of elements in the list
	 * 
	 * @return the total number of Dodes
	 */
	int sizeR() {
		Dode<E> current = head;
		return findSize(current);
	}

	int findSize(Dode<E> start) {
		if (start == null)
			return 0;
		return 1 + findSize(start.getNext());
	}

	public String toString() {
		StringBuilder print = new StringBuilder();
		print.append('[');
		for (int Dode = 0; Dode < size(); Dode++) {
			print.append(get(Dode).toString());
			if (Dode != size() - 1)
				print.append(',');
		}
		print.append(']');
		return print.toString();
	}
}
