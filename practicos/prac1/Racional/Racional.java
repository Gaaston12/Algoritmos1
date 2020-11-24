public class Racional{
    private Integer num;
    private Integer den;

    public Racional(){
        this.num = 0;
        this.den = 1;
    }

    public Racional(Integer x, Integer y){
        this.num = x;
        this.den = y;
    }

    public Integer getNum(){
        return this.num;
    }

    public Integer getDen(){
        return this.den;
    }

    public void setNum(Integer n){
        this.num = n;
    }

    public void setDen(Integer n){
        this.den = n;
    }

    public Integer mcd (Integer a, Integer b){
        if(b==0)
            return a;
        else
            return mcd(b,  a % b);
    }

    public void reduce (){
        Integer n = this.mcd(this.num, this.den);
        this.num = this.num / n;
        this.den = this.den / n;
    }

    public void add(Racional otro){

        System.out.println(this.num);
        System.out.println(this.den);
        System.out.println("");
        this.num = (this.num * otro.getDen()) + (otro.getNum() + this.den);
        System.out.println("Numerador: "+this.num);
        this.den = this.den * otro.getDen();
        System.out.println("Denominador: "+this.den);
        this.reduce();
    }

    public void sub(Racional otro){
        this.num = (this.num * otro.getDen()) - (otro.getNum() + this.den);
        this.den = this.den * otro.getDen();
        this.reduce();
    }

    @Override
    public String toString(){
        return ("\n" + this.num + "/" + this.den + "\n");
    }
}