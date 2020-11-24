public class GenericLinkable<T>{
    private T content;
    private GenericLinkable<T> next;

    public GenericLinkable(){
        this.content = null;
        this.next = null;
    }

    public GenericLinkable (T x){
        this.content = x;
        this.next = null;
    }

    public T getContent(){
        return this.content;
    }

    public void setContent (T content){
        this.content = content;
    }

    public void setNext (GenericLinkable<T> next){
        this.next = next;
    }

    public GenericLinkable<T> getNext (){
        return this.next;
    }
}