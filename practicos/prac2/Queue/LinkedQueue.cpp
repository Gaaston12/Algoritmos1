#ifndef _LINKEDQUEUE_HPP_
#define _LINKEDQUEUE_HPP_
#include "Queue.hpp"
template <typename T>
class LinkedQueue : Queue<T>{
	private:
		typedef struct node_t {
			T info;
			node_t* next;
		} node_t;
		typedef node_t* Node;
		Node first;
		Node last;
		int size;
	public:
		//Constructor
		LinkedQueue() {
                        //TODO: Implement
			throw "Method not yet implemented!\n";                        
		}
		//Destructor
		~LinkedQueue() {
			//TODO: Implement
			throw "Method not yet implemented!\n";
		}
		T deQueue() {
			//TODO: Implement
			throw "Method not yet implemented!\n";
		}
		void enQueue(T value) {
			//TODO: Implement
			throw "Method not yet implemented!\n";
		}
		T getFirstElem() {
			//TODO: Implement
			throw "Method not yet implemented!\n";
		}
		T getLastElem() {
			//TODO: Implement
			throw "Method not yet implemented!\n";
		}
		bool isEmpty() {
			//TODO: Implement
			throw "Method not yet implemented!\n";
		}
		void empty() {
			//TODO: Implement
			throw "Method not yet implemented!\n";
		}

		std::string toString() {
			//TODO: Implement
			throw "Method not yet implemented!\n";
		}
};

#endif

