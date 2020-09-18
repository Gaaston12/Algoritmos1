package cola;

public interface Cola<T> {

    /**
     * Permite evaluar si la cola no tiene elementos.
     * @return true si la cola esta vacia.
     */
    public boolean esVacia();

    /**
     * Eliminar todos los elementos de la cola.
     */
    public void vaciar();

    /**
     * Agregar elemntos al final de al cola. (Encolar)
     * @param elem el elemento a agregar.
     * @return true si y solo si el encolado se realizo.
     */
    public boolean agregar(T elem);

    /**
     * Elimina el primer elemento en el extremo de salida de la cola, si esta es no vacia.
     * @throws IllegalStateException si la cola esta vacia
     */
    public void eliminar();

    /**
     * Retorna el primer elemento en el extremo de salida, si la cola es no vacia.
     * @return primer elmento de la cola.
     * @throws IllegalStateException si la cola es vacia.
     */
    public T primero();

    /**
     * Retorna la cantidad de elementos de la cola.
     * @return cantidad de elementos de la cola.
     */
    public int longitud();

    /**
     * Metodo para mostrar todos los elementos de la cola.
     * @return Un string que contiene todos los elementos de la cola.
     */
	public String toString();

    /**
     * compara 2 listas
     * @param other
     * @return true si las listas son iguales
     */
    //public boolean equals(T other);
}