public class ArrayStack implements Pila{
    private Object[] stack;
    private int top;
    private int max;

    /**
    * default constructor of the class
    **/
    public ArrayStack(){
        this.stack = new Object[100];
        this.top = -1;
        this.max = 99;
    }
    /**
    * Another constructor for the class
    * @param n length of the array for the stack
    **/
    public ArrayStack (int n){
        this.stack = new Object[n];
        this.top = -1;
        this.max = n-1;
    }

    /**
    * Tells if the Stack is empty
    * @return boolean
    **/
    public boolean isEmpty(){
        return (this.top == -1);
    }

    /**
    * Inserts an element in the top of the stack
    * @param element the Object to insert
    * @throws RuntimeException() tells if the stack is full
    **/
    public void push(Object element){
        if (this.top == this.max){
            throw new RuntimeException ("Stack is full");
        }
        else{
            this.top++;
            this.stack[this.top] = element;
        }
    }

    /**
    * Deletes the element in the top of the stack
    * @throws RuntimeException() tells if the stack is empty
    **/
    public void pop() throws RuntimeException{
        if(this.top <= -1){
            throw new RuntimeException ("Stack is empty");
        }
        else {
            this.top--;
        }
    }

    /**
    * Inserts an element in the top of the stack
    * @return the object in the top of the stack
    * @throws RuntimeException() tells if the stack is empty
    **/
    public Object top() throws RuntimeException{
        if(this.top <= -1){
            throw new RuntimeException ("Stack is empty");
        }
        else{
            return this.stack[this.top];
        }
    }

    /**
    * Inserts an element in the top of the stack
    * empties the list
    **/
    public void empty(){
        this.top = -1;
    }
}