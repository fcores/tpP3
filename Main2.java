public class Main {
    final static int INF = 99999;

    public static void main(String[] args) {
        Main fw = new Main();


        int graph[][] = {
                {0, 4, 2, INF, INF},  // Centro A → (B, C)
                {INF, 0, 1, 5, INF},  // Centro B → (C, D)
                {INF, INF, 0, 8, 10}, // Centro C → (D, E)
                {INF, INF, INF, 0, 2}, // Centro D → (E)
                {-4, INF, INF, INF, 0} // Centro E → (A)
        };

        int V = graph.length;
        fw.floydWarshall(graph, V);
    }

    // Implementación del algoritmo de Floyd-Warshall
    void floydWarshall(int graph[][], int V) {
        int dist[][] = new int[V][V];

        // Inicializar la matriz de distancias
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                dist[i][j] = graph[i][j];
            }
        }

        // Actualizar la matriz de distancias utilizando
        for (int k = 0; k < V; k++) {
            for (int i = 0; i < V; i++) {
                for (int j = 0; j < V; j++) {
                    // Si el camino a través de k es más corto, actualizamos
                    if (dist[i][k] != INF && dist[k][j] != INF && dist[i][k] + dist[k][j] < dist[i][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }

        // Imprimir la matriz de distancias mínimas
        printSolution(dist, V);

        // Detectar ciclos negativos
        detectNegativeCycles(dist, V);
    }

    // Método para imprimir la solución
    void printSolution(int dist[][], int V) {
        System.out.println("Matriz de distancias más cortas entre cada par de centros de distribución:");
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                if (dist[i][j] == INF)
                    System.out.print("INF ");
                else
                    System.out.print(dist[i][j] + "   ");
            }
            System.out.println();
        }
    }

    // Método para detectar ciclos negativos
    void detectNegativeCycles(int dist[][], int V) {
        boolean hasNegativeCycle = false;
        for (int i = 0; i < V; i++) {
            if (dist[i][i] < 0) {
                System.out.println("Ciclo negativo detectado en el nodo " + (char) ('A' + i));
                hasNegativeCycle = true;
            }
        }
        if (!hasNegativeCycle) {
            System.out.println("No se detectaron ciclos negativos en el sistema de rutas.");
        }
    }
}