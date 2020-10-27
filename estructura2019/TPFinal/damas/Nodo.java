package damas;

//Esta clase modela la ubicacion de las fichas en el tablero. 
public class Nodo{
    
    private Integer pos;
    private Character contenido; //[b-n-v] (blanco, negro, vacio)
    private Boolean recorrida;  //Ficha recorrida
    private Boolean comida;   //Ficha negra que comida   
    private Arco adyacentes;  //Fichas vecinas adyacentes

    public Nodo(Integer pos, Character content){
      this.pos = pos;
      this.comida = false;
      this.recorrida = false;
      this.adyacentes = null;
      this.contenido = content;
    }

    //Este metodo permite setear el color de la ficha, o casilla vacia
    public void setContenido(Character contenido){
      if(contenido=='b' || contenido=='n' || contenido == 'v')
        this.contenido = contenido;
    }
    
    public Character getContenido(){
        return this.contenido;
    }

    public void setRecorrida(Boolean recorrida){
      this.recorrida = recorrida;
    }

    public Boolean getRecorrida(){
      return this.recorrida;
    }

    public void setComida(Boolean comida){
      this.comida = comida;
    }

    public Boolean getComida(){
      return this.comida;
    }

    public void setAdyacentes(Arco adyacentes){
      this.adyacentes = adyacentes;
    }

    public Arco getAdyacentes(){
      return this.adyacentes;

    }

    public void setPos(Integer pos ){
      this.pos = pos;
    }
    
    public Integer getPos(){
      return this.pos;
    }
}