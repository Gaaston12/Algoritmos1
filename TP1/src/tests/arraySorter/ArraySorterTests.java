package tests.arraySorter;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.junit.rules.ExpectedException;
import org.junit.Rule;

import java.util.Collection;
import java.util.Arrays;
import arraySorter.ArraySorter;
import arraySorter.ArrayGenerator;

@RunWith(Parameterized.class)
public class ArraySorterTests {
   @Rule
   public ExpectedException noExceptions = ExpectedException.none();

   private Integer[] arregloA;
   private Integer[] arregloB;
   
   public ArraySorterTests(int min, int max, int longitud, long semilla) {
      this.arregloA = ArrayGenerator.generarArreglo(min, max, longitud, semilla);
      this.arregloB = ArrayGenerator.generarArreglo(min, max, longitud, semilla);
   }

   @Parameters
	public static Collection<Object[]> firstValues() {
	   long semilla = System.currentTimeMillis();
		//PARAMETERS
		return Arrays.asList(new Object[][] {
            {0, 100, 25, semilla},
		      {-25, 75, 25, semilla},
		      {-25, 75, 1, semilla},
		      {0, 1, 25, semilla},
		      {0, 100, 2, semilla},
		      {0, 100, 3, semilla},
            {-50, 0, 25, semilla}
		});
	}
	
	
	@Test
	public void elArregloQuedaOrdenadoPorBubbleSort() {
	   ArraySorter.bubbleSort(arregloA);
	   Arrays.sort(arregloB);
	   String mensaje = "(Bubble Sort) Se esperaba\n" + Arrays.toString(arregloB) + "\nPero se obtuvo\n" + Arrays.toString(arregloA);
	   assertTrue(mensaje, Arrays.equals(arregloA, arregloB));
	}
	
	@Test
	public void elArregloQuedaOrdenadoPorSelectionSort() {
	   ArraySorter.selectionSort(arregloA);
	   Arrays.sort(arregloB);
	   String mensaje = "(Selection Sort) Se esperaba\n" + Arrays.toString(arregloB) + "\nPero se obtuvo\n" + Arrays.toString(arregloA);
	   assertTrue(mensaje, Arrays.equals(arregloA, arregloB));
	}
	
	@Test
	public void elArregloQuedaOrdenadoPorShellSort() {
	   ArraySorter.shellSort(arregloA);
	   Arrays.sort(arregloB);
	   String mensaje = "(Shell Sort) Se esperaba\n" + Arrays.toString(arregloB) + "\nPero se obtuvo\n" + Arrays.toString(arregloA);
	   assertTrue(mensaje, Arrays.equals(arregloA, arregloB));
	}
	
	@Test
	public void elArregloQuedaOrdenadoPorQuickSort() {
	   ArraySorter.quickSort(arregloA);
	   Arrays.sort(arregloB);
	   String mensaje = "(Quick Sort) Se esperaba\n" + Arrays.toString(arregloB) + "\nPero se obtuvo\n" + Arrays.toString(arregloA);
	   assertTrue(mensaje, Arrays.equals(arregloA, arregloB));
	}



}
