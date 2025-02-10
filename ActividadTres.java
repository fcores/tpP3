package ClaseSiete;

public class ActividadTres {
    public static void main(String[] args) {
        int[] costos = {10, 15, 20, 25};  // Costos de los proyectos
        int[] beneficios = {100, 200, 150, 300}; // Beneficios esperados
        int presupuesto = 40;  // Presupuesto disponible
        int n = costos.length;

        int[][] dp = new int[n + 1][presupuesto + 1];


        for (int i = 1; i <= n; i++) {
            for (int w = 1; w <= presupuesto; w++) {
                if (costos[i - 1] <= w) {
                    dp[i][w] = Math.max(beneficios[i - 1] + dp[i - 1][w - costos[i - 1]], dp[i - 1][w]);
                } else {
                    dp[i][w] = dp[i - 1][w];
                }
            }
        }

        // beneficio máximo
        int beneficioMaximo = dp[n][presupuesto];
        System.out.println("El beneficio máximo que se puede obtener es: " + beneficioMaximo);

        // que proyectos fueron seleccionados
        int w = presupuesto;
        System.out.print("Proyectos seleccionados: ");
        for (int i = n; i > 0; i--) {
            if (dp[i][w] != dp[i - 1][w]) {
                System.out.print(i + " ");
                w -= costos[i - 1];
            }
        }
        System.out.println();
    }

    // complejidad: O(nxm)
}
