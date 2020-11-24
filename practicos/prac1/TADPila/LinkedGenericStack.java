/**
* GenericStack: abstract definition of stacks
* @author Nahuel Filippa
**/
public class LinkedGenericStack<T> implements GenericStack<T>{
    private GenericLinkable<T> head;

    public LinkedGenericStack(){
        this.head = null;
    }

    public LinkedGenericStack(T elem){
        this.head.setContent(elem);
    }

    public boolean isEmpty(){
        return this.head == null;
    }

    public void push (T elem){
        GenericLinkable<T> node = new GenericLinkable<T>();
        node.setContent(elem);
        node.setNext(head);
        head = node;
    }

    public void pop() throws RuntimeException{
        if (head == null){
            throw new RuntimeException("Stack is empty");
        }
        else{
            head = head.getNext();
        }
    }

    public T top() throws RuntimeException{
        if (head == null){
            throw new RuntimeException("Stack is empty");
        }
        else{
            return head.getContent();
        }
    }

    public void empty(){
        this.head = null;
    }
}