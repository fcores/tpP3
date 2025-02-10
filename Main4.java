import java.util.Arrays;

public class Main {

    public static int getMinimumCost(int[] c, int k) {
        // Ordenar los precios de las flores en orden descendente
        Arrays.sort(c);
        int n = c.length;
        int totalCost = 0;
        int[] purchases = new int[k]; // Rastrea cuántas flores ha comprado cada amigo

        // Comprar las flores comenzando por las más caras
        for (int i = n - 1; i >= 0; i--) {
            int friend = (n - 1 - i) % k; // Determina el amigo actual
            totalCost += (purchases[friend] + 1) * c[i];
            purchases[friend]++; // Incrementa las compras del amigo actual
        }

        return totalCost;
    }

    public static void main(String[] args) {
        // Ejemplo de entrada
        int[] c1 = {2, 5, 6};
        int k1 = 3;
        System.out.println("Costo mínimo (ejemplo 1): " + getMinimumCost(c1, k1)); // Salida: 13

        int[] c2 = {2, 5, 6};
        int k2 = 2;
        System.out.println("Costo mínimo (ejemplo 2): " + getMinimumCost(c2, k2)); // Salida: 15

        int[] c3 = {1, 3, 5, 7, 9};
        int k3 = 3;
        System.out.println("Costo mínimo (ejemplo 3): " + getMinimumCost(c3, k3)); // Salida: 29
    }
}