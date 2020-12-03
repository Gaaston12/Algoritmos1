package tp2.datos;

/**
* Esta clase representa la moneda de un pais.
* Toda moneda es una constante, es decir, una vez creada una moneda no cambia ni el pais ni la sigla.
*/
public final class Moneda {

   private final String pais;
   private final String sigla;

   /**
   * Construye una nueva moneda dado un pais y una sigla.
   * @param pais el nombre del pais, no puede ser {@code null} ni vacío.
   * @param sigla la sigla asociada a la moneda de {@code pais}, no puede ser {@code null} ni vacía.
   */
   public Moneda(String  pais, String  sigla) {
      if (pais == null || pais.trim().isEmpty()) {
         throw new IllegalArgumentException("El pais no puede ser null o vacío");
      }
      if (sigla == null || sigla.trim().isEmpty()) {
         throw new IllegalArgumentException("La sigla no puede ser null o vacía");
      }
      this.pais = pais;
      this.sigla = sigla;
   }

   /**
   * @return el pais asociado a esta moneda.
   */
   public String pais() {
      return pais;
   }

   /**
   * @return la sigla asociada a esta moneda.
   */
   public String sigla() {
      return sigla;
   }

   @Override
   public String toString() {
      return "{" + pais + ";" + sigla + "}";
   }

   @Override
   public boolean equals(Object other) {
      if (other == this) return true;
      if (other == null) return false;
      if (!(other instanceof Moneda)) return false;
      Moneda otherMoneda = (Moneda) other;
      return (pais.equals(otherMoneda.pais()) && sigla.equals(otherMoneda.sigla()));
   }

   @Override
   public int hashCode() {
      int result = 7;
      result = 31 * result + pais.hashCode();
      result = 31 * result + sigla.hashCode();
      return result;
   }


}
