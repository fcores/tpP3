package ClaseSiete;

public class ActividadCuatro {
    public static void main(String[] args) {
        int[] costos = {12, 20, 15, 25};  // Costos de los paquetes de inversión
        int[] ganancias = {150, 200, 100, 300}; // Ganancias esperadas
        int presupuesto = 35;  // Presupuesto disponible
        int n = costos.length;


        int[][] dp = new int[n + 1][presupuesto + 1];

        for (int i = 1; i <= n; i++) {
            for (int w = 1; w <= presupuesto; w++) {
                if (costos[i - 1] <= w) {
                    dp[i][w] = Math.max(ganancias[i - 1] + dp[i - 1][w - costos[i - 1]], dp[i - 1][w]);
                } else {
                    dp[i][w] = dp[i - 1][w];
                }
            }
        }

        // ganancia máxima
        int gananciaMaxima = dp[n][presupuesto];
        System.out.println("La ganancia máxima que se puede obtener es: " + gananciaMaxima);

        int w = presupuesto;
        System.out.print("Paquetes seleccionados: ");
        for (int i = n; i > 0; i--) {
            if (dp[i][w] != dp[i - 1][w]) {
                System.out.print(i + " ");
                w -= costos[i - 1];
            }
        }
        System.out.println();
    }
}

// complejidad: O(nxm)
