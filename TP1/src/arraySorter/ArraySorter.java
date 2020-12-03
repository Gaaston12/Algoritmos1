package arraySorter;

/**
* Provee métodos para ordenar arreglos de objetos comparables.
* Los algoritmos de ordenamiento provistos por esta clase son:
* <ul>
* <li>Bubble sort.</li>
* <li>Selection sort.</li>
* <li>Shell sort.</li>
* <li>Quick sort.</li>
* </ul>
* El invariante que deben cumplir todos los arreglos {@code array} para ser utilizados como argumentos de los distintos algoritmos de ordenamiento es:
* <pre>
* array != null &amp;&amp; for (T elem : array) {elem != null}
* </pre>
*/
public final class ArraySorter{

   private ArraySorter(){

   }

   /**
   * Ordena un arreglo, <i>in place</i>, usando el orden natural de sus elementos utilizando Bubble Sort.
   * @param <T> el tipo de los elementos del arreglo, los cuales deben ser comparables entre sí
   * @param array el arreglo de los elementos a ordenar, no puede ser {@code null}
   */
   public static <T extends Comparable<? super T>> void bubbleSort(T[] array) {
      if (array == null) throw new IllegalArgumentException("El arreglo es null, no se puede ordenar");
      boolean sorted = false;
      int n = array.length; 
      for (int pass = 1; (pass < n) && !sorted; ++pass) {
         sorted = true;
         for (int index = 0; index < n - pass; ++index) {
            int nextIndex = index + 1;
            if (array[index].compareTo(array[nextIndex]) > 0) {
               swap(array, index, nextIndex);
               sorted = false;
            }
         }
      }
   }

   /**
   * Ordena un arreglo, <i>in place</i>, usando el orden natural de sus elementos utilizando Selection Sort.
   * @param <T> el tipo de los elementos del arreglo, los cuales deben ser comparables entre sí
   * @param array el arreglo de los elementos a ordenar, no puede ser {@code null}
   */
   public static <T extends Comparable<? super T>> void selectionSort(T[] array) {
      if (array == null) throw new IllegalArgumentException("array is null, can't sort");
      //last = indice del ultimo elemento de la parte no ordenada
      for (int last = array.length - 1; last >= 1; last--) {
         //largest = posicion del elemento mas grande
         int largest = indexOfLargest(array, last + 1);
         swap(array, last, largest);
      }
   }

   /**
   * Ordena un arreglo, <i>in place</i>, usando el orden natural de sus elementos utilizando Shell Sort.
   * @param <T> el tipo de los elementos del arreglo, los cuales deben ser comparables entre sí
   * @param array el arreglo de los elementos a ordenar, no puede ser {@code null}
   */
   public static <T extends Comparable<? super T>> void shellSort(T[] array) {
      if (array == null) throw new IllegalArgumentException("El arreglo es null, no se puede ordenar");
   
      for ( int salto = array.length / 2; salto > 0; salto /= 2) {
         boolean cambios = true;
         // Mientras se intercambie algún elemento 
         while (cambios) {                                                                              
            cambios = false;
             // se da una pasada
            for (int i = salto; i < array.length; i++)         
            {
               // y si estan desordenados
               if (array[i - salto].compareTo(array[i]) > 0) {  
                  // se reordenan
                  T aux = array[i];                             
                  array[i] = array[i - salto];
                  array[i - salto] = aux;
                  // y se marca como cambio. 
                  cambios = true;                                                                
               }
            }
         }
      }
   }

   /**
   * Ordena un arreglo, <i>in place</i>, usando el orden natural de sus elementos utilizando Quick Sort.
   * @param <T> el tipo de los elementos del arreglo, los cuales deben ser comparables entre sí
   * @param array el arreglo de los elementos a ordenar, no puede ser {@code null}
   */
  public static <T extends Comparable<? super T>> void quickSort(T[] array) {
   if (array == null) throw new IllegalArgumentException("El arreglo es null, no se puede ordenar");
      //invocacion del metodo auxiliar
      partitionDutchFlag(array, 0, array.length - 1);
   }

   /**
   * Ordena un arreglo, usando el algoritmo de la bandeja Holandesa de Dijkstra.
   * @param <T> el tipo de los elementos del arreglo, los cuales deben ser comparables entre sí
   * @param int el primer elemento de la lista, entero
   * @param int el primer elemento de la lista, entero
   * @param array el arreglo de los elementos a ordenar, no puede ser {@code null}
   */
   private static <T extends Comparable<? super T>> void partitionDutchFlag(T[] array, int izq, int der) {
      T pivot = array[izq];
      int i = izq;
      int j = der;

      //Ciclo para particionar el arreglo
      while (i < j) {                            
         //Se comparan los elementos para hacer la particion            
         while (array[i].compareTo(pivot) <= 0 && i < j) {
            i++;
         }
         while (array[j].compareTo(pivot) > 0) {
            j--;
         }
         //Se intercambian en el caso de que no esten ordenados.
         if (i < j) {
            swap(array, i, j);
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
   }

   /* (non-Javadoc)
   * Este método intercambia dos posiciones de un arreglo.
   */ 
   private static <T extends Comparable<? super T>> void swap(T[] array, int i, int j) {
      T temp = array[i];
      array[i] = array[j];
      array[j] = temp;
   }

   /* (non-Javadoc)
   * Este método retorna el indice del elemento mas grande. 
   */
   private static <T extends Comparable<? super T>> int indexOfLargest(T[] array, int n){
      int largest = 0;
      for (int i = 1; i < n; i++){
         if (array[i].compareTo(array[largest]) > 0){
            largest = i;
         }
      }  
      return largest;
   }
}