
public class Dode<E extends Comparable<E>> {
	private Dode<E> next;
	private Dode<E> prev;
	private E data;
	Dode(Dode<E> next, E data){
		this.next = next;
		this.data = data;
	}
	Dode(Dode<E> next)
	{
		this(next, null);
	}
	Dode(E data){
		this(null, data);
	}
	Dode(){
		this(null, null);
	}
	
	
	void setNext(Dode<E> next){
		this.next = next;
	}
	Dode<E> getNext(){
		return next;
	}
	
	void setPrev(Dode<E> prev){
		this.prev = prev;
	}
	Dode<E> getPrev(){
		return prev;
	}
	
	void setData(E data){
		this.data = data;
	}
	E getData(){
		return data;
	}
}
