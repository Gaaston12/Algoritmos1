
package damas;

import damas.EmptyStackException;
import damas.FullStackException;
import damas.LinkedList;
import damas.Par;
import damas.Tablero;
import java.util.Scanner;

public class Juego{

    //Constructor de la clase
    public Juego() {} 

    //Este metodo inserta todas las fichas blancas en el tablero
    public void insertarFichasBlancas(LinkedList<Par> blancas, Tablero tablero) throws NullPositionException{
        Linkable<Par> cursor ;
        cursor = blancas.getHead();
        while (cursor != null){
            tablero.insertarFichaBlanca(cursor.getInfo());
            cursor = cursor.getNext();
        }
    }

    //Este metodo inserta todas las fichas negras en el tablero
    public void  insertarFichasNegras(LinkedList<Par> negras, Tablero tablero) throws NullPositionException{
        Linkable<Par> cursor ;
        cursor = negras.getHead();
        while (cursor != null){
            tablero.insertarFichaNegra(cursor.getInfo());
            cursor = cursor.getNext();
        }
    }

    //Este metodo toma el ancho del tablero, una lista de posiciones de fichas blancas y otra lista 
    //de posiciones de fichas negras, crea el tablero, inserta todas las fichas ingresadas
    //y devuelve true si existe alguna ficha blanca que pueda ganar en un solo movimiento.
    //De lo contrario retorna false
    public boolean jugadaGanadora(int ancho, LinkedList<Par> blancas, LinkedList<Par> negras) throws NullPositionException, FullStackException, EmptyStackException{
        Tablero tablero = new Tablero(ancho);
        insertarFichasBlancas(blancas, tablero);
        insertarFichasNegras(negras, tablero);
        System.out.println(tablero);
        return tablero.jugada();
        
    }

    // Este ejemplo tiene 2 caminos posibles 
    public void ejemplo1() throws NullPositionException, FullStackException, EmptyStackException{
        LinkedList<Par> blancas = new LinkedList<Par>();
        LinkedList<Par> negras = new LinkedList<Par>();
        blancas.insertar(new Par(9,0));
        blancas.insertar(new Par(3,8));
        blancas.insertar(new Par(4,5));
        
        negras.insertar(new Par(2,3));
        negras.insertar(new Par(2,5));
        negras.insertar(new Par(4,1));
        negras.insertar(new Par(4,3));
        negras.insertar(new Par(4,7));
        negras.insertar(new Par(6,1));
        negras.insertar(new Par(6,3));
        negras.insertar(new Par(6,7));
        negras.insertar(new Par(8,1));
        negras.insertar(new Par(8,3));
        negras.insertar(new Par(8,5));

        System.out.println("Hay camino: "+jugadaGanadora(10, blancas, negras));
    }
    
    //Este ejemplo no tiene caminos posibles
    public void ejemplo2() throws NullPositionException, FullStackException, EmptyStackException{
        LinkedList<Par> blancas = new LinkedList<Par>();
        LinkedList<Par> negras = new LinkedList<Par>();
        blancas.insertar(new Par(7,0));
        blancas.insertar(new Par(1,2));
        negras.insertar(new Par(2,7));
        negras.insertar(new Par(4,5));
        negras.insertar(new Par(4,3));
        negras.insertar(new Par(4,1));
        negras.insertar(new Par(6,1));
        negras.insertar(new Par(6,3));
        negras.insertar(new Par(6,5));
        System.out.println("Hay camino: "+jugadaGanadora(8, blancas, negras));
    }

    // Este ejemplo no tiene caminos posibles
    public void ejemplo3() throws NullPositionException, FullStackException, EmptyStackException{
        LinkedList<Par> blancas = new LinkedList<Par>();
        LinkedList<Par> negras = new LinkedList<Par>();
        blancas.insertar(new Par(7,0));
        blancas.insertar(new Par(5,8));
        blancas.insertar(new Par(1,1));
        negras.insertar(new Par(6,3));
        negras.insertar(new Par(6,5));
        negras.insertar(new Par(4,1));
        negras.insertar(new Par(4,3));
        negras.insertar(new Par(2,2));
        negras.insertar(new Par(2,7));
        negras.insertar(new Par(1,4));
        System.out.println("Hay camino: "+jugadaGanadora(9, blancas, negras));
    }

    //Este ejemplo tiene un camino posible
    public void ejemplo4() throws NullPositionException, FullStackException, EmptyStackException{
        LinkedList<Par> blancas = new LinkedList<Par>();
        LinkedList<Par> negras = new LinkedList<Par>();
        blancas.insertar(new Par(2,2));
        negras.insertar(new Par(1,3));
        negras.insertar(new Par(1,5));
        negras.insertar(new Par(3,3));
        negras.insertar(new Par(3,5));
        System.out.println("Hay camino: "+jugadaGanadora(8, blancas, negras));
        
    }

    //Este metodo permite elegir el ancho del tablero, e ingresar las fichas para el ejemplo
    public void ingresarFichas() throws NullPositionException, FullStackException, EmptyStackException{
        LinkedList<Par> blancas = new LinkedList<Par>();
        LinkedList<Par> negras = new LinkedList<Par>();
        Scanner input = new Scanner(System.in);
        int x = 0;
        int y = 0;
        
        int ancho;
        do{
            System.out.println("Ingrese el ancho del tablero (al menos 3)");
            ancho = input.nextInt();
            System.out.print("\033[H\033[2J"); // Limpia pantalla
            System.out.flush();
        }while(ancho < 3);

        System.out.println("Ingrese la cantidad de fichas blancas");
        int cant = input.nextInt();
        for(int i = 0; i < cant; i++){
            System.out.println("Ingrese coordenada X de la ficha blanca numero " +(i+1));
            x = input.nextInt();
            
            System.out.println("Ingrese coordenada Y de la ficha blanca numero " +(i+1));
            y = input.nextInt();
            blancas.insertar(new Par(x,y));
            System.out.print("\033[H\033[2J"); // Limpia pantalla
            System.out.flush();
        }
        System.out.println("Ingrese la cantidad de fichas negras");
        cant = input.nextInt();
        for(int i = 0; i < cant; i++){
            System.out.println("Ingrese coordenada X de la ficha negra numero " +(i+1));
            x = input.nextInt();
            System.out.println("Ingrese coordenada Y de la ficha negra numero " +(i+1));
            y = input.nextInt();
            negras.insertar(new Par(x,y));
            System.out.print("\033[H\033[2J"); // Limpia pantalla
            System.out.flush();
        }
        System.out.println("Hay camino: "+jugadaGanadora(ancho, blancas, negras));
    }
}