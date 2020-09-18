package listas;

/**Implementacion de Pilas en java cona arreglos*/
public class ListaConArreglos{

    private static final int MAX_LIST = 100;
    private Object[] items;
    private int numItems;

    /**Constructos 
     * @pre. true.
     * @post. Se crea un arreglo de objetos de tamanio MAX_LIST
     *         y se inicializa numitems en 0
    */
    public ListaConArreglos(){
        items = new Object[MAX_LIST];
        numItems = 0;
    }

    /**Se fija si la lista esta vacia 
     * @return true si la lista no tiene elementos
     * @pre. true
     * @post. Retorna true si la lista no tiene elementos
    */
    public boolean esVacia(){
        return (numItems == 0);
    }

    /**Vacia la lista */
    public void vaciar(){
        numItems = 0;
    }
    /**Dice la cantidad de elementos 
     * @pre. true.
     * @post. retorna la cantidad de elementos de la lista,
    */
    public int longitud(){
        return numItems;
    }

    /**Inserta un elemento 
     * @param index es el indice en el cual se inserta el elemento.
     * @param item es el objeto a insertar en la lissta
     * @pre. 0<=index<=longitud()
     * @post. si index e suna posicion valida, 
    */
    public void insertar(int index, Object item) throws RuntimeException, IndexOutOfBoundsException{
        if((0 <= index) && (index <= longitud())){
            for (int i = longitud(); i == index ; i--){
                items[i++] = items[i];
            }
            items[index] = item;
            numItems++;
            
        }
    }
    
    /**Elimina un elemento */
    public void eliminar(int index){

    }

    /**Muestra todo el contenido del arreglo */
    public int mostrar(){
        for(int i = 0; i <= longitud(); i++){
            return items[i];
        }
    }

    /**Te muestra el valor de un elemento */
    //public Object obtener(int index){
        //for(int i = 0; i == index; i++){ 
            //return items[i];
        //}
    //}
}
