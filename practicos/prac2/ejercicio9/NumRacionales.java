/*
    Ej. 9. Escribir una clase para el manejo de números racionales. Sus atributos son dos
variables de tipo long. Puede suponer que el denominador siempre es positivo. La
clase debe proveer funcionalidades para sumar y restar racionales, y un método equals
para comparar dos racionales por igualdad. Implementar también un método toString
que convierta un racional a una cadena. Hacer un método main que cree varios
racionales y les aplique diversas operaciones, mostrando sus resultados por pantalla.
*/

package ejercicio9;


public class NumRacionales {
    /** Atributos de la clase */

    /** Numerador. */
    /** Denominador */
    private long numerador, denominador;
    
    /** Constructor por defecto */
    /*public Racional() {
        this.numerador = 0;
        this.denominador = 1;
    }*/

    /** Racional creado por el usuario */
    /** Pre: d > 0 */
    /**Post: construye un numero racional con n como numerador y d como denominador */
    public long Racional(long n, long d){
        if(d <= 0) throw new IllegalArgumentException("Denominador es cero o negativo");
        if(d > 0){
            this.numerador = n;
            this.denominador = d;
        }       
    }

    /**Getters y Setters */
    public long getNumerador(){
        return numerador;
    }
    public void setNumerador(long n){
        this.numerador = n;
    }

    public long getDenominador(){
        return denominador;
    }    
    public void setDenominador(long d){
        this.denominador = d;
    }


    /**Suma de 2 numeros racionales */
    public Racional sumar(Racional r){

        long resulDeno;
        long resulNume;
        if(this.denominador == r.denominador){
            resulDeno = this.denominador;
            resulNume = this.numerador + r.numerador;

        }else{
            resulDeno = this.denominador * r.denominador;
            resulNume = (this.numerador * r.denominador) + (this.denominador * r.numerador);
        }
        return new Racional(resulNume, resulDeno);
    }

    /**resta de 2 numeros racionales */
    public Racional restar(Racional r){

        long resulDeno;
        long resulNume;

        if(this.denominador == r.denominador){
            resulDeno = this.denominador;
            resulNume = this.numerador - r.numerador;
        }else{
            resulNume = (this.numerador * r.denominador) - (this.denominador * r.numerador);
            resulDeno = this.denominador * r.denominador;
        }
        return new Racional(resulNume, resulDeno);
    }

    /**Compara 2 numeros Racionales */
    @Override
    public boolean equals(Objet other){
        if (other == this) return true;
        if (other == null) return false;
        if (other.getClass() != this.getClass()) return false;
        return (this.denominador == that.denominador && this.numerador == that.numerador);
    }
}
