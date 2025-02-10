package ClaseSiete;

public class ActividadUno {

    public static void main(String[] args) {
        int[] pesos = {3, 4, 2};  // Pesos de los objetos
        int[] valores = {4, 5, 3}; // Valores de los objetos
        int capacidad = 6;  // Capacidad máxima de la mochila
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
