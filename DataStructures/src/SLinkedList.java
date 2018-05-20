/**
 * A list where new items are added to the end
 * 
 * @author Will
 *
 */
public class SLinkedList<E extends Comparable<E>> {
	Node<E> head;

	/**
	 * Adds an item to the end of the list
	 * 
	 * @param item
	 *            the item to be added
	 */
	void add(E item) {
		if (head == null) {
			head = new Node<E>(item);
		} else {
			Node<E> current = head;
			// Traverse to the last Node
			while (current.getNext() != null) {
				current = current.getNext();
			}
			current.setNext(new Node<E>(item));
		}
	}

	/**
	 * Gets the element at the provided index
	 * 
	 * @param index
	 *            the specified index
	 * @return the item stored by the Node
	 */
	E get(int index) {
		// Return null if there is no list or if the index is out of bounds
		if (head == null || index < 0 || index >= size())
			return null;
		else {
			Node<E> current = head;
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
			Node<E> current = head;
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
	 * Removes the Node at the provided index
	 * 
	 * @param index
	 *            the specified index
	 * @return the data stored by the removed Node
	 */
	E remove(int index) {
		if (head == null || index >= size())
			return null;
		E temp = null;
		Node<E> current = head;
		if (index == 0) {
			temp = current.getData();
			// Removes the first item (works with 1 item and more)
			head = head.getNext();
		} else {
			// Removing items 1+
			for (int position = 0; position < index - 1; position++)
				current = current.getNext();
			temp = current.getNext().getData();
			current.setNext(current.getNext().getNext());
		}
		return temp;
	}

	/**
	 * Removes the first Node with the given item
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
	 * @return the total number of Nodes
	 */
	int size() {
		Node<E> current = head;
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
	 * @return the total number of Nodes
	 */
	int sizeR() {
		Node<E> current = head;
		return findSize(current);
	}

	int findSize(Node<E> start) {
		if (start == null)
			return 0;
		return 1 + findSize(start.getNext());
	}
	
	public String toString(){
		StringBuilder print = new StringBuilder();
		print.append('[');
		for(int node = 0; node < size(); node++){
			print.append(get(node).toString());
			if(node != size()-1)
				print.append(',');
		}
		print.append(']');
		return print.toString();
	}
}
