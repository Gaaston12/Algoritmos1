package cola;

import java.util.Collection;

public class ColaEncadenada<T> implements Cola<T> {

	private Nodo<T> raiz;
	private Nodo<T> ulti;
	private int longitud;

	/**
	 * Construye la cola vacia
	 */
	public ColaEncadenada(){
		raiz = null;
		ulti = null;
		longitud = 0;
	}

	/**
	 * Construye la cola a partir de la coleccion de tipo T.
	 * Los elementos se encolas de izquierda a derecha.
	 */
	public ColaEncadenada(Collection<T> elems){
		this();
		if(elems == null) throw new IllegalArgumentException("La coleccion es nula");
		for (T e : elems) {
			agregar(e);
		}
	}

	@Override
	public boolean esVacia(){
		return (this.longitud == 0);
	}

	@Override
	public void vaciar(){
		this.raiz = null;
		this.longitud = 0;
	}
	
	@Override
	public boolean agregar(T elem){
		Nodo<T> nuevoNodo = new Nodo<>(elem, null);
        if(esVacia()) this.raiz = nuevoNodo;
		else this.ulti.setSiguiente(nuevoNodo);
		
        this.ulti = nuevoNodo;
        this.longitud++;
        return true;
	}

	@Override
	public void eliminar(){
		if(esVacia()) throw new IllegalStateException("La cola esta vacia");
		this.raiz = this.raiz.getSiguiente();
	}

	@Override
	public T primero(){
		if( esVacia()) throw new IllegalStateException("La cola esta vacia");
		return this.raiz.getElem();
	}

	@Override
	public int longitud(){
		if( esVacia()) throw new IllegalStateException("La cola esta vacia");
		return this.longitud;
	}

	@Override
	public String toString() {
		String texto = null;
		for(int i = 0; i<= this.longitud; i++){
			texto = " " + this.raiz.getElem();
			this.raiz = this.raiz.getSiguiente();
		}
		return texto;
	}

	/*@Override
    public boolean equals(T other){
        if (other == this) return true;
		if (other == null) return false;
		if(this.longitud() != other.longitud()) return false; 
        if (other.getClass() != this.getClass()) return false;
        return (this.raiz.getElem() == other.getElem());
    }*/
}


