import javax.naming.NameNotFoundException;

public class binNode <T extends Comparable>{
    private T content; 
    private binNode<T> hi;
    private binNode<T> hd;

    public binNode(T x){
        content = x;
        hi = null;
        hd = null;
    }

    public void setHI(binNode<T> x){
        hi = x;
    }

    public void setHD(binNode<T> x){
        hd = x;
    }

    public binNode<T> getHI(){
        return hi;
    }

    public binNode<T> getHD(){
        return hd;
    }

    public T getContent(){
        return content;
    }

    public void setContent(T x){
        content = x;
    }

    public Boolean belongs(T x){
        if(content.compareTo(x) == 0){
            return true;
        }
        else{
            if(content.compareTo(x) > 0 && this.hi != null){
                return this.hi.belongs(x);
            }
            if(content.compareTo(x) < 0 && this.hd != null){
                return this.hd.belongs(x);
            }
        }
        return false;
    }

    public void insert (T x){

        if (this.content.compareTo(x) > 0 && this.hi != null){
            this.hi.insert(x);
        }
        if (this.content.compareTo(x) < 0 && this.hd != null){
            this.hd.insert(x);
        }
        if (this.content.compareTo(x) != 0){
            binNode<T> node = new binNode<T>(x);
            if(this.content.compareTo(x) > 0 && this.hi == null){
                this.hi = node;
            }
            if(this.getContent().compareTo(x) < 0 && this.hd == null){
                this.hd = node;
            }
        }

    }

    public void inOrder(){
        if (hi != null){
            hi.inOrder();
        }
        System.out.print(content);
        if(hd != null){
            hd.inOrder();
        }
    }

    public void preOrder(){
        System.out.print(content);
        if (hi != null){
            hi.preOrder();
        }
        if(hd != null){
            hd.preOrder();
        }
    }

    private binNode<T> maxOfTree(){
        if(this.hd == null){
            return this;
        }
        else{
            return this.hd.maxOfTree();
        }
    }

    private binNode<T> minOfTree(){
        if(this.hi == null){
            return this;
        }
        else{
            return this.hi.maxOfTree();
        }
    }

    private Boolean isLeaf(){
        return this.hi == null && this.hd == null;
    }

    public binNode<T> find(T x) throws RuntimeException{
        if(this.content.compareTo(x) == 0){
            return this;
        }else if(this.content.compareTo(x) < 0 && this.hd != null){
            return this.hd.find(x);
        }else if(this.content.compareTo(x) > 0 && this.hi != null){
            return this.hi.find(x);
        }else{
            return null;
        }
    }

    public void delete(T x){
        binNode<T> cursor = this.find(x);
        binNode<T> padre = this;
        binNode<T> aux = null;
        T minMax;

        if(cursor.isLeaf()){
            while(padre.getHD() != cursor && padre.getHI() != cursor){
                if(cursor.getContent().compareTo(padre.getContent()) < 0){
                    padre = padre.getHI();
                }else if(cursor.getContent().compareTo(padre.getContent()) > 0){
                    padre = padre.getHD();
                }
            }
            if(padre.getHD() == cursor){
                padre.setHD(null);
            }
            else if(padre.getHI() == cursor){
                padre.setHI(null);
            }
        }
        else{
            if(cursor.getHD() != null){
                aux = cursor.getHD().minOfTree();
                System.out.println(aux.getContent());
            }
            else if(cursor.getHI() != null){
                aux = cursor.getHI().maxOfTree();
                System.out.println(aux.getContent());

            }
            minMax = aux.getContent();
            cursor.delete(aux.getContent());
            cursor.setContent(aux.getContent());
        }

        
    }
}