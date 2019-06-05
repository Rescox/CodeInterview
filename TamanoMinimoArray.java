import java.util.Arrays;

/*Given an array of n positive integers and a positive integer s, 
find the minimal length of a subarray of which the sum ≥ s. 
If there isn't one, return 0 instead.*/

public class TamanoMinimoArray {
    public static int tamanoMinimo(int [] aNumeros, int iObjetivo) {
        if(aNumeros.length == 1 || aNumeros == null) {
            return 0;
        }
        int iResultado = aNumeros.length;
        int iSuma = 0;
        int iComienzoTamano = 0;
        int i = 0;
        Arrays.sort(aNumeros);
        boolean bExiste = false;

        while(i<=aNumeros.length) {
            if(iSuma >= iObjetivo) {
                bExiste = true;
                if(iComienzoTamano == i - 1) {
                    return 1;
                }
                
                iResultado = Math.min(iResultado, i-iComienzoTamano);
                iSuma = iSuma-aNumeros[iComienzoTamano];
                iComienzoTamano++;
            } else {
                if(i==aNumeros.length)
                    break;
                iSuma = iSuma + aNumeros[i];
                i++;
            }
        }

        if(bExiste)
            return iResultado;
        else
            return 0;
    } 

    public static void main(String[] args ) { 
        int [] aArray = {1,2,3,4,5,6};
        System.out.println("El tamaño es " +  tamanoMinimo(aArray, 11));
    }
}