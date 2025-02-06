package ClaseSeis;

public class ActividadDos {

    private int[][] matrizAdyacencia;
    private int numVertices;

    public ActividadDos(int numVertices) {
        this.numVertices = numVertices;
        matrizAdyacencia = new int[numVertices][numVertices];
    }

    // Agregar arista (grafo dirigido)
    public void agregarArista(int origen, int destino) {
        if (origen >= 0 && origen < numVertices && destino >= 0 && destino < numVertices) {
            matrizAdyacencia[origen][destino] = 1;
        } else {
            System.out.println("Vértices fuera de rango.");
        }
    }

    // Eliminar arista
    public void eliminarArista(int origen, int destino) {
        if (origen >= 0 && origen < numVertices && destino >= 0 && destino < numVertices) {
            matrizAdyacencia[origen][destino] = 0;
        } else {
            System.out.println("Vértices fuera de rango.");
        }
    }

    // Verificar si existe una arista entre dos vértices
    public boolean existeArista(int origen, int destino) {
        if (origen >= 0 && origen < numVertices && destino >= 0 && destino < numVertices) {
            return matrizAdyacencia[origen][destino] == 1;
        } else {
            System.out.println("Vértices fuera de rango.");
            return false;
        }
    }

    // Listar los vértices adyacentes de un nodo
    public void listarAdyacentes(int vertice) {
        if (vertice >= 0 && vertice < numVertices) {
            System.out.print("Adyacentes de " + vertice + ": ");
            for (int i = 0; i < numVertices; i++) {
                if (matrizAdyacencia[vertice][i] == 1) {
                    System.out.print(i + " ");
                }
            }
            System.out.println();
        } else {
            System.out.println("Vértice fuera de rango.");
        }
    }

    // Contar grado de salida (cantidad de aristas que salen de un vértice)
    public int gradoSalida(int vertice) {
        if (vertice >= 0 && vertice < numVertices) {
            int grado = 0;
            for (int i = 0; i < numVertices; i++) {
                if (matrizAdyacencia[vertice][i] == 1) {
                    grado++;
                }
            }
            return grado;
        } else {
            System.out.println("Vértice fuera de rango.");
            return -1;
        }
    }

    // Contar grado de entrada (cantidad de aristas que llegan a un vértice)
    public int gradoEntrada(int vertice) {
        if (vertice >= 0 && vertice < numVertices) {
            int grado = 0;
            for (int i = 0; i < numVertices; i++) {
                if (matrizAdyacencia[i][vertice] == 1) {
                    grado++;
                }
            }
            return grado;
        } else {
            System.out.println("Vértice fuera de rango.");
            return -1;
        }
    }

    // Mostrar la matriz de adyacencia
    public void mostrarMatriz() {
        System.out.println("Matriz de Adyacencia:");
        for (int i = 0; i < numVertices; i++) {
            for (int j = 0; j < numVertices; j++) {
                System.out.print(matrizAdyacencia[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        ActividadDos grafo = new ActividadDos(5); // Grafo con 5 nodos

        // Agregar aristas
        grafo.agregarArista(0, 1);
        grafo.agregarArista(0, 3);
        grafo.agregarArista(1, 2);
        grafo.agregarArista(2, 3);
        grafo.agregarArista(3, 4);

        // Mostrar matriz de adyacencia
        grafo.mostrarMatriz();

        // Verificar existencia de aristas
        System.out.println("Existe arista (0 -> 1): " + grafo.existeArista(0, 1));
        System.out.println("Existe arista (2 -> 4): " + grafo.existeArista(2, 4));

        // Listar adyacentes
        grafo.listarAdyacentes(0);
        grafo.listarAdyacentes(2);

        // Grados de entrada y salida
        System.out.println("Grado de salida de 0: " + grafo.gradoSalida(0));
        System.out.println("Grado de entrada de 3: " + grafo.gradoEntrada(3));

        // Eliminar arista y mostrar la matriz
        grafo.eliminarArista(0, 1);
        grafo.mostrarMatriz();
    }
    
}
