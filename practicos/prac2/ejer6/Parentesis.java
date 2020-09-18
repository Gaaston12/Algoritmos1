public class Parentesis {
    Pila pila = new Pila(); //pila para guardar los parentesis

    public static void main(String[] pps) {
        if(pps.length != 1){
            System.out.println("java Parentesis expresion ");
        }else {
            new Parentesis(app[0]);
        }
    }
}
/**
 * metodo para verificar que una expresion tiene balanceado sus parentesis
 * @param liena -- cadena que tiene la expresion a examinar
 */
public Parentesis(String linea) {

    for(int i = 0; i < linea.length(); i++){
        if(linea.charAt(i) == '(' pila.apilar(new Character('('));
        else if(linea.charAt(i) == ')') verifica(')');
    }
    if(pila.esVacia()) System.out.println("La expresion esta balanceada");
    else System.out.println("La expresion no esta balanceada");
}
    