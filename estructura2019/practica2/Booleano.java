public class Booleano {
    private Integer valor;

    public Booleano(){
        valor = 1;
    }

    public Booleano(Integer n){
        valor = n;
    }

    public Integer see(){
        return this.valor;
    }

    public void not(){
        valor += 1;
    }

    public void and (Booleano otro){
        this.valor *= otro.valor;
    } 

    public void then (Booleano otro){
        otro.not();
        this.and(otro);
        this.not();
    }

    @Override
    public String toString(){
        if (valor % 2 == 0){
            return "False";
        } else {
            return "True";
        }
    }
}