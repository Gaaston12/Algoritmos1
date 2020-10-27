package damas;

public class Pila{
    private Arco[] p;
    private int max;
    private int size;

    public Pila(int n){
        size = 0;
        max = n;
		p = new Arco[max];
        
    }

    public boolean isEmpty (){
        return (size == 0);
    }

    public int getSize(){
        return size;
    }

    public void push(Arco x) throws FullStackException{
        if(size < max){
            this.p[size] = x;  
            size++;
        }
        else
            throw  new FullStackException("Pila llena");
    }

    public void pop() throws EmptyStackException{
        if(size > 0)
            this.size --;
        else
            throw new EmptyStackException("No hay item para extraer");
    } 
    
    public Arco top() throws EmptyStackException{
        if(this.size > 0)
            return this.p[this.size-1];
        else
            throw  new EmptyStackException(" No hay item para mostrar") ;
    }
}