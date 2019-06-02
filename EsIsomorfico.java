import java.util.HashMap;

/*Dado dos strings s y t, determinar si son isomorficos. Dos string son
isomorficos si los caracteres en s pueden ser reemplazados para obtener t 
Ejemplo y solucion obtenidos de: https://www.programcreek.com/2014/05/leetcode-isomorphic-strings-java/*/

public class EsIsomorfico {
    public static boolean esIsomorfico(String s, String t) {
        if(s.length() != t.length()) {
            return false;
        }

        HashMap<Character, Character> frase1 = new HashMap<>();
        HashMap<Character, Character> frase2 = new HashMap<>();
        
        for(int i = 0; i < s.length(); i++) {
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);

            if(frase1.containsKey(c1)) {
                if(c2 != frase1.get(c1)) {
                    return false;
                }
            } else {
                if(frase2.containsKey(c2)) {
                    return false;
                }

                frase1.put(c1, c2);
                frase2.put(c2, c1);
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String t = "Dos";
        String s = "Uno";
        System.out.println(esIsomorfico(s, t));
    }
} 




