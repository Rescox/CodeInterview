import java.util.HashMap;

public class dosSumas {
    public int [] esSuma(int[] vNumeros, int iObjetivo) {
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
}