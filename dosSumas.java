
/* Dado un array de enteros bu scar los dos indices de los numeros del array que obtengan
como resultado de la suma de un entero en concreto*/
import java.util.Arrays;
import java.util.HashMap;

public class dosSumas {
    public static int [] esSuma(int[] vNumeros, int iObjetivo) {
        if(vNumeros.length < 2) {
            return new int[]{0,0};
        }
        
        HashMap<Integer, Integer> mapPosiblesResultados = new HashMap<Integer, Integer>();
        for(int i = 0; i < vNumeros.length; i++) {
            if(mapPosiblesResultados.keySet().contains(vNumeros[i])) {
                return new int [] {mapPosiblesResultados.get(vNumeros[i]),i};
            } else {
                mapPosiblesResultados.put(iObjetivo - vNumeros[i],i);
            }
        }
        return new int[]{0,0};
    }


    public static void main(String[] args) {
        int [] vNumeros = {1, 2, 3, 8, 10};
        int [] vResultado = esSuma(vNumeros, 12);
        System.out.println(Arrays.toString(vResultado));
    }
}