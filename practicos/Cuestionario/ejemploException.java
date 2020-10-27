//ejemplo 1
class Division 
{ 
    public static void main(String args[]) 
    { 
        try { 
            int a = 30, b = 0; 
            int c = a/b;  
            System.out.println ("Resultado = " + c); 
        } 
        catch(ArithmeticException e) { 
            System.out.println ("No se puede dividir por 0"); 
        } 
    } 
}
//ejemplo 2
public class EjExc {
    public static void main(String[] args) {
        int nums[]=new int;

        try {
            System.out.println("Antes de que se genere la excepción."); 
            nums=10;
        }catch (ArrayIndexOutOfBoundsException exc){
            System.out.println("Índice fuera de los límites!"); 
        }
        System.out.println("Después de que se genere la excepción.");
    }
}