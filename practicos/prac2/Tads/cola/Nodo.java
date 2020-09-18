package cola;


public class Nodo<T> {

	private T elem;
	private Nodo<T> sig;

	public Nodo(T elem) {
		this(elem, null);
	}

	public Nodo(T elem, Nodo<T> siguiente) {
		this.elem = elem;
		this.sig = siguiente;
	}

	public T getElem() {
		return elem;
	}

	public Nodo<T> getSiguiente() {
		return sig;	
	}

	public void setElem(T elem) {
		this.elem = elem;	
	}

	public void setSiguiente(Nodo<T> siguiente) {
		this.sig = siguiente;	
	}

}