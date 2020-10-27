// {Nat}, ∅, ins, union}

public interface iBag <S extends Comparable> {

    public void ins (S x);
    public void union (Bag <S> otro);
    public Boolean contains (S x);



}