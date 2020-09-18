package pila;

public interface Pila<T> {

	/**
	* Retorna el tope de la pila, si ésta no es vacía.
	* @return tope de la pila
	* @throws IllegalStateException si la pila está vacía
	* @see #esVacia()
	*/
	public T tope();

	/**
	* Permite evaluar si la pila no tiene elementos.
	* @return {@code true} sii la pila no tiene elementos
	*/
	public boolean esVacia();

	/**
	* Apila un elemento en el tope de la pila.
	* @param elem el elemento a apilar
	* @return {@code true} sii el elemento pudo ser apilado
	*/
	public boolean apilar(T elem);

	/**
	* Desapila el tope de la pila, y retorna el elemento desapilado, si ésta no es vacía.
	* @return tope de la pila
	* @throws IllegalStateException si la pila está vacía
	* @see #esVacia()
	*/
	public T desapilar();
	
	/**
	* @return cantidad de elementos en la pila.
	*/
	public int elementos();

	/**
	* Remueve todos los elementos en la pila.
	*/
	public void vaciar();

	/**
	* Invariante de clase.
	* @return {@code true} sii la pila satisface su invariante de clase
	*/
	public boolean repOK();

	@Override
	public String toString();

	@Override
	public boolean equals(Object other);

}
