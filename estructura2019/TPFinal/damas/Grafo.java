package damas;

import damas.Arco;
import damas.EmptyStackException;
import damas.Nodo;
import damas.NullPositionException;

//Esta clase es la implementacion de un tablero de damas, sus fichas y sus posibles movimientos
public class Grafo {
  private Nodo[] listNodo; //Arreglo que contiene los nodos del grafo
  private Integer cantFichasNegras; //Contador de las fichas negras guardadas en el grafo
  private Integer lado; //Medida de ancho y largo de tablero implementado por el grafo

  //Constructor de la clase
  public Grafo(Integer lado) { 
    listNodo = crearlistNodo(lado);
    this.cantFichasNegras = 0;
    this.lado = lado;
  }

  //Getters y setters
  public void setListNodo(Nodo[] listNodo) {
    this.listNodo = listNodo;
  }

  public Nodo[] getListNodo() {
    return this.listNodo;
  }

  public void setCantFichasNegras(Integer cantFichasNegras) {
    this.cantFichasNegras = cantFichasNegras;
  }

  public Integer getCantFichasNegras() {
    return this.cantFichasNegras;
  }

  public void setLado(Integer lado){
    this.lado = lado;
  }

  public Integer getLado() {
    return this.lado;
  }
 
  //Este metodo inserta una ficha y calcula sus arcos usando calcularArcos(int x)
  public void insFicha(Integer pos, char contenido)  {
    
    if (pos <  listNodo.length && pos >= 0) {
      if (listNodo[pos].getContenido() == 'v') {
        listNodo[pos].setContenido(contenido);
        listNodo[pos].setPos(pos);
      }
      if(listNodo[pos].getContenido() == 'b'){
        calcularArcos(pos);
        //System.out.println("cursor:"+ listNodo[pos].getAdyacentes().getPos());
      }
    } 
  }

  //Este metodo mapea movimiento() para todas las fichas blancas del arreglo 
  public boolean recorrido() throws FullStackException, EmptyStackException  {
    boolean res = false;
    Pila p = new Pila (cantFichasNegras);

    for (int i = 0; i < lado*lado; i++){
      if (listNodo[i].getContenido()=='b'){
        res = res || movimiento(i,i,p,cantFichasNegras,false);
       // System.out.println("ficha: "+i+" res ="+res);
      }
      if (res == true){
        mostrarJugada(p, i); // Metodo para testear
        return res;
      }
    }
    return res;
  }
  
  // Metodo para testing
  public void mostrarJugada(Pila p,int fichaBlanca)throws FullStackException, EmptyStackException {
    Pila camino = new Pila(p.getSize());
    int x;
    int y;
    for(int i = p.getSize() ; i > 0;i--){
      camino.push(p.top());
      p.pop();
    }
    
    System.out.println("Camino:  ");
    
    x=Par.intToPar(lado, fichaBlanca).getX();
    y = Par.intToPar(lado,fichaBlanca).getY();
    
    System.out.print("("+ x +","+ y +") ");
    
    for(int j = camino.getSize(); j > 0; j--){
      x = Par.intToPar(lado, camino.top().getSaltoComida()).getX();
      y = Par.intToPar(lado,camino.top().getSaltoComida()).getY();
    
      System.out.print("--> ("+ x +","+ y +") ");
      camino.pop();
    }
    System.out.println("\n");
  }
  
  //Metodo auxiliar para el constructor
  private Nodo[] crearlistNodo(Integer lado) {
    int size = lado * lado;
    Nodo nodo[] = new Nodo[size];
    
    for (int i = 0; i < nodo.length; i++) 
      nodo[i] = new Nodo(i,'v');  
   
    return nodo;
  }
       
  //Este metodo recorre todos los caminos posibles para una unica ficha blanca, hasta encontrar
  //uno que sea ganador y retornar true o hasta agotar los caminos y retornar false. 
  private boolean movimiento(Integer fichaInicial ,Integer ficha, Pila pila, int cantFichasNegras, boolean resultado) throws FullStackException, EmptyStackException{
    Arco aux = listNodo[ficha].getAdyacentes();
    while (aux != null) {
      if (aux.getSaltoComida() != -1) {
        Nodo fichaVecina = listNodo[aux.getPos()];
        Nodo casillaSalto = listNodo[aux.getSaltoComida()];
        if (fichaVecina.getContenido() == 'n' && (casillaSalto.getContenido() == 'v' || casillaSalto.getPos() == fichaInicial)&& fichaVecina.getComida() == false) {
          //System.out.println("Entra");
          calcularArcos(casillaSalto.getPos());
          fichaVecina.setComida(true);
          pila.push(aux);
          resultado = pila.getSize() == cantFichasNegras || movimiento(fichaInicial, casillaSalto.getPos(), pila,cantFichasNegras,resultado);
          if (resultado)
            return resultado;  

          listNodo[pila.top().getPos()].setComida(false);
          pila.pop();
        }
      }
      aux = aux.getNext();
    }
    return resultado;
  }
  
  //Este metodo calcula los arcos para una casilla en particular del grafo
  private void calcularArcos(Integer casilla) {
    // Chequeo de las esquinas
    if (esqSupIzq(casilla)) {
      insertarArco(casilla, vecinoInfDer(casilla), saltoInfDer(casilla));
    } else if (esqSupDer(casilla)) {
      insertarArco(casilla, vecinoInfIzq(casilla), saltoInfIzq(casilla));
    } else if (esqInfIzq(casilla)) {
      insertarArco(casilla, vecinoSupDer(casilla), saltoSupDer(casilla));
    } else if (esqInfDer(casilla)) {
      insertarArco(casilla, vecinoSupIzq(casilla), saltoSupIzq(casilla));
    }
    // Chequeo de los bordes
    else if (bordeSup(casilla)) {
      if (isBorder(vecinoInfIzq(casilla))) {
        insertarArco(casilla, vecinoInfIzq(casilla), -1);
      } else {
        insertarArco(casilla, vecinoInfIzq(casilla), saltoInfIzq(casilla));
      }
      if (isBorder(vecinoInfDer(casilla))) {
        insertarArco(casilla, vecinoInfDer(casilla), -1);
      } else {
        insertarArco(casilla, vecinoInfDer(casilla), saltoInfDer(casilla));
      }
    } else if (bordeInf(casilla)) {
      if (isBorder(vecinoSupIzq(casilla))) {
        insertarArco(casilla, vecinoSupIzq(casilla), -1);
      } else {
        insertarArco(casilla, vecinoSupIzq(casilla), saltoSupIzq(casilla));
      }
      if (isBorder(vecinoSupDer(casilla))) {
        insertarArco(casilla, vecinoSupDer(casilla), -1);
      } else {
        insertarArco(casilla, vecinoSupDer(casilla), saltoSupDer(casilla));
      }
    } else if (bordeDer(casilla)) {
      if (isBorder(vecinoSupIzq(casilla))) {
        insertarArco(casilla, vecinoSupIzq(casilla), -1);
      } else {
        insertarArco(casilla, vecinoSupIzq(casilla), saltoSupIzq(casilla));
      }
      if (isBorder(vecinoInfIzq(casilla))) {
        insertarArco(casilla, vecinoInfIzq(casilla), -1);
      } else {
        insertarArco(casilla, vecinoInfIzq(casilla), saltoInfIzq(casilla));
      }
    } else if (bordeIzq(casilla)) {
      if (isBorder(vecinoInfDer(casilla))) {
        insertarArco(casilla, vecinoInfDer(casilla), -1);
      } else {
        insertarArco(casilla, vecinoInfDer(casilla), saltoInfDer(casilla));
      }
      if (isBorder(vecinoSupDer(casilla))) {
        insertarArco(casilla, vecinoSupDer(casilla), -1);
      } else {
        insertarArco(casilla, vecinoSupDer(casilla), saltoSupDer(casilla));
      }
    }
    // Chequeo para nodos internos
    else {
      if (isBorder(vecinoInfIzq(casilla))) {
        insertarArco(casilla, vecinoInfIzq(casilla), -1);
      } else {
        insertarArco(casilla, vecinoInfIzq(casilla), saltoInfIzq(casilla));
      }
      if (isBorder(vecinoInfDer(casilla))) {
        insertarArco(casilla, vecinoInfDer(casilla), -1);
      } else {
        insertarArco(casilla, vecinoInfDer(casilla), saltoInfDer(casilla));
      }
      if (isBorder(vecinoSupIzq(casilla))) {
        insertarArco(casilla, vecinoSupIzq(casilla), -1);
      } else {
        insertarArco(casilla, vecinoSupIzq(casilla), saltoSupIzq(casilla));
      }
      if (isBorder(vecinoSupDer(casilla))) {
        insertarArco(casilla, vecinoSupDer(casilla), -1);
      } else {
        insertarArco(casilla, vecinoSupDer(casilla), saltoSupDer(casilla));
      }
    }
  }

  //Inserta un Arco a la ficha ingresada 'elem' con la posicion y el salto ingresados.
  private void insertarArco(Integer elem, Integer pos, Integer salto) {
    Arco aux = new Arco(pos);
    aux.setSaltoComida(salto);
    Arco cursor = listNodo[elem].getAdyacentes();
    //System.out.println("cursor:"+ aux.getPos());
    if(cursor == null)
      listNodo[elem].setAdyacentes(aux);
    else {
      while(cursor.getNext() != null && cursor.getPos() != pos)
        cursor = cursor.getNext();
      
      if(cursor.getPos() != pos)
          cursor.setNext(aux);
    }
    
  }

  //Retorna true si la ficha ingresada esta en el borde superior
  private boolean bordeSup(int pos) {
    if (pos < this.lado) 
      return true;
    else 
      return false;
  }

  //Retorna true si la ficha ingresada esta en el borde inferior
  private boolean bordeInf(int pos) {
    if (pos >= (this.lado * (this.lado-1))) 
      return true;
    else 
      return false;
  }

  //Retorna true si la ficha ingresada esta en el borde izquierdo
  private boolean bordeIzq(int pos) {
    if (pos % this.lado == 0) 
      return true;
     else 
      return false;
  }

  //Retorna true si la ficha ingresada esta en el borde derecho
  private boolean bordeDer(int pos) {
    if (pos % this.lado == this.lado - 1) 
      return true;
    else 
      return false;
  }

  //Retorna true si la ficha ingresada esta en la esquina superior izquierda
  private boolean esqSupIzq(int pos) {
    return bordeSup(pos) && bordeIzq(pos);
  }

  //Retorna true si la ficha ingresada esta en la esquina superior derecha
  private boolean esqSupDer(int pos) {
    return bordeSup(pos) && bordeDer(pos);
  }

  //Retorna true si la ficha ingresada esta en la esquina inferior izquierda
  private boolean esqInfIzq(int pos) {
    return bordeInf(pos) && bordeIzq(pos);
  }

  //Retorna true si la ficha ingresada esta en la esquina inferior derecha
  private boolean esqInfDer(int pos) {
    return bordeInf(pos) && bordeDer(pos);
  }

  //Retorna true si la ficha ingresada esta en cualquier borde
  private boolean isBorder(int pos) {
    return bordeSup(pos) || bordeInf(pos) || bordeDer(pos) || bordeIzq(pos);
  }

  //Calcula el vecino superior derecho de la ficha ingresada
  private int vecinoSupDer(int pos) {
    return pos - this.lado + 1;
  }

  //Calcula el vecino superior izquierdo de la ficha ingresada
  private int vecinoSupIzq(int pos) {
    return pos - this.lado - 1;
  }

  //Calcula el vecino inferior izquierdo de la ficha ingresada
  private int vecinoInfIzq(int pos) {
    return pos + this.lado - 1;
  }

  //Calcula el vecino inferior derecho de la ficha ingresada
  private int vecinoInfDer(int pos) {
    return pos + this.lado + 1;
  }

  //Calcula el salto al comer el vecino superior derecho de la ficha ingresada
  private int saltoSupDer(int pos) {
    return pos - 2 * (this.lado - 1);
  }

  //Calcula el salto al comer el vecino superior izquierdo de la ficha ingresada
  private int saltoSupIzq(int pos) {
    return pos - 2 * (this.lado + 1);
  }

  //Calcula el salto al comer el vecino inferior izquierdo de la ficha ingresada
  private int saltoInfIzq(int pos) {
    return pos + 2 * (this.lado - 1);
  }

  //Calcula el salto al comer el vecino inferior derecho de la ficha ingresada
  private int saltoInfDer(int pos) {
    return pos + 2 * (this.lado + 1);
  }

}