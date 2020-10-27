// Evaluates if a sucesion of characters is balanced -() [] {}-
public class Main{

    public static void main (String [] args){
        LinkedGenericStack<Character> pila = new LinkedGenericStack<Character>();
        Character s = new Character('a');
        for (int i = 0; i < args[0].length(); i++){
            s = args[0].charAt(i);
            if(pila.isEmpty()){
                pila.push(args[0].charAt(i));
            }
            else if((pila.top().equals('(') && s.equals(')')) || pila.top().equals('[') && s.equals(']') || pila.top().equals('{') && s.equals('}')){
                pila.pop();
            }
            else{
                pila.push(args[0].charAt(i));
            }
        }

        if(pila.isEmpty()){
            System.out.println("La secuencia esta balaceada");
        }
        else{
            System.out.println("La secuencia NO esta balanceada");
        }

    }
}