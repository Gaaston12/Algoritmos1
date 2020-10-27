
package damas;
import java.util.Scanner;
import damas.*;

//Esta clase modela el tablero del juego 
public class Tablero{
    
    private Grafo grafo; 

    public Tablero(int lado) {
        grafo = new Grafo(lado);
    }
    
    public Grafo getGrafo() {
        return this.grafo;
    }

    public void setGrafo(Grafo grafo) {
        this.grafo = grafo;
    }
    
    //Este metodo permite insertar la ficha pasandole como parametro el color y la coodernada de ella
    public void insertarFicha(String color,Par coordenada) throws NullPositionException {
        if (color.equals("blanca"))
           insertarFichaBlanca(coordenada);
        if (color.equals("negra"))
           insertarFichaNegra(coordenada);
    }
    
    //Este metodo permite insertar las fichas blancas pasandole como parametro la coodernada de ella 
    public void insertarFichaBlanca(Par par) throws NullPositionException {
        grafo.insFicha(calcularPos(par), 'b');        
    }

    //Este metodo permite insertar las fichas negras pasandole como parametro la coodernada de ella
    public void insertarFichaNegra(Par coordenada) throws NullPositionException {
        grafo.insFicha(calcularPos(coordenada), 'n');
        grafo.setCantFichasNegras(grafo.getCantFichasNegras()+1);
    }

    // Este metodo devuelve el recorrido  si una ficha blanca gana en un solo movimiento o falso en caso contrario 
    public boolean jugada() throws FullStackException,EmptyStackException,NullPositionException{
        
        return grafo.recorrido();
    }

    //Este metodo permite calcular la posicion en el grafo de la ficha pasandole como parametro la coodernada,
    //en caso de que la posicion no exista, devolvera una excepcion.
    private Integer calcularPos (Par coord) throws NullPositionException{
        if(coord.getX() >= 0 && coord.getY() >= 0 && coord.getX() < grafo.getLado() &&coord.getY() < grafo.getLado())
            return  Par.parToInt(coord,grafo.getLado());  
        else
            throw new NullPositionException("Posicion ("+ coord.getX()+","+coord.getY()+ ") no valida "); 
    }

    //Funcion de abstraccion
    //Este metodo modela el tablero graficamente, en el que las fichas blancas son representadas con "o"
    //y las fichas negras con "x". 
    public String toString (){
        System.out.print("\033[H\033[2J"); // Limpia pantalla
        System.out.flush();
        String ret = "";
        for(int i = 0; i < grafo.getListNodo().length; i++){
            
            if(grafo.getListNodo()[i].getContenido() == 'v')
                ret = ret + "[ ]";
            else if(grafo.getListNodo()[i].getContenido() == 'n')
                ret = ret +"[x]";
            else if(grafo.getListNodo()[i].getContenido() == 'b')
                ret = ret + "[o]";

            if(i%grafo.getLado() == grafo.getLado()-1 && i !=0)
                ret += "\n";
        }
        return ret;
    }
}
   
    
        
