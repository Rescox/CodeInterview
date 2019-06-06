import java.util.HashMap;
/* Traductor de numeros romanos a entero y viceversa (Queda la parte de la resta y la de las repeticiones */
public class NumerosRomanos {
    public static int RomanToNumber(String sNumero) {
        
        int iResultado = 0;
        HashMap<Character, Integer> mapValores = new HashMap<Character, Integer> ();
        mapValores.put('I', 1);
        mapValores.put('V', 5);
        mapValores.put('X', 10);
        mapValores.put('L', 50);
        mapValores.put('C', 100);
        mapValores.put('M', 1000);
        int i = 0;

        while(i < sNumero.length()) { 
            if(i == sNumero.length() - 1) {
                if(sNumero.length() % 2 != 0) { 
                    iResultado += mapValores.get(sNumero.charAt(i));
                    System.out.println(mapValores.get(sNumero.charAt(i)));
                }
                break;
            }
            
            if(mapValores.get(sNumero.charAt(i)) >= mapValores.get(sNumero.charAt(i+1))) 
                iResultado += mapValores.get(sNumero.charAt(i)) + mapValores.get(sNumero.charAt(i+1));
                System.out.println(mapValores.get(sNumero.charAt(i)));
                System.out.println(iResultado);
                i += 2;
        }
        
        return iResultado;
    }

    public static void main(String[] args) {
        String s = "MCLXIII";
        System.out.println("El numero es: " + RomanToNumber(s));
    }
}
