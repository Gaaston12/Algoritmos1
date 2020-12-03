package arraySorter;


public class Catalogo{
    
    private Libro[] libros;
    private int nroLibros;
    private final int DEFAULT_MAX = 50;

    public Catalogo() {
        libros = new Libro[DEFAULT_MAX];
        nroLibros = 0;
    }

    public Catalogo(int max) {
        libros = new Libro[max];
        nroLibros = 0;
    }

    public int ObtenerNroLibros(){
        return this.nroLibros;
    }

    public Libro obtenerLibro(int ind){
        return this.libros[ind];
    }

    // Si el catalogo no esta lleno inserta el libro al final del arreglo 
    public boolean agregarLibro(Libro l) {
        this.libros[nroLibros] = l;
        this.nroLibros++;
    	// Insertar siempre en la ultima posicion del arreglo
        return false;
    }

    // Si hay un libro con titulo t en el catalogo lo retorna, sino devuelve null.
    public Libro buscarPorTitulo(String t) {
        for (int i=0;i <= nroLibros-1;i++){
            if (libros[i].obtenerTitulo() == t){
                return libros[i];
            }
        }
        return null;
    	// recorrer libros hasta encontrar un libro con titulo t
    }

    /**
    * Muestra por pantalla todos los elementos del arreglo.
    */
    public void mostrar() {
        for (int i = 0; i<nroLibros; i++) 
            System.out.println("Libro " + i + ": " + libros[i].toString());
    }

    /**
   * Ordena un arreglo, usando el algoritmo de la bandeja Holandesa de Dijkstra.
   */
    public void quickSortLibros() {
        if (this.libros == null) throw new IllegalArgumentException("El arreglo es null, no se puede ordenar");
           //invocacion del metodo auxiliar
           partitionDutchFlag(this.libros, 0, this.ObtenerNroLibros() - 1);
        }

        /**
        * Ordena un arreglo, usando el algoritmo de la bandeja Holandesa de Dijkstra.
        * @param <Libro> el tipo de los elementos del arreglo, los cuales deben ser comparables entre sí
        * @param int el primer elemento de la lista, entero
        * @param int el primer elemento de la lista, entero
        * @param array el arreglo de los libros a ordenar, no puede ser {@code null}
        */
        private void partitionDutchFlag(Libro[] array, int izq, int der) {
            Libro pivot = array[izq];
            int i = izq;
            int j = der;
            int k;
     
           //Ciclo para particionar el arreglo
            while (i < j) {                            
                //Se comparan los elementos para hacer la particion            
                while (array[i].obtenerAutor().compareTo(pivot.obtenerAutor()) <= 0 && i < j) { //quité el =
                    i++;
                }

                while (array[j].obtenerAutor().compareTo(pivot.obtenerAutor()) > 0) {
                    j--;
                }
                //Se intercambian en el caso de que no esten ordenados.
                if (i < j) {
                    swap2(array, i, j);
                }
            }
     
            array[izq] = array[j];
            array[j] = pivot;
     
            if (izq < (j - 1)) {
                partitionDutchFlag(array, izq, j - 1);
            }
            if (j + 1 < der) {
                partitionDutchFlag(array, j + 1, der);
            }
            //En el caso de que existan libros del mismo autor, se ordenan en orden por titulo.
            for (k=0; k < this.ObtenerNroLibros()-1; k++){
                if (array[k].obtenerAutor().compareTo(array[k+1].obtenerAutor()) == 0){
                    if (array[k].obtenerTitulo().compareTo(array[k+1].obtenerTitulo()) > 0){
                        swap2(array,k,k+1);
                    }
                }
            }
        }
     
        /* (non-Javadoc)
        * Este método intercambia dos posiciones de un arreglo.
        */ 
        private static void swap2(Libro[] array, int i, int j) {
           Libro temp = array[i];
           array[i] = array[j];
           array[j] = temp;
        }
}
