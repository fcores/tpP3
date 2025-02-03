import java.util.ArrayList;
import java.util.List;

public class Main2 {
    public static void main(String[] args) {
        List<Integer> listaNumeros = new ArrayList<>();

        listaNumeros.add(1);
        listaNumeros.add(6);
        listaNumeros.add(7);
        listaNumeros.add(8);
        listaNumeros.add(114);

        // Llamar a la función y obtener los dos números mayores
        int[] maximos = encontrarDosMaximos(listaNumeros);
        System.out.println("Primer máximo: " + maximos[0]);
        System.out.println("Segundo máximo: " + maximos[1]);
    }

    public static int[] encontrarDosMaximos(List<Integer> listaNumeros) {
        if (listaNumeros.size() == 1) {
            // Caso base: si hay solo un elemento, devolvemos el mismo como máximo
            return new int[]{listaNumeros.get(0), Integer.MIN_VALUE};
        } else if (listaNumeros.size() == 2) {
            // Caso base: si hay dos elementos, devolverlos en orden descendente
            int a = listaNumeros.get(0);
            int b = listaNumeros.get(1);
            if (a > b) {
                return new int[]{a, b};
            } else {
                return new int[]{b, a};
            }
        }

        // Dividir la lista en dos mitades
        int mitad = listaNumeros.size() / 2;
        List<Integer> mitadIzquierda = listaNumeros.subList(0, mitad);
        List<Integer> mitadDerecha = listaNumeros.subList(mitad, listaNumeros.size());

        // Encontrar los máximos en ambas mitades recursivamente
        int[] maxIzquierda = encontrarDosMaximos(mitadIzquierda);
        int[] maxDerecha = encontrarDosMaximos(mitadDerecha);

        // Combinar los resultados
        int max1 = Math.max(maxIzquierda[0], maxDerecha[0]); // Máximo absoluto
        int max2;

        // Determinar el segundo máximo
        if (max1 == maxIzquierda[0]) {
            max2 = Math.max(maxIzquierda[1], maxDerecha[0]);
        } else {
            max2 = Math.max(maxIzquierda[0], maxDerecha[1]);
        }

        return new int[]{max1, max2};
    }
}