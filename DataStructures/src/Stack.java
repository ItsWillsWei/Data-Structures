
public class Stack<E extends Comparable<E>> {
	private Node<E> top;
	
	/**
	 * Pushes an item onto the stack
	 * @param data the data to be added
	 */
	void push(E data){
		if(top != null){
			Node<E> next = top;
			top = new Node<E>(next, data);
		}
		else
			top = new Node<E>(data);
	}
	
	/**
	 * Pops the top item off of the stack
	 * @return the first item
	 */
	E pop(){
		E data = null;
		if(top != null){
			data = top.getData();
			top = top.getNext();
		}
		return data;
	}
	
	/**
	 * Recursively finds the size of the stack
	 * @return the size of the stack
	 */
	int size(){
		Node<E> current = top;
		return findSize(current);
	}
	int findSize(Node<E> start){
		if(start == null)
			return 0;
		return 1+findSize(start.getNext());
	}
	
	/**
	 * Prints out the stack
	 */
	public String toString(){
		
			StringBuilder print = new StringBuilder();
			print.append('[');
			Node<E> current = top;
			while(current != null){
				print.append(current.getData().toString());
				current = current.getNext();
				if(current != null)
					print.append(',');
			}
			print.append(']');
			return print.toString();
		
	}

}
