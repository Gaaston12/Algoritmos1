
/* 
    Este programa determina si es posible capturar todas las piezas negras en un solo turno.
    La entrada consiste en el ancho del tablero (m), una lista de posiciones de piezas blancas y una lista
    de posiciones de piezas negras, correspondientes a un estado del juego.

    Lopez, Matias 40277612
    Filippa, Nahuel 38022379
    Fernandez, Facundo 41593885

*/

package damas;

import java.util.Scanner;
import damas.EmptyStackException;
import damas.FullStackException;
import damas.Pila;
import damas.Tablero;



public class Main{

    public static void main(String[] args) {
        Tablero tablero = new Tablero(10);
        Juego juego = new Juego();
        try {
            
            int op= 0;
            
            do{
                menu();
                System.out.println("Ingrese una opcion");
                Scanner input = new Scanner(System.in);
                op = input.nextInt();
                System.out.print("\033[H\033[2J"); // Limpia pantalla
                System.out.flush();
                switch (op) {
                    case 0:juego.ingresarFichas(); 
                        break;
                    case 1:juego.ejemplo1(); 
                        break;
                    case 2:juego.ejemplo2(); 
                    break;   
                    case 3:juego.ejemplo3(); 
                    break;   
                    case 4:juego.ejemplo4(); 
                    break;   
                    case -1:System.out.println("Salir");
                         break;
                    default:System.out.println("Opcion incorrecta");
                        break;
                }
                
            }while(op != -1);
          
        } catch (Exception e){
            System.out.println(e.getMessage());
        } 

           
    }
    static void menu(){
        System.out.println("\nMenu\n");
        
        System.out.println("Pulse 0 para ingresar fichas manualmente");
        for (int i= 1; i < 5; i++){
            System.out.println("Pulse "+i+" para el ejemplo "+i);
        }
        
        System.out.println("Pulse -1 para salir");
    }
    
}