package ClaseSiete;

public class ActividadDos {
    public static void main(String[] args) {
        int[] pesos = {2, 5, 6, 7};  // Pesos de los objetos
        int[] valores = {4, 2, 1, 6}; // Valores de los objetos
        int capacidad = 10;  // Capacidad máxima de la mochila
        int n = pesos.length;

        // Crear la tabla dp
        int[][] dp = new int[n + 1][capacidad + 1];

        // Llenamos la tabla
        for (int i = 1; i <= n; i++) {
            for (int w = 1; w <= capacidad; w++) {
                if (pesos[i - 1] <= w) {
                    dp[i][w] = Math.max(valores[i - 1] + dp[i - 1][w - pesos[i - 1]], dp[i - 1][w]);
                } else {
                    dp[i][w] = dp[i - 1][w];
                }
            }
        }

        // Mostrar el resultado
        System.out.println("El valor máximo que se puede obtener es: " + dp[n][capacidad]);
    }
}
