package tp2.colecciones;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.Set;

/**
* Grafo dirigido con pesos.
* Los invariantes están dados por las siguientes condiciones:
* <ul>
* <li>No pueden existir nodos {@code null} en el grafo.</li>
* <li>No pueden existir pesos {@code null} en el grafo.</li>
* <li>Si existe una arista A que une los vértices V1 con V2, entonces V1 y V2 deben ser nodos que pertenecen al grafo.</li>
* </ul>
* @param V el tipo de los nodos (vértices) en el grafo.
*/
public interface Grafo<V> { 

   /**
   * Agrega un nuevo nodo (vértice) al grafo.
   * @param nodo el nuevo nodo a agregar.
   * @return {@code true} sii el nodo pudo ser agregado.
   * <hr>
   * <i>Un nodo puede no ser agregado por que ya existe o por que la representación interna del grafo está llena.</i> 
   */
   public boolean agregarVertice(V nodo);
   
   /**
   * Elimina un nodo (vértice) <b>existente</b> del grafo, y elimina todas las aristas que van o llegan al mismo.
   * @param nodo el nodo a eliminar.
   * @return {@code true} sii el nodo {@code nodo} existía en el grafo y fue correctamente eliminado.
   */
   public boolean eliminarVertice(V nodo);

   /**
   * Consulta la existencia de un nodo (vértice) en el grafo.
   * @param nodo el nodo a consultar.
   * @return {@code true} sii {@code nodo} existe en el grafo.
   */
   public boolean existe(V nodo);
   
   /**
   * Retorna una coleccion con todos los vértices en el grafo.
   * @return los vertices en el grafo en una colección
   * <hr>
   * <i>Modificar los vértices obtenidos puede tener efectos en el grafo.</i>
   */
   public Collection<V> vertices();

   /**
   * Conecta dos nodos <b>existentes</b> con un costo particular.
   * @param desde el vértice desde donde sale la arista.
   * @param hacia el vértice hacia donde va la arista.
   * @param costo el costo de la nueva arista.
   * @return {@code true} sii la arista no existía en el grafo y fue agregada.
   */
   public boolean agregarArista(V desde, V hacia, double costo);
   
   /**
   * Elimina una arista que va desde un nodo (vértice) hacia otro.
   * @param desde el vértice desde donde sale la arista.
   * @param hacia el vértice hacia donde va la arista.
   * @return {@code true} sii la arista a eliminar existía y fue eliminada.
   */
   public boolean eliminarArista(V desde, V hacia);

   /**
   * Obtiene los vértices adyacentes a un nodo <b>existente</b>.
   * @param v el vértice sobre el cual obtener los adyacentes.
   * @return un conjunto de pares con cada vértice adyancete a {@code v} y el costo asociado.
   */
   public Set<Par<V, Double>> obtenerAdyacentes(V v);

   /**
   * Retorna cuantos vértices hay en el grafo.
   * @return la cantidad de nodos (vértices) presentes en el grafo.
   */
   public int cantidadVertices();
   
   /**
   * Retorna si el grafo no posee ningún vértice.
   * @return {@code true} sii no existe ningún nodo en el grafo, este método es similar a ejecutar <pre>cantidadVertices() == 0</pre>.
   */
   public boolean esVacio();

   /**
   * Retorna la cantidad de aristas en el grafo.
   * @return cuantas aristas existen en el grafo.
   * <hr>
   * <i>Un valor {@code 0} no implica que el grafo esté vacío.</i>
   */
   public int cantidadAristas();

   /**
   * Retorna el costo de una arista que conecta un nodo (vértice) con otro, ambos <b>existentes</b>
   * el costo puede ser opcional ya que puede no haber arista que conecta ambos nodos.
   * @param desde el vértice desde donde la arista se espera que salga.
   * @param hacia el vértice hacia donde la arista se espera que llegue.
   * @return {@code Optional.of(c)} si existe una arista que parte de {@code desde} y llega a {@code hacia} con costo {@code c}; {@code Optional.empty()} si no existe la arista.
   * @see <a href="https://docs.oracle.com/javase/8/docs/api/java/util/Optional.html">java.util.Optional</a>
   */
   public Optional<Double> costoArista(V desde, V hacia);


   /**
   * Retorna el camino menos costoso que conecta dos nodos (vértices) con su costo, si existe al menos un caminoy si no contiene ciclos negativos.
   * @param desde el vértice inicial del camino.
   * @param hacia el vértice final del camino.
   * @return {@code Optional.of(Par[c, costo])} si {@code c} es el camino menos costoso desde {@code desde} hasta {@code hacia} con costo {@code costo}; {@code Optional.empty()} si no existe ningún camino desde {@code desde} a {@code hacia} o si hay un ciclo negativo. 
   * <hr>
   * El camino {@code c} se considera el más corto y menos costoso si {@code c} comienza con {@code desde} y termina en {@code hacia} y tiene un costo {@code costo}, y no existe un {@code c'} que vaya desde {@code desde} hasta {@code hacia} cuyo costo
   * sea menor a {@code costo} .
   * @see <a href="https://docs.oracle.com/javase/8/docs/api/java/util/Optional.html">java.util.Optional</a>
   */
   public Optional<Par<List<V>, Double>> camino(V desde, V hacia);
    
   
}
