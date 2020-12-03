package tp2.colecciones;

/**
* Una tupla genérica que contiene dos datos de tipos posiblemente distintos.
*/
public class Par<A, B> {
   private A primero;
   private B segundo;

   /**
   * Construye un nuevo par.
   * @param primero el primer elemento de la tupla.
   * @param segundo el segundo elemento de la tupla.
   */
   public Par(A primero, B segundo) {
      this.primero = primero;
      this.segundo = segundo;
   }

   /**
   * Retorna el primer elemento de la tupla.
   * @return el primer elemento de esta tupla.
   */
   public A primero() {
      return primero;
   }

   /**
   * Retorna el segundo elemento de la tupla.
   * @return el segundo elemento de esta tupla.
   */
   public B segundo() {
      return segundo;  
   }

   /**
   * Define el primer elemento de esta tupla, el valor puede ser {@code null}.
   * @param primero el elemento con el cual reemplazar el primer elemento de esta tupla.
   */
   public void primero(A primero) {
      this.primero = primero; 
   }

   /**
   * Define el segundo elemento de esta tupla, el valor puede ser {@code null}.
   * @param segundo el elemento con el cual reemplazar el segundo elemento de esta tupla.
   */
   public void segundo(B segundo) {
      this.segundo = segundo; 
   }

   @Override
   /**
   * Retorna una representación de esta tupla en formato <pre>{primer elemento, segundo elemento}</pre> utilizando el método {@code toString()} de cada elemento.
   * @return la representación de esta tupla.
   */
   public String toString() {
      return "{" + (primero == null ? "NULL" : primero.toString()) + ", " + (segundo == null ? "NULL" : segundo.toString()) + "}";
   }

}
