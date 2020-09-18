#ifndef _QUEUE_HPP_
#define _QUEUE_HPP_
#include <string>
/*
 * Interface TAD cola.
 */
template <typename T>
class Queue {
	public:
		virtual ~Queue() {
		}
		/*
		 * Inserta un elemento al final de la cola
		 */
		virtual void enQueue(T value)=0;
		/*
		 * Elimina el elemento del inicio de la cola y
		 * lo devuelve
		 */
		virtual T deQueue()=0;
		/*
		 * Retorna el primer elemento de la cola
		 */
		virtual T getFirstElem()=0;
		/*
		 * Retorna el ultimo elemento de la cola
		 */
		virtual T getLastElem()=0;
		/*
		 * Retorna true ssi la cola esta vacia
		 */
		virtual bool isEmpty()=0;
		/*
		 * Vacia la cola
		 */
		virtual void empty()=0;
		/*
		 * Devuelve un string que representa a la cola
		 */
		virtual std::string toString() = 0;
};
#endif

