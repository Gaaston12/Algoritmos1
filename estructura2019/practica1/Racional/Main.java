public class Main{
    public static void main(String[] args) {
        Racional numero = new Racional(1,5);
        System.out.println(numero);
        Racional otro = new Racional(2,5);
        System.out.println(otro);
        numero.add(otro);
        System.out.println(numero);

    }
}