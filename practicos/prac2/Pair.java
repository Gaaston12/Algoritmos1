public class Pair <T>{
    private T value;
    private Integer mult;

    public Pair(T x, Integer n){
        this.value = x;
        this.mult = n;
    }

    public T fst(){
        return this.value;
    }

    public Integer snd(){
        return this.mult;
    }

    public void setFst (T x){
        this.value = x;
    }

    public void setSnd(Integer n){
        this.mult = n;
    }

}