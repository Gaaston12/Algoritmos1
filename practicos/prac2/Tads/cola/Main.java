package cola;

public class main {
    
   public static void main(String[] args) {
        ColaEncadenada cola1 = new ColaEncadenada();

        cola1.agregar(4);
        System.out.println(cola1.esVacia());
        System.out.println(cola1.toString());
    }
}
