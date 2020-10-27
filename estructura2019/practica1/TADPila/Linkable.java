public class Linkable{
    private Object content;
    private Linkable next;

    public Linkable(){
        this.content = null;
        this.next = null;
    }

    public Linkable (Object x){
        this.content = x;
        this.next = null;
    }

    public Object getContent(){
        return this.content;
    }

    public void setContent (Object content){
        this.content = content;
    }

    public void setNext (Linkable next){
        this.next = next;
    }

    public Linkable getNext (){
        return this.next;
    }

}