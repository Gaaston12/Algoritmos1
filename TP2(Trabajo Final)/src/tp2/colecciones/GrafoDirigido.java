package tp2.colecciones;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import tp2.colecciones.Grafo;

/**
* TODO: documentar de acuerdo a la implementación elegida
*/
public class GrafoDirigido<V> implements Grafo<V> {

   /**
   * TODO: documentar
   */
   public GrafoDirigido() {
      throw new UnsupportedOperationException("Falta implementar");
   }

   @Override
   /**@inheritDoc*/
   public boolean agregarVertice(V nodo) {
      throw new UnsupportedOperationException("Falta implementar");
   }
   
   @Override
   /**@inheritDoc*/
   public boolean eliminarVertice(V nodo) {
      throw new UnsupportedOperationException("Falta implementar");
   }

   @Override
   /**@inheritDoc*/
   public boolean existe(V nodo) {
      throw new UnsupportedOperationException("Falta implementar");
   }
   
   @Override
   /**@inheritDoc*/
   public Collection<V> vertices() {
      throw new UnsupportedOperationException("Falta implementar");
   }

   @Override
   /**@inheritDoc*/
   public boolean agregarArista(V desde, V hacia, double costo) {
      throw new UnsupportedOperationException("Falta implementar");
   }
   
   @Override
   /**@inheritDoc*/
   public boolean eliminarArista(V desde, V hacia) {
      throw new UnsupportedOperationException("Falta implementar");
   }

   @Override
   /**@inheritDoc*/
   public Set<Par<V, Double>> obtenerAdyacentes(V v) {
      throw new UnsupportedOperationException("Falta implementar");
   }

   @Override
   /**@inheritDoc*/
   public int cantidadVertices() {
      throw new UnsupportedOperationException("Falta implementar");
   }
   
   @Override
   /**@inheritDoc*/
   public boolean esVacio() {
      throw new UnsupportedOperationException("Falta implementar");
   }
   
   @Override
   /**@inheritDoc*/
   public int cantidadAristas() {
      throw new UnsupportedOperationException("Falta implementar");
   }

   @Override
   /**@inheritDoc*/
   public Optional<Double> costoArista(V desde, V hacia) {
     throw new UnsupportedOperationException("Falta implementar");
   }
   
   @Override
   /**@inheritDoc*/
   public Optional<Par<List<V>, Double>> camino(V desde, V hacia){
     throw new UnsupportedOperationException("Falta implementar");
   }
   
}
