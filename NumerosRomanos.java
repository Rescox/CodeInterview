import java.util.HashMap;
/* Traductor de numeros romanos a entero y viceversa 
Faltan comprobaciones*/
public class NumerosRomanos {
    public static int RomanToNumber(String sNumero) {
        int iResultado = 0;
        if(comprobacionNumeroCorrecto(sNumero)) {

            HashMap<Character, Integer> mapValores = caracteresRomano();
            int i = 0;

            while(i < sNumero.length()) { 
                if(i == sNumero.length() - 1) {
                    if(sNumero.length() % 2 != 0) { 
                        iResultado += mapValores.get(sNumero.charAt(i));
                        System.out.println(mapValores.get(sNumero.charAt(i)));
                    }
                    break;
                }
                
                if(mapValores.get(sNumero.charAt(i)) >= mapValores.get(sNumero.charAt(i+1))) { 
                    iResultado += mapValores.get(sNumero.charAt(i)) + mapValores.get(sNumero.charAt(i+1));
                    System.out.println(mapValores.get(sNumero.charAt(i)));
                    System.out.println(iResultado);
                    i += 2;
                } 
                
                else if(mapValores.get(sNumero.charAt(i)) < mapValores.get(sNumero.charAt(i+1))) { 
                    iResultado += Math.abs(mapValores.get(sNumero.charAt(i)) - mapValores.get(sNumero.charAt(i+1)));
                    System.out.println(mapValores.get(sNumero.charAt(i)));
                    System.out.println(iResultado);
                    i += 2;
                }
            }
        }
        
        return iResultado;
    }

    public static boolean comprobacionNumeroCorrecto(String sNumero) {
        HashMap<Character, Integer> mapValores = caracteresRomano();
        if(sNumero == null || sNumero.length() > 20) {
            return false;
        }
        
        for(int i = 0; i < sNumero.length() - 1; i++) {
            //Letra de tipo 5 restando
            if((sNumero.charAt(i) == 'V' 
            || sNumero.charAt(i) == 'L' 
            || sNumero.charAt(i) == 'D')
            && sNumero.charAt(i) >= mapValores.get(sNumero.charAt(i+1))) { 
                return false;
            }

        }

        return true;
    } 

    public static HashMap<Character, Integer> caracteresRomano() {
        HashMap<Character, Integer> mapValores = new HashMap<Character, Integer> ();
        mapValores.put('I', 1);
        mapValores.put('V', 5);
        mapValores.put('X', 10);
        mapValores.put('L', 50);
        mapValores.put('C', 100);
        mapValores.put('M', 1000);
        return mapValores;
    }
    public static void main(String[] args) {
        String s = "IX";
        System.out.println("El numero es: " + RomanToNumber(s));
    }
}