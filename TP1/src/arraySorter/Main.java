package arraySorter;

import java.util.Arrays;

/**
* Clase ejecutable para demostrar el uso de {@code ArraySorter}
* @see arraySorter.ArraySorter
* @see arraySorter.ArrayGenerator
*/
public class Main {

   public static void main(String[] args) {

      Integer[] arreglo = ArrayGenerator.generarArregloDeLongitud(0, 100, 10);
      System.out.println("Arreglo random, tamaño 10 y valores entre 0 y 100:\n" + Arrays.toString(arreglo));
      ArraySorter.bubbleSort(arreglo);
      System.out.println("Arreglo ordenado con BubbleSort:\n" + Arrays.toString(arreglo));

      arreglo = ArrayGenerator.generarArregloDeLongitud(0, 100, 30);
      System.out.println("Arreglo random, tamaño 30 y valores entre 0 y 100:\n" + Arrays.toString(arreglo));
      ArraySorter.selectionSort(arreglo);
      System.out.println("Arreglo ordenado con SelectionSort:\n" + Arrays.toString(arreglo));

      arreglo = ArrayGenerator.generarArregloDeLongitud(0, 100, 30);
      System.out.println("Arreglo random, tamaño 30 y valores entre 0 y 100:\n" + Arrays.toString(arreglo));
      ArraySorter.shellSort(arreglo);
      System.out.println("Arreglo ordenado con shellSort:\n" + Arrays.toString(arreglo)); 

      arreglo = ArrayGenerator.generarArregloDeLongitud(0, 100, 30);
      System.out.println("Arreglo random, tamaño 30 y valores entre 0 y 100:\n" + Arrays.toString(arreglo));
      ArraySorter.quickSort(arreglo);
      System.out.println("Arreglo ordenado con quickSort:\n" + Arrays.toString(arreglo));

      Libro l0 = new Libro("Harry Potter", "J. K. Rowling", 600);
      Libro l1 = new Libro("The Lord of the Rings", "J. R. R. Tolkien", 1000);
      Libro l2 = new Libro("Hamlet", "William Shakespeare", 140);
      Libro l3 = new Libro("The Hobbit", "J. R. R. Tolkien", 1000);
      Libro l4 = new Libro("Buick 8", "Stephen King", 800);

      Catalogo c1 = new Catalogo();
      c1.agregarLibro(l0);
      c1.agregarLibro(l1);
      c1.agregarLibro(l2);
      c1.agregarLibro(l3);
      c1.agregarLibro(l4);

      System.out.println("Catalogo:");
      c1.mostrar();

      System.out.println("Catalogo ordenado con quickSort:");
      c1.quickSortLibros();
      c1.mostrar();

   }
}
