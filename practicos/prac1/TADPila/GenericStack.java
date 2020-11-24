/**
* GenericStack: abstract definition of stacks
* @author Nahuel Filippa
**/
public interface GenericStack<T> {
    /**
    * Tells if the stack is empty
    * @return boolean
    **/
    public boolean isEmpty();

    /**
    * Inserts a element into the stack
    * @param element the new element to be inserted
    **/
    public void push(T element);
    
    /**
    * Deletes the element in the top of the stack
    **/
    public void pop() throws RuntimeException;

    /**
    * @return the element in the top of the stack
    **/
    public T top() throws RuntimeException;

    /**
    * Empties the stack 
    **/
    public void empty();
} 