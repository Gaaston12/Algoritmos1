package tp2;

import tp2.datos.Moneda;
import java.nio.file.Files;
import java.util.Optional;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import tp2.colecciones.Grafo;
import tp2.colecciones.GrafoDirigido;

/**
* Clase de prueba para grafos, permite crear un nuevo grafo dirigido con costos a partir de un archivo de vértices y otro de aristas, finalmente permite hacer una consulta sobre el costo de una arista particular.
* @see tp2.colecciones.Grafo
*/
public final class CargarDatos {

   private CargarDatos() {}

   /* (non-javadoc)
   * Estructura interna para tener una relación entre siglas y monedas.
   */
   private static Map<String, Moneda> siglaToMoneda;

   /* (non-javadoc)
   * Permite obtener un archivo a partir de una cadena, el archivo se espera que sea accesible para lectura.
   */
   private static File obtenerArchivo(String nombreArchivo) {
      if (nombreArchivo == null || nombreArchivo.trim().isEmpty())
         throw new IllegalArgumentException("nombreArchivo es null or vacío");
      File archivo = new File(nombreArchivo);
      if (!archivo.exists())
         throw new IllegalArgumentException("El archivo no existe (" + nombreArchivo + ")");
      if (!archivo.isFile())
         throw new IllegalArgumentException("El archivo no es un archivo (" + nombreArchivo + ")");
      if (!archivo.canRead())
         throw new IllegalArgumentException("El archivo no tiene permisos de lectura (" + nombreArchivo + ")");
      return archivo;
   }

   /* (non-javadoc)
   * Carga monedas desde un archivo de vertices y crea un nuevo grafo cargado con estos vértices.
   */
   private static Grafo<Moneda> cargarVertices(String nombreArchivoVertices, String delimitador) {
      if (delimitador == null || delimitador.isEmpty())
         throw new IllegalArgumentException("El delimitador es null or vacía");
      File archivoVertices = obtenerArchivo(nombreArchivoVertices);
      Grafo<Moneda> grafo = new GrafoDirigido<>();
      siglaToMoneda = new HashMap<>();
      try {
         for (String linea : Files.readAllLines(archivoVertices.toPath())) {
            if (linea == null || linea.trim().isEmpty())
               throw new IllegalArgumentException("Error de lectura (linea nula) o una línea es vacía");
            String[] valores = linea.split(delimitador);
            if (valores.length != 2)
               throw new IllegalArgumentException("Se esperaban 2 valores por línea en el archivo de vertices (" + nombreArchivoVertices + ")");
            String pais = valores[0].trim();
            String sigla = valores[1].trim();
            Moneda moneda = new Moneda(pais, sigla);
            siglaToMoneda.put(moneda.sigla(), moneda);
            if (!grafo.agregarVertice(moneda)) {
               System.out.println("Vértice repetido : " + moneda.toString());
            }
         }
      } catch (IOException e) {
         throw new IllegalArgumentException("Error al leer el archivo: " + nombreArchivoVertices, e); 
      } 
      return grafo;
   }

   /* (non-javadoc)
   * Carga tasas de cambio desde un archivo de aristas y las agrega a un grafo ya cargado con vértices.
   */
   private static void cargarAristas(String nombreArchivoAristas, String delimitador, Grafo<Moneda> grafo) {
      if (delimitador == null || delimitador.isEmpty())
         throw new IllegalArgumentException("El delimitador es null or vacía");
      if (grafo == null)
         throw new IllegalArgumentException("El grafo es null");
      File archivoAristas = obtenerArchivo(nombreArchivoAristas);
      try {
         for (String linea : Files.readAllLines(archivoAristas.toPath())) {
            String[] valores = linea.split(delimitador);
            if (valores.length != 3)
               throw new IllegalArgumentException("Se esperaban 3 valores por línea en el archivo de aristas (" + nombreArchivoAristas + ")");
            String origen = valores[0];
            if (origen.trim().isEmpty())
               throw new IllegalArgumentException("El origen es vacío para la línea actual (" + linea + ")");
            String destino = valores[1];
            if (destino.trim().isEmpty())
               throw new IllegalArgumentException("El destino es vacío para la línea actual (" + linea + ")");
            String costoCadena = valores[2];
            if (costoCadena.trim().isEmpty())
               throw new IllegalArgumentException("El costo es vacío para la línea actual (" + linea + ")");
            Double costo = null;
            try {
               costo = Double.valueOf(costoCadena.replaceAll(",", ""));
            } catch (NumberFormatException e) {
               throw new IllegalArgumentException("El costo tiene un formato incorrecto (" + costoCadena + ") en la línea (" + linea + ")", e);
            } 
            Moneda vo = siglaToMoneda.get(origen);
            Moneda vd = siglaToMoneda.get(destino);
            if (vo == null || !grafo.existe(vo))
               throw new IllegalArgumentException("No se cargó la moneda correspondiente a " + origen);
            if (vd == null || !grafo.existe(vd))
               throw new IllegalArgumentException("No se cargó la moneda correspondiente a " + destino);           
            grafo.agregarArista(vo, vd, costo);
         }  
      } catch (IOException e) {
         throw new IllegalArgumentException("Error al leer el archivo de aristas (" + nombreArchivoAristas + ")", e); 
      }
   }


   /**
   * A partir de un archivo de vértices y uno de aristas, se crea un nuevo grafo sobre el que finalmente se puede consultar el costo entre dos vértices adyacentes.
   * @param args los argumentos del programa que deberían contener 5 valores.
   */
   public static void main(String[] args) {
      if (args.length != 5) {
         System.out.println("Uso: java tp2.CargarDatos <archivo de verices> <archivo de aristas> <delimitador> <sigla inicial> <sigla final>");
         throw new IllegalArgumentException("Se esperaban 5 argumentos");
      }
      String nombreArchivoVertices = args[0];
      String nombreArchivoAristas = args[1];
      String delimitador = args[2];
      String siglaInicial = args[3];
      String siglaFinal = args[4];
      if (siglaInicial.trim().isEmpty())
         throw new IllegalArgumentException("La sigla inicial es vacía");
      if (siglaFinal.trim().isEmpty())
         throw new IllegalArgumentException("La sigla inicial es vacía");
      Grafo<Moneda> grafo = cargarVertices(nombreArchivoVertices, delimitador);
      System.out.println("Cantidad de vertices: " + grafo.cantidadVertices());
    
      cargarAristas(nombreArchivoAristas, delimitador, grafo);

      System.out.println("Cantidad de aristas: " + grafo.cantidadAristas());
      
      Moneda monedaInicial = siglaToMoneda.get(siglaInicial);
      Moneda monedaFinal = siglaToMoneda.get(siglaFinal);
      if (monedaInicial == null) {
         System.out.println("No existe moneda asociada a la sigla " + siglaInicial);
         return;
      }
      if (monedaFinal == null) {
         System.out.println("No existe moneda asociada a la sigla " + siglaFinal);
         return;
      }
      Optional<Double> oc = grafo.costoArista(monedaInicial, monedaFinal);
      if (!oc.isPresent())
         System.out.println("No existe una arista desde " + monedaInicial.toString() + " hacia " + monedaFinal.toString());
      else {
         System.out.println("El costo de ir desde la moneda " + monedaInicial.toString() + " hacia la moneda " + monedaFinal.toString() + " es de " + oc.get());
      }
   }
   
}
