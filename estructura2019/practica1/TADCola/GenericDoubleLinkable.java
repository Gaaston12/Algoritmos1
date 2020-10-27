public class GenericDoubleLinkable<T>{
    private T content;
    private GenericDoubleLinkable<T> next;
    private GenericDoubleLinkable<T> back;

    public GenericDoubleLinkable(){
        this.content = null;
        this.next = null;
        this.back = null;
    }

    public GenericDoubleLinkable(T x){
        this.content = x;
        this.next = null;
        this.back = null;
    }

    public void setContent(T x){
        this.content(x);
    }

    public T getContent(){
        return this.content;
    }

    public void setNext(GenericDoubleLinkable<T> x){
        this.next = x;
    }

    public GenericDoubleLinkable<T> getNext(){
        return this.next;
    }

    public void setBack(GenericDoubleLinkable<T> x){
        this.back = x;
    }

    public GenericDoubleLinkable<T> getBack(){
        return this.back;
    }


}