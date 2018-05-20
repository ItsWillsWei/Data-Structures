
public class Node<E extends Comparable<E>> {
	private Node<E> next;
	private E data;
	private int priority;
	Node(Node<E> next, E data, int priority){
		this.next = next;
		this.data = data;
		this.priority = priority;
	}
	Node(Node<E> next, int priority){
		this(next, null, priority);
	}
	Node(E data, int priority){
		this(null, data, priority);
	}
	Node(Node<E> next, E data){
		this(next, data, 1);
	}
	Node(Node<E> next)
	{
		this(next, null,1);
	}
	Node(E data){
		this(null, data,1);
	}
	Node(){
		this(null, null,1);
	}
	
	void setPriority(int priority){
		this.priority = priority;
	}
	int getPriority(){
		return priority;
	}
	
	void setNext(Node<E> next){
		this.next = next;
	}
	Node<E> getNext(){
		return next;
	}
	
	void setData(E data){
		this.data = data;
	}
	E getData(){
		return data;
	}
}
