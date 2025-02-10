import java.util.Scanner;

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
        int[][] dist = new int[V][V];
        int[][] next = new int[V][V];

        fw.floydWarshall(graph, V, dist, next);

        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese el vértice de origen (A-E): ");
        char origen = scanner.next().toUpperCase().charAt(0);
        System.out.println("Ingrese el vértice de destino (A-E): ");
        char destino = scanner.next().toUpperCase().charAt(0);

        int origenIndex = origen - 'A';
        int destinoIndex = destino - 'A';

        if (dist[origenIndex][destinoIndex] == INF) {
            System.out.println("No existe un camino entre " + origen + " y " + destino + ".");
        } else {
            System.out.println("La distancia más corta entre " + origen + " y " + destino + " es: " + dist[origenIndex][destinoIndex]);
            System.out.print("El camino es: ");
            fw.printPath(origenIndex, destinoIndex, next);
        }

        scanner.close();
    }

    // Implementación del algoritmo de Floyd-Warshall
    void floydWarshall(int[][] graph, int V, int[][] dist, int[][] next) {
        // Inicializar las matrices de distancias y de caminos
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                dist[i][j] = graph[i][j];
                if (graph[i][j] != INF && i != j) {
                    next[i][j] = j;
                } else {
                    next[i][j] = -1;
                }
            }
        }

        // Actualizar la matriz de distancias utilizando Floyd-Warshall
        for (int k = 0; k < V; k++) {
            for (int i = 0; i < V; i++) {
                for (int j = 0; j < V; j++) {
                    if (dist[i][k] != INF && dist[k][j] != INF && dist[i][k] + dist[k][j] < dist[i][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                        next[i][j] = next[i][k];
                    }
                }
            }
        }
    }

    // Método para imprimir el camino
    void printPath(int u, int v, int[][] next) {
        if (next[u][v] == -1) {
            System.out.println("No existe un camino.");
            return;
        }
        System.out.print((char) ('A' + u));
        while (u != v) {
            u = next[u][v];
            System.out.print(" -> " + (char) ('A' + u));
        }
        System.out.println();
    }
}