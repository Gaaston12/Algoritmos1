import java.lang.reflect.Array;
import java.util.ArrayList;

/*Clase Sorting que provee metodos de ordenacion*/

public class Sorting{
	// Swap: intercambia dos posiciones de un array
	// pre:  0 <= i,j <= array.lenght
	// post: intercambia los valores
	private static void swap(Comparable[] array, int i, int j){
	  Comparable temp = array[i];
  	  array[i] = array[j];
	  array[j] = temp;
 	}//end swap
 	
 	// bubbleSort: Implementa el algoritmo de sorting bubbleSort
 	// pre: n = array.lenght
 	// post: ordena el arreglo de menor a mayor
 	public static void bubbleSort(Comparable[] array, int n){
	  boolean sorted = false;
	  for (int pass = 1; (pass < n)&& !sorted; ++pass){
	    sorted = true;
	    for (int index = 0; index < n - pass; ++index){
	    int nextIndex = index + 1;
	    if (array[index].compareTo(array[nextIndex])>0){
		  swap(array, index, nextIndex);
		  sorted = false;
	    } // end if
	    }//end for
	  }//end for
	}// end bubbleSort	
	
	// selectionSort: Implementa el algortimo de selectionSort
	// pre: n = array.lenght
	// post: ordena el arreglo de menor a mayor
	public static void selectionSort(Comparable[] array, int n){
	// last: index del ultimo elemento de la parte no ordenada
    // largest: posicion del elemento mas grande
    for (int last = n-1; last >= 1; last--){
	    int largest = indexOfLargest(array, last+1);
	    swap(array, last, largest);
    }// end for
	}// end selectionSort
	
	// indexOfLargest: Metodo Privado que retorna el indice del elemento mas grande
	// hasta n
	// pre: n < array.lenght
	// post: devuelve el indice del mas grande hasta n
	private static int indexOfLargest(Comparable[] array, int n){
		int largest = 0;
		for (int i = 1; i < n; i++){
			if (array[i].compareTo(array[largest]) > 0){
				largest = i;
			}
		} //end for 	
		return largest;
	}// end indexOfLargest
	
	// mergeSort: implementa el algoritmo MergeSort
	// pre: 0 <= begin <= end <= array.lenght
	// post: ordena array.  
	public static void mergeSort(Comparable[] array, int begin, int end){
		if (begin < end){
			int mid = (begin + end)/2;
			mergeSort(array, begin, mid);//ordena la primera mitad
			mergeSort(array, mid+1, end);//ordena la segunda mitad
			merge(array, begin, mid, end);//mezcla las mitades ordenadas
		}
	}
	
	// merge: mezcla dos partes consecutivas de array
	// pre: 0 <= begin, mid, end <= array.lenght
	private static void merge(Comparable[] array, int begin, int mid, int end){
		Comparable[] aux = new Comparable[(end-begin)];
		int i,j,k;
		i = begin;
		j = mid;
		k = 0;
		while((i<mid) && (j<=end)){
			if (array[j].compareTo(array[i]) < 0 ){
				aux[k] = array[j];
				k++;
				j++;
			}
			else {
				aux[k] = array[i];
				k++;
				i++;
			}
		}
		while (i < mid){
			aux[k] = array [i];
			k++;
			i++;
		}
		while (j <= end){
			aux[k] = array [j];
			k++;
			j++;
		}
		for (int c = 0; c < ((end-begin)); c++){
			//System.out.println(aux[c]);
			array[begin+c] = aux[c];
			//System.out.println(array[c]);
		}

	}
	
	// quickSort: implementa el algoritmo de quicksort
	// pre: 0 <= begin <= end <= array.lenght
	// post: ordena array
	public static void quickSort(Comparable[] array, int begin, int end){
	if (begin < end){
		// Calculo la particion 
		int p = partition(array, begin, end);
		// ordeno la parte izq
		quickSort(array, begin, p);
		// ordeno la parte derecha
		quickSort(array, p+1, end);
	}
	}	
	
	// partition: dado un arreglo retorna un p, el cual es el pivote.
	// pre: 0 <= begin <= end <= array.lenght
	// post: para todo begin <= k <= p: array[k] <= array[p] y para todo k: p <= k <= end : array[p] <= array[k]
	private static int partition(Comparable[] array, int begin, int end){
		Comparable pivot = array[begin];
		int i = begin - 1;
		int j = end + 1;
		while (i < j) {
			//invariante: 
			//para k < = i : a[k] <= pivot y para k >= j : pivot <= a[k] 
			do j--; while (array[j].compareTo(pivot) > 0); 
			do i++; while (array[i].compareTo(pivot) < 0);
			if (i < j) {swap(array, i, j);}	
		}
		return j;
	}

	public static void insertionSort (Comparable[] array, int begin, int end){
		int pivot = begin + 1;
		Integer i;
		Integer j;
		Comparable aux;
		while (pivot <= end){
			i = begin;
			while (array[i].compareTo(array[pivot]) == -1){ //Si es menor
				i++;
			}
			aux = array[pivot];
			j = pivot;
			while (j.compareTo(i) == 1){ //Si es mayor
				array[j] = array[j-1];
				j--;
			}
			array[j] = aux;
			pivot ++;
		}

	}
}
