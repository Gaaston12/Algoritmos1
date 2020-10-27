package damas;

// Esta clase es la implementacion del movimiento de la ficha en el tablero 
public class Arco{

  private Integer pos; // Posicion de la piesa a comer
  private Integer saltoComida; // Posicion donde salta la ficha blanca cuando come
  private Arco next; // Proximo arco

  public Arco(Integer pos){
    this.pos = pos;
    this.saltoComida = 0;
    this.next = null;
  }

  // setters y getters 
  public void setNext(Arco next){
    this.next = next;
  }
  public Arco getNext(){
    return this.next;
  }

  public void setPos(int pos){
    this.pos = pos;
  }
  public Integer getPos(){
    return this.pos;
  }

  public void setSaltoComida(Integer saltoComida){
    this.saltoComida = saltoComida;
  }
  
  public Integer getSaltoComida(){
    return this.saltoComida;
  }
}
