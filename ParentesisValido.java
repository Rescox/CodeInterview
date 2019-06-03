import java.util.HashMap;
import java.util.Stack;

/*
Dado un array que contiene solo caracteres '(', ')', '{', '}', '[' y ']' determinar si están bien cerrado
es decir que () o {} pero no ([)
*/

public class ParentesisValido {
    public static boolean esValido(String sCadena) {
        HashMap<Character, Character> mapCloseCharacters = new HashMap<Character, Character>(); 
        mapCloseCharacters.put('(', ')');
        mapCloseCharacters.put('{', '}');
        mapCloseCharacters.put('[', ']');
        
        Stack<Character> stack = new Stack<Character>();

        int iIndex = 0;

        while (iIndex < sCadena.length()) {
            char cAux = sCadena.charAt(iIndex);

            if(mapCloseCharacters.keySet().contains(cAux)) {
                stack.push(cAux);
            } else if(mapCloseCharacters.values().contains(cAux)) {
                if(!stack.empty() && mapCloseCharacters.get(stack.peek()) == cAux) {
                    stack.pop();
                } else {
                    return false;
                } 
            }
            
            iIndex++;
        }    
    return stack.empty();
    } 

    public static void main(String[] args) {
        String cadena = "(})";
        System.out.println(esValido(cadena));
    }
}