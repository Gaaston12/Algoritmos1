/*Esta clase provee metodos basicos para obtener arreglos random de una longitud dada*/

import java.util.*;
public class ArrayGenerator{
	/*atributo privado que contiene el array*/
	private Integer[] array;
	/*atributo privado que contiene la longitud del array*/
	private int lenght;
	/*atributo privado con un generador random*/
	private Random generator; 
	
	public ArrayGenerator(){
	};
	/*ArrayGenerator: constructor*/
	/*pre:true*/
	/*post: crea un obejto de ArrayGenerator con el tamaño pasado por parametro*/
	public ArrayGenerator(int i){
		array = new Integer[i];
		lenght = i;
		generator = new Random();	
	};
	/*GenerateNewArray: genera un nuevo array random*/
	/*pre: true*/
	/*post: genera el array*/
	public void generateNewArray(){
		for (int j=0; j < lenght; j++){
			//int n = generator.nextInt();
			array[j] = new Integer(generator.nextInt(50));	
		} 
	};
	/* getArray: retorna el arreglo */
	/*pre: true*/
	/*post: retorna el arreglo*/
	public Integer[] getArray(){
		return array;
	}
	/*getLenght: retorna la longitud del arreglo*/
	/*pre:true*/
	/*post:retorna la longitud del arreglo*/
	public int getLenght(){
			return lenght;
	};
	/*toString:Muestra el array*/
	/*pre:true*/
	/*post:se escribe el contenido del arreglo en un string*/
	public String toString(){
		String s = new String();
		for (int j=0; j < lenght; j++){
			s = s + "," + Integer.toString(array[j]);
		}	
		return s;
	}
}
