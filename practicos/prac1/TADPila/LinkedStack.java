/**
* LinkedStack: stacks implemented using linked lists
* @author Nahuel Filippa
**/
public class LinkedStack implements Pila{
    private Linkable head;
    /**
    * Class constructor
    **/
    public LinkedStack(){
        this.head = null;
    } 
    /**
    * Tells if the stack is empty
    * @return boolean
    **/
    public boolean isEmpty(){
        return this.head == null;
    }
    /**
    * Inserts an element on the top of the stack
    * @param element Object to be pushed into the stack
    **/
    public void push (Object element){
        Linkable linkable = new Linkable(element);
        linkable.setNext(this.head);
        this.head = linkable;
    }
    /**
    * Tells if the stack is empty
    * @throws RuntimeException() if stack is empty
    **/
    public void pop () throws RuntimeException{
        if (head != null){
            this.head = this.head.getNext();
        }
        else {
            throw new RuntimeException ("Stack is empty");
        }
    }

    /**
    * Tells if the stack is empty
    * @return Object in top of the stack
    * @throws RuntimeException() if stack is empty
    **/
    public Object top () throws RuntimeException{
        if (head != null){
            return this.head.getContent();
        }
        else {
            throw new RuntimeException("Stack is empty");
        }
    }
    /**
    * Empties the stack
    **/
    public void empty(){
        this.head = null;
    }
}