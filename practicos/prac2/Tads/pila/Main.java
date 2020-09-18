package pila;
public class Main {
    public static void main(String[] args) {

        PilaEncadenada<Integer> pila = new PilaEncadenada<Integer>();

        for(int i = 0; i <= 5; i++){
            pila.apilar(i);
        }
        for(int i = 0; i <= pila.elementos(); i++){
            System.out.println(pila.tope());
            pila.desapilar();
        }
    }
}
