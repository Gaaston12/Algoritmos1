// Ejemplo de una interfaz basica para arboles contiene la funcionalidad minima para este tipo
// de estructuras, puede ser enriquecidad con mas operaciones
public interface BinaryTreeBasis{
    // Devuelve el elemento de la raiz
    public Object getRoot();
    // Setea la raiz
    public void setRoot(Object item);
    // Dice si el arbol es vacio
    public boolean isEmpty();
    //Remueve todo los nodos del arbol
    public void makeEmpty();
    // recorrido preOrder
    public void printPreOrder();
    // recorrido postOrder
    public void printPostOrder();
    // recorrido inOrder
    public void printInOrder();
    }