package damas;

import damas.Linkable;

public class LinkedList<E>{

		private Linkable head;

		public LinkedList (){
			head= null;
		} 

		public Linkable<E> getHead(){
			return this.head;
		}

		public E head() throws EmptyStackException{
			if (!esVacia()){
				return (E) head.getNext();
			}
			else{
				throw new EmptyStackException ("La lista esta vacia");	
			}
		}	

		public void insertar (E elem){
			Linkable nodo = new Linkable();
			nodo.setInfo(elem);
			nodo.setNext(head);
			head = nodo; 
			 
		}

		public void eliminar() throws EmptyStackException{
			if (!esVacia()){
				head = head.getNext();	
			}
			else{
				throw new EmptyStackException ("La lista esta vacia");
			}
		}

		public boolean esVacia (){
			return head == null;
		}

	}