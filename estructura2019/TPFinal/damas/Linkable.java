package damas;
public class Linkable<E>{

	private E info;
	private Linkable next;

	public Linkable (){
		info = null;
		next = null;
	}

	public E getInfo() {
		return this.info;
	}

	public void setInfo(E info) {
		this.info = info;
	}

	public Linkable getNext() {
		return this.next;
	}

	public void setNext(Linkable next) {
		this.next = next;
	}
	
}	

	