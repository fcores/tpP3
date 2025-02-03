import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    // Función para encontrar la cantidad mínima de monedas
    public static List<Integer> encontrarMinimoMonedas(int[] monedas, int monto) {
        Arrays.sort(monedas);
        List<Integer> resultado = new ArrayList<>();
        for (int i = monedas.length - 1; i >= 0; i--) {
            while (monto >= monedas[i]) {
                monto -= monedas[i];
                resultado.add(monedas[i]);
            }
        }
        return resultado;
    }
    public static void main(String[] args) {
        int[] monedas = {10,1,5,2,10,10,5,2,5,5,5,5,5,5,10};
        int monto = 33;
        List<Integer> resultado = encontrarMinimoMonedas(monedas, monto);
        System.out.println("Monedas usadas para hacer " + monto + ": " + resultado);
    }
}